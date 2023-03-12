// Generated from XQueryGrammar.g4 by ANTLR 4.7.2

package project.parsers;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XQueryGrammarParser}.
 */
public interface XQueryGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code StringXQ}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterStringXQ(XQueryGrammarParser.StringXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringXQ}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitStringXQ(XQueryGrammarParser.StringXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SingleSlashXQ}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterSingleSlashXQ(XQueryGrammarParser.SingleSlashXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SingleSlashXQ}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitSingleSlashXQ(XQueryGrammarParser.SingleSlashXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ApXQ}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterApXQ(XQueryGrammarParser.ApXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ApXQ}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitApXQ(XQueryGrammarParser.ApXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JoinXQ}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterJoinXQ(XQueryGrammarParser.JoinXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JoinXQ}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitJoinXQ(XQueryGrammarParser.JoinXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarXQ}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterVarXQ(XQueryGrammarParser.VarXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarXQ}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitVarXQ(XQueryGrammarParser.VarXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SequenceXQ}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterSequenceXQ(XQueryGrammarParser.SequenceXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SequenceXQ}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitSequenceXQ(XQueryGrammarParser.SequenceXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BracketXQ}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterBracketXQ(XQueryGrammarParser.BracketXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BracketXQ}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitBracketXQ(XQueryGrammarParser.BracketXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FlworXQ}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterFlworXQ(XQueryGrammarParser.FlworXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FlworXQ}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitFlworXQ(XQueryGrammarParser.FlworXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagXQ}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterTagXQ(XQueryGrammarParser.TagXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagXQ}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitTagXQ(XQueryGrammarParser.TagXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LetClauseXQ}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterLetClauseXQ(XQueryGrammarParser.LetClauseXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LetClauseXQ}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitLetClauseXQ(XQueryGrammarParser.LetClauseXQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoubleSlashXQ}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterDoubleSlashXQ(XQueryGrammarParser.DoubleSlashXQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoubleSlashXQ}
	 * labeled alternative in {@link XQueryGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitDoubleSlashXQ(XQueryGrammarParser.DoubleSlashXQContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryGrammarParser#joinClause}.
	 * @param ctx the parse tree
	 */
	void enterJoinClause(XQueryGrammarParser.JoinClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryGrammarParser#joinClause}.
	 * @param ctx the parse tree
	 */
	void exitJoinClause(XQueryGrammarParser.JoinClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryGrammarParser#idList}.
	 * @param ctx the parse tree
	 */
	void enterIdList(XQueryGrammarParser.IdListContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryGrammarParser#idList}.
	 * @param ctx the parse tree
	 */
	void exitIdList(XQueryGrammarParser.IdListContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryGrammarParser#forClause}.
	 * @param ctx the parse tree
	 */
	void enterForClause(XQueryGrammarParser.ForClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryGrammarParser#forClause}.
	 * @param ctx the parse tree
	 */
	void exitForClause(XQueryGrammarParser.ForClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryGrammarParser#letClause}.
	 * @param ctx the parse tree
	 */
	void enterLetClause(XQueryGrammarParser.LetClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryGrammarParser#letClause}.
	 * @param ctx the parse tree
	 */
	void exitLetClause(XQueryGrammarParser.LetClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryGrammarParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(XQueryGrammarParser.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryGrammarParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(XQueryGrammarParser.WhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryGrammarParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void enterReturnClause(XQueryGrammarParser.ReturnClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryGrammarParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void exitReturnClause(XQueryGrammarParser.ReturnClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultipleCond}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterMultipleCond(XQueryGrammarParser.MultipleCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultipleCond}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitMultipleCond(XQueryGrammarParser.MultipleCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OrCond}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterOrCond(XQueryGrammarParser.OrCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OrCond}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitOrCond(XQueryGrammarParser.OrCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqualCond}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterEqualCond(XQueryGrammarParser.EqualCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqualCond}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitEqualCond(XQueryGrammarParser.EqualCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AndCond}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterAndCond(XQueryGrammarParser.AndCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AndCond}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitAndCond(XQueryGrammarParser.AndCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotCond}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterNotCond(XQueryGrammarParser.NotCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotCond}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitNotCond(XQueryGrammarParser.NotCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyCond}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterEmptyCond(XQueryGrammarParser.EmptyCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyCond}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitEmptyCond(XQueryGrammarParser.EmptyCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BracketCond}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterBracketCond(XQueryGrammarParser.BracketCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BracketCond}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitBracketCond(XQueryGrammarParser.BracketCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IsCond}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterIsCond(XQueryGrammarParser.IsCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IsCond}
	 * labeled alternative in {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitIsCond(XQueryGrammarParser.IsCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SingleSlashAP}
	 * labeled alternative in {@link XQueryGrammarParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterSingleSlashAP(XQueryGrammarParser.SingleSlashAPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SingleSlashAP}
	 * labeled alternative in {@link XQueryGrammarParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitSingleSlashAP(XQueryGrammarParser.SingleSlashAPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoubleSlashAP}
	 * labeled alternative in {@link XQueryGrammarParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterDoubleSlashAP(XQueryGrammarParser.DoubleSlashAPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoubleSlashAP}
	 * labeled alternative in {@link XQueryGrammarParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitDoubleSlashAP(XQueryGrammarParser.DoubleSlashAPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AllChildrenRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterAllChildrenRP(XQueryGrammarParser.AllChildrenRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AllChildrenRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitAllChildrenRP(XQueryGrammarParser.AllChildrenRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoubleSlashRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterDoubleSlashRP(XQueryGrammarParser.DoubleSlashRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoubleSlashRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitDoubleSlashRP(XQueryGrammarParser.DoubleSlashRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FilteredRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterFilteredRP(XQueryGrammarParser.FilteredRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FilteredRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitFilteredRP(XQueryGrammarParser.FilteredRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterTagRP(XQueryGrammarParser.TagRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitTagRP(XQueryGrammarParser.TagRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TextRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterTextRP(XQueryGrammarParser.TextRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TextRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitTextRP(XQueryGrammarParser.TextRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttributeRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterAttributeRP(XQueryGrammarParser.AttributeRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttributeRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitAttributeRP(XQueryGrammarParser.AttributeRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BracketRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterBracketRP(XQueryGrammarParser.BracketRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BracketRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitBracketRP(XQueryGrammarParser.BracketRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SequenceRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterSequenceRP(XQueryGrammarParser.SequenceRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SequenceRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitSequenceRP(XQueryGrammarParser.SequenceRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParentRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterParentRP(XQueryGrammarParser.ParentRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParentRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitParentRP(XQueryGrammarParser.ParentRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SelfRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterSelfRP(XQueryGrammarParser.SelfRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SelfRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitSelfRP(XQueryGrammarParser.SelfRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SingleSlashRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterSingleSlashRP(XQueryGrammarParser.SingleSlashRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SingleSlashRP}
	 * labeled alternative in {@link XQueryGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitSingleSlashRP(XQueryGrammarParser.SingleSlashRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AndFilter}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterAndFilter(XQueryGrammarParser.AndFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AndFilter}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitAndFilter(XQueryGrammarParser.AndFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IsFilter}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterIsFilter(XQueryGrammarParser.IsFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IsFilter}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitIsFilter(XQueryGrammarParser.IsFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BracketFilter}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterBracketFilter(XQueryGrammarParser.BracketFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BracketFilter}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitBracketFilter(XQueryGrammarParser.BracketFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RPFilter}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterRPFilter(XQueryGrammarParser.RPFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RPFilter}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitRPFilter(XQueryGrammarParser.RPFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotFilter}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterNotFilter(XQueryGrammarParser.NotFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotFilter}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitNotFilter(XQueryGrammarParser.NotFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstantFilter}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterConstantFilter(XQueryGrammarParser.ConstantFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstantFilter}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitConstantFilter(XQueryGrammarParser.ConstantFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqualFilter}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterEqualFilter(XQueryGrammarParser.EqualFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqualFilter}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitEqualFilter(XQueryGrammarParser.EqualFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OrFilter}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterOrFilter(XQueryGrammarParser.OrFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OrFilter}
	 * labeled alternative in {@link XQueryGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitOrFilter(XQueryGrammarParser.OrFilterContext ctx);
}