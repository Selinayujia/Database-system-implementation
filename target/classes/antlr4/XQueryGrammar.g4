grammar XQueryGrammar;
import XPathGrammar;

xq                  : VAR                                                   #VarXQ
                    | STRINGCONSTANT                                        #StringXQ
                    | ap                                                    #ApXQ
                    | xq '/' rp                                             #SingleSlashXQ
                    | xq '//' rp                                            #DoubleSlashXQ
                    | '(' xq ')'                                            #BracketXQ
                    | xq ',' xq                                             #SequenceXQ
                    | '<' TAGNAME '>' ('{')? xq ('}')? '</' TAGNAME '>'     #TagXQ
                    | forClause (letClause)? (whereClause)? returnClause    #FlworXQ
                    | letClause xq                                          #LetClauseXQ ; 
forClause           : 'for' VAR 'in' xq (',' VAR 'in' xq)*;
letClause           : 'let' VAR ':=' xq (',' VAR ':=' xq)*;
whereClause         : 'where' cond;
returnClause        : 'return' xq;
cond                : xq ('=' | 'eq') xq                                    #EqualCond
                    | xq ('==' | 'is') xq                                   #IsCond
                    | 'empty' '(' xq ')'                                    #EmptyCond
                    | 'some' (VAR 'in' xq (',')?)+ 'satisfies' cond         #MultipleCond
                    | '(' cond ')'                                          #BracketCond
                    | cond 'and' cond                                       #AndCond
                    | cond 'or' cond                                        #OrCond
                    | 'not' cond                                            #NotCond;

VAR                 : '$' TEXT;