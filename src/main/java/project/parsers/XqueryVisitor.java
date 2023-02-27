package project.parsers;
import java.util.*;
import org.w3c.dom.*;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilderFactory;

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
	@Override public List<Node> visitFlworXQ(XQueryGrammarParser.FlworXQContext ctx){
		List<Node> res = new ArrayList<>();
        HashMap<String, List<Node>> temp = new HashMap<>(varMap);
        recursiveHelperVar(ctx, res, 0);
        varMap = temp;
        return res;

	}

	@Override public List<Node> visitTagXQ(XQueryGrammarParser.TagXQContext ctx){
		String text = ctx.TAGNAME(0).getText();
		visit(ctx.xq());
		Element element = null;
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            element = doc.createElement(text);

            for (Node n : contextNodes) {
                Node c = n.cloneNode(true);
                doc.adoptNode(c);
                element.appendChild(c);
            }

        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }

        List<Node> res = new ArrayList<>();
        res.add(element);
        contextNodes = res;
        return contextNodes;
	}


	@Override public List<Node> visitLetClauseXQ(XQueryGrammarParser.LetClauseXQContext ctx){
		List<Node> tempNodes = contextNodes;
        HashMap<String, List<Node>> tempMap = varMap;
        contextNodes = visit(ctx.letClause());
        List<Node> res = visit(ctx.xq());
        contextNodes = tempNodes;
        varMap = tempMap;
        return res;

	}

	@Override public List<Node> visitDoubleSlashXQ(XQueryGrammarParser.DoubleSlashXQContext ctx){
		visit(ctx.xq());
		for(int i = 0; i <  contextNodes.size(); i++){
        	contextNodes.addAll(getNodeDescendants((contextNodes.get(i))));
		}
       	contextNodes = visit(ctx.rp());
        contextNodes = deduplicate(contextNodes);

        return contextNodes;

	}

	@Override public List<Node> visitForClause(XQueryGrammarParser.ForClauseContext ctx){
		return contextNodes;

	}

	@Override public List<Node> visitWhereClause(XQueryGrammarParser.WhereClauseContext ctx){
		return visit(ctx.cond());

	}
	
	@Override public List<Node> visitReturnClause(XQueryGrammarParser.ReturnClauseContext ctx){
		return visit(ctx.xq());

	}

	@Override public List<Node> visitMultipleCond(XQueryGrammarParser.MultipleCondContext ctx) {
        List<Node> tempNodes = contextNodes;
        HashMap<String, List<Node>> tempMap = varMap;

        for (int i = 0; i < ctx.VAR().size(); i++) {
            varMap.put(ctx.VAR(i).getText(), visit(ctx.xq(i)));
        }
        List<Node> res = visit(ctx.cond());

        varMap = tempMap;
        contextNodes = tempNodes;

        return res;
    }

	@Override public List<Node> visitOrCond(XQueryGrammarParser.OrCondContext ctx) {
        List<Node> res = new ArrayList<>();
        List<Node> temp = new ArrayList<>(contextNodes);
        List<Node> stepRes = visit(ctx.cond(0));
        contextNodes = temp;
        stepRes.addAll(visit(ctx.cond(1)));
        res = deduplicate(stepRes);
        contextNodes = res;

        return res;
    }

	@Override public List<Node> visitEqualCond(XQueryGrammarParser.EqualCondContext ctx) {
		List<Node> res = new ArrayList<>();
        List<Node> temp = new ArrayList<>(contextNodes);
        List<Node> resLeft = visit(ctx.xq(0));
       	contextNodes = temp;
        List<Node> resRight = visit(ctx.xq(1));

        for (Node nodeLeft : resLeft) {
            for (Node nodeRight : resRight) {
                if (nodeLeft.isEqualNode(nodeRight)) {
                    res.add(nodeLeft);
                }
            }
        }
        contextNodes = res;
        return res;
    }

	@Override public List<Node> visitAndCond(XQueryGrammarParser.AndCondContext ctx) {
        List<Node> temp = new ArrayList<>(contextNodes);
        List<Node> resLeft = visit(ctx.cond(0));
        contextNodes = temp;
        List<Node> resRight = visit(ctx.cond(1));

        if (resLeft.size() != 0 && resRight.size() != 0) {
            return contextNodes;
        }
        return new ArrayList<>();
    }

	@Override public List<Node> visitNotCond(XQueryGrammarParser.NotCondContext ctx) {
        List<Node> temp = new ArrayList<>(contextNodes);
        List<Node> removeNodes = visit(ctx.cond());

        if (removeNodes.size() != 0) {
            return new ArrayList<>();
        }
		contextNodes = temp;
        return contextNodes;
    }

	@Override public List<Node> visitEmptyCond(XQueryGrammarParser.EmptyCondContext ctx) {
        List<Node> temp = contextNodes;
        List<Node> res = visit(ctx.xq());
        contextNodes = temp;
        if (res.size() == 0) {
            return contextNodes;
        }
        return new ArrayList<>();
    }

	@Override public List<Node> visitBracketCond(XQueryGrammarParser.BracketCondContext ctx) {
        return visit(ctx.cond());
    }

	@Override public List<Node> visitIsCond(XQueryGrammarParser.IsCondContext ctx) {
        List<Node> res = new ArrayList<>();
        List<Node> temp = new ArrayList<>(contextNodes);
        List<Node> resLeft = visit(ctx.xq(0));
        contextNodes = temp;
        List<Node> resRight = visit(ctx.xq(1));

        for (Node leftNode : resLeft) {
            for (Node rightNode : resRight) {
                if (leftNode.isSameNode(rightNode)) {
                    res.add(leftNode);
                }
            }
        }
        contextNodes = res;
        return res;
    }


