package tl.antlr4;

import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import tl.antlr4.TLParser.ExpressionContext;

public class Function {
    private List<TerminalNode> params;
    private ParseTree block;
    private Scope scope;

    public Function(List<TerminalNode> params, ParseTree block) {
        this.params = params;
        this.block = block;
        scope = new Scope();
    }
    
    public Function(Function f) {
        this.params = f.params;
        this.block = f.block;
        this.scope = f.scope.copy();
    }
    
    public TLValue invoke(List<ExpressionContext> params, Map<String, Function> functions) {
        if (params.size() != this.params.size()) {
            throw new RuntimeException("Illegal Function call");
        }
        EvalVisitor evalVisitor = new EvalVisitor(scope, functions);
        for (int i = 0; i < this.params.size(); i++) {
            TLValue value = evalVisitor.visit(params.get(i));
            scope.assign(this.params.get(i).getText(), value);
        }
        return evalVisitor.visit(this.block);
    }
}
