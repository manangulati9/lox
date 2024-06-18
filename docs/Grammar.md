# Grammar

## Syntax Rules

**program** → **declaration*** EOF

**declaration** → **funcDecl** | **varDecl** | **statement**

**funDecl** → "fun" **function**

**function** → IDENTIFIER "(" **parameters**? ")" **block**

**parameters** → IDENTIFIER ( "," IDENTIFIER )*

**varDecl** → "var" IDENTIFIER ( "=" **expression** )? ";"

**statement** → **exprStmt** | **ifStmt** | **printStmt** | **whileStmt** | **forStmt** | **block** | **breakStmt** | **returnStmt**

**ifStmt** → "if" "(" **expression** ")" **statement** ( "else" **statement** )?

**printStmt** → "print" **expression** ";"

**whileStmt** → "while" "(" **expression** ")" **statement**

**forStmt** → "for" "(" ( **varDecl** | **exprStmt** | ";" ) **expression**? ";" **expression**? ")" **statement**

**block** → "{" **declaration*** "}"

**breakStmt** → "break" ";"

**returnStmt** → "return" **expression**? ";"

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

**unary** → ( "!" | "-" ) **unary** | **call**

**call** → **primary** ( "(" **arguments**? ")" )*

**arguments** → **expression** ( "," **expression** )*

**primary** → "true" | "false" | "nil" | NUMBER | STRING | "(" **expression** ")" | IDENTIFIER
