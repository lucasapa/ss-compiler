package compiler.tree.arithmetic;

import java.util.Stack;
import compiler.tree.Node;
import compiler.tree.symbols.SymbolTable;
import compiler.tree.types.Type;
import org.antlr.runtime.Token;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class Add extends Node{

	public Add(Token token)  {
		super(token);
	}
	
	public void execute(Stack<Object> stack){
		super.execute(stack);
		if(getTypeDef().equals(Type.INTEGER)){
		    Number int1 = (Number) stack.pop();
		    Number int2 = (Number) stack.pop();
		    stack.push(int1.intValue() + int2.intValue());
		}else if(getTypeDef().equals(Type.FLOAT)){
		    Number float1 = (Number) stack.pop();
		    Number float2 = (Number) stack.pop();
		    stack.push(float1.floatValue() + float2.floatValue());
		}else if (getTypeDef().equals(Type.STRING)){
		    String string1 = stack.pop().toString();
		    String string2 = stack.pop().toString();
		    stack.push(string2 + string1);
		}
	}

	public void analyze (SymbolTable st){//deberia ir un   SymbolTable st
		super.analyze(st);
		Type resultType;
		Type t1=getChild(0).getTypeDef();
		Type t2=getChild(1).getTypeDef();
		resultType = Type.promotion(t1, t2);
		setTypeDef(resultType);
	}
	
    	public void generateBytecode(MethodVisitor mv){
		Type t1=getChild(0).getTypeDef();
		Type t2=getChild(1).getTypeDef();
		if (getTypeDef().equals(Type.INTEGER)) {
		    super.generateBytecode(mv);
		    mv.visitInsn(Opcodes.IADD);
		}
		//FALTA !!!!!!!
	}

}
