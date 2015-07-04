package tl.antlr4;

import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import tl.antlr4.TLParser.ExpressionContext;

public class Function {
	private String id;
    private List<TerminalNode> params;
    private ParseTree block;

    public Function(String id, List<TerminalNode> params, ParseTree block) {
    	this.id = id;
        this.params = params;
        this.block = block;
    }
    
    public TLValue invoke(List<ExpressionContext> params, Map<String, Function> functions, Scope scope) {
        if (params.size() != this.params.size()) {
            throw new RuntimeException("Illegal Function call");
        }
        scope = new Scope(scope); // create function scope
        EvalVisitor evalVisitor = new EvalVisitor(scope, functions); 
        for (int i = 0; i < this.params.size(); i++) {
            TLValue value = evalVisitor.visit(params.get(i));
            scope.assignParam(this.params.get(i).getText(), value);
        }
        TLValue ret = TLValue.VOID;
        try {
        	evalVisitor.visit(this.block);
        } catch (ReturnValue returnValue) {
        	ret = returnValue.value;
        }
        return ret;
    }
}
