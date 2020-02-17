
/* XQuery.g4
 * Created by Xiaohan Zhu and Zhiqiang Sun
 */

grammar xQuery;

ap
	: 'doc("' filename '")' '/' rp          # ADescendent
	| 'doc("' filename '")' '//' rp         # ADesOrSelf
	;


filename
	: NAME ('.' NAME)?
	;

rp
	: NAME                         # TagName
	| '*'                          # Children
	| '.'                          # Self
	| '..'                         # Parent
	| 'text()'                     # Text
	| '@' NAME                     # Attribute
	| '(' rp ')'                   # RBracket
	| rp '/' rp                    # RDescendent
	| rp '//' rp                   # RDesOrSelf
	| rp '[' filter ']'            # RFilter
	| rp ',' rp                    # RConcat
	;

filter
	: rp                           # FRp
	| rp '=' rp                    # FEqual
	| rp 'eq' rp                   # FEqual
	| rp '==' rp                   # FIs
	| rp 'is' rp                   # FIs
	| '(' filter ')'               # FBracket
	| filter 'and' filter          # FAnd
	| filter 'or' filter           # FOr
	| 'not' filter                 # FNot
	;

var : '$' NAME
    ;

xq
    : var                          # XQValue
    | ap                           # XQAp
    | STRINGCONSTANT               # StringConstant
    | '(' xq ')'                   # XQBracket
    | xq ',' xq                    # XQConcat
    | xq '/' rp                    # XQChild
    | xq '//' rp                   # XQDescendent
    | '<' NAME '>' '{' xq '}' '</' NAME '>'   # XQNodeConstrctor
    | forClause? letClause? whereClause? returnClause  # XQFLWOR
    | letClause xq                 # XQDefine
    ;

forClause
    : 'for' var 'in' xq(',' var 'in' xq)*
    ;

letClause
    : 'let' var ':=' xq(',' var ':=' xq)*
    ;

whereClause
    : 'where' cond
    ;

cond
    : xq '=' xq                     # XQEqual
    | xq 'eq' xq                    # XQEqual
    | xq '==' xq                    # XQIs
    | xq 'is' xq                    # XQIs
    | 'empty' '(' xq ')'            # XQIsEmpty
    | 'some' var 'in' xq(',' var 'in' xq)* 'satisfies' cond  # XQSatisfy
    | '(' cond ')'                  # XQCond
    | cond 'and' cond               # XQAndCond
    | cond 'or' cond                # XQOrCond
    | 'not' cond                    # XQNot
    ;

returnClause
    : 'return' xq
    ;


NAME: [a-zA-Z0-9_-]+;
WS : [ \t\r\n]+ -> skip;
//STRINGCONSTANT:'"'(ESC|.)*?'"';
//fragment
//ESC:'\\"'|'\\\\';//2-charsequences\"and\\
STRINGCONSTANT: '"' [a-zA-Z0-9_,.;:'"?!@#$%^&*` \t\r\n-]* '"';
// have to consider empty string, should use *