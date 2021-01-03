grammar Expr;

expr : '-' expr # Neg
 | expr '*' expr # Mul
 | expr '/' expr # Div
 | expr '+' expr # Add
 | expr '-' expr # Sub
 | INT # int
 | '(' expr ')' # parens
 ;

INT : [0-9]+ ; // match integers

WS : [ \t\r\n]+ -> skip ; // toss out whitespace