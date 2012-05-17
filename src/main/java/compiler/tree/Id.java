package compiler.tree;

import compiler.tree.Node;
import compiler.tree.symbols.Symbol;
import compiler.tree.symbols.SymbolTable;
import compiler.tree.types.Type;
import org.antlr.runtime.Token;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Stack;

public class Id extends Node{

    private Symbol symbol;

    public Id(Token token) {
        super(token);
    }

    public void execute(Stack<Object> stack){
        stack.push(symbol.getValue());
    }

    public void analyze(SymbolTable st){
        symbol = st.lookup(getText());
        setTypeDef(symbol.getType());
    }


    public void generateBytecode(MethodVisitor mv){
        super.generateBytecode(mv);
        if (getTypeDef().equals(Type.INTEGER)) {
            mv.visitVarInsn(Opcodes.ILOAD, symbol.getIdx());
        }if(getTypeDef().equals(Type.STRING)){
            mv.visitVarInsn(Opcodes.ALOAD, symbol.getIdx());
        }
    }
}
