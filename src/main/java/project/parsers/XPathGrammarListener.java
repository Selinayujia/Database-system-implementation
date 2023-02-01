// Generated from XPathGrammar.g4 by ANTLR 4.7.2

package project.parsers;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XPathGrammarParser}.
 */
public interface XPathGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code SingleSlashAP}
	 * labeled alternative in {@link XPathGrammarParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterSingleSlashAP(XPathGrammarParser.SingleSlashAPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SingleSlashAP}
	 * labeled alternative in {@link XPathGrammarParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitSingleSlashAP(XPathGrammarParser.SingleSlashAPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoubleSlashAP}
	 * labeled alternative in {@link XPathGrammarParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterDoubleSlashAP(XPathGrammarParser.DoubleSlashAPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoubleSlashAP}
	 * labeled alternative in {@link XPathGrammarParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitDoubleSlashAP(XPathGrammarParser.DoubleSlashAPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AllChildrenRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterAllChildrenRP(XPathGrammarParser.AllChildrenRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AllChildrenRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitAllChildrenRP(XPathGrammarParser.AllChildrenRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoubleSlashRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterDoubleSlashRP(XPathGrammarParser.DoubleSlashRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoubleSlashRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitDoubleSlashRP(XPathGrammarParser.DoubleSlashRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FilteredRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterFilteredRP(XPathGrammarParser.FilteredRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FilteredRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitFilteredRP(XPathGrammarParser.FilteredRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterTagRP(XPathGrammarParser.TagRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitTagRP(XPathGrammarParser.TagRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TextRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterTextRP(XPathGrammarParser.TextRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TextRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitTextRP(XPathGrammarParser.TextRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttributeRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterAttributeRP(XPathGrammarParser.AttributeRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttributeRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitAttributeRP(XPathGrammarParser.AttributeRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BracketRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterBracketRP(XPathGrammarParser.BracketRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BracketRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitBracketRP(XPathGrammarParser.BracketRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SequenceRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterSequenceRP(XPathGrammarParser.SequenceRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SequenceRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitSequenceRP(XPathGrammarParser.SequenceRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParentRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterParentRP(XPathGrammarParser.ParentRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParentRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitParentRP(XPathGrammarParser.ParentRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SelfRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterSelfRP(XPathGrammarParser.SelfRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SelfRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitSelfRP(XPathGrammarParser.SelfRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SingleSlashRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterSingleSlashRP(XPathGrammarParser.SingleSlashRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SingleSlashRP}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitSingleSlashRP(XPathGrammarParser.SingleSlashRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AndFilter}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterAndFilter(XPathGrammarParser.AndFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AndFilter}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitAndFilter(XPathGrammarParser.AndFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IsFilter}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterIsFilter(XPathGrammarParser.IsFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IsFilter}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitIsFilter(XPathGrammarParser.IsFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BracketFilter}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterBracketFilter(XPathGrammarParser.BracketFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BracketFilter}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitBracketFilter(XPathGrammarParser.BracketFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RPFilter}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterRPFilter(XPathGrammarParser.RPFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RPFilter}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitRPFilter(XPathGrammarParser.RPFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotFilter}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterNotFilter(XPathGrammarParser.NotFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotFilter}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitNotFilter(XPathGrammarParser.NotFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstantFilter}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterConstantFilter(XPathGrammarParser.ConstantFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstantFilter}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitConstantFilter(XPathGrammarParser.ConstantFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqualFilter}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterEqualFilter(XPathGrammarParser.EqualFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqualFilter}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitEqualFilter(XPathGrammarParser.EqualFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OrFilter}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterOrFilter(XPathGrammarParser.OrFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OrFilter}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitOrFilter(XPathGrammarParser.OrFilterContext ctx);
}