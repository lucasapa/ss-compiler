package compiler.tree.types;

import compiler.tree.Node;
import org.antlr.runtime.Token;

public class FloatType extends Node {

    public FloatType(Token token) {
        super(token);
        setTypeDef(Type.FLOAT);
    }


	public String getName() {		
		return "Float";
	}
}
