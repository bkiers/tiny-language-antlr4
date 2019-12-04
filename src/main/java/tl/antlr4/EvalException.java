package tl.antlr4;

import org.antlr.v4.runtime.ParserRuleContext;

public class EvalException extends RuntimeException {
    public EvalException(ParserRuleContext context) {
        this("Illegal expression: " + context.getText(), context);
    }
    
    public EvalException(String msg, ParserRuleContext context) {
        super(msg + " line:" + context.start.getLine());
    }
}
