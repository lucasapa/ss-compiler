package compiler.tree.arithmetic;

import java.util.Stack;
import compiler.tree.Node;
import compiler.tree.symbols.SymbolTable;
import compiler.tree.types.Type;
import org.antlr.runtime.Token;


public class Div extends Node {

	public Div(Token token) {
		super(token);
	}
	
	public void execute(Stack<Object> stack){
		super.execute(stack);
		Number i2 = (Number) stack.pop();
		Number i1 = (Number) stack.pop();
		switch (getTypeDef()){
             		case INTEGER:
                 		stack.push(i1.intValue() / i2.intValue());
                 		break;
             		default:
                 		stack.push(i1.floatValue() / i2.floatValue());
	    }
    }
	
	public void analyze (SymbolTable st){
		super.analyze(st);
		Type t1 = getChild(0).getTypeDef();
		Type t2 = getChild(1).getTypeDef();
		Type resultType = Type.promotion(t1, t2);
		setTypeDef(resultType);
	}

}
