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
import java.util.ArrayList;

public class XQueryOptimize {
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


    public static String rewrite(ParseTree parseTree) {
        
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
