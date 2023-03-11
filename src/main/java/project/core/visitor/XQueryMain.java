package project.core.visitor;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import org.w3c.dom.Node;
import org.w3c.dom.Document;

import java.util.*;
import java.io.File;

import project.parsers.XQueryGrammarLexer;
import project.parsers.XQueryGrammarParser;
import project.parsers.XqueryVisitor;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class XQueryMain {
    public static void main(String[] args) {
       
        try {
           
            // Generate tree and visitor
            CharStream query = CharStreams.fromFileName("query.txt");
            //CharStream query = CharStreams.fromFileName(args[0]);
            XQueryGrammarLexer lexer = new XQueryGrammarLexer(query);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            XQueryGrammarParser parser = new XQueryGrammarParser(tokens);


            parser.removeErrorListeners();
            ParseTree tree = parser.xq();

            // Visit the tree
            // below needs implementation in the XpathVisitor class
           
            XqueryVisitor visitor = new XqueryVisitor();
            
            List<Node> res = visitor.visit(tree);
            

            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

          //  Node body = doc.createElement("RESULT");
            for (Node node : res) {
                Node copy= doc.importNode(node, true);
               // body.appendChild(copy);
               doc.appendChild(copy);
            }
           // doc.appendChild(body);
            

            DOMSource xml_content = new DOMSource(doc);


            StreamResult file = new StreamResult(new File("./output.xml"));
            //StreamResult file = new StreamResult(new File(args[1]));
            Transformer tf = TransformerFactory.newInstance().newTransformer();
            tf.transform(xml_content, file);
            
        
        } catch(Exception e) {  
            System.err.println("Exception here: " + e.getMessage());
        }
    }
    
}
