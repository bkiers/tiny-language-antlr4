package tl.antlr4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import tl.antlr4.TLParser.FunctionDeclContext;

public class SymbolVisitor extends TLBaseVisitor<TLValue> {
    Map<String, Function> functions;
    
    public SymbolVisitor(Map<String, Function> functions) {
        this.functions = functions;
    }
    
    @Override
    public TLValue visitFunctionDecl(FunctionDeclContext ctx) {
        List<TerminalNode> params = ctx.idList() != null ? ctx.idList().Identifier() : new ArrayList<TerminalNode>(); 
        ParseTree block = ctx.block();
        String id = ctx.Identifier().getText() + params.size();
        functions.put(id, new Function(params, block));
        return TLValue.VOID;
    }
}
