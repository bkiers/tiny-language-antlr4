package tl.antlr4;

import org.antlr.v4.runtime.misc.NotNull;

public class EvalVisitor extends TLBaseVisitor<TLValue> {

    private Scope scope = new Scope();

    // '-' expression                           #unaryMinusExpression
    // TODO

    // '!' expression                           #notExpression
    // TODO

    // expression '^' expression                #powerExpression
    // TODO

    // expression '*' expression                #multiplyExpression
    // TODO

    // expression '/' expression                #divideExpression
    // TODO

    // expression '%' expression                #modulusExpression
    // TODO

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
    // TODO

    // expression '>=' expression               #gtEqExpression
    // TODO

    // expression '<=' expression               #ltEqExpression
    // TODO

    // expression '>' expression                #gtExpression
    // TODO

    // expression '<' expression                #ltExpression
    // TODO

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
    // TODO

    // expression '||' expression               #orExpression
    // TODO

    // expression '?' expression ':' expression #ternaryExpression
    // TODO

    // expression In expression                 #inExpression
    // TODO

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
    // TODO

    // Size '(' expression ')'      #sizeFunctionCall
    // TODO

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
