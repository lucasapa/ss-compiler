package compiler.tree;

import java.util.Stack;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.objectweb.asm.MethodVisitor;
import compiler.tree.symbols.SymbolTable;
import compiler.tree.types.Type;


public class Node extends CommonTree {
	
	Type type;
	
	public Node(Token token) {
		super(token);
	}
    
	public Node getChild(int i) {
		return (Node) super.getChild(i);
	}

	public void toString(StringBuilder builder, String indent) {
		builder.append(indent);
		builder.append(getClass().getSimpleName());
		builder.append("<").append(getText()).append(">");
		builder.append('\n');

		int count = getChildCount();
		for (int i = 0; i < count; i++) {
		    getChild(i).toString(builder, indent + "   ");
		}
	}
    

	public String toString() {
		StringBuilder builder = new StringBuilder();
		toString(builder, "");

		return builder.toString();
	}
    
	public void execute(Stack<Object> stack){
		int count = getChildCount();
		for(int i=0;i<count;i++){
			getChild(i).execute(stack);
		}
	}
    
	public void analyze(SymbolTable symbolTable){
		int count = getChildCount();
		for(int i=0; i<count; i++){
		    getChild(i).analyze(symbolTable);

		}
	}

	public void generateBytecode(MethodVisitor mv) {
		int count = getChildCount();
		for (int i = 0; i < count; i++) {
		    getChild(i).generateBytecode(mv);
		}
    	}
    
	public void setTypeDef(Type type) {
		this.type = type;
	}
    
	public Type getTypeDef() {
		return type;
	}

	public void reportError(String error) {
		System.out.println(error);
		throw new RuntimeException();
	}
        
}