/*
    T visitStringXQ(XQueryGrammarParser.StringXQContext ctx); [Done]
    
    T visitSingleSlashXQ(XQueryGrammarParser.SingleSlashXQContext ctx); [DONE]
	
	T visitApXQ(XQueryGrammarParser.ApXQContext ctx); [Done]
	
	T visitVarXQ(XQueryGrammarParser.VarXQContext ctx);[Done]
	
	T visitSequenceXQ(XQueryGrammarParser.SequenceXQContext ctx);[Done]
	
	T visitBracketXQ(XQueryGrammarParser.BracketXQContext ctx);[Done]
	
	T visitFlworXQ(XQueryGrammarParser.FlworXQContext ctx);[Done]
	
	T visitTagXQ(XQueryGrammarParser.TagXQContext ctx);[Done]

	T visitLetClauseXQ(XQueryGrammarParser.LetClauseXQContext ctx);[Done]

	T visitDoubleSlashXQ(XQueryGrammarParser.DoubleSlashXQContext ctx);[Done]

	T visitForClause(XQueryGrammarParser.ForClauseContext ctx);[Done]

	T visitLetClause(XQueryGrammarParser.LetClauseContext ctx);[Done]

	T visitWhereClause(XQueryGrammarParser.WhereClauseContext ctx);[Done]

	T visitReturnClause(XQueryGrammarParser.ReturnClauseContext ctx);[Done]
	
	T visitMultipleCond(XQueryGrammarParser.MultipleCondContext ctx);[Done]
	
	T visitOrCond(XQueryGrammarParser.OrCondContext ctx);[Done]

	T visitEqualCond(XQueryGrammarParser.EqualCondContext ctx);[Done]

	T visitAndCond(XQueryGrammarParser.AndCondContext ctx);[Done]

	T visitNotCond(XQueryGrammarParser.NotCondContext ctx); [Done]

	T visitEmptyCond(XQueryGrammarParser.EmptyCondContext ctx);[Done]

	T visitBracketCond(XQueryGrammarParser.BracketCondContext ctx);[Done]

	T visitIsCond(XQueryGrammarParser.IsCondContext ctx);[Done]


// Mingejie Song


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
	  private void recursiveHelperVar(XQueryGrammarParser.FlworXQContext ctx, List<Node> nodes, int iter) {

        if (ctx.forClause().VAR().size() == iter) {

            if (ctx.letClause() != null) {
                visit(ctx.letClause());
            }

            if ((ctx.whereClause() == null) || (visit(ctx.whereClause()).size() != 0)) {
                nodes.addAll(visit(ctx.returnClause()));

            }
        } else {

            List<Node> res = visit(ctx.forClause().xq(iter));
            for (int i = 0; i < res.size(); i++) {

                List<Node> n = new ArrayList<>();
                n.add(res.get(i));

                varMap.put(ctx.forClause().VAR(iter).getText(), n);
                recursiveHelperVar(ctx, nodes, iter + 1);
            }
        }
    }
	private List<Node> getNodeDescendants(Node node) {
        // recursively get descendants
        List<Node> descendants = new ArrayList<>();
        descendants.add(node);
        for(int i = 0; i < node.getChildNodes().getLength(); i++){
            descendants.addAll(getNodeDescendants(node.getChildNodes().item(i)));
        }
        return descendants;
    }

    
}
