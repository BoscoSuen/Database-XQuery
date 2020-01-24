// Generated from /Users/vivian/CSE232B-Database/src/resource/xQuery.g4 by ANTLR 4.8
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
	 * Visit a parse tree produced by the {@code ADescendent}
	 * labeled alternative in {@link xQueryParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitADescendent(xQueryParser.ADescendentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ADesOrSelf}
	 * labeled alternative in {@link xQueryParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitADesOrSelf(xQueryParser.ADesOrSelfContext ctx);
	/**
	 * Visit a parse tree produced by {@link xQueryParser#filename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilename(xQueryParser.FilenameContext ctx);
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
	 * Visit a parse tree produced by the {@code RConcat}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRConcat(xQueryParser.RConcatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RFilter}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRFilter(xQueryParser.RFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Text}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(xQueryParser.TextContext ctx);
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
	 * Visit a parse tree produced by the {@code Self}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelf(xQueryParser.SelfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RDesOrSelf}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRDesOrSelf(xQueryParser.RDesOrSelfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RBracket}
	 * labeled alternative in {@link xQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRBracket(xQueryParser.RBracketContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FIs}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFIs(xQueryParser.FIsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FAnd}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFAnd(xQueryParser.FAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FRp}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFRp(xQueryParser.FRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FOr}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFOr(xQueryParser.FOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FBracket}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFBracket(xQueryParser.FBracketContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FEqual}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFEqual(xQueryParser.FEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FNot}
	 * labeled alternative in {@link xQueryParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFNot(xQueryParser.FNotContext ctx);
}