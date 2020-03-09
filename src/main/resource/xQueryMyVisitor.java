/**
 * Created by Xiaohan Zhu and Zhiqiang Sun
 */

package main.resource;

// import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.util.*;

public class xQueryMyVisitor extends xQueryBaseVisitor<Object> {

    private ArrayList<Node> list = new ArrayList<>(); // current visited list

    @Override
    // ap: 'doc("' filename '")' '/' rp
    public ArrayList<Node> visitADescendent(xQueryParser.ADescendentContext ctx) {
        Node root = getRoot(ctx.filename().getText());
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
        Set<Node> res = new HashSet<>();
        for (Node i : input) {
            res.add(i);
        }
        input = new ArrayList<>(res);
        return input;
    }

    // Xquery
    Map<String, ArrayList<Node>> textMap = new HashMap<>();
    // current rp Node List: list

    @Override
    // xq: var
    public ArrayList<Node> visitVar(xQueryParser.VarContext ctx) {
        return textMap.get(ctx.getText());    // makeText(s)
    }

    @Override
    // xq: var
    public ArrayList<Node> visitXQValue(xQueryParser.XQValueContext ctx) {
        return textMap.get(ctx.getText());
    }

    @Override
    // xq: stringConstant
    public ArrayList<Node> visitStringConstant(xQueryParser.StringConstantContext ctx) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document doc = db.newDocument();
        String curStr = ctx.STRINGCONSTANT().toString();
        curStr = curStr.substring(1, curStr.length() - 1);
        Node newNode = doc.createTextNode(curStr);
        ArrayList<Node> res = new ArrayList<>();
        res.add(newNode);
        return res;
    }

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
        HashMap<String, ArrayList<Node>> tt = new HashMap<>(textMap);
        ArrayList<Node> res = new ArrayList<>();
        ArrayList<Node> left = (ArrayList<Node>) visit(ctx.xq(0));
        textMap = tt;
        ArrayList<Node> right = (ArrayList<Node>) visit(ctx.xq(1));
        res.addAll(right);
        res.addAll(left);
        textMap = tt;
        return unique(res);
    }

    @Override
    // xq: xq '/' rp
    public ArrayList<Node> visitXQChild(xQueryParser.XQChildContext ctx) {
        list = (ArrayList<Node>) visit(ctx.xq());
        visit(ctx.rp());
        return unique(list);
    }

    // xq: xq '//' rp
    public ArrayList<Node> visitXQDescendent(xQueryParser.XQDescendentContext ctx) {
        list = (ArrayList<Node>) visit(ctx.xq());
        Queue<Node> queue = new LinkedList<>(list);
        ArrayList<Node> res = new ArrayList<>(list);
        getDesOrSelf(res, queue);
        list = res;
        visit(ctx.rp());

        return unique(list);
    }

    // xq: '<' NAME '>' '{' xq '}' '</' NAME '>'
    public ArrayList<Node> visitXQNodeConstrctor(xQueryParser.XQNodeConstrctorContext ctx) {
        ArrayList<Node> res = (ArrayList<Node>) visit(ctx.xq());
        String tagName = ctx.NAME(0).getText();
        return makeElem(tagName, res);
    }

    private ArrayList<Node> makeElem(String tagName, ArrayList<Node> nodeList) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document doc = db.newDocument();

        Node newNode = doc.createElement(tagName);
        for (Node node : nodeList) {
            Node deepCopy = doc.importNode(node, true);
            newNode.appendChild(deepCopy);
        }
        ArrayList<Node> res =  new ArrayList<>();
        res.add(newNode);
        return res;
    }

    @Override
    // xq: forClause
    public ArrayList<HashMap<String, ArrayList<Node>>> visitForClause(xQueryParser.ForClauseContext ctx) {
        ArrayList<HashMap<String, Node>> combined = new ArrayList<>();
        ArrayList<HashMap<String, ArrayList<Node>>> res = new ArrayList<>();
        int idx = 0;  // current for loop idx
        Deque<HashMap<String, Node>> deque = new LinkedList<>();  // used for BFS
        HashMap<String, ArrayList<Node>> temp = new HashMap<>(textMap);
        String var0 = ctx.var(0).getText();
        ArrayList<Node> list0 = (ArrayList<Node>) visit(ctx.xq(0));
        for (Node n : list0) {
            HashMap<String, Node> map = new HashMap<>();
            map.put(var0, n);
            deque.offer(map);
        }
        while (!deque.isEmpty()) {
            idx++;
            int size = deque.size();
            if (idx == ctx.var().size()) {
                // get all the combined map list
                while (!deque.isEmpty()) {
                    HashMap<String, Node> curMap = deque.poll();
                    combined.add(curMap);
                }
                break;
            } else {
                for (int i = 0; i < size; ++i) {
                    HashMap<String, Node> curMap = deque.poll();
                    String nextVar = ctx.var(idx).getText(); // current map bind the next var-node pairs

                    for (String var : curMap.keySet()) {
                        ArrayList<Node> subListToTextMap = new ArrayList<>();
                        subListToTextMap.add(curMap.get(var));
                        textMap.put(var, subListToTextMap);
                    }
                    ArrayList<Node> nextList = (ArrayList<Node>) visit(ctx.xq(idx));
                    for (Node n : nextList) {
                        HashMap<String, Node> map = new HashMap<>(curMap);
                        map.put(nextVar, n);
                        deque.offer(map);
                    }
                }
            }
        }
        textMap = temp;
        // now we get all the combined map list,
        // we have to convert the node to list of node to match the var query
        for (HashMap<String, Node> map : combined) {
            HashMap<String, ArrayList<Node>> curMap = new HashMap<>();
            for (String var : map.keySet()) {
                ArrayList<Node> nodeList = new ArrayList<>();
                nodeList.add(map.get(var));
                curMap.put(var, nodeList);
            }
            res.add(curMap);
        }

        return res;
    }

    @Override
    // xq: where clause
    public ArrayList<Node> visitWhereClause(xQueryParser.WhereClauseContext ctx) {
        return (ArrayList<Node>) visit(ctx.cond());
    }

    @Override
    // xq: return clause
    public ArrayList<Node> visitReturnClause(xQueryParser.ReturnClauseContext ctx) {
        return (ArrayList<Node>) visit(ctx.xq());
    }

    @Override
    // xq: forClause letClause? whereClause? returnClause  # XQFLWOR
    public ArrayList<Node> visitXQFLWOR(xQueryParser.XQFLWORContext ctx) {
        ArrayList<Node> res = new ArrayList<>();
        if (ctx.forClause() == null) {
            return res;
        }

        ArrayList<HashMap<String, ArrayList<Node>>> combinedList = (ArrayList<HashMap<String, ArrayList<Node>>>) visit(ctx.forClause());
        HashMap<String, ArrayList<Node>> temp = new HashMap<>(textMap);
        for (HashMap<String, ArrayList<Node>> map : combinedList) {
            textMap.putAll(map); // the current query map cover the original text map
            if (ctx.letClause() != null) {
                visit(ctx.letClause());
            }
            if (ctx.whereClause() != null) {
                ArrayList<Node> where = (ArrayList<Node>) visit(ctx.whereClause());
                if (where.size() > 0) {
                    res.addAll((ArrayList<Node>)visit(ctx.returnClause()));
                }
            }
            else {
                res.addAll((ArrayList<Node>)visit(ctx.returnClause()));
            }
            textMap = temp;
        }
        textMap = temp;
        return res;
    }

    @Override
    // xq: letClause xq
    public ArrayList<Node> visitXQDefine(xQueryParser.XQDefineContext ctx) {
        HashMap<String, ArrayList<Node>> temp = new HashMap<>(textMap);
        visit(ctx.letClause());
        ArrayList<Node> result = (ArrayList<Node>) visit(ctx.xq());
        textMap = temp;
        return result;
    }

    @Override
    public ArrayList<Node> visitLetClause(xQueryParser.LetClauseContext ctx) {
        for (int i = 0; i < ctx.var().size(); i++) {
            textMap.put(ctx.var(i).getText(), (ArrayList<Node>) visit(ctx.xq(i)));
        }
        return list;
    }

    // cond: xq '=' xq / xq 'eq' xq
    public ArrayList<Node> visitXQEqual(xQueryParser.XQEqualContext ctx) {
        ArrayList<Node> temp = new ArrayList<>(list);
        Map<String, ArrayList<Node>> tt = new HashMap<>(textMap);
        ArrayList<Node> left = (ArrayList<Node>) visit(ctx.xq(0));
        list = temp;
        textMap = tt;
        ArrayList<Node> right = (ArrayList<Node>) visit(ctx.xq(1));
        list = temp;
        textMap = tt;
        if (hasEqualOrSame(left, right, true)) {
            return temp;
        }
        return new ArrayList<>();
    }

    // cond: xq '==' xq / xq 'is' xq
    public ArrayList<Node> visitXQIs(xQueryParser.XQIsContext ctx) {
        ArrayList<Node> temp = new ArrayList<>(list);
        ArrayList<Node> left = (ArrayList<Node>) visit(ctx.xq(0));
        list = temp;
        ArrayList<Node> right = (ArrayList<Node>) visit(ctx.xq(1));
        list = temp;
        if (hasEqualOrSame(left, right, false)) {
            return temp;
        }
        return new ArrayList<>();
    }

    // cond: '(' cond ')'
    public ArrayList<Node> visitXQCond(xQueryParser.XQCondContext ctx) {
        return (ArrayList<Node>) visit(ctx.cond());
    }

    // cond: 'empty' '(' xq ')'
    public ArrayList<Node> visitXQIsEmpty(xQueryParser.XQIsEmptyContext ctx) {
        ArrayList<Node> temp = new ArrayList<>(list);
        ArrayList<Node> res = (ArrayList<Node>) visit(ctx.xq());
        list = temp;
        return res.size() == 0? list : new ArrayList<>();
    }

    // cond: cond 'or' cond
    public ArrayList<Node> visitXQOrCond(xQueryParser.XQOrCondContext ctx) {
        ArrayList<Node> left = (ArrayList<Node>) visit(ctx.cond(0));
        ArrayList<Node> right = (ArrayList<Node>) visit(ctx.cond(1));
        if (!left.isEmpty() || !right.isEmpty()) {
            return list;
        }
        return new ArrayList<>();
    }

    // cond: cond 'and' cond
    public ArrayList<Node> visitXQAndCond(xQueryParser.XQAndCondContext ctx) {
        ArrayList<Node> left = (ArrayList<Node>) visit(ctx.cond(0));
        ArrayList<Node> right = (ArrayList<Node>) visit(ctx.cond(1));
        if (!left.isEmpty() && !right.isEmpty()) {
            return list;
        }
        return new ArrayList<>();
    }

    // cond: 'not' cond
    public ArrayList<Node> visitXQNot(xQueryParser.XQNotContext ctx) {
        ArrayList<Node> res = (ArrayList<Node>) visit(ctx.cond());
        return res.size() == 0? list : new ArrayList<>();
    }

    // cond: 'some' var 'in' xq(',' var 'in' xq)* 'satisfies' cond
    // not very sure
    public ArrayList<Node> visitXQSatisfy(xQueryParser.XQSatisfyContext ctx) {
        for (int i = 0; i < ctx.var().size(); i++) {
            ArrayList<Node> cur = (ArrayList<Node>) visit(ctx.xq(i));
            textMap.put(ctx.var(i).getText(), cur);
        }
        ArrayList<Node> res = (ArrayList<Node>) visit(ctx.cond());
        return res;
    }

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
