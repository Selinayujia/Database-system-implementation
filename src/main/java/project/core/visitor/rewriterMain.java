package project.core.visitor;

import java.io.FileWriter;
import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import project.parsers.XQueryGrammarLexer;
import project.parsers.XQueryGrammarParser;
import project.parsers.XqueryRewriter;

public class rewriterMain {
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


          // rewrite to string
          XqueryRewriter visitor = new XqueryRewriter();
          String rewriteOutput = visitor.visit(tree);
          rewriteOutput  = "<result>" + rewriteOutput + "</result>";
          try {
              FileWriter writer = new FileWriter("newQuery.txt");
              //FileWriter writer = new FileWriter(args[1]);
              writer.write(rewriteOutput);
              writer.close();
          } catch (IOException e) {
              System.out.println("An error occurred.");
              e.printStackTrace(); 
          }
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace(); 
        }
     
    }
    
}
