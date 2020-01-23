// Generated from /Users/suen/Desktop/CSE232B/CSE232B-Database/src/resource/xQuery.g4 by ANTLR 4.8
package resource;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link xQueryParser}.
 */
public interface xQueryListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code Descendent}
	 * labeled alternative in {@link xQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterDescendent(xQueryParser.DescendentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Descendent}
	 * labeled alternative in {@link xQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitDescendent(xQueryParser.DescendentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AllDescendent}
	 * labeled alternative in {@link xQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterAllDescendent(xQueryParser.AllDescendentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AllDescendent}
	 * labeled alternative in {@link xQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitAllDescendent(xQueryParser.AllDescendentContext ctx);
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
	 * Enter a parse tree produced by the {@code Txt}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterTxt(xQueryParser.TxtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Txt}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitTxt(xQueryParser.TxtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Concatenation}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterConcatenation(xQueryParser.ConcatenationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Concatenation}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitConcatenation(xQueryParser.ConcatenationContext ctx);
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
	 * Enter a parse tree produced by the {@code RAll}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRAll(xQueryParser.RAllContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RAll}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRAll(xQueryParser.RAllContext ctx);
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
	 * Enter a parse tree produced by the {@code Current}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterCurrent(xQueryParser.CurrentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Current}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitCurrent(xQueryParser.CurrentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RRn}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRRn(xQueryParser.RRnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RRn}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRRn(xQueryParser.RRnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CheckNotEmpty}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterCheckNotEmpty(xQueryParser.CheckNotEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CheckNotEmpty}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitCheckNotEmpty(xQueryParser.CheckNotEmptyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Not}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterNot(xQueryParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitNot(xQueryParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AlsoIs}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterAlsoIs(xQueryParser.AlsoIsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AlsoIs}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitAlsoIs(xQueryParser.AlsoIsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Or}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterOr(xQueryParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitOr(xQueryParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Equal}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterEqual(xQueryParser.EqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Equal}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitEqual(xQueryParser.EqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code And}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterAnd(xQueryParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code And}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitAnd(xQueryParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AlsoEqual}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterAlsoEqual(xQueryParser.AlsoEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AlsoEqual}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitAlsoEqual(xQueryParser.AlsoEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Is}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterIs(xQueryParser.IsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Is}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitIs(xQueryParser.IsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FFn}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterFFn(xQueryParser.FFnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FFn}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitFFn(xQueryParser.FFnContext ctx);
}