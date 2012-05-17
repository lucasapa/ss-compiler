package compiler.tree;

import org.antlr.runtime.Token;
import compiler.tree.types.Type;

public class LiteralString extends Node {
	
    public LiteralString(Token token) {
        super(token);
        setTypeDef(Type.STRING);
    }
}
