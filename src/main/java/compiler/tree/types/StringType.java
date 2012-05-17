package compiler.tree.types;


import compiler.tree.Node;
import org.antlr.runtime.Token;

public class StringType extends Node {


    public StringType(Token token) {
        super(token);
        setTypeDef(Type.STRING);
    }

		public String getName() {
			return "String";
		}
}

