package project.core.visitor;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;


import org.w3c.dom.Node;
import org.w3c.dom.Document;

import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;  

import project.parsers.XQueryGrammarLexer;
import project.parsers.XQueryGrammarParser;
import project.parsers.XqueryRewriter;
import project.parsers.XqueryVisitor;



import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class XQueryMain {
    public static void main(String[] args) {
       
        try {
           
            // Generate tree and visitor
            //CharStream query = CharStreams.fromFileName("newQuery.txt");
            CharStream query = CharStreams.fromFileName(args[0]);
            XQueryGrammarLexer lexer = new XQueryGrammarLexer(query);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            XQueryGrammarParser parser = new XQueryGrammarParser(tokens);


            parser.removeErrorListeners();
            ParseTree tree = parser.xq();
              

            // Visit the tree
            // below needs implementation in the XpathVisitor class
           
            XqueryVisitor joinVisitor = new XqueryVisitor();

            long startTime = System.nanoTime();

            List<Node> res = joinVisitor.visit(tree);

            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            long durationInMillis = duration / 1000000;
            System.out.println("Execution time: " + durationInMillis + " milliseconds");
            
           
            

            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();


            for (Node node : res) {
                Node copy= doc.importNode(node, true);
               doc.appendChild(copy);
            }
    
            

            DOMSource xml_content = new DOMSource(doc);


            //StreamResult file = new StreamResult(new File("./output.xml"));
            StreamResult file = new StreamResult(new File(args[1]));
            Transformer tf = TransformerFactory.newInstance().newTransformer();
            tf.transform(xml_content, file);
            
        
        } catch(Exception e) {  
            System.err.println("Exception here: " + e.getMessage());
        }
    }
    
}
