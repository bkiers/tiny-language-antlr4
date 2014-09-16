package tl.antlr4;

import java.util.HashMap;
import java.util.Map;

public class Scope {

    private Scope parent;
    private Map<String, TLValue> variables;

    public Scope() {
        // only for the global scope, the parent is null
        this(null);
    }

    public Scope(Scope p) {
        parent = p;
        variables = new HashMap<String, TLValue>();
    }

    public void assign(String var, TLValue value) {
        if(resolve(var) != null) {
            // There is already such a variable, re-assign it
            this.reAssign(var, value);
        }
        else {
            // A newly declared variable
            variables.put(var, value);
        }
    }

    public Scope copy() {
        // Create a shallow copy of this scope. Used in case functions are
        // are recursively called. If we wouldn't create a copy in such cases,
        // changing the variables would result in changes ro the Maps from
        // other "recursive scopes".
        Scope s = new Scope();
        s.variables = new HashMap<String, TLValue>(this.variables);
        s.parent = this.parent;
        return s;
    }

    public boolean isGlobalScope() {
        return parent == null;
    }

    public Scope parent() {
        return parent;
    }

    private void reAssign(String identifier, TLValue value) {
        if(variables.containsKey(identifier)) {
            // The variable is declared in this scope
            variables.put(identifier, value);
        }
        else if(parent != null) {
            // The variable was not declared in this scope, so let
            // the parent scope re-assign it
            parent.reAssign(identifier, value);
        }
    }

    public TLValue resolve(String var) {
        TLValue value = variables.get(var);
        if(value != null) {
            // The variable resides in this scope
            return value;
        }
        else if(!isGlobalScope()) {
            // Let the parent scope look for the variable
            return parent.resolve(var);
        }
        else {
            // Unknown variable
            return null;
        }
    }
    
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	for(Map.Entry<String,TLValue> var: variables.entrySet()) {
    		sb.append(var.getKey()+"->"+var.getValue()+",");
    	}
    	return sb.toString();
    }
}
