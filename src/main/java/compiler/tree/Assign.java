package compiler.tree;

import java.util.Stack;

import compiler.tree.types.Type;
import org.antlr.runtime.Token;

import compiler.tree.symbols.Symbol;
import compiler.tree.symbols.SymbolTable;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class Assign extends Node{

	
	private Symbol symbol = null;
	
	public Assign(Token token) {
		super(token);
	}
	
	public void analyze(SymbolTable st) {
		super.analyze(st);
		Id variableNode = (Id) getChild(0);
		symbol = st.lookup(variableNode.getText());
		setTypeDef(getChild(1).getTypeDef());
	}
	
	public void execute(Stack<Object> stack) {
		getChild(1).execute(stack);
        	symbol.setValue(stack.pop());
	}

	public void generateBytecode(MethodVisitor mv){
		super.generateBytecode(mv);
		if (getTypeDef().equals(Type.INTEGER)) {
		    mv.visitVarInsn(Opcodes.ISTORE, symbol.getIdx());
		}if(getTypeDef().equals(Type.STRING)){
		    mv.visitVarInsn(Opcodes.ASTORE, symbol.getIdx());
		}
    	}

}
