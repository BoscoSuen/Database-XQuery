package main.resource;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.w3c.dom.Node;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.*;

public class XQueryOptimize {
    static Map<String, String> var2xq = new HashMap<>();
    static Map<String, String> var2root = new HashMap<>();
    static Map<String, ArrayList<String>> root2child = new HashMap<>();
    static ArrayList<String[]> pairs = new ArrayList<>();
    static Map<String, String> root2where = new HashMap<>();
    static Map<String, String> root2join = new HashMap<>();

    public static void main(String[] args) throws IOException {
//        use file reader:
        File inputFile = new File("XQueryTest.txt");
        if (!inputFile.isFile() || !inputFile.exists()) return;
        FileInputStream fileInputStream = new FileInputStream(inputFile);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuffer sb = new StringBuffer();
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            sb.append(" ").append(str);
        }
        String inputQuery = sb.toString();
//        System.out.println("Query String is: " + stringBuffer);

        CharStream input = CharStreams.fromString(inputQuery);
        xQueryLexer lexer = new xQueryLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        xQueryParser parser = new xQueryParser(tokens);
        ParseTree parseTree = parser.xq();

        // TODO: rewrite the query parse tree
        String queryRewritten = rewrite(parseTree);
        if (queryRewritten.length() == 0) queryRewritten = inputQuery;
        else {
            // rewrite the query and save the query format
            File outputFile = new File("OptimizedQuery.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            bufferedWriter.write(queryRewritten);
            bufferedWriter.close();
            fileOutputStream.close();
        }

        CharStream rewrittenInput = CharStreams.fromString(queryRewritten);
        xQueryLexer rewrittenLexer = new xQueryLexer(rewrittenInput);
        CommonTokenStream rewrittenTokens = new CommonTokenStream(rewrittenLexer);
        xQueryParser rewrittenParser = new xQueryParser(rewrittenTokens);
        ParseTree rewrittenParseTree = rewrittenParser.xq();

        xQueryMyVisitor visitor = new xQueryMyVisitor();
        ArrayList<Node> list = (ArrayList<Node>) visitor.visit(rewrittenParseTree);
        System.out.println("Number of nodes found: " + list.size());

        for (Node n : list) {
            String curOutput = printNode(n);
            System.out.println("curOutput is:\n" + curOutput);
        }
    }

    public static void parsingForClause(ParseTree forClause) {
        for (int i = 1; i < forClause.getChildCount(); i += 4) {
            String currVar = trimVarString(forClause.getChild(i).getText());
            String xq = forClause.getChild(i + 2).getText();
            var2xq.put(currVar, xq);
            String rootVar;
            if (xq.startsWith("doc")) {
                rootVar = currVar;
            } else {
                int varEnd = xq.indexOf("/") > -1? xq.indexOf("/") : xq.length();
                rootVar = var2root.get(xq.substring(1, varEnd));
            }
            var2root.put(currVar, rootVar);
            ArrayList<String> childrenList = root2child.getOrDefault(rootVar, new ArrayList<>());
            if (!xq.startsWith("doc")) {
                childrenList.add(currVar);
            }
            root2child.put(rootVar, childrenList);
        }
    }

    public static void parsingWhereClause(ParseTree allCond) {
        List<String> condList = Arrays.asList(allCond.getText().split("and"));
        for (String cond : condList) {
            String[] vars = cond.split(cond.contains("eq")? "eq" : "=");
            pairs.add(new String[]{trimVarString(vars[0]), trimVarString(vars[1])});
        }
    }

    public static String trimVarString(String input) {
        return input.substring(input.indexOf("$") + 1).trim();
    }

    public static String completeVarString(String input) {
        return input.startsWith("\"")? input : "$" + input;
    }

    public static boolean needRewrite(ParseTree parseTree) {
        ParseTree forClause = parseTree.getChild(0);
        ParseTree whereClause = parseTree.getChild(1);

        String forClauseText = forClause.getText();
        if (forClauseText.contains("join") || !forClauseText.contains("for")) {
            return false;
        }
        parsingForClause(forClause);
        parsingWhereClause(whereClause.getChild(1));
//        for (Map.Entry<String, String> e : var2root.entrySet()) {
//            System.out.println(e.getKey() + "," + e.getValue());
//        }
//        for (Map.Entry<String, String> e : var2root.entrySet()) {
//            System.out.println(e.getKey() + "," + e.getValue());
//        }
        boolean flag = false;
        for (String[] pair : pairs) {
            // System.out.println(pair[0] + "," + pair[1]);
            String where1 = pair[0];
            String where2 = pair[1];
            String where1Root = where1.startsWith("\"")? "" : var2root.get(where1);
            String where2Root = where2.startsWith("\"")? "" : var2root.get(where2);
            if (!where1.startsWith("\"") && !where2.startsWith("\"") && !where2Root.equals(where1Root)) {
                flag = true;
                continue;
            }
            String toAdd = completeVarString(where1) + " eq " + completeVarString(where2);
            toAdd = root2where.containsKey(where1Root) ? " and " + toAdd : "where " + toAdd;
            root2where.put(where1Root, root2where.getOrDefault(where1Root, "") + toAdd);
        }
        for (Map.Entry<String, String> e : root2where.entrySet()) {
            System.out.println(e.getKey() + "," + e.getValue());
        }
        return flag;
    }


    public static String rewrite(ParseTree parseTree) {
        if (!needRewrite(parseTree)) return "";
        ParseTree forClause = parseTree.getChild(0);
        ParseTree whereClause = parseTree.getChild(1);
        ParseTree returnClause = parseTree.getChild(2);



    }


    private static String printNode(Node node) {
        StringWriter stringWriter = new StringWriter();
        try {
            Transformer trans = TransformerFactory.newInstance().newTransformer();
            trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            trans.transform(new DOMSource(node), new StreamResult(stringWriter));
        } catch (TransformerException te) {
            System.out.println("Error in transforming node to string");
        }
        return stringWriter.toString();
    }
}
