package tl.antlr4;

import org.antlr.v4.runtime.ParserRuleContext;

public class EvalException extends RuntimeException {
    public EvalException(ParserRuleContext ctx) {
        super("Illegal expression: "+ctx.getText()+" line:"+ctx.start.getLine());
    }
}
