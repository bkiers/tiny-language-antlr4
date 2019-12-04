// Generated from /Users/yosimycortes/Documents/code/CMPE152/Project4/tiny-language-antlr4/src/main/antlr4/tl/antlr4/TL.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TLParser}.
 */
public interface TLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TLParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(TLParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(TLParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(TLParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(TLParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(TLParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(TLParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(TLParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(TLParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierFunctionCall}
	 * labeled alternative in {@link TLParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierFunctionCall(TLParser.IdentifierFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierFunctionCall}
	 * labeled alternative in {@link TLParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierFunctionCall(TLParser.IdentifierFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printlnFunctionCall}
	 * labeled alternative in {@link TLParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterPrintlnFunctionCall(TLParser.PrintlnFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printlnFunctionCall}
	 * labeled alternative in {@link TLParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitPrintlnFunctionCall(TLParser.PrintlnFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printFunctionCall}
	 * labeled alternative in {@link TLParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterPrintFunctionCall(TLParser.PrintFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printFunctionCall}
	 * labeled alternative in {@link TLParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitPrintFunctionCall(TLParser.PrintFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assertFunctionCall}
	 * labeled alternative in {@link TLParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterAssertFunctionCall(TLParser.AssertFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assertFunctionCall}
	 * labeled alternative in {@link TLParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitAssertFunctionCall(TLParser.AssertFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sizeFunctionCall}
	 * labeled alternative in {@link TLParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterSizeFunctionCall(TLParser.SizeFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sizeFunctionCall}
	 * labeled alternative in {@link TLParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitSizeFunctionCall(TLParser.SizeFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(TLParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(TLParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(TLParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(TLParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLParser#elseIfStat}.
	 * @param ctx the parse tree
	 */
	void enterElseIfStat(TLParser.ElseIfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLParser#elseIfStat}.
	 * @param ctx the parse tree
	 */
	void exitElseIfStat(TLParser.ElseIfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLParser#elseStat}.
	 * @param ctx the parse tree
	 */
	void enterElseStat(TLParser.ElseStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLParser#elseStat}.
	 * @param ctx the parse tree
	 */
	void exitElseStat(TLParser.ElseStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(TLParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(TLParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(TLParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(TLParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(TLParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(TLParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLParser#idList}.
	 * @param ctx the parse tree
	 */
	void enterIdList(TLParser.IdListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLParser#idList}.
	 * @param ctx the parse tree
	 */
	void exitIdList(TLParser.IdListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(TLParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(TLParser.ExprListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpression(TLParser.BoolExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpression(TLParser.BoolExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpression(TLParser.NumberExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpression(TLParser.NumberExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpression(TLParser.IdentifierExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpression(TLParser.IdentifierExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(TLParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(TLParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(TLParser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(TLParser.OrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryMinusExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinusExpression(TLParser.UnaryMinusExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryMinusExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinusExpression(TLParser.UnaryMinusExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code powerExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPowerExpression(TLParser.PowerExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code powerExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPowerExpression(TLParser.PowerExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqExpression(TLParser.EqExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqExpression(TLParser.EqExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(TLParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(TLParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInExpression(TLParser.InExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInExpression(TLParser.InExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStringExpression(TLParser.StringExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStringExpression(TLParser.StringExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionExpression(TLParser.ExpressionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionExpression(TLParser.ExpressionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddExpression(TLParser.AddExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddExpression(TLParser.AddExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCompExpression(TLParser.CompExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCompExpression(TLParser.CompExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNullExpression(TLParser.NullExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNullExpression(TLParser.NullExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpression(TLParser.FunctionCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpression(TLParser.FunctionCallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultExpression(TLParser.MultExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultExpression(TLParser.MultExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterListExpression(TLParser.ListExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitListExpression(TLParser.ListExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ternaryExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTernaryExpression(TLParser.TernaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ternaryExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTernaryExpression(TLParser.TernaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inputExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInputExpression(TLParser.InputExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inputExpression}
	 * labeled alternative in {@link TLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInputExpression(TLParser.InputExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(TLParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(TLParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLParser#indexes}.
	 * @param ctx the parse tree
	 */
	void enterIndexes(TLParser.IndexesContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLParser#indexes}.
	 * @param ctx the parse tree
	 */
	void exitIndexes(TLParser.IndexesContext ctx);
}