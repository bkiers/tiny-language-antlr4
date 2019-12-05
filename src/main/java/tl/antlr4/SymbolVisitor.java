package tl.antlr4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import tl.antlr4.TLParser.FunctionDeclContext;

public class SymbolVisitor extends TLBaseVisitor<TLValue> {

    private Map<String, Function> functs;
    
    SymbolVisitor(Map<String, Function> functions) {
        this.functs = functions;
    }
    
    @Override
    public TLValue visitFunctionDecl(FunctionDeclContext context) {
        List<TerminalNode> params = context.idList() != null ? context.idList().Identifier() : new ArrayList<TerminalNode>();
        ParseTree block = context.block();
        String id = context.Identifier().getText() + params.size();
        functs.put(id, new Function(params, block));
        return TLValue.VOID;
    }
}
