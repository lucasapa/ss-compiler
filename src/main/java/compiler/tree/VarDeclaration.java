package compiler.tree;

import java.util.Stack;

import org.antlr.runtime.Token;

import compiler.tree.symbols.Symbol;
import compiler.tree.symbols.SymbolTable;
import compiler.tree.types.Type;
import org.objectweb.asm.MethodVisitor;

public class VarDeclaration extends Node{

	public VarDeclaration(Token token) {
		super(token);
	}

	public void execute(Stack<Object> stack){
		getChild(1).execute(stack);

	}

	public void analyze(SymbolTable symbolTable){
		Type type = getChild(1).getTypeDef();
		String name = getChild(0).getText();
		symbolTable.declare(name,type);  
	}

	public void generateBytecode(MethodVisitor mv){
        	super.generateBytecode(mv);
    	}
	
}
