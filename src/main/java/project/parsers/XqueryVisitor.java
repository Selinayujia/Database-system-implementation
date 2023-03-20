package project.parsers;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.w3c.dom.*;
import java.util.*;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.io.StringWriter;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class XqueryVisitor extends XQueryGrammarBaseVisitor<List<Node>> {

    private HashMap<String, List<Node>> varMap = new HashMap<>();
    private List<Node> contextNodes = new ArrayList<>();
    
   
    @Override public List<Node> visitVarXQ(XQueryGrammarParser.VarXQContext ctx) {

        String content = ctx.VAR().getText();
        if (varMap.containsKey(content)){
            //!!!!!!!! always return a list, otherwise the contextNodes has the wrong value !!!!! example:  testcase4
            // contextNodes =   varMap.get(content) ; -- wrong !!!!
            contextNodes =  new ArrayList<>(varMap.get(content) );
        }
        else {
            //FIXME, var not define, raise an error and return? 
            System.err.println("Error var " + content+" not define" );
            contextNodes = new ArrayList<>();
        }

		return contextNodes;
 
    }
 
    @Override public List<Node> visitStringXQ(XQueryGrammarParser.StringXQContext ctx) {
         
        String constant = ctx.STRINGCONSTANT().getText();
        constant = constant.substring(1, constant.length()-1);  
        // create a text node 
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
        contextNodes = dedup(contextNodes);

        return contextNodes;
    }

    @Override public List<Node> visitDoubleSlashXQ(XQueryGrammarParser.DoubleSlashXQContext ctx) {
        
        visit(ctx.xq());
        List<Node> descendants = new ArrayList<>();
        for(int i = 0; i < contextNodes.size(); i++){
            descendants.addAll(getNodeDescendants(contextNodes.get(i)));
        }
        contextNodes.addAll(descendants);
        contextNodes = visit(ctx.rp());
        contextNodes = dedup( contextNodes);

        return  contextNodes;
    }

    @Override public List<Node> visitApXQ(XQueryGrammarParser.ApXQContext ctx) {
        return visit(ctx.ap());
        
    }

    @Override public List<Node> visitBracketXQ(XQueryGrammarParser.BracketXQContext ctx) {
        return visit(ctx.xq());
    }

    @Override public List<Node> visitSequenceXQ(XQueryGrammarParser.SequenceXQContext ctx) {
        List<Node> temp =  new ArrayList<>(contextNodes);
		List<Node> res = new ArrayList<>();
		res.addAll(visit(ctx.xq(0)));
		contextNodes = temp;
		res.addAll(visit(ctx.xq(1)));
		contextNodes = res;
		return contextNodes;
    }

    
    @Override public List<Node> visitTagXQ(XQueryGrammarParser.TagXQContext ctx) {
        String text = ctx.TAGNAME(0).getText();
		List<Node> context = visit(ctx.xq());
		Element element = null;
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            element = doc.createElement(text);

            for (Node n : context) {
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

    @Override public List<Node> visitFlworXQ(XQueryGrammarParser.FlworXQContext ctx) {
        List<Node> res = new ArrayList<>();
        HashMap<String, List<Node>> temp = new HashMap<>(varMap);
        recursiveHelperVar(ctx, res, 0);
        varMap = temp; //backtrack
        contextNodes = res ; //????????????
        return res;
    }

   
    //TODO 
    @Override public List<Node> visitLetClauseXQ(XQueryGrammarParser.LetClauseXQContext ctx) {
        List<Node> tmpNodes = contextNodes;  
        HashMap<String, List<Node>> tmpContext = new HashMap<>(varMap);
        contextNodes = visit(ctx.letClause());
        List<Node> res = visit(ctx.xq());
        contextNodes = tmpNodes; 
        varMap = tmpContext;

        return res;

        
        // HashMap<String, List<Node>> tempMap = new HashMap<>(varMap);
        // contextNodes = visit(ctx.letClause());
        // List<Node> res = visit(ctx.xq());
        // varMap = tempMap;
        // return res;
    }

    @Override public List<Node> visitLetClause(XQueryGrammarParser.LetClauseContext ctx) {
        int len = ctx.VAR().size();
        for(int i = 0; i < len; i++) {
            varMap.put(ctx.VAR(i).getText(), visit(ctx.xq(i)));
        }

        return contextNodes;
    }

    @Override public List<Node> visitForClause(XQueryGrammarParser.ForClauseContext ctx) {
        return contextNodes;
    }


    @Override public List<Node> visitWhereClause(XQueryGrammarParser.WhereClauseContext ctx) {
        return visit(ctx.cond());
    }

    @Override public List<Node> visitReturnClause(XQueryGrammarParser.ReturnClauseContext ctx) {
        List<Node> res = visit(ctx.xq());
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

    @Override public List<Node> visitEmptyCond(XQueryGrammarParser.EmptyCondContext ctx) {
        List<Node> temp = contextNodes;
        List<Node> res = visit(ctx.xq());
        contextNodes = temp;
        if (res.size() == 0) {
            return contextNodes;
        }
        return new ArrayList<>();
    }

     
    @Override public List<Node> visitMultipleCond(XQueryGrammarParser.MultipleCondContext ctx) {
        List<Node> tempNodes =  contextNodes;
        HashMap<String, List<Node>> tempMap = varMap ;
         for (int i = 0; i < ctx.VAR().size(); i++) {
            //System.out.println("update Context: " +  ctx.VAR(i).getText());
            List<Node> content = visit(ctx.xq(i))  ; 
            varMap.put( ctx.VAR(i).getText(), content );    
         }
        List<Node> res = visit(ctx.cond());
 
        varMap = tempMap;
        contextNodes = tempNodes;
        
        return res;
         
    }

    @Override public List<Node> visitBracketCond(XQueryGrammarParser.BracketCondContext ctx) {

        return visit(ctx.cond());
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

    @Override public List<Node> visitOrCond(XQueryGrammarParser.OrCondContext ctx) {
        List<Node> res = new ArrayList<>();
        List<Node> temp = new ArrayList<>(contextNodes);
        List<Node> stepRes = visit(ctx.cond(0));
        contextNodes = temp;
        stepRes.addAll(visit(ctx.cond(1)));
        res = dedup(stepRes);
        contextNodes = res;

        return res;
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

  


     
   // old methods from xpath -> xquery

	@Override public List<Node> visitSingleSlashAP(XQueryGrammarParser.SingleSlashAPContext ctx) {
        // a single slash simply just direct the next part of relative path
        String fName = ctx.FILENAME().getText();
        fName = fName.substring(1, fName.length()-1) ;
        contextNodes = getInitialNodeFromFile(fName);
        // go to the next relative path of the query
        return visit(ctx.rp());
    }

    @Override public List<Node> visitDoubleSlashAP(XQueryGrammarParser.DoubleSlashAPContext ctx) {
        // a double slash recursively find all the descendant nodes of the current node
        String fName = ctx.FILENAME().getText();
        fName = fName.substring(1, fName.length()-1) ;

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
        contextNodes = dedup(selfAndDescendants) ; 
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
        contextNodes  = dedup(contextNodes) ; 
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
        res =  dedup(res) ; 
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

    // milestone3

    @Override public List<Node> visitJoinXQ(XQueryGrammarParser.JoinXQContext ctx) {
        return visit(ctx.joinClause());
    }

    @Override public List<Node> visitJoinClause(XQueryGrammarParser.JoinClauseContext ctx) {
        List<Node> tmp = contextNodes;
        List<Node> resLeft = visit(ctx.xq(0));
        contextNodes = tmp;
        List<Node> resRight = visit(ctx.xq(1)); // list of tuples

        List<TerminalNode> joinIdLeft = ctx.idList(0).TAGNAME();
        List<TerminalNode> joinIdRight = ctx.idList(1).TAGNAME();



        Map<String, LinkedList<Node>> leftSideKeyTupleMap = new HashMap<>();

        for (Node l : resLeft) {
            String key = generateKeyString(l, joinIdLeft);
            if (!leftSideKeyTupleMap.containsKey(key)) {
                leftSideKeyTupleMap.put(key, new LinkedList<>());
            }

            leftSideKeyTupleMap.get(key).add(l);
        }

        List<Node> res = new LinkedList<>();
        for (Node r : resRight) {
            String key = generateKeyString(r, joinIdRight);
            
            if (leftSideKeyTupleMap.containsKey(key)) { // left, right both have the same key, perform join
                //System.out.println("find");
                List<Node> leftValues = leftSideKeyTupleMap.get(key);
                for (Node l : leftValues) {
                    List<Node> joining = new LinkedList<>();
                    List<Node> listLeft = new ArrayList<>();
                    List<Node> listRight = new ArrayList<>();
                    listLeft.add(l);
                    listRight.add(r);
                    joining.addAll(getAllChildren(listLeft));
                    joining.addAll(getAllChildren(listRight));

                    // make element 
                    Element element = null;
                    try {
                        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
                        element = doc.createElement(l.getNodeName());

                        for (Node n : joining) {
                            Node c = n.cloneNode(true);
                            doc.adoptNode(c);
                            element.appendChild(c);
                        }

                    } catch (Exception e) {
                        System.err.println("Exception: " + e.getMessage());
                    }



                    res.add(element);
                }
            }

        }

        contextNodes = res;
        return contextNodes;
    }

    @Override public List<Node> visitIdList(XQueryGrammarParser.IdListContext ctx) { 
        return visitChildren(ctx); 
    }



// private funcs


// milestone 3
    private String generateKeyString(Node tuple, List<TerminalNode> joinedIds) {
        String res = "";
        List<Node> tmp = new ArrayList<>();
        tmp.add(tuple);
        List<Node> children = getAllChildren(tmp);

        for (TerminalNode id : joinedIds) {
            for (Node child : children) {

                if (child.getNodeName().equals(id.getText())) { 
                    List<Node> temp = new ArrayList<>();
                    temp.add(child);
                    res += nodeListToString(getAllChildren(temp));
                     
                }
            }
        }
        return res;
    }
    // private String nodeListToHashString(List<Node> nodes) { 
    //     String ret = "";
    //     for (int i = 0; i < nodes.size(); i++) {
    //         ret += nodes.get(i).hashCode() + "\n";
    //     }
    //     return ret;
    // }

    private String nodeListToString(List<Node> nodes) { 
        String res = "";
        for (int i = 0; i < nodes.size(); i++) {

            StringWriter sw = new StringWriter();
            try {
                Transformer t = TransformerFactory.newInstance().newTransformer();
                t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
                t.setOutputProperty(OutputKeys.INDENT, "yes");
                t.transform(new DOMSource(nodes.get(i)), new StreamResult(sw));
            } catch (TransformerException te) {
                System.out.println("NodeToString Exception");
            }
            res +=  sw.toString() + "\n";
        }
        return res;
    }

    // private String nodeToString(Node inputNode) { 
    //     StringWriter sw = new StringWriter();
    //     try {
    //         Transformer t = TransformerFactory.newInstance().newTransformer();
    //         t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
    //         t.setOutputProperty(OutputKeys.INDENT, "yes");
    //         t.transform(new DOMSource(inputNode), new StreamResult(sw));
    //     } catch (TransformerException te) {
    //         System.out.println("NodeToString Exception");
    //     }
    //     return sw.toString();
    // }
 



    private List<Node> getAllChildren(List<Node> nodes) {
        List<Node> res = new ArrayList<>();

        for (Node node : nodes) {
            NodeList nodelist = node.getChildNodes();
            for (int i = 0; i < nodelist.getLength(); i++) {
                res.add(nodelist.item(i));
            }
        }

        return res;
    }

    private List<Node> getAllParents(List<Node> nodes) {
        List<Node> res = new ArrayList<>();

        for (Node node : nodes) {
            res.add(node.getParentNode());
        }

        return res;
    }

     

    private void recursiveHelperVar(XQueryGrammarParser.FlworXQContext ctx, List<Node> nodes, int iter) {

        if (ctx.forClause().VAR().size() == iter) {

            if (ctx.letClause() != null) {
                visit(ctx.letClause());
            }

            if ((ctx.whereClause() == null) || (visit(ctx.whereClause()).size() != 0)) {
                List<Node> curRes = visit(ctx.returnClause());
                nodes.addAll( curRes);

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

    private List<Node> dedup(List<Node> input) {     
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
 

    private List<Node> getNodeDescendants(Node node) {
        List<Node> descendants = new ArrayList<>();
        int len = node.getChildNodes().getLength();
        descendants.add(node);
        for(int i = 0; i < len; i++){
            descendants.addAll(getNodeDescendants(node.getChildNodes().item(i)));
        }
        return descendants;
    }

    

    

}

