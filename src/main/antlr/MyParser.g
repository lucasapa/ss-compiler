parser grammar MyParser;

options {
    output = AST;
    tokenVocab = MyLexer;
    ASTLabelType = Node;
}

@header {
    package compiler;
    import compiler.tree.*;
}

program: statement* EOF^;
statement: printStatement | assignStatement | varDeclarationStatement;
printStatement: PRINT^ expression;
assignStatement: ID ASSIGN^ expression;
varDeclarationStatement: ID VARDECLARATION^ expression;

typeSpec: INTEGER_TYPE | FLOAT_TYPE | STRING_TYPE;

expression: addExpr;
multExpr: factor ((MUL | DIV)^ factor)*;
addExpr: multExpr ((ADD | SUB)^ multExpr)*;
factor: FLOAT | INTEGER | STRING | LPARENTHESES! expression RPARENTHESES!;


