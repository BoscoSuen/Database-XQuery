
/* XPath.g4
 *
 */

grammar xQuery;

ap
	: 'doc("' filename '")' '/' rp          # Descendent
	| 'doc("' filename '")' '//' rp         # AllDescendent
	;

filename
	: NAME ('.' NAME)?
	;

rp
	: NAME                         # TagName
	| '*'                          # Children
	| '.'                          # Current
	| '..'                         # Parent
	| 'text()'                     # Txt
	| '@' NAME                     # Attribute
	| '(' rp ')'                   # RRn
	| rp '/' rp                    # RDescendent
	| rp '//' rp                   # RAll
	| rp '[' filter ']'            # RFilter
	| rp ',' rp                    # Concatenation
	;

filter
	: rp                           # CheckNotEmpty
	| rp '=' rp                    # Equal
	| rp 'eq' rp                   # AlsoEqual
	| rp '==' rp                   # Is
	| rp 'is' rp                   # AlsoIs
	| '(' filter ')'               # FFn
	| filter 'and' filter          # And
	| filter 'or' filter           # Or
	| 'not' filter                 # Not
	;

NAME: [a-zA-Z0-9_-]+;
WS : [ \t\r\n]+ -> skip;
