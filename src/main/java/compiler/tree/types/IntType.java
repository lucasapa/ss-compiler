package compiler.tree.types;

import compiler.tree.Node;
import org.antlr.runtime.Token;

public class IntType extends Node {

    public IntType(Token token) {
        super(token);
        setTypeDef(Type.INTEGER);
    }

    public String getName() {
		return "Integer";
	}
	
}
