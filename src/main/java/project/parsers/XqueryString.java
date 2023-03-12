package project.parsers;
public class XqueryString extends XQueryGrammarBaseVisitor<String>{
    @Override public String visitVarXQ(XQueryGrammarParser.VarXQContext ctx) {
        return ctx.VAR().getText();
    }

    @Override public String visitStringXQ(XQueryGrammarParser.StringXQContext ctx) {
        return ctx.STRINGCONSTANT().getText();
    }

    @Override public String visitApXQ(XQueryGrammarParser.ApXQContext ctx) {
        return visit(ctx.ap());
    }

    @Override public String visitBracketXQ(XQueryGrammarParser.BracketXQContext ctx) {
        return "(" + visit(ctx.xq()) + ")";
    }

    @Override public String visitSequenceXQ(XQueryGrammarParser.SequenceXQContext ctx) {
        return visit(ctx.xq(0)) + "," + visit(ctx.xq(1));
    }

    @Override public String visitSingleSlashXQ(XQueryGrammarParser.SingleSlashXQContext ctx) {
        return visit(ctx.xq()) + "/" + visit(ctx.rp());
    }

    @Override public String visitDoubleSlashXQ(XQueryGrammarParser.DoubleSlashXQContext ctx) {
        return visit(ctx.xq()) + "//" + visit(ctx.rp());
    }

    @Override public String visitTagXQ(XQueryGrammarParser.TagXQContext ctx) {
        String tag = ctx.TAGNAME(0).getText();
        return "<" + tag + ">{" + visit(ctx.xq()) + "}</" + tag + ">";
    }

    @Override public String visitFlworXQ(XQueryGrammarParser.FlworXQContext ctx) {
        String ret = "";
        ret += visit(ctx.forClause());
        if (ctx.letClause() != null) {
            ret += visit(ctx.letClause());
        }
        if (ctx.whereClause() != null) {
            ret += visit(ctx.whereClause());
        }
        ret += visit(ctx.returnClause());
        return ret;
    }

    @Override public String visitLetClauseXQ(XQueryGrammarParser.LetClauseXQContext ctx) {
        return visit(ctx.letClause()) + visit(ctx.xq());
    }

    @Override public String visitJoinXQ(XQueryGrammarParser.JoinXQContext ctx) {
        return visit(ctx.joinClause());
    }

    @Override public String visitJoinClause(XQueryGrammarParser.JoinClauseContext ctx) {
        String ret = " join(" + visit(ctx.xq(0)) + "," + visit(ctx.xq(1));
        ret += "," + visit(ctx.idList(0)) + "," + visit(ctx.idList(1)) + ")";
        return ret;
    }

    @Override public String visitIdList(XQueryGrammarParser.IdListContext ctx) {
        String ret = "";
        int idCount = ctx.TAGNAME().size();
        ret += "[" + ctx.TAGNAME(0).getText();
        for (int i = 1; i < idCount; i++) {
            ret += "," + visit(ctx.TAGNAME(i));
        }
        ret += "]";
        return ret;
    }

    @Override public String visitForClause(XQueryGrammarParser.ForClauseContext ctx) {
        String ret = "";
        int VarCount = ctx.VAR().size();
        ret += " for " + ctx.VAR(0).getText() + " in " + visit(ctx.xq(0));
        for (int i = 1; i < VarCount; i++) {
            ret += ",\n" + ctx.VAR(i).getText() + " in " + visit(ctx.xq(i));
        }
        return ret;
    }

    @Override public String visitLetClause(XQueryGrammarParser.LetClauseContext ctx) {
        String ret = "\n";
        int VarCount = ctx.VAR().size();
        ret += "let " + ctx.VAR(0).getText() + " := " + visit(ctx.xq(0));
        for (int i = 1; i < VarCount; i++) {
            ret += ",\n" + ctx.VAR(i).getText() + " := " + visit(ctx.xq(i));
        }
        return ret;
    }

    @Override public String visitWhereClause(XQueryGrammarParser.WhereClauseContext ctx) {
        return "\nwhere " + visit(ctx.cond());
    }

    @Override public String visitReturnClause(XQueryGrammarParser.ReturnClauseContext ctx) {
        return "\nreturn " + visit(ctx.xq());
    }

    @Override public String visitEqualCond(XQueryGrammarParser.EqualCondContext ctx) {
        return visit(ctx.xq(0)) + "=" + visit(ctx.xq(1));
    }

    @Override public String visitIsCond(XQueryGrammarParser.IsCondContext ctx) {
        return visit(ctx.xq(0)) + "==" + visit(ctx.xq(1));
    }

    @Override public String visitEmptyCond(XQueryGrammarParser.EmptyCondContext ctx) {
        return "empty(" + visit(ctx.xq()) + ")";
    }


