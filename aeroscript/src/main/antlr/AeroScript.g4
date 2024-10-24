grammar AeroScript;

@header {
package no.uio.aeroscript.antlr;
}

// Whitespace and comments added
WS           : [ \t\r\n\u000C]+ -> channel(HIDDEN);
COMMENT      : '/*' .*? '*/' -> channel(HIDDEN) ;
LINE_COMMENT : '//' ~[\r\n]* -> channel(HIDDEN) ;

LCURL   : '{';
RCURL   : '}';
LSQUARE : '[';
RSQUARE : ']';
LPAREN  : '(';
RPAREN  : ')';

NEG     : '--';
SEMI    : ';';
COMMA   : ',';
GREATER : '>';

PLUS    : '+';
MINUS   : '-';
TIMES   : '*';

NEXT    : '->';   // → peker på hvilken instruks som skal gjøres etter det som står før

// Define all the elements of the language for the various keywords that you need
RANDOM  : 'random';
POINT   : 'point';

OBSTACLE: 'obstacle';
BATTERY : 'low battery';
MESSAGE : 'message';
ON      : 'on';
FOR     : 'for';
S       : 's';
SPEED   : 'at speed';
RETURN  : 'return to base';
MOVE    : 'move';
TO      : 'to';
BY      : 'by';
TURN    : 'turn';
RIGHT   : 'right';
LEFT    : 'left';
ASCEND  : 'ascend by';
DESCEND : 'descend by';
GROUND  : 'descend to ground'; 


// Keywords
ID: [a-zA-Z_]+; // Allow underscore in ID
NUMBER: '-'?[0-9]+('.'[0-9]+)?;

// Entry point
program  : (execution)+; 
execution: NEXT? ID LCURL (statement)* RCURL (NEXT ID)?;

// Statements
statement : action | reaction | execution; 
reaction : ON event NEXT ID;
event   : OBSTACLE | BATTERY | MESSAGE LSQUARE ID RSQUARE;
    
action  :   (acDock | acMove | acTurn | acAscend | acDescend) 
            (FOR expression S | SPEED expression)?;
acDock : RETURN;
acMove : MOVE (TO POINT point | BY NUMBER);
acTurn : TURN (RIGHT | LEFT) BY expression;
acAscend: ASCEND expression;
acDescend: DESCEND expression | GROUND;

expression : expression (PLUS | MINUS | TIMES) expression |
             NEG expression |
             RANDOM range? |
             POINT point |
             NUMBER |
             LPAREN expression RPAREN;

point : LPAREN expression COMMA expression RPAREN;
range : LSQUARE expression COMMA expression RSQUARE;
