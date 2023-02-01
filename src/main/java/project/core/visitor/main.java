package project.core.visitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;


import project.parsers.XPathGrammarLexer;
import project.parsers.XPathGrammarParser;
//import project.parsers.XPathGrammarVisitor;


public class main {
    public static void main(String[] args) {
        try {
            // Generate tree and visitor
            CharStream ANTLRInput = CharStreams.fromFileName("test_files/j_caesar.xml");
            XPathGrammarLexer lexer = new XPathGrammarLexer(ANTLRInput);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            XPathGrammarParser parser = new XPathGrammarParser(tokens);
            parser.removeErrorListeners();
            ParseTree tree = parser.ap();
            System.err.println(tree);

            // Visit the tree
            // below needs implementation in the xpathgrammarvisitor class
            //XPathGrammarVisitor visitor = new XPathGrammarVisitor();
        
            // visitor.visit(tree);

            //parse the result back to a tree
        } catch(Exception e) {  
            System.err.println("Exception: " + e.getMessage());
        }
    }
}

