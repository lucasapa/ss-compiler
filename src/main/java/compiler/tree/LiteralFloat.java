package compiler.tree;

import compiler.tree.types.Type;
import org.antlr.runtime.Token;

public class LiteralFloat extends Node {

    public LiteralFloat(Token token) {
        super(token);
        setTypeDef(Type.FLOAT);
    }
}
