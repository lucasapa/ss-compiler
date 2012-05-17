package compiler.tree;

import compiler. MyLexer;
import compiler.tree.arithmetic.Add;
import compiler.tree.arithmetic.Div;
import compiler.tree.arithmetic.Mul;
import compiler.tree.arithmetic.Sub;
import compiler.tree.values.FloatValue;
import compiler.tree.values.IntValue;
import compiler.tree.values.StringValue;


import org.antlr.runtime.Token;

public class NodeFactory {
    public static Node create(Token token) {
        Node node;

        if (token == null) {
            node = new Node(null);
        }
        else {
            switch (token.getType()) {
            	case MyLexer.ASSIGN:
            		node = new Assign(token);
            		break;
            	case MyLexer.VARDECLARATION:
            		node = new VarDeclaration(token);
            		break;
            	case MyLexer.FLOAT:
            		node = new FloatValue(token);
            		break;
            	case MyLexer.FLOAT_TYPE:
                    node= new LiteralFloat(token);
                    break;
            	case MyLexer.PRINT:
            		node = new Print(token);
            		break;
                case MyLexer.ADD:
                    node = new Add(token);
                    break;
                case MyLexer.SUB:
            		node = new Sub(token);
            		break;
                case MyLexer.MUL:
            		node = new Mul(token);
            		break;
                case MyLexer.DIV:
            		node = new Div(token);
            		break;
                case MyLexer.INTEGER:
                	node = new IntValue(token);
                    break;
                case MyLexer.INTEGER_TYPE:
                    node= new LiteralInteger(token);
                    break;
                case MyLexer.EOF:
                    node = new Program(token);
                    break;
		        case MyLexer.STRING:
                    node = new StringValue(token);
                    break;
		        case MyLexer.ID:
                    node = new Id(token);
                    break;
		        case MyLexer.STRING_TYPE:
                    node= new LiteralString(token);
                    break;
                default:
                    node = new Node(token);
            }
        }


        return node;
    }
}
