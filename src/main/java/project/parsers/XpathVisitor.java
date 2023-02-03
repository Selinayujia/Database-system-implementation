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

	@Override public List<Node>  visitDoubleSlashRP(XPathGrammarParser.DoubleSlashRPContext ctx) {
        visit(ctx.rp(0));
        visit(ctx.rp(1));
        List<Node> nodes = new ArrayList<>(new HashSet<>(contextNodes));
        contextNodes = nodes;
        return nodes;
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


    // Ask TA
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

     // FIXME 
	@Override public List<Node> visitAttributeRP(XPathGrammarParser.AttributeRPContext ctx) { 
        List<Node> res = new ArrayList<>();
        String attr = ctx.ATTRNAME().getText().substring(1); //???? 
        //System.out.println("Attribute Name " + attr);

        for (Node node : contextNodes) {
            NamedNodeMap nodemap = node.getAttributes();
            if (nodemap != null && nodemap.getNamedItem(attr) != null) {
                res.add(nodemap.getNamedItem(attr));
            }
        }

        contextNodes = res;
        // FIXME
        return res;
        //return visitChildren(ctx);
         }

	@Override public List<Node> visitBracketRP(XPathGrammarParser.BracketRPContext ctx) {
         return contextNodes; }

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

    /* 
    // Together split these later

	@Override public T visitSingleSlashRP(XPathGrammarParser.SingleSlashRPContext ctx) { return visitChildren(ctx); }

	@Override public T visitAndFilter(XPathGrammarParser.AndFilterContext ctx) { return visitChildren(ctx); }
	
	@Override public T visitIsFilter(XPathGrammarParser.IsFilterContext ctx) { return visitChildren(ctx); }

	@Override public T visitBracketFilter(XPathGrammarParser.BracketFilterContext ctx) { return visitChildren(ctx); }

	@Override public T visitRPFilter(XPathGrammarParser.RPFilterContext ctx) { return visitChildren(ctx); }

	@Override public T visitNotFilter(XPathGrammarParser.NotFilterContext ctx) { return visitChildren(ctx); }

	@Override public T visitConstantFilter(XPathGrammarParser.ConstantFilterContext ctx) { return visitChildren(ctx); }
	
	@Override public T visitEqualFilter(XPathGrammarParser.EqualFilterContext ctx) { return visitChildren(ctx); }

	@Override public T visitOrFilter(XPathGrammarParser.OrFilterContext ctx) { return visitChildren(ctx); }
    
    */


    // helper functions

    private List<Node> getInitialNodeFromFile(String filename) {
         // TODO make test path a global?
        String filepath= "test_files/" + filename;  
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
}