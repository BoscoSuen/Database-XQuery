package main.resource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class xQueryMyVisitor extends xQueryBaseVisitor<Object> {

    private Node curr; // NOT sure yet
    private ArrayList<Node> list = new ArrayList<>(); // current visited list

    @Override
    // ap: 'doc("' filename '")' '/' rp
    public ArrayList<Node> visitADescendent(xQueryParser.ADescendentContext ctx) {
        Node root = getRoot(ctx.filename().getText());
        return (ArrayList<Node>) visitChildren(ctx);
    }

    @Override
    // ap: 'doc("' filename '")' '//' rp
    public ArrayList<Node> visitADesOrSelf(xQueryParser.ADesOrSelfContext ctx) {
        Node root = getRoot(ctx.filename().getText());
        ArrayList<Node> res = new ArrayList<>();
        res.addAll(list);
        for (Node n : list) {
            for (int i = 0; i < n.getChildNodes().getLength(); ++i) {
                res.add(n.getChildNodes().item(i));
            }
        }
        list = res;
        return (ArrayList<Node>) visit(ctx.rp());
    }

    @Override
    // filename : NAME ('.' NAME)?
    public Object visitFilename(xQueryParser.FilenameContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    // rp : NAME
    public ArrayList<Node> visitTagName(xQueryParser.TagNameContext ctx) {
        ArrayList<Node> res = new ArrayList<>();
        ArrayList<Node> children = getChildren(list);
        for (Node child : children) {
            if (child.getNodeName().equals(ctx.getText())) {
                res.add(child);
            }
        }
        list = res;
        return res;
    }

    @Override
    // rp : '..'
    public ArrayList<Node> visitParent(xQueryParser.ParentContext ctx) {
        Set<Node> set = new HashSet<>();  // unique parent
        for (Node n : list) {
            set.add(n.getParentNode());
        }
        ArrayList<Node> res = new ArrayList<>();
        for (Node n : set) {
            res.add(n);
        }
        list = res;
        return res;
    }

    @Override
    // rp: '@' NAME
    public ArrayList<Node> visitAttribute(xQueryParser.AttributeContext ctx) {
        ArrayList<Node> res = new ArrayList<>();
        String name = ctx.NAME().getText();
        for (Node n : list) {
            if (!((Element)n).getAttribute(name).isEmpty()) {
                res.add(n);
            }
        }
        list = res;
        return res;
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
    // rp: 'text()'
    public Object visitText(xQueryParser.TextContext ctx) {
        ArrayList<Node> res = new ArrayList<>();
        ArrayList<Node> children = getChildren(list);
        for (Node child : children) {
            if (child.getNodeType() == Node.TEXT_NODE) { // Should we consider "\n" etc.?
                res.add(child);
            }
        }
        list = res;
        return res;
    }

    @Override
    public Object visitRDescendent(xQueryParser.RDescendentContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    // rp: '*'
    public ArrayList<Node> visitChildren(xQueryParser.ChildrenContext ctx) {
        ArrayList<Node> res = getChildren(list);
        list = res;
        return res;
    }

    @Override
    // rp : '.'
    public ArrayList<Node> visitSelf(xQueryParser.SelfContext ctx) {
        return list;
    }

    @Override
    public Object visitRDesOrSelf(xQueryParser.RDesOrSelfContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    // rp: '(' rp ')'
    public ArrayList<Node> visitRBracket(xQueryParser.RBracketContext ctx) {
        return (ArrayList<Node>) visit(ctx.rp());
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

    // Get the list of children of current nodes
    private ArrayList<Node> getChildren(ArrayList<Node> list) {
        ArrayList<Node> childrenList = new ArrayList<>();
        for (Node n : list) {
            NodeList children = n.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                childrenList.add(children.item(i));
            }
        }
        return childrenList;
    }

}