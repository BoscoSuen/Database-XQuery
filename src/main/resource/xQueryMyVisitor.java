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
import java.util.*;

public class xQueryMyVisitor extends xQueryBaseVisitor<Object> {

    private ArrayList<Node> list = new ArrayList<>(); // current visited list

    @Override
    // ap: 'doc("' filename '")' '/' rp
    public ArrayList<Node> visitADescendent(xQueryParser.ADescendentContext ctx) {
        Node root = getRoot(ctx.filename().getText());
        list.add(root);
        return (ArrayList<Node>) visit(ctx.rp());
    }

    @Override
    // ap: 'doc("' filename '")' '//' rp
    public ArrayList<Node> visitADesOrSelf(xQueryParser.ADesOrSelfContext ctx) {
        Node root = getRoot(ctx.filename().getText());
        list.add(root);
        Queue<Node> queue = new LinkedList<Node>(list);
        ArrayList<Node> res = new ArrayList<Node>(list);
        getDesOrSelf(res, queue);
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
    // rp: rp ',' rp
    public ArrayList<Node> visitRConcat(xQueryParser.RConcatContext ctx) {
        Set<Node> set = new HashSet<>();
        ArrayList<Node> temp = new ArrayList<>(list);
        visit(ctx.rp(0));
        ArrayList<Node> left = new ArrayList<>(list);
        list = temp;
        visit(ctx.rp(1));
        ArrayList<Node> right = new ArrayList<>(list);
        set.addAll(left);
        set.addAll(right);
        ArrayList<Node> res = new ArrayList<>();
        for (Node n : set) {
            res.add(n);
        }
        list = res;
        return res;
    }

    @Override
    // rp: rp '[' filter ']'
    public ArrayList<Node> visitRFilter(xQueryParser.RFilterContext ctx) {
        visit(ctx.rp());
        ArrayList<Node> temp = new ArrayList<Node>(list);
        ArrayList<Node> res = new ArrayList<Node>();
        for (Node n : temp) {
            list = new ArrayList<Node>();
            list.add(n);
            if (!((ArrayList<Node>)visit(ctx.filter())).isEmpty()) {
                res.add(n);
            }
        }
        list = res;
        return res;
    }

    @Override
    // rp: 'text()'
    public ArrayList<Node> visitText(xQueryParser.TextContext ctx) {
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
    // rp: rp '/' rp
    public ArrayList<Node> visitRDescendent(xQueryParser.RDescendentContext ctx) {
        visit(ctx.rp(0));
        return (ArrayList<Node>) visit(ctx.rp(1));
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
    // rp: rp '//' rp
    public ArrayList<Node> visitRDesOrSelf(xQueryParser.RDesOrSelfContext ctx) {
        visit(ctx.rp(0));
        Queue<Node> queue = new LinkedList<Node>(list);
        ArrayList<Node> res = new ArrayList<Node>(list);
        getDesOrSelf(res, queue);
        list = res;
        return (ArrayList<Node>) visit(ctx.rp(1));
    }

    @Override
    // rp: '(' rp ')'
    public ArrayList<Node> visitRBracket(xQueryParser.RBracketContext ctx) {
        return (ArrayList<Node>) visit(ctx.rp());
    }

    @Override
    // filter : filter 'and' filter
    public ArrayList<Node> visitFAnd(xQueryParser.FAndContext ctx) {
        ArrayList<Node> temp = new ArrayList<>(list);
        ArrayList<Node> left = (ArrayList<Node>) visit(ctx.filter(0));
        list = temp;
        ArrayList<Node> right = (ArrayList<Node>) visit(ctx.filter(1));
        Set<Node> set = new HashSet<>();
        left.retainAll((right)); // intersection
        set.addAll(left);
        ArrayList<Node> res = new ArrayList<Node>();
        for (Node n : set) {
            res.add(n);
        }
        list = res;
        return res;
    }

    @Override
    // filter : rp
    public ArrayList<Node> visitFRp(xQueryParser.FRpContext ctx) {
        ArrayList<Node> temp = new ArrayList<>(list);
        ArrayList<Node> res = (ArrayList<Node>) visit(ctx.rp());
        list = temp;
        return res;
    }

    @Override
    // filter : filter 'or' filter
    public ArrayList<Node> visitFOr(xQueryParser.FOrContext ctx) {
        ArrayList<Node> temp = new ArrayList<>(list);
        ArrayList<Node> left = (ArrayList<Node>) visit(ctx.filter(0));
        list = temp;
        ArrayList<Node> right = (ArrayList<Node>) visit(ctx.filter(1));
        Set<Node> set = new HashSet<>();
        set.addAll(left);
        set.addAll(right);
        ArrayList<Node> res = new ArrayList<Node>();
        for (Node n : set) {
            res.add(n);
        }
        list = res;
        return res;
    }

    @Override
    // filter: '(' filter ')'
    public ArrayList<Node> visitFBracket(xQueryParser.FBracketContext ctx) {
        return (ArrayList<Node>) visit(ctx.filter());
    }

    @Override
    // filter: rp '=' rp / rp 'eq' rp
    public ArrayList<Node> visitFEqual(xQueryParser.FEqualContext ctx) {
        ArrayList<Node> temp = new ArrayList<>(list);
        Set<Node> set = new HashSet<>();
        for (Node n : list) {
            ArrayList<Node> t = new ArrayList<Node>();
            t.add(n);
            list = t;
            ArrayList<Node> left = (ArrayList<Node>) visit(ctx.rp(0));
            list = t;
            ArrayList<Node> right = (ArrayList<Node>) visit(ctx.rp(1));
            for (Node l : left) {
                for (Node r : right) {
                    if (l.isEqualNode(r)) {
                        set.add(n);
                        break;
                    }
                }
            }
        }
        ArrayList<Node> res = new ArrayList<Node>();
        for (Node n : set) {
            res.add(n);
        }
        list = res;
        return res;
    }

    @Override
    // filter: rp '==' rp / rp 'is' rp
    public ArrayList<Node> visitFIs(xQueryParser.FIsContext ctx) {
        ArrayList<Node> temp = new ArrayList<>(list);
        Set<Node> set = new HashSet<>();
        for (Node n : list) {
            ArrayList<Node> t = new ArrayList<Node>();
            t.add(n);
            list = t;
            ArrayList<Node> left = (ArrayList<Node>) visit(ctx.rp(0));
            list = t;
            ArrayList<Node> right = (ArrayList<Node>) visit(ctx.rp(1));
            for (Node l : left) {
                for (Node r : right) {
                    if (l.isSameNode(r)) {
                        set.add(n);
                        break;
                    }
                }
            }
        }
        ArrayList<Node> res = new ArrayList<Node>();
        for (Node n : set) {
            res.add(n);
        }
        list = res;
        return res;
    }

    @Override
    // filter : 'not' filter
    public ArrayList<Node> visitFNot(xQueryParser.FNotContext ctx) {
        ArrayList<Node> temp = new ArrayList<>(list);
        ArrayList<Node> filterRes = (ArrayList<Node>) visit(ctx.filter());
        Set<Node> set = new HashSet<>();
        set.addAll(temp);
        set.removeAll(filterRes);
        ArrayList<Node> res = new ArrayList<Node>();
        for (Node n : set) {
            res.add(n);
        }
        list = res;
        return res;
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

    // Get descendants of a node, including node itself
    private void getDesOrSelf(ArrayList<Node> res, Queue<Node>  queue) {
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            if (!n.hasChildNodes()) {
                continue;
            }
            NodeList children = n.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                res.add(children.item(i));
                queue.offer(children.item(i));
            }
        }
    }

}