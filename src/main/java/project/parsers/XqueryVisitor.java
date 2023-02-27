package project.parsers;
import java.util.*;
import org.w3c.dom.*;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilderFactory;

public class XqueryVisitor extends XQueryGrammarBaseVisitor<List<Node>> {

    private List<Node> contextNodes = new ArrayList<>();
	private HashMap<String, List<Node>> varMap = new HashMap<>();
    @Override public List<Node> visitStringXQ(XQueryGrammarParser.StringXQContext ctx) {
        String constant = ctx.STRINGCONSTANT().getText();
        constant = constant.substring(1, constant.length()-1);  
		Node text = null;
		try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            text = doc.createTextNode(constant);
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }

        List<Node> res = new ArrayList<>();
        res.add(text);
        contextNodes = res;

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

	// old methods from xpath -> xquery

	@Override public List<Node> visitSingleSlashAP(XQueryGrammarParser.SingleSlashAPContext ctx) {
        // a single slash simply just direct the next part of relative path
        String fName = ctx.FILENAME().getText();
        contextNodes = getInitialNodeFromFile(fName);
        // go to the next relative path of the query
        return visit(ctx.rp());
    }

    @Override public List<Node> visitDoubleSlashAP(XQueryGrammarParser.DoubleSlashAPContext ctx) {
        // a double slash recursively find all the descendant nodes of the current node
        String fName = ctx.FILENAME().getText();
        contextNodes = getInitialNodeFromFile(fName);

        List<Node> descendants = new ArrayList<>();
        for(int i = 0; i <  contextNodes.size(); i++){
            descendants.addAll(getNodeDescendants(contextNodes.get(i)));
        }

        contextNodes = descendants ; 
        return visit(ctx.rp());
    }

    
    @Override public List<Node> visitAllChildrenRP(XQueryGrammarParser.AllChildrenRPContext ctx) {
        List<Node> nodes = getAllChildren(contextNodes);
        contextNodes = nodes;
        return nodes;
    }

     
	@Override public List<Node>  visitDoubleSlashRP(XQueryGrammarParser.DoubleSlashRPContext ctx) {
        
        //rp1 
        visit(ctx.rp(0));
        List<Node> selfAndDescendants = new ArrayList<>();
        for(int i = 0; i < contextNodes.size(); i++){
            selfAndDescendants.addAll(getNodeDescendants(contextNodes.get(i)));
        }
        //dedup
        contextNodes = deduplicate(selfAndDescendants) ; 
        //rp2
        visit(ctx.rp(1));
        return contextNodes ; 
    }

	@Override public List<Node> visitFilteredRP(XQueryGrammarParser.FilteredRPContext ctx) {
        visit(ctx.rp());
        List<Node> nodes = new ArrayList<>();
        List<Node> nodeToEvaluate = new ArrayList<>(contextNodes);

        for (Node node : nodeToEvaluate) {
            contextNodes.clear();
            contextNodes.add(node);
            if (visit(ctx.f()).size() != 0) {
                nodes.add(node);
            }
        }
        contextNodes = nodes;
        return nodes;
    }



    @Override public List<Node> visitTagRP(XQueryGrammarParser.TagRPContext ctx) {
        // Find elements nodes with a specific a tag name, e.g persona
        List<Node> elements = new ArrayList<>();
        List<Node> nodes = getAllChildren(contextNodes);
        for (Node node : nodes) {
            // check if the node is an element and compare tag name to element name
            if (node.getNodeType() == Node.ELEMENT_NODE && ctx.TAGNAME().getText().equals(node.getNodeName())) {
                elements.add(node);
            }
        }
      
        contextNodes = elements;
        return elements;
    }
   

	@Override public List<Node> visitTextRP(XQueryGrammarParser.TextRPContext ctx) { 
        List<Node> res = new ArrayList<>();
        for (Node node : contextNodes) {
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                NodeList childrenNodes = node.getChildNodes();
                for (int i = 0; i < childrenNodes.getLength(); i++) {
                    if (childrenNodes.item(i).getNodeType() == Node.TEXT_NODE) {
                        res.add(childrenNodes.item(i));
                    }
                }
            }
        }

