package compiler;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.antlr.runtime.RecognitionException;

import compiler.tree.Node;

import java.io.IOException;

public class SimpleTest
    extends TestCase
{
    public SimpleTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(SimpleTest.class);
    }

    public void testAdd()
        throws IOException, RecognitionException
    {
        Compiler compiler = new Compiler();
        Node ast = compiler.parse("print 3 + 2", true);

        assertNotNull(ast);
    }

    public void testMul()
        throws IOException, RecognitionException
    {
        Compiler compiler = new Compiler();
        Node ast = compiler.parse("print 3 * 2", true);

        assertNotNull(ast);
    }

    public void testComplexExpr()
        throws IOException, RecognitionException
    {
        Compiler compiler = new Compiler();
        Node ast = compiler.parse("print 3 * (2 + 4 / 2) - 1", true);

        assertNotNull(ast);
    }

}
