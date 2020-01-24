
/* XPath.g4
 * https://en.wikipedia.org/wiki/XPath
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

NAME: [a-zA-Z0-9_-]+;
WS : [ \t\r\n]+ -> skip;
