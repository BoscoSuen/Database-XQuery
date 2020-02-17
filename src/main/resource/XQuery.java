/**
 * Created by Xiaohan Zhu and Zhiqiang Sun
 */

package main.resource;

import org.antlr.runtime.ANTLRInputStream;
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

public class XQuery {

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
            sb.append(str);
        }
        String stringBuffer = sb.toString();
        System.out.println(stringBuffer);
        CharStream input = CharStreams.fromString(stringBuffer);

//        use ANTLRInputStream:
//        ANTLRInputStream input = new ANTLRInputStream(System.in);


        xQueryLexer lexer = new xQueryLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        xQueryParser parser = new xQueryParser(tokens);
        ParseTree parseTree = parser.xq();
        xQueryMyVisitor visitor = new xQueryMyVisitor();
        ArrayList<Node> list = (ArrayList<Node>) visitor.visit(parseTree);
        System.out.println("Number of nodes found: " + list.size());
    }

    // Transform node to printable string
    // Reference: https://stackoverflow.com/questions/4412848/xml-node-to-string-in-java
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

