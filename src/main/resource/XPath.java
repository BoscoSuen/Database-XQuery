package main.resource;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.w3c.dom.Node;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

public class XPath {

    public static void main(String[] args) throws IOException {
        CharStream charStream = CharStreams.fromFileName("test.txt");
        xQueryLexer xQueryLexer = new xQueryLexer(charStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(xQueryLexer);
        xQueryParser xQueryParser = new xQueryParser(commonTokenStream);

        ParseTree parseTree = xQueryParser.ap();
        xQueryMyVisitor visitor = new xQueryMyVisitor();
        ArrayList<Node> list = (ArrayList<Node>) visitor.visit(parseTree);
        // can add a break point at the println to see the elements in the parseTree
        System.out.println(list.size() + " elements found.");
        for (Node n : list) {
            System.out.println(printNode(n));
        }
    }

    // Transform node to printable string
    // Reference: https://stackoverflow.com/questions/4412848/xml-node-to-string-in-java
    public static String printNode(Node node) {
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
