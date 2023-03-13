package project.parsers;
import java.util.*;

public class XqueryStringJoin extends XqueryString{
    // <key : root var, value :  a list of var children > 
    Map<String, List<String>> joinGroups = new LinkedHashMap<>();
    // eg: <$s , ($a, $m ) > => join on $s == $a , $s == $m 
    Map<String, HashSet<String>> joinConditions = new HashMap<>();
    // used in rewriting the FOR part
    Map<String, String> varContents = new HashMap<>();  
    List<String> joinedVars = new LinkedList<>();  
    

    boolean rewrite = false ;
    

     
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

     
    @Override public String visitVarXQ(XQueryGrammarParser.VarXQContext ctx) {
        String varStr = super.visitVarXQ(ctx);
        if (rewrite) {
            varStr = "$tuple/" + varStr.substring(1) + "/*";
        }
        //String varStr = "$tuple/" + super.visitVarXQ(ctx).substring(1) + "/*";
        return varStr;
    }

     

    


    @Override public String visitFlworXQ(XQueryGrammarParser.FlworXQContext ctx) {
        
        visit(ctx.forClause());
       
        // assume there is no let clause in project specification 
        if (ctx.whereClause() != null) {
            visit(ctx.whereClause());
        }
       
        visit(ctx.returnClause());
       
        if (joinGroups.size() <= 1) { // there is no join, return flworXQ
            return super.visitFlworXQ(ctx);
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
            // ??? why ???
            // for (String  newVar : newGroupVar ) { 
            //     if (joinConditions.containsKey(newVar)) { // newVar is key
            //         for (String v : joinConditions.get(newVar)) {
            //             if (joinedVars.contains(v)) { // value is in joinedVars
            //                 leftJoin.add(newVar.substring(1));
            //                 rightJoin.add(v.substring(1));
            //                 joinConditions.get(newVar).remove(v);
            //             }
            //         }
            //     } else { // newVar is not key, but in the value set
            //         for (String key : joinConditions.keySet()) {
            //             if (joinConditions.get(key).contains(newVar)) { // value is the newVar
            //                 leftJoin.add(newVar.substring(1));
            //                 rightJoin.add(key.substring(1));
            //                 joinConditions.get(key).remove(newVar);
            //             }
            //         }
            //     }

            // }

            for (String joinedVar : joinedVars) { 
                if (joinConditions.containsKey(joinedVar)) {  //key is the joinedVar, newGroupVar is in the value set 
                    for (String v : joinConditions.get(joinedVar)) {
                            if (newGroupVar.contains(v)) {
                                leftJoin.add(joinedVar.substring(1));
                                rightJoin.add(v.substring(1));
                                joinConditions.get(joinedVar).remove(v);
                            }
                        
                    }
                } else { // joinedVar is not key, but in the value set + newGroupVar contains key 
                    for (String key : joinConditions.keySet()) {
                        if(newGroupVar.contains(key)){
                            Set<String> values = joinConditions.get(key);
                            for (String v : values) {
                                if (v.equals(joinedVar)) { // value is the joinedVar        
                                    leftJoin.add(v.substring(1));
                                    rightJoin.add(key.substring(1));
                                    joinConditions.get(key).remove(v);
                                    
                                }
                            }
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

   

    
    @Override public String visitForClause(XQueryGrammarParser.ForClauseContext ctx) {
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

        return super.visitForClause(ctx);
    }

    @Override public String visitEqualCond(XQueryGrammarParser.EqualCondContext ctx) {
         
        String key = visit(ctx.xq(0));
        joinConditions.putIfAbsent( key, new HashSet<>());            
        joinConditions.get(key).add(visit(ctx.xq(1)));
        
        return super.visitEqualCond(ctx);
    }

    

    
}