package main.resource;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.w3c.dom.Node;

import java.io.IOException;
import java.util.ArrayList;

public class XPath {

    public static void main(String[] args) throws IOException {
        CharStream charStream = CharStreams.fromFileName("src/data/test.txt");
        xQueryLexer xQueryLexer = new xQueryLexer(charStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(xQueryLexer);
        xQueryParser xQueryParser = new xQueryParser(commonTokenStream);

        ParseTree parseTree = xQueryParser.ap();
        xQueryMyVisitor visitor = new xQueryMyVisitor();
        ArrayList<Node> list = (ArrayList<Node>) visitor.visit(parseTree);
        // can add a break point at the println to see the elements in the parseTree
        for (Node n : list) {
            System.out.println(n.getNodeName());
        }
    }
}
