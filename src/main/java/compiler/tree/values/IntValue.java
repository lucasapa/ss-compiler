package compiler.tree.values;

import java.util.Stack;

import compiler.tree.Node;
import compiler.tree.types.Type;

import org.antlr.runtime.Token;

public class IntValue extends Node {

	public IntValue(Token token) {
		super(token);
	}
	
	public void execute(Stack<Object> stack){
		stack.push(Integer.parseInt(getText()));
	}
	
	void analize(){
		setTypeDef(Type.INTEGER);
	}

}
