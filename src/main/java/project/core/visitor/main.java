package project.core.visitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import org.w3c.dom.Node;
import java.util.*;


import project.parsers.XPathGrammarLexer;
import project.parsers.XPathGrammarParser;
import project.parsers.XpathVisitor;


public class main {
    public static void main(String[] args) {
        try {
            // Generate tree and visitor
            CharStream ANTLRInput = CharStreams.fromFileName("test_files/query.txt");
            XPathGrammarLexer lexer = new XPathGrammarLexer(ANTLRInput);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            XPathGrammarParser parser = new XPathGrammarParser(tokens);
            parser.removeErrorListeners();
            ParseTree tree = parser.ap(); // ? what does this return
            System.out.println(tree);

            // Visit the tree
            // below needs implementation in the XpathVisitor class
            XpathVisitor visitor = new XpathVisitor();
        
            List<Node> res = visitor.visit(tree);
            System.out.println(res);
            // The query in query.txt can run at this stage
            // Correct way to check the node value is  via node.getTextContent()
            


            //parse the result back to a tree
        } catch(Exception e) {  
            System.err.println("Exception: " + e.getMessage());
        }
    }
}

