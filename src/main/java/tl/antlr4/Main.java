package tl.antlr4;

import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {
    public static void main(String[] args) {
        try {
//            TLLexer lexer = new TLLexer(CharStreams.fromFileName("src/main/tl/test.tl"));
//            TLLexer lexer = new TLLexer(CharStreams.fromFileName("src/main/tl/test2.tl"));
            TLLexer lexer = new TLLexer(CharStreams.fromFileName("src/main/tl/test3.tl"));
            TLParser parser = new TLParser(new CommonTokenStream(lexer));
            parser.setBuildParseTree(true);
            ParseTree parse_tree = parser.parse();
            
            Scope scope = new Scope();
            Map<String, Function> func = new HashMap<>();
            SymbolVisitor symbolVisitor = new SymbolVisitor(func);
            symbolVisitor.visit(parse_tree);
            EvalVisitor visitor = new EvalVisitor(scope, func);
            visitor.visit(parse_tree);
        } catch (Exception e) {
            if (e.getMessage() != null) {
                System.err.println(e.getMessage());
            } else {
                e.printStackTrace();
            }
        }
    }
}
