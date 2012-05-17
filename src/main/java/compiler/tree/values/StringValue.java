package compiler.tree.values;

import compiler.tree.Node;
import compiler.tree.symbols.SymbolTable;
import compiler.tree.types.Type;
import org.antlr.runtime.Token;
import org.objectweb.asm.MethodVisitor;

import java.util.Stack;

public class StringValue extends Node {

    public StringValue(Token token) {
        super(token);
    }

    public void execute(Stack<Object> stack){
        stack.push(getText());
    }

    public void analyze (SymbolTable st){
        super.setTypeDef(Type.STRING);
    }

    public void generateBytecode(MethodVisitor mv) {
        super.generateBytecode(mv);
        mv.visitLdcInsn(getText());
    }
}
