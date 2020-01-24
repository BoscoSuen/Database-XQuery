package main.resource;


public class xQueryMyVisitor extends xQueryBaseVisitor<Object> {
    @Override
    public Object visitADescendent(xQueryParser.ADescendentContext ctx) {
        System.out.println("Success");
        return visitChildren(ctx);
    }

    @Override
    public Object visitADesOrSelf(xQueryParser.ADesOrSelfContext ctx) {
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
    public Object visitChildren(xQueryParser.ChildrenContext ctx) {
        return visitChildren(ctx);
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
}