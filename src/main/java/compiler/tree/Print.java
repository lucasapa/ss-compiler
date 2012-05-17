package compiler.tree;

import java.util.Stack;

import compiler.tree.types.Type;
import org.antlr.runtime.Token;

import compiler.tree.symbols.SymbolTable;
import org.objectweb.asm.MethodVisitor;

public class Print extends Node{

	public Print(Token token) {
		super(token);

	}
	
	public void execute(Stack<Object> stack){
		super.execute(stack);
		System.out.println(stack.pop());
		//FALTA
	}
    
	public void analyze(SymbolTable st){
		super.analyze(st);
		Type t1=getChild(0).getTypeDef();
		setTypeDef(t1);

   	}

	public void generateBytecode(MethodVisitor mv) {
		String type;
		switch (getTypeDef()){
		    case INTEGER:{
		        type="(I)V";
		    }break;
		    case STRING:{
		        type="(Ljava/lang/String;)V";
		    }  break;
		    case FLOAT:{
		        type="(F)V";
		    }break;
		    default:{
		        type="(Ljava/lang/Object;)V";
		    }
		}
		//FALTA !! PREGUNTAR
	}
	
}
