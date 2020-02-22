/**
 * Created by Xiaohan Zhu and Zhiqiang Sun
 */

package XQueryProcessor;

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
import java.io.*;
import java.util.ArrayList;

public class XPath {

    public static void main(String[] args) throws IOException {
        File inputFile = new File("XPathTest.txt");
        if (!inputFile.isFile() || !inputFile.exists()) return;
        File outputFile = new File("XPathOutput.txt");
        if (!outputFile.exists()) outputFile.createNewFile(); // create output file

        FileInputStream fileInputStream = new FileInputStream(inputFile);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        fileOutputStream.write(("-------------------------------------------------\n").getBytes());

        // get XPath output
        String stringBuffer = null;
        int idx = 1;
        while ((stringBuffer = bufferedReader.readLine()) != null) {
            CharStream charStream = CharStreams.fromString(stringBuffer);
            xQueryLexer xQueryLexer = new xQueryLexer(charStream);
            CommonTokenStream commonTokenStream = new CommonTokenStream(xQueryLexer);
            xQueryParser xQueryParser = new xQueryParser(commonTokenStream);

            ParseTree parseTree = xQueryParser.ap();
            xQueryMyVisitor visitor = new xQueryMyVisitor();
            ArrayList<Node> list = (ArrayList<Node>) visitor.visit(parseTree);
            System.out.println("Test Case No." + idx + ": " + list.size() + " elements found.");
            StringBuffer sb = new StringBuffer();
            sb.append("Now get the query output in test case No.").append(idx).append(":\n");
            fileOutputStream.write(sb.toString().getBytes());
            for (Node n : list) {
                String curOutput = printNode(n);
                fileOutputStream.write(curOutput.getBytes());
            }
            fileOutputStream.write(("-------------------------------------------------\n").getBytes());
            idx++;
        }
        System.out.println("Get the query output file in \"output.txt\":");
        fileOutputStream.flush();
        fileOutputStream.close();
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
