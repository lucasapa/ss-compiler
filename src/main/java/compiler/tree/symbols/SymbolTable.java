package compiler.tree.symbols;

import java.util.HashMap;
import java.util.Map;

import compiler.tree.types.Type;

public class SymbolTable {
	
	Map<String,Symbol> map;
    private int idx;

	public SymbolTable (){
		 map = new HashMap<String, Symbol>();
	}
	
	public Symbol lookup(String name){
		return map.get(name);
	}
	
	public void declare(String name, Type type){
		map.put(name, new Symbol(name,type,idx));
        idx++;
	}
	
	
	
}
