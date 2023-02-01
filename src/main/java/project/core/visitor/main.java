package project.core.visitor;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;


import project.parsers.XPathGrammarLexer;
import project.parsers.XPathGrammarParser;
//import project.parsers.XPathGrammarVisitor;


public class main {
    public static void evaluator(String[] args) {
        try {
            // Generate tree and visitor
            final String expression = "doc('j_caesar.xml')//PERSONA";
            XPathGrammarLexer lexer = new XPathGrammarLexer(CharStreams.fromString(expression));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            XPathGrammarParser parser = new XPathGrammarParser(tokens);
            parser.removeErrorListeners();
            ParseTree tree = parser.ap();
            System.err.println(tree);

            // Visit the tree
            // below needs implementation in the expressiongrammarvisitor class
            //ExpressionGrammarVisitor visitor = new ExpressionGrammarVisitor();
        
            // visitor.visit(tree);
        } catch(Exception e) {  
            System.err.println("Exception: " + e.getMessage());
        }
    }
}

