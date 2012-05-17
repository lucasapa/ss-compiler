lexer grammar MyLexer;

@header {
    package compiler;
}

/* Whitespaces */
WHITESPACE: (' '|'\t'|'\n'|'\r')+ {skip();} ;

/* Reserved words */

PRINT: 'print';
ASSIGN: ':=';
VARDECLARATION: ':';


/*  Types */
INTEGER_TYPE: 'Integer';
FLOAT_TYPE: 'Float';
STRING_TYPE: 'String';


/* Strings */
STRING: QUOTE (~'"')* QUOTE;
QUOTE: '"';


/* Operators */
ADD: '+';
SUB:  '-';
MUL: '*';
DIV: '/';

	
/* Numbers */
FLOAT : INTEGER '.' INTEGER;
INTEGER: DIGIT+;
fragment DIGIT: '0'..'9';

LPARENTHESES: '(';
RPARENTHESES: ')';

/* Letters */
fragment LETTER : 'a'..'z' | 'A'..'Z';
ID : LETTER(INTEGER | LETTER)*;
