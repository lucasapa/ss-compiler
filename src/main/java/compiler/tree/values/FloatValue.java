package compiler.tree.values;

import compiler.tree.Node;
import compiler.tree.symbols.SymbolTable;
import compiler.tree.types.Type;
import org.antlr.runtime.Token;

import java.util.Stack;

public class FloatValue extends Node {
    public FloatValue(Token token) {
        super(token);
    }

    @Override
    public void execute (Stack<Object> stack) {
        stack.push(Float.parseFloat(getText()));
    }

    @Override
    public void analyze(SymbolTable symbolTable) {
    	setTypeDef(Type.FLOAT);
    }
}
