package tl.antlr4;

import org.antlr.v4.runtime.misc.NotNull;

import tl.antlr4.TLParser.AndExpressionContext;
import tl.antlr4.TLParser.AssertFunctionCallContext;
import tl.antlr4.TLParser.DivideExpressionContext;
import tl.antlr4.TLParser.GtEqExpressionContext;
import tl.antlr4.TLParser.GtExpressionContext;
import tl.antlr4.TLParser.InExpressionContext;
import tl.antlr4.TLParser.LtEqExpressionContext;
import tl.antlr4.TLParser.LtExpressionContext;
import tl.antlr4.TLParser.ModulusExpressionContext;
import tl.antlr4.TLParser.MultiplyExpressionContext;
import tl.antlr4.TLParser.NotExpressionContext;
import tl.antlr4.TLParser.OrExpressionContext;
import tl.antlr4.TLParser.PowerExpressionContext;
import tl.antlr4.TLParser.SizeFunctionCallContext;
import tl.antlr4.TLParser.SubtractExpressionContext;
import tl.antlr4.TLParser.TernaryExpressionContext;
import tl.antlr4.TLParser.UnaryMinusExpressionContext;

public class EvalVisitor extends TLBaseVisitor<TLValue> {

    private Scope scope = new Scope();

    // '-' expression                           #unaryMinusExpression
    @Override
    public TLValue visitUnaryMinusExpression(UnaryMinusExpressionContext ctx) {
    	TLValue v = this.visit(ctx.expression());
    	if (!v.isNumber()) {
            throw new RuntimeException("Illegal expression: -" + v);
        }
    	return new TLValue(-1 * v.asDouble());
    }

    // '!' expression                           #notExpression
    @Override
    public TLValue visitNotExpression(NotExpressionContext ctx) {
    	TLValue v = this.visit(ctx.expression());
    	if(!v.isBoolean()) {
            throw new RuntimeException("Illegal expression: !" + v);
        }
    	return new TLValue(!v.asBoolean());
    }

    // expression '^' expression                #powerExpression
    @Override
    public TLValue visitPowerExpression(PowerExpressionContext ctx) {
    	TLValue lhs = this.visit(ctx.expression(0));
    	TLValue rhs = this.visit(ctx.expression(1));
    	if (lhs.isNumber() && rhs.isNumber()) {
    		return new TLValue(Math.pow(lhs.asDouble(), rhs.asDouble()));
    	}
    	throw new RuntimeException("Illegal expression: " + lhs + "^" + rhs);
    }

    // expression '*' expression                #multiplyExpression
    @Override
    public TLValue visitMultiplyExpression(MultiplyExpressionContext ctx) {
    	TLValue lhs = this.visit(ctx.expression(0));
    	TLValue rhs = this.visit(ctx.expression(1));
    	if (lhs.isNumber() && rhs.isNumber()) {
    		return new TLValue(lhs.asDouble() * rhs.asDouble());
    	}
    	throw new RuntimeException("Illegal expression: " + lhs + "*" + rhs);
    }

    // expression '/' expression                #divideExpression
    @Override
    public TLValue visitDivideExpression(DivideExpressionContext ctx) {
    	TLValue lhs = this.visit(ctx.expression(0));
    	TLValue rhs = this.visit(ctx.expression(1));
    	if (lhs.isNumber() && rhs.isNumber()) {
    		return new TLValue(lhs.asDouble() / rhs.asDouble());
    	}
    	throw new RuntimeException("Illegal expression: " + lhs + "/" + rhs);
    }

    // expression '%' expression                #modulusExpression
	@Override
	public TLValue visitModulusExpression(ModulusExpressionContext ctx) {
		TLValue lhs = this.visit(ctx.expression(0));
    	TLValue rhs = this.visit(ctx.expression(1));
    	if (lhs.isNumber() && rhs.isNumber()) {
    		return new TLValue(lhs.asDouble() % rhs.asDouble());
    	}
    	throw new RuntimeException("Illegal expression: " + lhs + "%" + rhs);
	}
	
    // expression '+' expression                #addExpression
    @Override
    public TLValue visitAddExpression(@NotNull TLParser.AddExpressionContext ctx) {
        TLValue lhs = this.visit(ctx.expression(0));
        TLValue rhs = this.visit(ctx.expression(1));

        if(lhs.isNumber() && rhs.isNumber()) {
            return new TLValue(lhs.asDouble() + rhs.asDouble());
        }

        return new TLValue(lhs.toString() + rhs.toString());
    }

