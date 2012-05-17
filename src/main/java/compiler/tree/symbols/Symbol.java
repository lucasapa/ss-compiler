package compiler.tree.symbols;

import compiler.tree.types.Type;

public class Symbol {
	
	
	private String name;
	private Type type;
	private Object value;
    private int idx;

    public Symbol(String name, Type type, int idx){
		this.name = name;
		this.type = type;
        this.idx = idx;
	}
	
    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public int getIdx() {
        return idx;
    }

    public Type getType() {
        return type;
    }
}
