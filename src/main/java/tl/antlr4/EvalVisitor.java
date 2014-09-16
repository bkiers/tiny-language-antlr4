package tl.antlr4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;

import tl.antlr4.TLParser.AndExpressionContext;
import tl.antlr4.TLParser.AssertFunctionCallContext;
import tl.antlr4.TLParser.BlockContext;
import tl.antlr4.TLParser.DivideExpressionContext;
import tl.antlr4.TLParser.ExpressionContext;
import tl.antlr4.TLParser.ExpressionExpressionContext;
import tl.antlr4.TLParser.ForStatementContext;
import tl.antlr4.TLParser.FunctionCallExpressionContext;
import tl.antlr4.TLParser.FunctionDeclContext;
import tl.antlr4.TLParser.GtEqExpressionContext;
import tl.antlr4.TLParser.GtExpressionContext;
import tl.antlr4.TLParser.IdentifierFunctionCallContext;
import tl.antlr4.TLParser.InExpressionContext;
import tl.antlr4.TLParser.ListContext;
import tl.antlr4.TLParser.ListExpressionContext;
import tl.antlr4.TLParser.LtEqExpressionContext;
import tl.antlr4.TLParser.LtExpressionContext;
import tl.antlr4.TLParser.ModulusExpressionContext;
import tl.antlr4.TLParser.MultiplyExpressionContext;
import tl.antlr4.TLParser.NotExpressionContext;
import tl.antlr4.TLParser.OrExpressionContext;
import tl.antlr4.TLParser.PowerExpressionContext;
import tl.antlr4.TLParser.SizeFunctionCallContext;
import tl.antlr4.TLParser.StatementContext;
import tl.antlr4.TLParser.SubtractExpressionContext;
import tl.antlr4.TLParser.TernaryExpressionContext;
import tl.antlr4.TLParser.UnaryMinusExpressionContext;
import tl.antlr4.TLParser.WhileStatementContext;

public class EvalVisitor extends TLBaseVisitor<TLValue> {
	private static ReturnValue returnValue = new ReturnValue();
    private Scope scope;
    private Map<String, Function> functions;
    
    public EvalVisitor(Scope scope, Map<String, Function> functions) {
        this.scope = scope;
        this.functions = functions;
    }

    // functionDecl
    @Override
    public TLValue visitFunctionDecl(FunctionDeclContext ctx) {
        return TLValue.VOID;
    }
    
    // list: '[' exprList? ']'
    @Override
    public TLValue visitList(ListContext ctx) {
        List<TLValue> list = new ArrayList<TLValue>();
        if (ctx.exprList() != null) {
	        for(ExpressionContext ex: ctx.exprList().expression()) {
	            list.add(this.visit(ex));
	        }
        }
        return new TLValue(list);
    }
    
    
    // '-' expression                           #unaryMinusExpression
    @Override
    public TLValue visitUnaryMinusExpression(UnaryMinusExpressionContext ctx) {
    	TLValue v = this.visit(ctx.expression());
    	if (!v.isNumber()) {
    	    throw new EvalException(ctx);
        }
    	return new TLValue(-1 * v.asDouble());
    }

