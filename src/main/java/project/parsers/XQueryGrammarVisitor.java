// Generated from XQueryGrammar.g4 by ANTLR 4.7.2

package project.parsers;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XQueryGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XQueryGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code StringXQ}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringXQ(XQueryGrammarParser.StringXQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SingleSlashXQ}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleSlashXQ(XQueryGrammarParser.SingleSlashXQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ApXQ}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApXQ(XQueryGrammarParser.ApXQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarXQ}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarXQ(XQueryGrammarParser.VarXQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SequenceXQ}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequenceXQ(XQueryGrammarParser.SequenceXQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BracketXQ}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketXQ(XQueryGrammarParser.BracketXQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FlworXQ}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlworXQ(XQueryGrammarParser.FlworXQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagXQ}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagXQ(XQueryGrammarParser.TagXQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LetClauseXQ}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetClauseXQ(XQueryGrammarParser.LetClauseXQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoubleSlashXQ}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleSlashXQ(XQueryGrammarParser.DoubleSlashXQContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryGrammarParser#forClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForClause(XQueryGrammarParser.ForClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryGrammarParser#letClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetClause(XQueryGrammarParser.LetClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryGrammarParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereClause(XQueryGrammarParser.WhereClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryGrammarParser#returnClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnClause(XQueryGrammarParser.ReturnClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultipleCond}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultipleCond(XQueryGrammarParser.MultipleCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OrCond}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrCond(XQueryGrammarParser.OrCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqualCond}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualCond(XQueryGrammarParser.EqualCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AndCond}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndCond(XQueryGrammarParser.AndCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotCond}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotCond(XQueryGrammarParser.NotCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyCond}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyCond(XQueryGrammarParser.EmptyCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BracketCond}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketCond(XQueryGrammarParser.BracketCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IsCond}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsCond(XQueryGrammarParser.IsCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SingleSlashAP}
	 * labeled alternative in {@link XQueryGrammarParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleSlashAP(XQueryGrammarParser.SingleSlashAPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoubleSlashAP}
	 * labeled alternative in {@link XQueryGrammarParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleSlashAP(XQueryGrammarParser.DoubleSlashAPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AllChildrenRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllChildrenRP(XQueryGrammarParser.AllChildrenRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoubleSlashRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleSlashRP(XQueryGrammarParser.DoubleSlashRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FilteredRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilteredRP(XQueryGrammarParser.FilteredRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagRP(XQueryGrammarParser.TagRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TextRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextRP(XQueryGrammarParser.TextRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttributeRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeRP(XQueryGrammarParser.AttributeRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BracketRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketRP(XQueryGrammarParser.BracketRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SequenceRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequenceRP(XQueryGrammarParser.SequenceRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParentRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentRP(XQueryGrammarParser.ParentRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SelfRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfRP(XQueryGrammarParser.SelfRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SingleSlashRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleSlashRP(XQueryGrammarParser.SingleSlashRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AndFilter}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndFilter(XQueryGrammarParser.AndFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IsFilter}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsFilter(XQueryGrammarParser.IsFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BracketFilter}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketFilter(XQueryGrammarParser.BracketFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RPFilter}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRPFilter(XQueryGrammarParser.RPFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotFilter}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotFilter(XQueryGrammarParser.NotFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConstantFilter}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantFilter(XQueryGrammarParser.ConstantFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqualFilter}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualFilter(XQueryGrammarParser.EqualFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OrFilter}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrFilter(XQueryGrammarParser.OrFilterContext ctx);
}