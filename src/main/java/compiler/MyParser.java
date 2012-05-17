package compiler;

import compiler.tree.*;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTreeAdaptor;

import java.io.IOException;
import java.io.Reader;

public class MyParser extends MyParserParser {
    private RecognitionException error;
    private MyLexer lexer;

    public MyParser(Reader reader)
        throws IOException
    {
        this(new MyLexer(reader));
        setTreeAdaptor(createAdaptor());
    }

    public MyParser(MyLexer lexer) {
        super(new CommonTokenStream(lexer));
        this.lexer = lexer;
    }

    private CommonTreeAdaptor createAdaptor() {
        return new CommonTreeAdaptor() {
            public Object create(Token token) {
                return NodeFactory.create(token);
            }
        };
    }

    public void reportError(RecognitionException e) {
        super.reportError(e);
        error = e;
    }

    public RecognitionException getError() {

        if (error == null) {
            error = lexer.getError();
        }
        
        return error;
    }
}
