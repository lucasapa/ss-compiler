package compiler.tree;

import compiler.tree.types.Type;
import org.antlr.runtime.Token;

public class LiteralInteger extends Node{

    public LiteralInteger(Token token) {
        super(token);
        setTypeDef(Type.INTEGER);
    }
}
