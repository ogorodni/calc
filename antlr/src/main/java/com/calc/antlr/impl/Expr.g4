grammar Expr;

expr : expr op=('*'|'/') expr # MulDiv
 | expr op=('+'|'-') expr # AddSub
 | INT # int
 | '(' expr ')' # parens
 ;

MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;

 INT : [0-9]+ ; // match integers

 WS : [ \t\r\n]+ -> skip ; // toss out whitespace