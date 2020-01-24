package main.resource;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.IOException;

public class XPath {

    public static void main(String[] args) throws IOException {
        CharStream charStream = CharStreams.fromFileName("src/data/test.xml");
        xQueryLexer xQueryLexer = new xQueryLexer(charStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(xQueryLexer);
        xQueryParser xQueryParser = new xQueryParser(commonTokenStream);

        ParseTree parseTree = xQueryParser.ap();
        xQueryBaseVisitor visitor = new xQueryBaseVisitor();
        visitor.visit(parseTree);
        // can add a break point at the println to see the elements in the parseTree
        System.out.println("test end here");
    }
}
