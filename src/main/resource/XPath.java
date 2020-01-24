package main.resource;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class XPath {

    public static void main(String[] args) throws IOException {
        CharStream charStream = CharStreams.fromFileName("src/data/test.xml");
        xQueryLexer xQueryLexer = new xQueryLexer(charStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(xQueryLexer);
        xQueryParser xQueryParser = new xQueryParser(commonTokenStream);

        ParseTree parseTree = xQueryParser.ap();
        System.out.println("done");
    }
}
