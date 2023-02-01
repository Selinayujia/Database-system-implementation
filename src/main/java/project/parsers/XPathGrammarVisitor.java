// Generated from XPathGrammar.g4 by ANTLR 4.7.2

package project.parsers;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XPathGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XPathGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code SingleSlashAP}
	 * labeled alternative in {@link XPathGrammarParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleSlashAP(XPathGrammarParser.SingleSlashAPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoubleSlashAP}
	 * labeled alternative in {@link XPathGrammarParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleSlashAP(XPathGrammarParser.DoubleSlashAPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AllChildrenRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllChildrenRP(XPathGrammarParser.AllChildrenRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoubleSlashRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleSlashRP(XPathGrammarParser.DoubleSlashRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FilteredRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilteredRP(XPathGrammarParser.FilteredRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagRP(XPathGrammarParser.TagRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TextRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextRP(XPathGrammarParser.TextRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttributeRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeRP(XPathGrammarParser.AttributeRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BracketRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketRP(XPathGrammarParser.BracketRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SequenceRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequenceRP(XPathGrammarParser.SequenceRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParentRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentRP(XPathGrammarParser.ParentRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SelfRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfRP(XPathGrammarParser.SelfRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SingleSlashRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleSlashRP(XPathGrammarParser.SingleSlashRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AndFilter}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndFilter(XPathGrammarParser.AndFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IsFilter}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsFilter(XPathGrammarParser.IsFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BracketFilter}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketFilter(XPathGrammarParser.BracketFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RPFilter}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRPFilter(XPathGrammarParser.RPFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotFilter}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotFilter(XPathGrammarParser.NotFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConstantFilter}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantFilter(XPathGrammarParser.ConstantFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqualFilter}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualFilter(XPathGrammarParser.EqualFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OrFilter}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrFilter(XPathGrammarParser.OrFilterContext ctx);
}