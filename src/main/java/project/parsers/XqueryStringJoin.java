package project.parsers;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class XqueryStringJoin extends XqueryString{

    HashMap<String, String> descendant = new HashMap<>();
    HashMap<String, LinkedList<String>> queryGroup = new LinkedHashMap<>();
    HashMap<String, HashSet<String>> equalities = new HashMap<>();
    HashMap<String, String> varPath = new HashMap<>();
    LinkedList<String> joinedVars = new LinkedList<>();
    Boolean optable = true;

    enum Location {
        START, IN_FOR, IN_WHERE, IN_RETURN, REWRITING
    }
    Location location = Location.START;

    private void clearInfo() {
        location = Location.START;
        descendant = new HashMap<>();
        queryGroup = new LinkedHashMap<>();
        equalities = new HashMap<>();
        joinedVars = new LinkedList<>();
    }

    // To construct a single query in join operation
    private String constructGroup() {
        String groupRoot = queryGroup.keySet().toArray()[0].toString();
        LinkedList<String> vars = queryGroup.get(groupRoot);
        queryGroup.remove(groupRoot);
        String res = "";

        // For part
        res += " for ";
        int len = vars.size();
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                res += ",\n";
            }
            res += vars.get(i) + " in " + varPath.get(vars.get(i)); //  wrong
        }


        // Where part
        LinkedList<String> conditions = new LinkedList<>();
        for (String var : vars) {                       // variables in same group
            for (String condLeft : equalities.keySet()) {
                if (condLeft.equals(var)) {
                    for (String condRight : equalities.get(condLeft)) {
                        // if the group contains variableLeft and variableRight, show where in group
                        if (vars.contains(condRight) || condRight.charAt(0) != '$') {
                            conditions.add(condLeft + "=" + condRight);
                            equalities.get(condLeft).remove(condRight);
                        }
                    }
                } else if (equalities.get(condLeft).contains(var) && vars.contains(condLeft)) {
                    conditions.add(condLeft + "=" + var);
                    equalities.get(condLeft).remove(var);
                } else if (condLeft.charAt(0) != '$') {
                    for (String condRight : equalities.get(condLeft)) {
                        if (condRight.charAt(0) != '$') {
                            conditions.add(condLeft + "=" + condRight);
                            equalities.get(condLeft).remove(condRight);
                        } else if (condRight.equals(var)) {
                            conditions.add(condLeft + "=" + condRight);
                            equalities.get(condLeft).remove(condRight);
                        }
                    }
                }
            }
        }
        if (!conditions.isEmpty()) {
            res += "\nwhere ";
            res += String.join("\nand ", conditions);
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

    @Override public String visitVarXQ(XQueryGrammarParser.VarXQContext ctx) {
        String varStr = super.visitVarXQ(ctx);
        if (location == Location.REWRITING) {
            varStr = "$tuple/" + varStr.substring(1) + "/*";
        }

        return varStr;
    }

    @Override public String visitStringXQ(XQueryGrammarParser.StringXQContext ctx) {
        if (location == Location.IN_FOR) {
            optable = false;
        }
        return super.visitStringXQ(ctx);
    }

    @Override public String visitApXQ(XQueryGrammarParser.ApXQContext ctx) {
        if (location == Location.IN_WHERE) {
            optable = false;
        }
        return super.visitApXQ(ctx);
    }

    @Override public String visitSequenceXQ(XQueryGrammarParser.SequenceXQContext ctx) {
        if (location == Location.IN_FOR || location == Location.IN_WHERE) {
            optable = false;
        }
        return super.visitSequenceXQ(ctx);
    }

    @Override public String visitSingleSlashXQ(XQueryGrammarParser.SingleSlashXQContext ctx) {
        if (location == Location.IN_WHERE) {
            optable = false;
        }
        return super.visitSingleSlashXQ(ctx);
    }

    @Override public String visitDoubleSlashXQ(XQueryGrammarParser.DoubleSlashXQContext ctx) {
        if (location == Location.IN_WHERE) {
            optable = false;
        }
        return super.visitDoubleSlashXQ(ctx);
    }

    @Override public String visitTagXQ(XQueryGrammarParser.TagXQContext ctx) {
        if (location == Location.IN_FOR || location == Location.IN_WHERE) {
            optable = false;
        }
        return super.visitTagXQ(ctx);
    }

    @Override public String visitFlworXQ(XQueryGrammarParser.FlworXQContext ctx) {
        if (location != Location.START || !optable) {
            optable = false;
            return super.visitFlworXQ(ctx);
        }
        location = Location.IN_FOR;

        visit(ctx.forClause());
        if (!optable || ctx.letClause() != null) {
            optable = false;
            return super.visitFlworXQ(ctx);
        }
        location = Location.IN_WHERE;

        if (ctx.whereClause() != null) {
            visit(ctx.whereClause());
        }
        if (!optable) {
            return super.visitFlworXQ(ctx);
        }
        location = Location.IN_RETURN;

        visit(ctx.returnClause());
        if (!optable) {
            return super.visitFlworXQ(ctx);
        }

        if (queryGroup.size() <= 1) {
            clearInfo();
            return super.visitFlworXQ(ctx);
        }

        location = Location.REWRITING;
        // Rewrite the query to join format
        String res = "for $tuple in ";
        String first_group = constructGroup();

        while (!queryGroup.isEmpty()) {
            LinkedList<String> leftJoin = new LinkedList<>();
            LinkedList<String> rightJoin = new LinkedList<>();

            String groupRoot = queryGroup.keySet().toArray()[0].toString();

            LinkedList<String> compareVars = queryGroup.get(groupRoot);

            for (String joinedVar : joinedVars) {
                if (equalities.containsKey(joinedVar)) {
                    for (String v : equalities.get(joinedVar)) {
                        if (equalities.keySet().contains(joinedVar)) {
                            if (compareVars.contains(v)) {
                                leftJoin.add(joinedVar.substring(1));
                                rightJoin.add(v.substring(1));
                                equalities.get(joinedVar).remove(v);
                            }
                        }
                        if (equalities.keySet().contains(v)) {
                            if (compareVars.contains(joinedVar)) {
                                leftJoin.add(joinedVar.substring(1));
                                rightJoin.add(v.substring(1));
                                equalities.get(v).remove(joinedVar);
                            }
                        }
                    }
                }
            }

            String next_group = constructGroup();
            first_group = "join(" + first_group + ",\n" + next_group + ",\n" + "["
                    + String.join(", ", leftJoin) + "], [" + String.join(", ", rightJoin) + "])";
        }
        res += first_group + visit(ctx.returnClause());
        clearInfo();
        return res;
    }

    @Override public String visitLetClauseXQ(XQueryGrammarParser.LetClauseXQContext ctx) {
        optable = false;
        return super.visitLetClauseXQ(ctx);
    }

    @Override public String visitJoinXQ(XQueryGrammarParser.JoinXQContext ctx) {
        optable = false;
        return super.visitJoinXQ(ctx);
    }

    // done
    @Override public String visitForClause(XQueryGrammarParser.ForClauseContext ctx) {
        int VarCount = ctx.VAR().size();
        for (int i = 0; i < VarCount; i++) {
            String child = ctx.VAR(i).getText();
            //System.out.println(ctx.xq(i).getText());
            // String xqStr = visit(ctx.xq(i));    // return xq string
            String xqStr = ctx.xq(i).getText();    // return xq string
            varPath.put(child, xqStr);
            if (xqStr.charAt(0) == '$') {       // with variable parent
                int idx;
                if ((idx = xqStr.indexOf('/')) != -1) {
                    xqStr = xqStr.substring(0, idx);
                }
                descendant.put(child, xqStr);

                String newParent = child;
                while (descendant.get(newParent) != null) {
                    newParent = descendant.get(newParent);
                }

                queryGroup.get(newParent).add(child);
            }
            else {                              // with root parent
                descendant.put(child, null);
                LinkedList<String> q= new LinkedList<>();
                queryGroup.put(child, q);
                queryGroup.get(child).add(child);
            }
        }

        return super.visitForClause(ctx);
    }

    @Override public String visitEqualCond(XQueryGrammarParser.EqualCondContext ctx) {
        if (location == Location.IN_WHERE) {
            String lhs = visit(ctx.xq(0));
            String rhs = visit(ctx.xq(1));
            equalities.putIfAbsent(lhs, new HashSet<>());
            equalities.get(lhs).add(rhs);
        }
        return super.visitEqualCond(ctx);
    }

    @Override public String visitIsCond(XQueryGrammarParser.IsCondContext ctx) {
        optable = false;
        return super.visitIsCond(ctx);
    }

    @Override public String visitEmptyCond(XQueryGrammarParser.EmptyCondContext ctx) {
        optable = false;
        return super.visitEmptyCond(ctx);
    }

    @Override public String visitMultipleCond(XQueryGrammarParser.MultipleCondContext ctx) {
        optable = false;
        return super.visitMultipleCond(ctx);
    }

    @Override public String visitOrCond(XQueryGrammarParser.OrCondContext ctx) {
        optable = false;
        return super.visitOrCond(ctx);
    }

    @Override public String visitNotCond(XQueryGrammarParser.NotCondContext ctx) {
        optable = false;
        return super.visitNotCond(ctx);
    }
}