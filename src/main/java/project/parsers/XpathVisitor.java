package project.parsers;
import org.w3c.dom.Document;
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
        return visit(ctx.rp());
    }

    @Override public List<Node> visitTagRP(XPathGrammarParser.TagRPContext ctx) {
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
}