// Generated from /Users/suen/Desktop/CSE232B/CSE232B-Database/src/resource/xQuery.g4 by ANTLR 4.8
package resource;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link xQueryParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface xQueryVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code Descendent}
	 * labeled alternative in {@link xQueryParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescendent(xQueryParser.DescendentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AllDescendent}
	 * labeled alternative in {@link xQueryParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllDescendent(xQueryParser.AllDescendentContext ctx);
	/**
	 * Visit a parse tree produced by {@link xQueryParser#filename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilename(xQueryParser.FilenameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Txt}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTxt(xQueryParser.TxtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Concatenation}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatenation(xQueryParser.ConcatenationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagName}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagName(xQueryParser.TagNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parent}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParent(xQueryParser.ParentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Attribute}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(xQueryParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RFilter}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRFilter(xQueryParser.RFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RAll}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRAll(xQueryParser.RAllContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RDescendent}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRDescendent(xQueryParser.RDescendentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Children}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChildren(xQueryParser.ChildrenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Current}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCurrent(xQueryParser.CurrentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RRn}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRRn(xQueryParser.RRnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CheckNotEmpty}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckNotEmpty(xQueryParser.CheckNotEmptyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(xQueryParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AlsoIs}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlsoIs(xQueryParser.AlsoIsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(xQueryParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Equal}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqual(xQueryParser.EqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code And}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(xQueryParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AlsoEqual}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlsoEqual(xQueryParser.AlsoEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Is}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIs(xQueryParser.IsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FFn}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFFn(xQueryParser.FFnContext ctx);
}