    // '!' expression                           #notExpression
    @Override
    public TLValue visitNotExpression(NotExpressionContext ctx) {
    	TLValue v = this.visit(ctx.expression());
    	if(!v.isBoolean()) {
    	    throw new EvalException(ctx);
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
    	throw new EvalException(ctx);
    }

    // expression '*' expression                #multiplyExpression
    @Override
    public TLValue visitMultiplyExpression(MultiplyExpressionContext ctx) {
    	TLValue lhs = this.visit(ctx.expression(0));
    	TLValue rhs = this.visit(ctx.expression(1));
    	if(lhs == null || rhs == null) {
    		System.err.println("lhs "+ lhs+ " rhs "+rhs);
    	    throw new EvalException(ctx);
    	}
    	
    	// number * number
        if(lhs.isNumber() && rhs.isNumber()) {
            return new TLValue(lhs.asDouble() * rhs.asDouble());
        }

        // string * number
        if(lhs.isString() && rhs.isNumber()) {
            StringBuilder str = new StringBuilder();
            int stop = rhs.asDouble().intValue();
            for(int i = 0; i < stop; i++) {
                str.append(lhs.asString());
            }
            return new TLValue(str.toString());
        }

        // list * number
        if(lhs.isList() && rhs.isNumber()) {
            List<TLValue> total = new ArrayList<TLValue>();
            int stop = rhs.asDouble().intValue();
            for(int i = 0; i < stop; i++) {
                total.addAll(lhs.asList());
            }
            return new TLValue(total);
        }    	
    	throw new EvalException(ctx);
    }

    // expression '/' expression                #divideExpression
    @Override
    public TLValue visitDivideExpression(DivideExpressionContext ctx) {
    	TLValue lhs = this.visit(ctx.expression(0));
    	TLValue rhs = this.visit(ctx.expression(1));
    	if (lhs.isNumber() && rhs.isNumber()) {
    		return new TLValue(lhs.asDouble() / rhs.asDouble());
    	}
    	throw new EvalException(ctx);
    }

    // expression '%' expression                #modulusExpression
	@Override
	public TLValue visitModulusExpression(ModulusExpressionContext ctx) {
		TLValue lhs = this.visit(ctx.expression(0));
    	TLValue rhs = this.visit(ctx.expression(1));
    	if (lhs.isNumber() && rhs.isNumber()) {
    		return new TLValue(lhs.asDouble() % rhs.asDouble());
    	}
    	throw new EvalException(ctx);
	}
	
    // expression '+' expression                #addExpression
    @Override
    public TLValue visitAddExpression(@NotNull TLParser.AddExpressionContext ctx) {
        TLValue lhs = this.visit(ctx.expression(0));
        TLValue rhs = this.visit(ctx.expression(1));
        
        if(lhs == null || rhs == null) {
            throw new EvalException(ctx);
        }
        
        // number + number
        if(lhs.isNumber() && rhs.isNumber()) {
            return new TLValue(lhs.asDouble() + rhs.asDouble());
        }
        
        // list + any
        if(lhs.isList()) {
            List<TLValue> list = lhs.asList();
            list.add(rhs);
            return new TLValue(list);
        }

        // string + any
        if(lhs.isString()) {
            return new TLValue(lhs.asString() + "" + rhs.toString());
        }

        // any + string
        if(rhs.isString()) {
            return new TLValue(lhs.toString() + "" + rhs.asString());
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
    	if (lhs.isList()) {
            List<TLValue> list = lhs.asList();
            list.remove(rhs);
            return new TLValue(list);
        }
    	throw new EvalException(ctx);
    }

    // expression '>=' expression               #gtEqExpression
    @Override
    public TLValue visitGtEqExpression(GtEqExpressionContext ctx) {
    	TLValue lhs = this.visit(ctx.expression(0));
    	TLValue rhs = this.visit(ctx.expression(1));
    	if (lhs.isNumber() && rhs.isNumber()) {
    		return new TLValue(lhs.asDouble() >= rhs.asDouble());
    	}
    	if(lhs.isString() && rhs.isString()) {
            return new TLValue(lhs.asString().compareTo(rhs.asString()) >= 0);
        }
    	throw new EvalException(ctx);
    }

    // expression '<=' expression               #ltEqExpression
    @Override
    public TLValue visitLtEqExpression(LtEqExpressionContext ctx) {
    	TLValue lhs = this.visit(ctx.expression(0));
    	TLValue rhs = this.visit(ctx.expression(1));
    	if (lhs.isNumber() && rhs.isNumber()) {
    		return new TLValue(lhs.asDouble() <= rhs.asDouble());
    	}
    	if(lhs.isString() && rhs.isString()) {
            return new TLValue(lhs.asString().compareTo(rhs.asString()) <= 0);
        }
    	throw new EvalException(ctx);
    }

    // expression '>' expression                #gtExpression
    @Override
    public TLValue visitGtExpression(GtExpressionContext ctx) {
    	TLValue lhs = this.visit(ctx.expression(0));
    	TLValue rhs = this.visit(ctx.expression(1));
    	if (lhs.isNumber() && rhs.isNumber()) {
    		return new TLValue(lhs.asDouble() > rhs.asDouble());
    	}
    	if(lhs.isString() && rhs.isString()) {
            return new TLValue(lhs.asString().compareTo(rhs.asString()) > 0);
        }
    	throw new EvalException(ctx);
    }

    // expression '<' expression                #ltExpression
    @Override
    public TLValue visitLtExpression(LtExpressionContext ctx) {
    	TLValue lhs = this.visit(ctx.expression(0));
    	TLValue rhs = this.visit(ctx.expression(1));
    	if (lhs.isNumber() && rhs.isNumber()) {
    		return new TLValue(lhs.asDouble() < rhs.asDouble());
    	}
    	if(lhs.isString() && rhs.isString()) {
            return new TLValue(lhs.asString().compareTo(rhs.asString()) < 0);
        }
    	throw new EvalException(ctx);
    }

    // expression '==' expression               #eqExpression
    @Override
    public TLValue visitEqExpression(@NotNull TLParser.EqExpressionContext ctx) {
        TLValue lhs = this.visit(ctx.expression(0));
        TLValue rhs = this.visit(ctx.expression(1));
        if (lhs == null) {
        	throw new EvalException(ctx);
        }
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
    	    throw new EvalException(ctx);
        }
		return new TLValue(lhs.asBoolean() && rhs.asBoolean());
    }

    // expression '||' expression               #orExpression
    @Override
    public TLValue visitOrExpression(OrExpressionContext ctx) {
    	TLValue lhs = this.visit(ctx.expression(0));
    	TLValue rhs = this.visit(ctx.expression(1));
    	
    	if(!lhs.isBoolean() || !rhs.isBoolean()) {
    	    throw new EvalException(ctx);
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
    	throw new EvalException(ctx);
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

    private TLValue resolveIndexes(ParserRuleContext ctx, TLValue val, List<ExpressionContext> indexes) {
    	for (ExpressionContext ec: indexes) {
    		TLValue idx = this.visit(ec);
    		if (!idx.isNumber() || (!val.isList() && !val.isString()) ) {
        		throw new EvalException("Problem resolving indexes on "+val+" at "+idx, ec);
    		}
    		int i = idx.asDouble().intValue();
    		if (val.isString()) {
    			val = new TLValue(val.asString().substring(i, i+1));
    		} else {
    			val = val.asList().get(i);
    		}
    	}
    	return val;
    }
    
    private void setAtIndex(ParserRuleContext ctx, List<ExpressionContext> indexes, TLValue val, TLValue newVal) {
    	if (!val.isList()) {
    		throw new EvalException(ctx);
    	}
    	// TODO some more list size checking in here
    	for (int i = 0; i < indexes.size() - 1; i++) {
    		TLValue idx = this.visit(indexes.get(i));
    		if (!idx.isNumber()) {
        		throw new EvalException(ctx);
    		}
    		val = val.asList().get(idx.asDouble().intValue());
    	}
    	TLValue idx = this.visit(indexes.get(indexes.size() - 1));
		if (!idx.isNumber()) {
    		throw new EvalException(ctx);
		}
    	val.asList().set(idx.asDouble().intValue(), newVal);
    }
    
    // functionCall indexes?                    #functionCallExpression
    @Override
    public TLValue visitFunctionCallExpression(FunctionCallExpressionContext ctx) {
    	TLValue val = this.visit(ctx.functionCall());
    	if (ctx.indexes() != null) {
        	List<ExpressionContext> exps = ctx.indexes().expression();
        	val = resolveIndexes(ctx, val, exps);
        }
    	return val;
    }

    // list indexes?                            #listExpression
    @Override
    public TLValue visitListExpression(ListExpressionContext ctx) {
    	TLValue val = this.visit(ctx.list());
    	if (ctx.indexes() != null) {
        	List<ExpressionContext> exps = ctx.indexes().expression();
        	val = resolveIndexes(ctx, val, exps);
        }
    	return val;
    }

    // Identifier indexes?                      #identifierExpression
    @Override
    public TLValue visitIdentifierExpression(@NotNull TLParser.IdentifierExpressionContext ctx) {
        String id = ctx.Identifier().getText();
        TLValue val = scope.resolve(id);
        
        if (ctx.indexes() != null) {
        	List<ExpressionContext> exps = ctx.indexes().expression();
        	val = resolveIndexes(ctx, val, exps);
        }
        return val;
    }

    // String indexes?                          #stringExpression
    @Override
    public TLValue visitStringExpression(@NotNull TLParser.StringExpressionContext ctx) {
        String text = ctx.getText();
        text = text.substring(1, text.length() - 1).replaceAll("\\\\(.)", "$1");
        TLValue val = new TLValue(text);
        if (ctx.indexes() != null) {
        	List<ExpressionContext> exps = ctx.indexes().expression();
        	val = resolveIndexes(ctx, val, exps);
        }
        return val;
    }

    // '(' expression ')' indexes?              #expressionExpression
    @Override
    public TLValue visitExpressionExpression(ExpressionExpressionContext ctx) {
        TLValue val = this.visit(ctx.expression());
        if (ctx.indexes() != null) {
        	List<ExpressionContext> exps = ctx.indexes().expression();
        	val = resolveIndexes(ctx, val, exps);
        }
        return val;
    }

    // Input '(' String? ')'                    #inputExpression
    // TODO

    
    // assignment
    // : Identifier indexes? '=' expression
    // ;
    @Override
    public TLValue visitAssignment(@NotNull TLParser.AssignmentContext ctx) {
        TLValue newVal = this.visit(ctx.expression());
        if (ctx.indexes() != null) {
        	TLValue val = scope.resolve(ctx.Identifier().getText());
        	List<ExpressionContext> exps = ctx.indexes().expression();
        	setAtIndex(ctx, exps, val, newVal);
        } else {
        	String id = ctx.Identifier().getText();        	
        	scope.assign(id, newVal);
        }
        return TLValue.VOID;
    }

    // Identifier '(' exprList? ')' #identifierFunctionCall
    @Override
    public TLValue visitIdentifierFunctionCall(IdentifierFunctionCallContext ctx) {
        List<ExpressionContext> params = ctx.exprList() != null ? ctx.exprList().expression() : new ArrayList<ExpressionContext>();
        String id = ctx.Identifier().getText() + params.size();
        Function function;      
        if ((function = functions.get(id)) != null) {
            return function.invoke(params, functions, scope.copy());
        }
        throw new EvalException(ctx);
    }

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
            throw new EvalException(ctx);
        }

        if(!value.asBoolean()) {
            throw new AssertionError("Failed Assertion "+ctx.expression().getText()+" line:"+ctx.start.getLine());
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

        throw new EvalException(ctx);
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
    
    // block
    // : (statement | functionDecl)* (Return expression Newline)?
    // ;
    @Override
    public TLValue visitBlock(BlockContext ctx) {
        scope = new Scope(scope); // create new local scope
        for (StatementContext sx: ctx.statement()) {
            this.visit(sx);
        }
        ExpressionContext ex;
        if ((ex = ctx.expression()) != null) {
        	returnValue.value = this.visit(ex);
        	scope = scope.parent();
        	throw returnValue;
        }
        scope = scope.parent();
        return TLValue.VOID;
    }
    
    // forStatement
    // : For Identifier '=' expression To expression OBrace block CBrace
    // ;
    @Override
    public TLValue visitForStatement(ForStatementContext ctx) {
        int start = this.visit(ctx.expression(0)).asDouble().intValue();
        int stop = this.visit(ctx.expression(1)).asDouble().intValue();
        for(int i = start; i <= stop; i++) {
            scope.assign(ctx.Identifier().getText(), new TLValue(i));
            TLValue returnValue = this.visit(ctx.block());
            if(returnValue != TLValue.VOID) {
                return returnValue;
            }
        }
        return TLValue.VOID;
    }
    
    // whileStatement
    // : While expression OBrace block CBrace
    // ;
    @Override
    public TLValue visitWhileStatement(WhileStatementContext ctx) {
        while( this.visit(ctx.expression()).asBoolean() ) {
            TLValue returnValue = this.visit(ctx.block());
            if (returnValue != TLValue.VOID) {
                return returnValue;
            }
        }
        return TLValue.VOID;
    }
    
}