        contextNodes = res;
        return res;
     }

	@Override public List<Node> visitAttributeRP(XQueryGrammarParser.AttributeRPContext ctx) { 
        List<Node> res = new ArrayList<>();
        String attr = ctx.ATTRNAME().getText().substring(1) ; // @AttributeName

        for (Node node : contextNodes) {
            NamedNodeMap nodemap = node.getAttributes();
            if (nodemap != null && nodemap.getNamedItem(attr) != null) {
                res.add(nodemap.getNamedItem(attr));
            }
        }
        contextNodes =  res ; 
        return res;

    }

	@Override public List<Node> visitBracketRP(XQueryGrammarParser.BracketRPContext ctx) {
        return visit(ctx.rp());
    }

	@Override public List<Node> visitSequenceRP(XQueryGrammarParser.SequenceRPContext ctx) { 
        List<Node> res = new ArrayList<>();
        List<Node> originNodes = new ArrayList<>(contextNodes);
        res.addAll(visit(ctx.rp(0)));
        contextNodes = originNodes;
        res.addAll(visit(ctx.rp(1)));

        contextNodes = res;
        return res;
     }

	@Override public List<Node> visitParentRP(XQueryGrammarParser.ParentRPContext ctx) { 
        List<Node> res = getAllParents(contextNodes);
        contextNodes= res;
        return res;
     }

	@Override public List<Node> visitSelfRP(XQueryGrammarParser.SelfRPContext ctx) { 
        return contextNodes; 
    }

    @Override public List<Node> visitSingleSlashRP(XQueryGrammarParser.SingleSlashRPContext ctx) { 
        visit(ctx.rp(0));
        visit(ctx.rp(1));
        contextNodes  = deduplicate(contextNodes) ; 
        return contextNodes ;
    }

    // Below are methods for filters
    // there is no need to update contextNode in the filter method, only return size matters 
    @Override public List<Node> visitAndFilter(XQueryGrammarParser.AndFilterContext ctx) { 

        List<Node> origiNodes = new ArrayList<>(contextNodes);
        List<Node> filter1 = visit(ctx.f(0)) ;
        contextNodes = origiNodes;
        List<Node> filter2 = visit(ctx.f(1));
        
        if (filter1.size() != 0 && filter2.size() != 0) {
            return filter1 ; 
        }
        return new ArrayList<>() ; 
         
     }

     @Override public List<Node> visitOrFilter(XQueryGrammarParser.OrFilterContext ctx) { 
        List<Node> res = new ArrayList<>() ; 
        List<Node> origiNodes = new ArrayList<>(contextNodes);
        res.addAll(visit(ctx.f(0))) ; 
        contextNodes = origiNodes;
        res.addAll(visit(ctx.f(1))) ; 
        // dedup
        res =  deduplicate(res) ; 
        return res;
      }


    @Override public List<Node> visitBracketFilter(XQueryGrammarParser.BracketFilterContext ctx) {
        return visit(ctx.f());
    }

    @Override public List<Node> visitIsFilter(XQueryGrammarParser.IsFilterContext ctx) { 
        
        List<Node> origiNodes = new ArrayList<>( contextNodes);
        List<Node> rp1 = visit(ctx.rp(0));
        contextNodes = origiNodes;
        List<Node> rp2 = visit(ctx.rp(1));

        List<Node> res = new ArrayList<>();
        for (Node currNode1 : rp1) {
            for (Node currNode2 : rp2) {
                if (currNode1.isSameNode(currNode2)) {
                    res.add(currNode1);
                }
            }
        }
        return res; 
         
    }
    @Override public List<Node> visitEqualFilter(XQueryGrammarParser.EqualFilterContext ctx) {  
         
        List<Node> origiNodes = new ArrayList<>( contextNodes);
        List<Node> rp1 = visit(ctx.rp(0));
        contextNodes = origiNodes;
        List<Node> rp2 = visit(ctx.rp(1));

        List<Node> res = new ArrayList<>();
        for (Node currNode1 : rp1) {
            for (Node currNode2 : rp2) {
                if (currNode1.isEqualNode(currNode2)) {
                    res.add(currNode1);
                }
            }
        }
        return res; 

    }
    @Override public List<Node> visitRPFilter(XQueryGrammarParser.RPFilterContext ctx) { 
        return visit(ctx.rp());
     }

     
	@Override public List<Node> visitNotFilter(XQueryGrammarParser.NotFilterContext ctx) { 
        List<Node> nonEmptyList = new ArrayList<>( contextNodes);
        List<Node> filterRes = visit(ctx.f()); 
       
        if (filterRes.size() == 0) {
            return nonEmptyList;   
        }
        return new ArrayList<>();
        
     }

	@Override public List<Node> visitConstantFilter(XQueryGrammarParser.ConstantFilterContext ctx) {  
        
        visit(ctx.rp());
        String str  = ctx.STRINGCONSTANT().getText(); 
        str  = str.substring(1, str.length() - 1);  // "REAL TEXT"
        
        List<Node> res = new ArrayList<>();
        for (Node node : contextNodes) {
            if (node.getNodeType() == Node.TEXT_NODE && node.getNodeValue().equals(str)) {
                res.add(node);
            }
        }
        contextNodes = res;
        return res;
    } 

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

	private List<Node> getInitialNodeFromFile(String filename) {
        String filepath= filename;  
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        List<Node> starterNodeList = new ArrayList<>();
    
        try {
            Document doc = dbf.newDocumentBuilder().parse(filepath);
            starterNodeList.add(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return starterNodeList;
    }

    private List<Node> getAllChildren(List<Node> nodes) {
        List<Node> allChildrenNodes = new ArrayList<>();
        for (Node node : nodes) {
            NodeList childrenNode = node.getChildNodes();
            for (int i = 0; i < childrenNode.getLength(); i++) {
                allChildrenNodes.add(childrenNode.item(i));
            }
        }
        return allChildrenNodes;
    }

    private List<Node> getAllParents(List<Node> nodes) {
        List<Node> res = new ArrayList<>();

        for (Node node : nodes) {
            res.add(node.getParentNode());
        }

        return res;
	}

    
}
