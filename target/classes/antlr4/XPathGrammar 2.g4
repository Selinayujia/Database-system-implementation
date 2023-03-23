grammar XPathGrammar;

@header {
package project.parsers;
}

ap                  : ('doc' | 'document') '(' FILENAME ')' '/' rp     #SingleSlashAP
                    | ('doc' | 'document') '(' FILENAME ')' '//' rp    #DoubleSlashAP;

rp                  : TAGNAME                       #TagRP
                    | '*'                           #AllChildrenRP
                    | '.'                           #SelfRP
                    | '..'                          #ParentRP
                    | 'text()'                      #TextRP
                    | ATTRNAME                      #AttributeRP
                    | rp '/' rp                     #SingleSlashRP
                    | rp '//' rp                    #DoubleSlashRP
                    | '(' rp ')'                    #BracketRP
                    | rp '[' f ']'                  #FilteredRP
                    | rp ',' rp                     #SequenceRP;
f                   : rp                            #RPFilter
                    | rp '=' STRINGCONSTANT         #ConstantFilter
                    | rp ('=' | 'eq') rp            #EqualFilter
                    | rp ('==' | 'is') rp           #IsFilter
                    | '(' f ')'                     #BracketFilter
                    | f 'and' f                     #AndFilter
                    | f 'or' f                      #OrFilter
                    | 'not' f                       #NotFilter;

fragment LOWERCASE  : [a-z];
fragment UPPERCASE  : [A-Z];
fragment DIGIT      : [0-9];

TAGNAME             : TEXT;
ATTRNAME            : '@' TEXT;
TEXT                : (LOWERCASE | UPPERCASE | DIGIT | '_' | '-')+;
FILENAME            : '"' TEXT '.' TEXT '"';
STRINGCONSTANT      : '"' (~'"')* '"';
WHITESPACE          : [ \t\r\n]+ -> skip;