    @Override public String visitMultipleCond(XQueryGrammarParser.MultipleCondContext ctx) {
        String re = " some ";
        int VarCount = ctx.VAR().size();

        for (int i = 0; i < VarCount; i++) {
            re += ctx.VAR(i).getText() + "in" + visit(ctx.xq(i));
            if (i != VarCount - 1) re += ",";
        }

        return re + " satisfies " + visit(ctx.cond());
    }

    @Override public String visitBracketCond(XQueryGrammarParser.BracketCondContext ctx) {

        return "(" + visit(ctx.cond()) + ')';
    }

    @Override public String visitAndCond(XQueryGrammarParser.AndCondContext ctx) {
        return visit(ctx.cond(0)) + " and " + visit(ctx.cond(1));
    }

    @Override public String visitOrCond(XQueryGrammarParser.OrCondContext ctx) {
        return visit(ctx.cond(0)) + " or " + visit(ctx.cond(1));
    }

    @Override public String visitNotCond(XQueryGrammarParser.NotCondContext ctx) {
        return " not " + visit(ctx.cond());
    }

    @Override public String visitSingleSlashAP(XQueryGrammarParser.SingleSlashAPContext ctx) {
        return "doc(" + ctx.FILENAME().getText() + ")/" + visit(ctx.rp());
    }

    @Override public String visitDoubleSlashAP(XQueryGrammarParser.DoubleSlashAPContext ctx) {
        return "doc(" + ctx.FILENAME().getText() + ")//" + visit(ctx.rp());
    }

    @Override public String visitTagRP(XQueryGrammarParser.TagRPContext ctx) {
        return ctx.TAGNAME().getText();
    }

    @Override public String visitAllChildrenRP(XQueryGrammarParser.AllChildrenRPContext ctx) {
        return "*";
    }

    @Override public String visitSelfRP(XQueryGrammarParser.SelfRPContext ctx) {
        return ".";
    }

    @Override public String visitParentRP(XQueryGrammarParser.ParentRPContext ctx) {
        return "..";
    }

    @Override public String visitTextRP(XQueryGrammarParser.TextRPContext ctx) {
        return "text()";
    }

    @Override public String visitAttributeRP(XQueryGrammarParser.AttributeRPContext ctx) {
        return ctx.ATTRNAME().getText();
    }

    @Override public String visitBracketRP(XQueryGrammarParser.BracketRPContext ctx) {
        return "(" + visit(ctx.rp()) + ")";
    }

    @Override public String visitSingleSlashRP(XQueryGrammarParser.SingleSlashRPContext ctx) {
        return visit(ctx.rp(0)) + "/" + visit(ctx.rp(1));
    }

    @Override public String visitDoubleSlashRP(XQueryGrammarParser.DoubleSlashRPContext ctx) {
        return visit(ctx.rp(0)) + "//" + visit(ctx.rp(1));
    }


    @Override public String visitFilteredRP(XQueryGrammarParser.FilteredRPContext ctx) {
        return visit(ctx.rp()) + "[" + visit(ctx.f()) + "]";
    }

    @Override public String visitSequenceRP(XQueryGrammarParser.SequenceRPContext ctx) {
        return visit(ctx.rp(0)) + ", " + visit(ctx.rp(1));
    }

    @Override public String visitRPFilter(XQueryGrammarParser.RPFilterContext ctx) {
        return visit(ctx.rp());
    }

    @Override public String visitConstantFilter(XQueryGrammarParser.ConstantFilterContext ctx) {
        return visit(ctx.rp()) + "=" + ctx.STRINGCONSTANT().getText();
    }

    @Override public String visitEqualFilter(XQueryGrammarParser.EqualFilterContext ctx) {
        return visit(ctx.rp(0)) + "=" + visit(ctx.rp(1));
    }

    @Override public String visitIsFilter(XQueryGrammarParser.IsFilterContext ctx) {
        return visit(ctx.rp(0)) + "==" + visit(ctx.rp(1));
    }

    @Override public String visitBracketFilter(XQueryGrammarParser.BracketFilterContext ctx) {
        return "(" + visit(ctx.f()) + ")";
    }

    @Override public String visitAndFilter(XQueryGrammarParser.AndFilterContext ctx) {
        return visit(ctx.f(0)) + " and " + visit(ctx.f(1));
    }

    @Override public String visitOrFilter(XQueryGrammarParser.OrFilterContext ctx) {
        return visit(ctx.f(0)) + " or " + visit(ctx.f(1));
    }

    @Override public String visitNotFilter(XQueryGrammarParser.NotFilterContext ctx) {
        return " not " + visit(ctx.f());
    }
}