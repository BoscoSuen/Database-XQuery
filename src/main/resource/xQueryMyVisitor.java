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
        Queue<Node> queue = new LinkedList<>(list);
        ArrayList<Node> res = new ArrayList<>(list);
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
        ArrayList<Node> res = new ArrayList<>();
        for (Node n : list) {
            res.add(n.getParentNode());
        }
        list = unique(res);
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
    // rp: 'text()'
    public ArrayList<Node> visitText(xQueryParser.TextContext ctx) {
        ArrayList<Node> res = new ArrayList<>();
        ArrayList<Node> children = getChildren(list);
        for (Node child : children) {
            if (child.getNodeType() == Node.TEXT_NODE) {
                res.add(child);
            }
        }
        list = res;
        return res;
    }

    @Override
    // rp: '*'
    public ArrayList<Node> visitChildren(xQueryParser.ChildrenContext ctx) {
        list = getChildren(list);
        return list;
    }

    @Override
    // rp : '.'
    public ArrayList<Node> visitSelf(xQueryParser.SelfContext ctx) {
        return list;
    }

    @Override
    // rp: '(' rp ')'
    public ArrayList<Node> visitRBracket(xQueryParser.RBracketContext ctx) {
        return (ArrayList<Node>) visit(ctx.rp());
    }

    @Override
    // rp: rp '/' rp
    public ArrayList<Node> visitRDescendent(xQueryParser.RDescendentContext ctx) {
        visit(ctx.rp(0));
        visit(ctx.rp(1));
        return unique(list);
    }

    @Override
    // rp: rp '//' rp
    public ArrayList<Node> visitRDesOrSelf(xQueryParser.RDesOrSelfContext ctx) {
        visit(ctx.rp(0));
        Queue<Node> queue = new LinkedList<>(list);
        ArrayList<Node> res = new ArrayList<>(list);
        getDesOrSelf(res, queue);
        list = unique(res);
        visit(ctx.rp(1));
        return unique(list);
    }

    @Override
    // rp: rp ',' rp
    public ArrayList<Node> visitRConcat(xQueryParser.RConcatContext ctx) {
        ArrayList<Node> res = new ArrayList<>();
        ArrayList<Node> temp = new ArrayList<>(list);
        visit(ctx.rp(0));
        ArrayList<Node> left = new ArrayList<>(list);
        list = temp;
        visit(ctx.rp(1));
        ArrayList<Node> right = new ArrayList<>(list);
        res.addAll(left);
        res.addAll(right);
        list = unique(res);
        return res;
    }

    @Override
    // rp: rp '[' filter ']'
    public ArrayList<Node> visitRFilter(xQueryParser.RFilterContext ctx) {
        visit(ctx.rp());
        ArrayList<Node> temp = new ArrayList<>(list);
        ArrayList<Node> res = new ArrayList<>();
        for (Node n : temp) {
            list = new ArrayList<>();
            list.add(n);
            if (!((ArrayList<Node>)visit(ctx.filter())).isEmpty()) {
                res.add(n);
            }
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
    // filter: '(' filter ')'
    public ArrayList<Node> visitFBracket(xQueryParser.FBracketContext ctx) {
        return (ArrayList<Node>) visit(ctx.filter());
    }

    @Override
    // filter: rp '=' rp / rp 'eq' rp
    public ArrayList<Node> visitFEqual(xQueryParser.FEqualContext ctx) {
        ArrayList<Node> temp = new ArrayList<>(list);
        ArrayList<Node> left = (ArrayList<Node>) visit(ctx.rp(0));
        list = temp;
        ArrayList<Node> right = (ArrayList<Node>) visit(ctx.rp(1));
        list = temp;
        if (hasEqualOrSame(left, right, true)) {
            return temp;
        }
        return new ArrayList<>();
    }

    @Override
    // filter: rp '==' rp / rp 'is' rp
    public ArrayList<Node> visitFIs(xQueryParser.FIsContext ctx) {
        ArrayList<Node> temp = new ArrayList<>(list);
        ArrayList<Node> left = (ArrayList<Node>) visit(ctx.rp(0));
        list = temp;
        ArrayList<Node> right = (ArrayList<Node>) visit(ctx.rp(1));
        list = temp;
        if (hasEqualOrSame(left, right, false)) {
            return temp;
        }
        return new ArrayList<>();
    }

    @Override
    // filter : filter 'and' filter
    public ArrayList<Node> visitFAnd(xQueryParser.FAndContext ctx) {
        ArrayList<Node> left = (ArrayList<Node>) visit(ctx.filter(0));
        ArrayList<Node> right = (ArrayList<Node>) visit(ctx.filter(1));
        Set<Node> set = new HashSet<>();
        left.retainAll((right)); // intersection
        set.addAll(left);
        return set.size() == 0? new ArrayList<>() : list;
    }

    @Override
    // filter : filter 'or' filter
    public ArrayList<Node> visitFOr(xQueryParser.FOrContext ctx) {
        ArrayList<Node> left = (ArrayList<Node>) visit(ctx.filter(0));
        ArrayList<Node> right = (ArrayList<Node>) visit(ctx.filter(1));
        Set<Node> set = new HashSet<>();
        set.addAll(left); // union
        set.addAll(right);
        return set.size() == 0? new ArrayList<>() : list;
    }

    @Override
    // filter : 'not' filter
    public ArrayList<Node> visitFNot(xQueryParser.FNotContext ctx) {
        ArrayList<Node> filterRes = (ArrayList<Node>) visit(ctx.filter());
        return filterRes.size() == 0? list : new ArrayList<>();
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

    // If there exists any equal or same nodes in left and right lists
    private boolean hasEqualOrSame(ArrayList<Node> left, ArrayList<Node> right, boolean isEqual) {
        for (Node l : left) {
            for (Node r : right) {
                if ((isEqual && l.isEqualNode(r)) || (!isEqual && l.isSameNode(r))) {
                    return true;
                }
            }
        }
        return false;
    }

    // Remove duplicate elements in the list
    private ArrayList<Node> unique(ArrayList<Node> input) {
        ArrayList<Node> res = new ArrayList<>();
        for (Node i : input) {
            if (res.contains(i)) {
                continue;
            }
            res.add(i);
        }
        input = res;
        return input;
    }






    // Xquery
    Map<String, ArrayList<Node>> textMap = new HashMap<>();
    Deque<HashMap<String, ArrayList<Node>>> deque = new LinkedList<>();  // used for iteration clause
    // current rp Node List: list

    @Override
    // xq: var
    public ArrayList<Node> visitVar(xQueryParser.VarContext ctx) {
        return textMap.get(ctx.getText());    // makeText(s)
    }

    // xq: stringConstant

    @Override
    // xq: ap
    public ArrayList<Node> visitXQAp(xQueryParser.XQApContext ctx) {
        return (ArrayList<Node>) visit(ctx.ap());
    }

    @Override
    // xq: ( xq )
    public ArrayList<Node> visitXQBracket(xQueryParser.XQBracketContext ctx) {
        return (ArrayList<Node>) visit(ctx.xq());
    }

    @Override
    // xq: xq , xq
    public ArrayList<Node> visitXQConcat(xQueryParser.XQConcatContext ctx) {
        ArrayList<Node> res = new ArrayList<>();
        ArrayList<Node> temp = new ArrayList<>(list);
        visit(ctx.xq(0));
        ArrayList<Node> left = new ArrayList<>(list);
        list = temp;
        visit(ctx.xq(1));
        List<Node> right = new ArrayList<>(list);
        res.addAll(left);
        res.addAll(right);
        list = unique(res);
        return res;
    }

    // xq: xq '/' rp

    // xq: xq '//' rp

}