package project.parsers;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XpathVisitor extends XPathGrammarBaseVisitor<List<Node>>{

    private List<Node> contextNodes = new ArrayList<>();

    @Override public List<Node> visitSingleSlashAP(XPathGrammarParser.SingleSlashAPContext ctx) {
        // a single slash simply just direct the next part of relative path
        String fName = ctx.FILENAME().getText();
        contextNodes = getInitialNodeFromFile(fName);
        // go to the next relative path of the query
        return visit(ctx.rp());
    }

    @Override public List<Node> visitDoubleSlashAP(XPathGrammarParser.DoubleSlashAPContext ctx) {
        // a double slash recursively find all the descendant nodes of the current node
        String fName = ctx.FILENAME().getText();
        contextNodes = getInitialNodeFromFile(fName);

        List<Node> descendants = new ArrayList<>();
        for(int i = 0; i <  contextNodes.size(); i++){
            //FIXME(1) dedup??? no 
            descendants.addAll(getNodeDescendants(contextNodes.get(i)));
        }

        contextNodes = descendants ; 
        return visit(ctx.rp());
    }

    
    @Override public List<Node> visitAllChildrenRP(XPathGrammarParser.AllChildrenRPContext ctx) {
        List<Node> nodes = getAllChildren(contextNodes);
        contextNodes = nodes;
        return nodes;
    }

    //FIXME   
	@Override public List<Node>  visitDoubleSlashRP(XPathGrammarParser.DoubleSlashRPContext ctx) {
        /* 
        visit(ctx.rp(0));
        visit(ctx.rp(1));
        List<Node> nodes = new ArrayList<>(new HashSet<>(contextNodes));
        contextNodes = nodes;
        return nodes; */ 
        
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
        
        /* 
        visit(ctx.rp(0));
        List<Node> selfAndDescendants = new ArrayList<>();
        for(int i = 0; i < contextNodes.size(); i++){
            selfAndDescendants.addAll(getNodeDescendants(contextNodes.get(i)));
        }
        contextNodes =  selfAndDescendants ; 
        List<Node> tmp = new ArrayList<>(contextNodes );
        List<Node> res = new ArrayList<>() ; 
        res.addAll(tmp) ; 
        res.addAll( visit(ctx.rp(1))) ; 
        res = deduplicate(res) ; 
        contextNodes = res;
        return res; */
        
    }

	@Override public List<Node> visitFilteredRP(XPathGrammarParser.FilteredRPContext ctx) {
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



    // FIXME  (2) getAllChildren ? 
    @Override public List<Node> visitTagRP(XPathGrammarParser.TagRPContext ctx) {
        // Find elements nodes with a specific a tag name, e.g persona
        List<Node> elements = new ArrayList<>();
        List<Node> nodes = getAllChildren(contextNodes);
        System.out.println(nodes.size());
        for (Node node : nodes) {
            // check if the node is an element and compare tag name to element name
            if (node.getNodeType() == Node.ELEMENT_NODE && ctx.TAGNAME().getText().equals(node.getNodeName())) {
                elements.add(node);
            }
        }
      
        contextNodes = elements;
        return elements;
    }
   

    // Mingjie
	@Override public List<Node> visitTextRP(XPathGrammarParser.TextRPContext ctx) { 
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

      
	@Override public List<Node> visitAttributeRP(XPathGrammarParser.AttributeRPContext ctx) { 
        List<Node> res = new ArrayList<>();
        String attr = ctx.ATTRNAME().getText().substring(1) ; // @AttributeName
        //System.out.println("Attribute Name " + attr);

        for (Node node : contextNodes) {
            NamedNodeMap nodemap = node.getAttributes();
            if (nodemap != null && nodemap.getNamedItem(attr) != null) {
                res.add(nodemap.getNamedItem(attr));
            }
        }
        contextNodes =  res ; 
        return res;

        // FIXME(3)  return visitChildren(ctx); ??
    
    }

	@Override public List<Node> visitBracketRP(XPathGrammarParser.BracketRPContext ctx) {
        return visit(ctx.rp());
    }

	@Override public List<Node> visitSequenceRP(XPathGrammarParser.SequenceRPContext ctx) { 
        List<Node> res = new ArrayList<>();
        List<Node> originNodes = new ArrayList<>(contextNodes);
        res.addAll(visit(ctx.rp(0)));
        contextNodes = originNodes;
        res.addAll(visit(ctx.rp(1)));

        contextNodes = res;
        return res;
     }

	@Override public List<Node> visitParentRP(XPathGrammarParser.ParentRPContext ctx) { 
        List<Node> res = getAllParents(contextNodes);
        contextNodes= res;
        return res;
     }

	@Override public List<Node> visitSelfRP(XPathGrammarParser.SelfRPContext ctx) { 
        return contextNodes; 
    }

    @Override public List<Node> visitSingleSlashRP(XPathGrammarParser.SingleSlashRPContext ctx) { 
        visit(ctx.rp(0));
        visit(ctx.rp(1));
        contextNodes  = deduplicate(contextNodes) ; 
        return contextNodes ;
    }

    // Below are methods for filters
    // FIXME 4:  there is no need to update contextNode in the filter method, only return size matters 
    @Override public List<Node> visitAndFilter(XPathGrammarParser.AndFilterContext ctx) { 

        List<Node> origiNodes = new ArrayList<>(contextNodes);
        List<Node> filter1 = visit(ctx.f(0)) ;
        contextNodes = origiNodes;
        List<Node> filter2 = visit(ctx.f(1));
        
        if (filter1.size() != 0 && filter2.size() != 0) {
            return filter1 ; 
        }
        return new ArrayList<>() ; 
         
     }

     @Override public List<Node> visitOrFilter(XPathGrammarParser.OrFilterContext ctx) { 
        List<Node> res = new ArrayList<>() ; 
        List<Node> origiNodes = new ArrayList<>(contextNodes);
        res.addAll(visit(ctx.f(0))) ; 
        contextNodes = origiNodes;
        res.addAll(visit(ctx.f(1))) ; 
        // dedup
        res =  deduplicate(res) ; 
        return res;
      }


    @Override public List<Node> visitBracketFilter(XPathGrammarParser.BracketFilterContext ctx) {
        return visit(ctx.f());
    }

    @Override public List<Node> visitIsFilter(XPathGrammarParser.IsFilterContext ctx) { 
        
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
    @Override public List<Node> visitEqualFilter(XPathGrammarParser.EqualFilterContext ctx) {  
         
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
    @Override public List<Node> visitRPFilter(XPathGrammarParser.RPFilterContext ctx) { 
        return visit(ctx.rp());
     }

     
	@Override public List<Node> visitNotFilter(XPathGrammarParser.NotFilterContext ctx) { 
        List<Node> nonEmptyList = new ArrayList<>( contextNodes);
        List<Node> filterRes = visit(ctx.f()); 
       
        if (filterRes.size() == 0) {
            return nonEmptyList;   
        }
        return new ArrayList<>();
        
     }

	@Override public List<Node> visitConstantFilter(XPathGrammarParser.ConstantFilterContext ctx) {  
        
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


    // helper functions

    private List<Node> getInitialNodeFromFile(String filename) {
        String filepath= filename;  
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        List<Node> starterNodeList = new ArrayList<>();
    
        try {
            DocumentBuilder b = dbf.newDocumentBuilder();
            Document doc = b.parse(filepath);
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


    private List<Node> getNodeDescendants(Node node) {
        // recursively get descendants
        List<Node> descendants = new ArrayList<>();
        descendants.add(node);
        for(int i = 0; i < node.getChildNodes().getLength(); i++){
            descendants.addAll(getNodeDescendants(node.getChildNodes().item(i)));
        }
        return descendants;
    }

    private List<Node> getAllParents(List<Node> nodes) {
        List<Node> res = new ArrayList<>();

        for (Node node : nodes) {
            res.add(node.getParentNode());
        }

        return res;
    }

    //order matters, cannot use hashset for deduplication 
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