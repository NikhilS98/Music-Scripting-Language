grammar Mupl;

//syntax rules
start: 'begin' DELIMITER (statement)* 'end' DELIMITER;

statement: assign | cmd | block;

assign:	TYPE IDENTIFIER OPERATOR expr DELIMITER
	;

expr: 	value 
	|	value OPERATOR expr
	;

value:	INSTRUMENT
	|	LITERAL
	|	IDENTIFIER
	;

block: KEYWORD INT DELIMITER cmd+ DELIMITER
	;

cmd:  KEYWORD expr KEYWORD expr loop? DELIMITER
	;

loop: INT KEYWORD;



//tokens definitions
COMMENT: '//' ~('\r' | '\n')* { skip(); }
        | '/*' .*? '*/' { skip(); };
WHITESPACE : [\t\r\n ]+ -> skip;
INT     : [0-9]+ ;
KEYWORD	: 'play' | 'with' | 'at' | 'times';
INSTRUMENT : 'piano' | 'guitar' | 'drum' | 'violin' ;
TYPE : 'progression' | 'instrument' ;
OPERATOR : '=' | '+' ;
DELIMITER : '[' | ']' | ';';
IDENTIFIER : [A-Za-z_$] [A-Za-z_$0-9]* ;
LITERAL	: '"' (~[\r\n"])* '"' ;