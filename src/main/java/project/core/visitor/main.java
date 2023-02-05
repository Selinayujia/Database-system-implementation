package project.core.visitor;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import org.w3c.dom.Node;
import org.w3c.dom.Document;

import java.util.*;
import java.io.File;

import project.parsers.XPathGrammarLexer;
import project.parsers.XPathGrammarParser;
import project.parsers.XpathVisitor;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class main {
    public static void main(String[] args) {
        try {
            // Generate tree and visitor
            //CharStream query = CharStreams.fromFileName("query.txt");
            CharStream query = CharStreams.fromFileName(args[0]);
            XPathGrammarLexer lexer = new XPathGrammarLexer(query);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            XPathGrammarParser parser = new XPathGrammarParser(tokens);


            parser.removeErrorListeners();
            ParseTree tree = parser.ap();

            // Visit the tree
            // below needs implementation in the XpathVisitor class
            XpathVisitor visitor = new XpathVisitor();
            List<Node> res = visitor.visit(tree);

            //parse the result back to a tree

            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

            Node body = doc.createElement("RESULT");
            for (Node node : res) {
                Node copy= doc.importNode(node, true);
                body.appendChild(copy);
            }
            doc.appendChild(body);

            DOMSource xml_content = new DOMSource(doc);


            //StreamResult file = new StreamResult(new File("./output.xml"));
            StreamResult file = new StreamResult(new File(args[1]));
            Transformer tf = TransformerFactory.newInstance().newTransformer();
            tf.transform(xml_content, file);
            
        
        } catch(Exception e) {  
            System.err.println("Exception: " + e.getMessage());
        }
    }
}

