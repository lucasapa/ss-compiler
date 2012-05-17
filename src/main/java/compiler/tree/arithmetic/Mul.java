package compiler.tree.arithmetic;

import java.util.Stack;

import compiler.tree.symbols.SymbolTable;
import compiler.tree.types.Type;
import org.antlr.runtime.Token;
import compiler.tree.Node;

public class Mul extends Node {

	public Mul(Token token) {
		super(token);
	}
	
	public void analyze (SymbolTable st){
        	super.analyze(st);
		Type t1 = getChild(0).getTypeDef();
		Type t2 = getChild(1).getTypeDef();
		Type resultType = Type.promotion(t1, t2);
		setTypeDef(resultType);
    	}

	public void execute(Stack<Object> stack){
		super.execute(stack);
		Number n2 = (Number) stack.pop();
        	Number n1 = (Number) stack.pop();
		switch (getTypeDef()){
            		case INTEGER:
                		stack.push(n1.intValue() * n2.intValue());
                		break;
            		default:
                		stack.push(n1.floatValue() * n2.floatValue());
        	}
	}
	
	

}
