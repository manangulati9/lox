# Grammar

## Syntax Rules

**program** → **declaration*** EOF

**declaration** → **varDecl** | **statement**

**varDecl** → "var" IDENTIFIER ( "=" **expression** )? ";"

**statement** → **exprStmt** | **ifStmt** | **printStmt** | **whileStmt** | **forStmt** | **block**

**ifStmt** → "if" "(" **expression** ")" **statement** ( "else" **statement** )?

**printStmt** → "print" **expression** ";"

**whileStmt** → "while" "(" **expression** ")" **statement**

**forStmt** → "for" "(" ( **varDecl** | **exprStmt** | ";" ) **expression**? ";" **expression**? ")" **statement**

**block** → "{" **declaration*** "}"

**exprStmt** → **expression** ";"

**expression** → **assignment**

**assignment** → IDENTIFIER "=" **assignment** | **ternary**

**ternary** → **logic_or** "?" **logic_or** ":" **logic_or** | **logic_or**

**logic_or** → **logic_and** ( "or" **logic_and** )*

**logic_and** → **equality** ( "and" **equality** )*

**equality** → **comparison** ( ( "!=" | "==" ) **comparison** )*

**comparison** → **term** ( ( ">" | ">=" | "<" | "<=" ) **term** )*

**term** → **factor** ( ( "-" | "+" ) **factor** )*

**factor** → **unary** ( ( "/" | "\*" ) **unary** )*

**unary** → ( "!" | "-" ) **unary** | **primary**

**primary** → "true" | "false" | "nil" | NUMBER | STRING | "(" **expression** ")" | IDENTIFIER
