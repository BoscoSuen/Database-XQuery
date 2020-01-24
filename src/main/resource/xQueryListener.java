// Generated from /Users/suen/Desktop/CSE232B/CSE232B-Database/src/resource/xQuery.g4 by ANTLR 4.8
package main.resource;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link xQueryParser}.
 */
public interface xQueryListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code ADescendent}
	 * labeled alternative in {@link xQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterADescendent(xQueryParser.ADescendentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ADescendent}
	 * labeled alternative in {@link xQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitADescendent(xQueryParser.ADescendentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ADesOrSelf}
	 * labeled alternative in {@link xQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterADesOrSelf(xQueryParser.ADesOrSelfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ADesOrSelf}
	 * labeled alternative in {@link xQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitADesOrSelf(xQueryParser.ADesOrSelfContext ctx);
	/**
	 * Enter a parse tree produced by {@link xQueryParser#filename}.
	 * @param ctx the parse tree
	 */
	void enterFilename(xQueryParser.FilenameContext ctx);
	/**
	 * Exit a parse tree produced by {@link xQueryParser#filename}.
	 * @param ctx the parse tree
	 */
	void exitFilename(xQueryParser.FilenameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagName}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterTagName(xQueryParser.TagNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagName}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitTagName(xQueryParser.TagNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parent}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterParent(xQueryParser.ParentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parent}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitParent(xQueryParser.ParentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Attribute}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(xQueryParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Attribute}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(xQueryParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RConcat}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRConcat(xQueryParser.RConcatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RConcat}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRConcat(xQueryParser.RConcatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RFilter}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRFilter(xQueryParser.RFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RFilter}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRFilter(xQueryParser.RFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Text}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterText(xQueryParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Text}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitText(xQueryParser.TextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RDescendent}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRDescendent(xQueryParser.RDescendentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RDescendent}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRDescendent(xQueryParser.RDescendentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Children}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterChildren(xQueryParser.ChildrenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Children}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitChildren(xQueryParser.ChildrenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Self}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterSelf(xQueryParser.SelfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Self}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitSelf(xQueryParser.SelfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RDesOrSelf}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRDesOrSelf(xQueryParser.RDesOrSelfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RDesOrSelf}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRDesOrSelf(xQueryParser.RDesOrSelfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RBracket}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRBracket(xQueryParser.RBracketContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RBracket}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRBracket(xQueryParser.RBracketContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FIs}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterFIs(xQueryParser.FIsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FIs}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitFIs(xQueryParser.FIsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FAnd}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterFAnd(xQueryParser.FAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FAnd}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitFAnd(xQueryParser.FAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FRp}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterFRp(xQueryParser.FRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FRp}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitFRp(xQueryParser.FRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FOr}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterFOr(xQueryParser.FOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FOr}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitFOr(xQueryParser.FOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FBracket}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterFBracket(xQueryParser.FBracketContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FBracket}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitFBracket(xQueryParser.FBracketContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FEqual}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterFEqual(xQueryParser.FEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FEqual}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitFEqual(xQueryParser.FEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FNot}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterFNot(xQueryParser.FNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FNot}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitFNot(xQueryParser.FNotContext ctx);
}