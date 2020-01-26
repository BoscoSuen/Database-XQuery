package main.resource;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class xQueryMyVisitor extends xQueryBaseVisitor<Object> {
    @Override
    public Object visitADescendent(xQueryParser.ADescendentContext ctx) {
        Node root = getRoot(ctx.filename().getText());
        System.out.println(root);
        return visitChildren(ctx);
    }

    @Override
    public Object visitADesOrSelf(xQueryParser.ADesOrSelfContext ctx) {
        Node root = getRoot(ctx.filename().getText());
        return visitChildren(ctx);
    }

    @Override
    public Object visitFilename(xQueryParser.FilenameContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitTagName(xQueryParser.TagNameContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitParent(xQueryParser.ParentContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitAttribute(xQueryParser.AttributeContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitRConcat(xQueryParser.RConcatContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitRFilter(xQueryParser.RFilterContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitText(xQueryParser.TextContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitRDescendent(xQueryParser.RDescendentContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    // NOT sure yet
    public NodeList visitChildren(xQueryParser.ChildrenContext ctx) {
        return getChildren(curr);
    }

    @Override
    public Object visitSelf(xQueryParser.SelfContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitRDesOrSelf(xQueryParser.RDesOrSelfContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitRBracket(xQueryParser.RBracketContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitFIs(xQueryParser.FIsContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitFAnd(xQueryParser.FAndContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitFRp(xQueryParser.FRpContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitFOr(xQueryParser.FOrContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitFBracket(xQueryParser.FBracketContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitFEqual(xQueryParser.FEqualContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitFNot(xQueryParser.FNotContext ctx) {
        return visitChildren(ctx);
    }

    // Get the root node of an input file
    private Node getRoot(String fileName) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document doc = null;
        try {
            doc = db.parse(new File(fileName));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc.getDocumentElement();
    }

    // Get the list of children of a node
    // NOT sure yet
    private NodeList getChildren(Node node) {
        if (! node.hasChildNodes()) return null;
        return node.getChildNodes();
    }

    private Node curr; // NOT sure yet
}