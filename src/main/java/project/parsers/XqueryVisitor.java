package project.parsers;
import java.util.*;
import org.w3c.dom.*;
public class XqueryVisitor extends XQueryGrammarBaseVisitor<List<Node>> {

    private List<Node> contextNodes = new ArrayList<>();
	private HashMap<String, List<Node>> varMap = new HashMap<>();
    @Override public List<Node> visitStringXQ(XQueryGrammarParser.StringXQContext ctx) {
        return contextNodes;
    }

    @Override public List<Node> visitSingleSlashXQ(XQueryGrammarParser.SingleSlashXQContext ctx) {
        visit(ctx.xq());
        visit(ctx.rp());
        contextNodes = deduplicate(contextNodes);

        return contextNodes;
    }
    @Override public List<Node> visitApXQ(XQueryGrammarParser.ApXQContext ctx) {
		visit(ctx.ap());
        return contextNodes;
    }
	@Override public List<Node> visitVarXQ(XQueryGrammarParser.VarXQContext ctx){
		String content = ctx.VAR().getText();
        if (varMap.containsKey(content)){
            contextNodes = varMap.get(content);
        }
        else {
            contextNodes = new ArrayList<>();
        }

		return contextNodes;
	}
	@Override public List<Node> visitSequenceXQ(XQueryGrammarParser.SequenceXQContext ctx){
		List<Node> temp =  new ArrayList<>(contextNodes);
		List<Node> res = new ArrayList<>();
		res.addAll(visit(ctx.xq(0)));
		contextNodes = temp;
		res.addAll(visit(ctx.xq(1)));
		contextNodes = res;
		return contextNodes;
	}
	@Override public List<Node> visitBracketXQ(XQueryGrammarParser.BracketXQContext ctx){
		return visit(ctx.xq());
	}
/*
    T visitStringXQ(XQueryGrammarParser.StringXQContext ctx); [Done]
    
    T visitSingleSlashXQ(XQueryGrammarParser.SingleSlashXQContext ctx); [DONE]
	
	T visitApXQ(XQueryGrammarParser.ApXQContext ctx); [Done]
	
	T visitVarXQ(XQueryGrammarParser.VarXQContext ctx);[Done]
	
	T visitSequenceXQ(XQueryGrammarParser.SequenceXQContext ctx);[Done]
	
	T visitBracketXQ(XQueryGrammarParser.BracketXQContext ctx);[Done]
	
	T visitFlworXQ(XQueryGrammarParser.FlworXQContext ctx);
	
	T visitTagXQ(XQueryGrammarParser.TagXQContext ctx);

	T visitLetClauseXQ(XQueryGrammarParser.LetClauseXQContext ctx);

	T visitDoubleSlashXQ(XQueryGrammarParser.DoubleSlashXQContext ctx);

	T visitForClause(XQueryGrammarParser.ForClauseContext ctx);

	T visitLetClause(XQueryGrammarParser.LetClauseContext ctx);

	T visitWhereClause(XQueryGrammarParser.WhereClauseContext ctx);

	T visitReturnClause(XQueryGrammarParser.ReturnClauseContext ctx);







	// Mingejie Song
	T visitMultipleCond(XQueryGrammarParser.MultipleCondContext ctx);
	
	T visitOrCond(XQueryGrammarParser.OrCondContext ctx);

	T visitEqualCond(XQueryGrammarParser.EqualCondContext ctx);

	T visitAndCond(XQueryGrammarParser.AndCondContext ctx);

	T visitNotCond(XQueryGrammarParser.NotCondContext ctx);

	T visitEmptyCond(XQueryGrammarParser.EmptyCondContext ctx);

	T visitBracketCond(XQueryGrammarParser.BracketCondContext ctx);

	T visitIsCond(XQueryGrammarParser.IsCondContext ctx);

	T visitSingleSlashAP(XQueryGrammarParser.SingleSlashAPContext ctx);

	T visitDoubleSlashAP(XQueryGrammarParser.DoubleSlashAPContext ctx);

	T visitAllChildrenRP(XQueryGrammarParser.AllChildrenRPContext ctx);

	T visitDoubleSlashRP(XQueryGrammarParser.DoubleSlashRPContext ctx);

	T visitFilteredRP(XQueryGrammarParser.FilteredRPContext ctx);

	T visitTagRP(XQueryGrammarParser.TagRPContext ctx);

	T visitTextRP(XQueryGrammarParser.TextRPContext ctx);

	T visitAttributeRP(XQueryGrammarParser.AttributeRPContext ctx);

	T visitBracketRP(XQueryGrammarParser.BracketRPContext ctx);

	T visitSequenceRP(XQueryGrammarParser.SequenceRPContext ctx);

	T visitParentRP(XQueryGrammarParser.ParentRPContext ctx);

	T visitSelfRP(XQueryGrammarParser.SelfRPContext ctx);

	T visitSingleSlashRP(XQueryGrammarParser.SingleSlashRPContext ctx);

	T visitAndFilter(XQueryGrammarParser.AndFilterContext ctx);

	T visitIsFilter(XQueryGrammarParser.IsFilterContext ctx);

	T visitBracketFilter(XQueryGrammarParser.BracketFilterContext ctx);

	T visitRPFilter(XQueryGrammarParser.RPFilterContext ctx);

	T visitNotFilter(XQueryGrammarParser.NotFilterContext ctx);

	T visitConstantFilter(XQueryGrammarParser.ConstantFilterContext ctx);

	T visitEqualFilter(XQueryGrammarParser.EqualFilterContext ctx);

	T visitOrFilter(XQueryGrammarParser.OrFilterContext ctx);
    */







     // helper funcs
     // order matters, cannot use hashset for deduplication 
     private List<Node> deduplicate(List<Node> input) {     
        List<Node> result = new ArrayList<>();
        for (Node curNode : input) {  
            boolean dup = false  ;    
            for (Node node : result) {
                if (curNode.isSameNode(node)) {
                    dup = true ; 
                    break ; 
                }
            }
            if (!dup) {
                result.add(curNode);
            }
        }
        return result;
      }

    
}
