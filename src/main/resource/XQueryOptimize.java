package main.resource;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
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
    static boolean nestedFlag = false;


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

        File reInputFile = new File("OptimizedQuery.txt");
        FileInputStream fileReinputStream = new FileInputStream(reInputFile);
        InputStreamReader reInputStreamReader = new InputStreamReader(fileReinputStream);
        BufferedReader reBufferedReader = new BufferedReader(reInputStreamReader);
        StringBuffer sb_new = new StringBuffer();
        String str_new = null;
        while ((str_new = reBufferedReader.readLine()) != null) {
            sb_new.append(" ").append(str_new);
        }
        String reInputQuery = sb_new.toString();

        CharStream rewrittenInput = CharStreams.fromString(reInputQuery);
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
//        System.out.println(allCond.getChild(1).getText());
//        List<String> condList = Arrays.asList(allCond.getText().split("and"));
//        for (String cond : condList) {
//            // System.out.println(cond);
//            String[] vars = cond.split(cond.contains("eq")? "eq" : "=");
//            // System.out.println(vars[0] + "," + vars[1] + "\n");
//            pairs.add(new String[]{trimVarString(vars[0]), trimVarString(vars[1])});
//        }
        String curr = allCond.getChild(1).getText();
        if (curr.equals("eq") || curr.equals("=")) {
            pairs.add(new String[]{trimVarString(allCond.getChild(0).getText()),
                    trimVarString(allCond.getChild(2).getText())});
        } else {
            parsingWhereClause(allCond.getChild(0));
            parsingWhereClause(allCond.getChild(2));
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
//        for (Map.Entry<String, String> e : root2where.entrySet()) {
//            System.out.println(e.getKey() + "," + e.getValue());
//        }
        return flag;
    }


    public static String rewrite(ParseTree parseTree) {
        if (!needRewrite(parseTree)) return "";
        boolean canMergeRoot = true;
        while(canMergeRoot) {
            canMergeRoot = false;
            String left = "";
            String right = "";
            for (String[] pair : pairs) {
                left = pair[0];
                right = pair[1];
                String parentLeft = var2root.get(left);
                String parentRight = var2root.get(right);
                if (left.startsWith("\"") || right.startsWith("\"") || parentLeft.equals(parentRight)) {
                    continue;
                }
                System.out.println(left + ":" + parentLeft + ", " + right + ":" + parentRight );
                canMergeRoot = true;
                break;
            }
            if (!canMergeRoot) break;   // do not need to construct join clause

            // merge two roots in var2root
            String joinedXq1 = joinXq(var2root.get(left));
            String joinedXq2 = joinXq(var2root.get(right));
            String[] attrs = joinAttr(left,right);
            String joinConstructed = "join (\n" + joinedXq1 + ",\n" + joinedXq2 + ",\n" + attrs[0] + "," + attrs[1] + " )\n";
            String leftRoot = var2root.get(left);
            String rightRoot = var2root.get(right);
            root2join.put(leftRoot,joinConstructed);

            // merge right to the left
            ArrayList<String> rightVars = root2child.get(rightRoot);
            var2root.put(rightRoot,leftRoot);
            for (String var : rightVars) {
                var2root.put(var,leftRoot);
            }
        }

        // get the optimize query
        Map<String, String> tupleMap = new HashMap<>();
        int nestedCount = 0;    // count the nested tuples
        for (Map.Entry<String,String> entry : root2join.entrySet()) {
            if (nestedCount == 0) {
                String tuple = "$tuple";
                tupleMap.put(entry.getKey(),tuple);
            } else {
                String tuple = "$tuple" + String.valueOf(nestedCount);
                tupleMap.put(entry.getKey(),tuple);
            }
            nestedCount++;
        }
        // get nested join clause
        StringBuilder res = new StringBuilder();
        res.append("for ");
        int loopCount = 0;
        for (Map.Entry<String,String> entry : root2join.entrySet()) {
            String tuple = tupleMap.get(entry.getKey());
            if (loopCount > 0) {
                res.append(", \n");
            }
            res.append(tuple).append(" in ").append(entry.getValue());
            loopCount++;
        }

        // append the nest return clause
        res.append("\n").append(getReturnClause(tupleMap,parseTree.getChild(2)));
        return res.toString();
    }

    private static String getReturnClause(Map<String,String> tupleMap, ParseTree returnNode) {
        if (returnNode instanceof TerminalNode) {
            // base case
            String cur = returnNode.getText();
//            System.out.println(cur);
            if (cur.indexOf("$") == 0) {
                nestedFlag = true;
                return "";
            } else if (nestedFlag) {
                String rootVar = var2root.get(cur);
                String tuple = tupleMap.get(rootVar);
                nestedFlag = false;
                return tuple + '/' + cur + "/*";
            } else {
                return cur;
            }
        } else {
            StringBuilder res = new StringBuilder();
            for(int i = 0; i < returnNode.getChildCount(); i++) {
                res.append(getReturnClause(tupleMap,returnNode.getChild(i)));
            }
            return res.toString();
        }
    }

    private static String joinXq(String root) {
        if (root2join.containsKey(root)) {
            return root2join.get(root);
        }
        StringBuffer res = new StringBuffer();
        res.append("for ");
        res.append("$").append(root).append(" in ").append(var2xq.get(root));
        ArrayList<String> childVars = root2child.get(root);
        for (String var : childVars) {
            res.append(", \n").append("$").append(var).append(" in ").append(var2xq.get(var));
        }
        res.append("\n");
        if (root2where.containsKey(root)) {
            // need to add where clause in this joinXQ
            res.append(root2where.get(root));
            res.append("\n");
        }
        res.append("return <tuple> {").append("\n");
        res.append("\t").append("<").append(root).append("> {$").append(root).append("} </").append(root).append(">");
        for (String var : childVars) {
            res.append(", \n").append("\t").append("<").append(var).append("> {$").append(var).append("} </").append(var).append(">");
        }
        res.append("\t").append("}</tuple>\n");
        return res.toString();
    }

    private static String[] joinAttr(String left, String right) {
        StringBuffer res1 = new StringBuffer();
        StringBuffer res2 = new StringBuffer();
        res1.append("[");
        res2.append("[");
        for (String[] pair : pairs) {
            // merge to join clause
            String attr1 = pair[0];
            String attr2 = pair[1];
            if (attr1.indexOf('\"') != -1 || attr2.indexOf('\"') != -1) continue;   // do not need to set the attribute
            String attr1Root = var2root.get(attr1);
            String attr2Root = var2root.get(attr2);
            if (attr1Root.equals(var2root.get(left)) && attr2Root.equals(var2root.get(right))) {
                if (res1.length() == 1) res1.append(attr1);
                else res1.append(", ").append(attr1);
                if (res2.length() == 1) res2.append(attr2);
                else res2.append(", ").append(attr2);
            }
            if (attr2Root.equals(var2root.get(left)) && attr1Root.equals(var2root.get(right))) {
                if (res1.length() == 1) res1.append(attr2);
                else res1.append(", ").append(attr2);
                if (res2.length() == 1) res2.append(attr1);
                else res2.append(", ").append(attr1);
            }
        }
        res1.append("]");
        res2.append("]");
        return new String[]{res1.toString(), res2.toString()};
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
