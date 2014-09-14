package tl.antlr4;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {
    public static void main(String[] args) throws Exception {
        TLLexer lexer = new TLLexer(new ANTLRFileStream("src/main/tl/test.tl"));
        TLParser parser = new TLParser(new CommonTokenStream(lexer));
        parser.setBuildParseTree(true);
        ParseTree tree = parser.parse();
        
        
        EvalVisitor visitor = new EvalVisitor();
        visitor.visit(tree);
    }
}
