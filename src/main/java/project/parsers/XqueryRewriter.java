package project.parsers;
import java.util.*;

public class XqueryRewriter extends XQueryGrammarBaseVisitor<String>{
     // <key : root var, value :  a list of var children > 
     Map<String, List<String>> joinGroups = new LinkedHashMap<>();
     // eg: <$s , ($a, $m ) > => join on $s == $a , $s == $m 
     Map<String, HashSet<String>> joinConditions = new HashMap<>();
     // used in rewriting the FOR part
     Map<String, String> varContents = new HashMap<>();  
     List<String> joinedVars = new LinkedList<>();  
     
 
     boolean rewrite = false ;
     @Override public String visitVarXQ(XQueryGrammarParser.VarXQContext ctx) {
        String varStr =  ctx.VAR().getText();
        if (rewrite) {
            varStr = "$tuple/" + varStr.substring(1) + "/*";
        }
        return varStr;
        
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
        visit(ctx.forClause());
       
        // assume there is no let clause in project specification 
        if (ctx.whereClause() != null) {
            visit(ctx.whereClause());
        }
       
        visit(ctx.returnClause());
       
        if (joinGroups.size() <= 1) { // there is no join, return flworXQ
            String ret = "";
            ret += visit(ctx.forClause());
            if (ctx.letClause() != null) {
                ret += visit(ctx.letClause());
            }
            if (ctx.whereClause() != null) {
                ret += visit(ctx.whereClause());
            }
            ret += visit(ctx.returnClause());
            return ret ;
        }
        
        
        // Rewrite the query to join format
        rewrite = true ;  
        String res = "for $tuple in ";
        String curGroup = constructJoinGroup();

        
        while (!joinGroups.isEmpty()) {
            List<String> leftJoin = new LinkedList<>();
            List<String> rightJoin = new LinkedList<>();

            
            String root = joinGroups.keySet().toArray()[0].toString();
            List<String> newGroupVar = joinGroups.get(root);
         
            for (String  newVar : newGroupVar ) { 
                if (joinConditions.containsKey(newVar)) { // newVar is key
                    for (String v : joinConditions.get(newVar)) {
                        if (joinedVars.contains(v)) { // value is in joinedVars
                            rightJoin.add(newVar.substring(1));
                            leftJoin.add(v.substring(1));
                            joinConditions.get(newVar).remove(v);
                        }
                    }
                } else { // newVar is not key, but in the value set
                    for (String key : joinConditions.keySet()) {
                        if (joinConditions.get(key).contains(newVar) && joinedVars.contains (key)) { // value is the newVar
                            rightJoin.add(newVar.substring(1));
                            leftJoin.add(key.substring(1));
                            joinConditions.get(key).remove(newVar);
                        }
                    }
                }

            }


            String  newGroup = constructJoinGroup();
            curGroup = "join(" + curGroup + ",\n" + newGroup  + ",\n" + "["
                    + String.join(", ", leftJoin) + "], [" + String.join(", ", rightJoin) + "])";
        }
        res += curGroup + visit(ctx.returnClause());
       
        return res;
        
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
        //construct rewrite content 
        Map<String, String> parentMap = new HashMap<>();
        int varNums = ctx.VAR().size();
        for (int i = 0; i < varNums; i++) {
            String curVar = ctx.VAR(i).getText();
            String xqStr = ctx.xq(i).getText();     
            varContents.put(curVar, xqStr); // used in rewriting the FOR part
            if (xqStr.charAt(0) == '$') { // children var
                int idx = xqStr.indexOf('/');
                if (idx != -1) {
                    xqStr = xqStr.substring(0, idx);
                }
                parentMap.put(curVar, xqStr);

                //find real parent
                String realParent = curVar;
                while (parentMap.get(realParent) != null) {
                    realParent = parentMap.get(realParent);
                }

                joinGroups.get(realParent).add(curVar);
            }
            else {  // root var
                parentMap.put(curVar, null);
                joinGroups.put(curVar, new LinkedList<>());
                joinGroups.get(curVar).add(curVar);
            }
        }
        //construct return string
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
        String key = visit(ctx.xq(0));
        joinConditions.putIfAbsent( key, new HashSet<>());            
        joinConditions.get(key).add(visit(ctx.xq(1)));
        
       
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


    //helper function 
    private String constructJoinGroup() {
        String root = joinGroups.keySet().toArray()[0].toString();
        List<String> vars = joinGroups.get(root);
        joinGroups.remove(root);
        String res = "";

        // For  
        res += " for ";
        int len = vars.size();
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                res += ",\n";
            }
            res += vars.get(i) + " in " + varContents.get(vars.get(i));  
        }


        // Where
        // handle conditions in the same group (optimization: move select upward)  
        List<String> rewriteConditions = new LinkedList<>(); 
        for (String var : vars) { // for each var in same group
            for (String left : joinConditions.keySet()) {
                if (left.equals(var)) { // left side is the curVar + right side is in vars or is stringConstant
                    for (String right : joinConditions.get(left)) {
                        if (vars.contains(right) || right.charAt(0) != '$') {
                            rewriteConditions.add(left + " eq " + right);
                            joinConditions.get(left).remove(right);
                        }
                    }
                } else if (joinConditions.get(left).contains(var) && vars.contains(left)) {  // left side is in vars + right side contains curVar
                    rewriteConditions .add(left + " eq " + var);
                    joinConditions.get(left).remove(var);
                } else if (left.charAt(0) != '$') { // left side is stringConstant
                    for (String right : joinConditions.get(left)) {
                        if (right.charAt(0) != '$') { // right side is also stringConstant
                            rewriteConditions .add(left + " eq " + right);
                            joinConditions.get(left).remove(right);
                        } else if (right.equals(var)) { // right side is the curVar
                            rewriteConditions.add(left + " eq " + right);
                            joinConditions.get(left).remove(right);
                        }
                    }
                }
            }
        }

        if (!rewriteConditions .isEmpty()) {
            res += "\nwhere ";
            res += String.join("\nand ", rewriteConditions );
        }

        // Return part
        res += "\nreturn <tuple>\n";
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                res += ",\n";
            }
            String varName = vars.get(i).substring(1);
            res += "<" + varName + ">{" + vars.get(i) + "}</" + varName + ">";
        }
        res += "\n</tuple>";
        joinedVars.addAll(vars);
        return res;
    }
}