    // expression '-' expression                #subtractExpression
    @Override
    public TLValue visitSubtractExpression(SubtractExpressionContext ctx) {
    	TLValue lhs = this.visit(ctx.expression(0));
    	TLValue rhs = this.visit(ctx.expression(1));
    	if (lhs.isNumber() && rhs.isNumber()) {
    		return new TLValue(lhs.asDouble() - rhs.asDouble());
    	}
    	throw new RuntimeException("Illegal expression: " + lhs + "-" + rhs);
    }

    // expression '>=' expression               #gtEqExpression
    @Override
    public TLValue visitGtEqExpression(GtEqExpressionContext ctx) {
    	TLValue lhs = this.visit(ctx.expression(0));
    	TLValue rhs = this.visit(ctx.expression(1));
    	if (lhs.isNumber() && rhs.isNumber()) {
    		return new TLValue(lhs.asDouble() >= rhs.asDouble());
    	}
    	throw new RuntimeException("Illegal expression: " + lhs + ">=" + rhs);
    }

    // expression '<=' expression               #ltEqExpression
    @Override
    public TLValue visitLtEqExpression(LtEqExpressionContext ctx) {
    	TLValue lhs = this.visit(ctx.expression(0));
    	TLValue rhs = this.visit(ctx.expression(1));
    	if (lhs.isNumber() && rhs.isNumber()) {
    		return new TLValue(lhs.asDouble() <= rhs.asDouble());
    	}
    	throw new RuntimeException("Illegal expression: " + lhs + "<=" + rhs);
    }

    // expression '>' expression                #gtExpression
    @Override
    public TLValue visitGtExpression(GtExpressionContext ctx) {
    	TLValue lhs = this.visit(ctx.expression(0));
    	TLValue rhs = this.visit(ctx.expression(1));
    	if (lhs.isNumber() && rhs.isNumber()) {
    		return new TLValue(lhs.asDouble() > rhs.asDouble());
    	}
    	throw new RuntimeException("Illegal expression: " + lhs + ">" + rhs);
    }

    // expression '<' expression                #ltExpression
    @Override
    public TLValue visitLtExpression(LtExpressionContext ctx) {
    	TLValue lhs = this.visit(ctx.expression(0));
    	TLValue rhs = this.visit(ctx.expression(1));
    	if (lhs.isNumber() && rhs.isNumber()) {
    		return new TLValue(lhs.asDouble() < rhs.asDouble());
    	}
    	throw new RuntimeException("Illegal expression: " + lhs + "<" + rhs);
    }

    // expression '==' expression               #eqExpression
    @Override
    public TLValue visitEqExpression(@NotNull TLParser.EqExpressionContext ctx) {
        TLValue lhs = this.visit(ctx.expression(0));
        TLValue rhs = this.visit(ctx.expression(1));
        return new TLValue(lhs.equals(rhs));
    }

    // expression '!=' expression               #notEqExpression
    @Override
    public TLValue visitNotEqExpression(@NotNull TLParser.NotEqExpressionContext ctx) {
        TLValue lhs = this.visit(ctx.expression(0));
        TLValue rhs = this.visit(ctx.expression(1));
        return new TLValue(!lhs.equals(rhs));
    }

    // expression '&&' expression               #andExpression
    @Override
    public TLValue visitAndExpression(AndExpressionContext ctx) {
    	TLValue lhs = this.visit(ctx.expression(0));
    	TLValue rhs = this.visit(ctx.expression(1));
    	
    	if(!lhs.isBoolean() || !rhs.isBoolean()) {
            throw new RuntimeException("Illegal expression: " + lhs + "&&" +rhs);
        }
		return new TLValue(lhs.asBoolean() && rhs.asBoolean());
    }

    // expression '||' expression               #orExpression
    @Override
    public TLValue visitOrExpression(OrExpressionContext ctx) {
    	TLValue lhs = this.visit(ctx.expression(0));
    	TLValue rhs = this.visit(ctx.expression(1));
    	
    	if(!lhs.isBoolean() || !rhs.isBoolean()) {
            throw new RuntimeException("Illegal expression: " + lhs + "||" +rhs);
        }
		return new TLValue(lhs.asBoolean() || rhs.asBoolean());
    }

    // expression '?' expression ':' expression #ternaryExpression
    @Override
    public TLValue visitTernaryExpression(TernaryExpressionContext ctx) {
    	TLValue condition = this.visit(ctx.expression(0));
    	if (condition.asBoolean()) {
    		return new TLValue(this.visit(ctx.expression(1)));
    	} else {
    		return new TLValue(this.visit(ctx.expression(2)));
    	}
    }

