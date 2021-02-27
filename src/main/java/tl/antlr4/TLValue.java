package tl.antlr4;

import java.util.List;

public class TLValue implements Comparable<TLValue> {

    public static final TLValue NULL = new TLValue();
    public static final TLValue VOID = new TLValue();

    private Object value;

    private TLValue() {
        // private constructor: only used for NULL and VOID
        value = new Object();
    }

    private TLValue(Object v) {
        if(v == null) {
            throw new RuntimeException("v == null");
        }
        value = v;
    }

    TLValue(Boolean v) {
        this((Object)v);
    }

    TLValue(List<TLValue> v) {
        this((Object)v);
    }

    TLValue(Integer v) {
        this((Object)v);
    }

    TLValue(Double v) {
        this((Object)v);
    }

    TLValue(String v) {
        this((Object)v);
    }

    public Boolean asBoolean() {
        return (Boolean)value;
    }

    public double asDouble() {
        return ((Number)value).doubleValue();
    }

    public int asInt() {
        return ((Number)value).intValue();
    }

    @SuppressWarnings("unchecked")
    public List<TLValue> asList() {
        return (List<TLValue>)value;
    }

    public String asString() {
        return (String)value;
    }

    @Override
    public int compareTo(TLValue that) {
        Integer result = this.compare(that);
        if (result != null) {
            return result;
        }
        throw new RuntimeException("illegal expression: can't compare `" + this + "` to `" + that + "`");
    }

    Integer compare(TLValue that) {
        if(this.isInteger() && that.isInteger()) {
            if(this.asInt() == that.asInt()) {
                return 0;
            }
            else {
                return Integer.compare(this.asInt(), that.asInt());
            }
        }
        if(this.isNumber() && that.isNumber()) {
            if(this.equals(that)) {
                return 0;
            }
            else {
                return Double.compare(this.asDouble(), that.asDouble());
            }
        }
        else if(this.isString() && that.isString()) {
            return this.asString().compareTo(that.asString());
        }
        else {
            return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if(this == VOID || o == VOID) {
            throw new RuntimeException("can't use VOID: " + this + " ==/!= " + o);
        }
        if(this == o) {
            return true;
        }
        if(o == null || this.getClass() != o.getClass()) {
            return false;
        }
        TLValue that = (TLValue)o;
        return this.equals(that);
    }

    public boolean equals(TLValue that) {
        if(this.isInteger() && that.isInteger()) {
            return this.asInt() == that.asInt();
        }
        if(this.isNumber() && that.isNumber()) {
            double diff = Math.abs(this.asDouble() - that.asDouble());
            return diff < 0.00000000001;
        }
        else {
            return this.value.equals(that.value);
        }
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isBoolean() {
        return value instanceof Boolean;
    }

    public boolean isNumber() {
        return value instanceof Number;
    }

    public boolean isInteger() {
        return value instanceof Integer;
    }

    public boolean isList() {
        return value instanceof List<?>;
    }

    public boolean isNull() {
        return this == NULL;
    }

    public boolean isVoid() {
        return this == VOID;
    }

    public boolean isString() {
        return value instanceof String;
    }

    @Override
    public String toString() {
        return isNull() ? "NULL" : isVoid() ? "VOID" : String.valueOf(value);
    }
}
