package tl.antlr4;

import java.util.HashMap;
import java.util.Map;

public class Scope {

    private Scope parent;
    private Map<String, TLValue> variables;

    Scope() {
        this(null);
    }

    Scope(Scope p) {
        parent = p;
        variables = new HashMap<>();
    }
    
    public void assignParam(String var, TLValue val) {
    	variables.put(var, val);
    }
    
    public void assign(String var, TLValue val) {
        if(resolve(var) != null) {
            this.reAssign(var, val);
        }
        else {
            variables.put(var, val);
        }
    }

    private boolean isGlobalScope() {
        return parent == null;
    }

    public Scope parent() {
        return parent;
    }

    private void reAssign(String identifier, TLValue val) {
        if(variables.containsKey(identifier)) {
            variables.put(identifier, val);
        }
        else if(parent != null) {
            parent.reAssign(identifier, val);
        }
    }

    public TLValue resolve(String var) {
        TLValue val = variables.get(var);
        if(val != null) {
            return val;
        }
        else if(!isGlobalScope()) {
            return parent.resolve(var);
        }
        else {
            return null;
        }
    }
    
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	for(Map.Entry<String,TLValue> var: variables.entrySet()) {
    		sb.append(var.getKey()).append("->").append(var.getValue()).append(",");
    	}
    	return sb.toString();
    }
}