    // expression In expression                 #inExpression
	@Override
	public TLValue visitInExpression(InExpressionContext ctx) {
		TLValue lhs = this.visit(ctx.expression(0));
    	TLValue rhs = this.visit(ctx.expression(1));
    	
    	if (rhs.isList()) {
    		for(TLValue val: rhs.asList()) {
    			if (val.equals(lhs)) {
    				return new TLValue(true);
    			}
    		}
    		return new TLValue(false);
    	}
    	throw new RuntimeException("Illegal expression: "+lhs+ " in "+rhs);
	}
	
    // Number                                   #numberExpression
    @Override
    public TLValue visitNumberExpression(@NotNull TLParser.NumberExpressionContext ctx) {
        return new TLValue(Double.valueOf(ctx.getText()));
    }

    // Bool                                     #boolExpression
    @Override
    public TLValue visitBoolExpression(@NotNull TLParser.BoolExpressionContext ctx) {
        return new TLValue(Boolean.valueOf(ctx.getText()));
    }

    // Null                                     #nullExpression
    @Override
    public TLValue visitNullExpression(@NotNull TLParser.NullExpressionContext ctx) {
        return TLValue.NULL;
    }

    // functionCall indexes?                    #functionCallExpression
    // TODO

    // list indexes?                            #listExpression
    // TODO

    // Identifier indexes?                      #identifierExpression
    @Override
    public TLValue visitIdentifierExpression(@NotNull TLParser.IdentifierExpressionContext ctx) {
        String id = ctx.Identifier().getText();
        // TODO account for optional `indexes` production
        return scope.resolve(id);
    }

    // String indexes?                          #stringExpression
    @Override
    public TLValue visitStringExpression(@NotNull TLParser.StringExpressionContext ctx) {
        String text = ctx.getText();
        String stripped = text.substring(1, text.length() - 1).replaceAll("\\\\(.)", "$1");
        // TODO account for optional `indexes` production
        return new TLValue(stripped);
    }

    // '(' expression ')' indexes?              #expressionExpression
    // TODO

    // Input '(' String? ')'                    #inputExpression
    // TODO

    @Override
    public TLValue visitAssignment(@NotNull TLParser.AssignmentContext ctx) {
        String id = ctx.Identifier().getText();
        // TODO account for optional `indexes` production
        TLValue value = this.visit(ctx.expression());
        scope.assign(id, value);
        return TLValue.VOID;
    }

    // Identifier '(' exprList? ')' #identifierFunctionCall
    // TODO

    // Println '(' expression? ')'  #printlnFunctionCall
    @Override
    public TLValue visitPrintlnFunctionCall(@NotNull TLParser.PrintlnFunctionCallContext ctx) {
        System.out.println(this.visit(ctx.expression()));
        return TLValue.VOID;
    }

    // Print '(' expression ')'     #printFunctionCall
    @Override
    public TLValue visitPrintFunctionCall(@NotNull TLParser.PrintFunctionCallContext ctx) {
        System.out.print(this.visit(ctx.expression()));
        return TLValue.VOID;
    }

    // Assert '(' expression ')'    #assertFunctionCall
    @Override
    public TLValue visitAssertFunctionCall(AssertFunctionCallContext ctx) {
    	TLValue value = this.visit(ctx.expression());

        if(!value.isBoolean()) {
            throw new RuntimeException("assert(...) only takes boolean expressions");
        }

        if(!value.asBoolean()) {
            throw new AssertionError(ctx.expression().toString());
        }

        return TLValue.VOID;
    }

    // Size '(' expression ')'      #sizeFunctionCall
    @Override
    public TLValue visitSizeFunctionCall(SizeFunctionCallContext ctx) {
    	TLValue value = this.visit(ctx.expression());

        if(value.isString()) {
            return new TLValue(value.asString().length());
        }

        if(value.isList()) {
            return new TLValue(value.asList().size());
        }

        throw new RuntimeException("Illegal function call: size("+ value +")");
    }

    // ifStatement
    //  : ifStat elseIfStat* elseStat? End
    //  ;
    //
    // ifStat
    //  : If expression Do block
    //  ;
    //
    // elseIfStat
    //  : Else If expression Do block
    //  ;
    //
    // elseStat
    //  : Else Do block
    //  ;
    @Override
    public TLValue visitIfStatement(@NotNull TLParser.IfStatementContext ctx) {

        // if ...
        if(this.visit(ctx.ifStat().expression()).asBoolean()) {
            return this.visit(ctx.ifStat().block());
        }

        // else if ...
        for(int i = 0; i < ctx.elseIfStat().size(); i++) {
            if(this.visit(ctx.elseIfStat(i).expression()).asBoolean()) {
                return this.visit(ctx.elseIfStat(i).block());
            }
        }

        // else ...
        if(ctx.elseStat() != null) {
            return this.visit(ctx.elseStat().block());
        }

        return TLValue.VOID;
    }
}
