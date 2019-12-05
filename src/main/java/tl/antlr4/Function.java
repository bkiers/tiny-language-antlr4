package tl.antlr4;

import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import tl.antlr4.TLParser.ExpressionContext;

public class Function {

    private List<TerminalNode> params;
    private ParseTree block;

    Function(List<TerminalNode> params, ParseTree block) {
        this.params = params;
        this.block = block;
    }
    
    public TLValue invoke(List<ExpressionContext> params, Map<String, Function> func, Scope scope) {
        if (params.size() != this.params.size()) {
            throw new RuntimeException("Illegal Function call");
        }
        Scope scopeNext = new Scope(null);

        EvalVisitor evalVisitor = new EvalVisitor(scope, func);
        for (int i = 0; i < this.params.size(); i++) {
            TLValue value = evalVisitor.visit(params.get(i));
            scopeNext.assignParam(this.params.get(i).getText(), value);
        }
        EvalVisitor evalVisitorNext = new EvalVisitor(scopeNext,func);
        
        TLValue ret = TLValue.VOID;
        try {
        	evalVisitorNext.visit(this.block);
        } catch (ReturnValue returnValue) {
        	ret = returnValue.value;
        }
        return ret;
    }
}
