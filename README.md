# Lox

Lox is a small programming language implemented in Java. This project is designed to demonstrate the creation and execution of a simple programming language, covering parsing, interpreting, and error handling.

## Table of Contents

- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Examples](#examples)
- [Development](#development)
- [Contributing](#contributing)
- [License](#license)

## Features

- **Dynamic Typing:** Lox is dynamically typed, meaning variables can store values of any type, and a single variable can even store values of different types at different times.
- **Turing completeness:** Lox is turing complete and therefore has capability to perform any computation that can be described algorithmically, given enough time and resources.
- **Automatic memory management**: Uses Java's garbage collector for automatic memory management to handle memory cleanup, improving reliability and developer productivity.
- **Modularity**: Supports modular programming with clear separation of concerns, facilitating code organization and reusability.
- **Error Handling:** Robust error reporting for syntax and runtime errors.
- **Extensible:** Designed to be easily extendable with additional features and improvements.


## Installation

**Docker** is needed to run the lox interpreter. Download docker from the [official website](https://docs.docker.com/get-docker/)

### Clone the Repository
```bash
git clone https://github.com/manangulati9/lox.git
cd lox
```
### Run docker build
```bash
docker build -t lox .
```

## Usage

You can run Lox in two modes: interactive (REPL) and script mode.

### Interactive Mode (REPL)

To start the interactive shell, run the following command:

```bash
docker run -it --rm lox
```

### Script Mode

To execute a Lox script, run this command with a lox script.

```bash
docker run --rm lox path_to_lox_script.lox
```

## Syntax and Constructs

### Data types

- **Numbers**
- **Strings**
- **Booleans**
- **Nil**

### Expressions

An expression's main job is to produce a value. This value is then stored in variables.

#### - Arithmetic:
```
less < than;
lessThan <= orEqual;
greater > than;
greaterThan >= orEqual;
```

#### - Comparisons:
```
1 == 2;         // false.
"cat" != "dog"; // true.
314 == "pi"; // false.
123 == "123"; // false.
```

#### - Logical operators:
```
!true;  // false.
!false; // true.
true and false; // false.
true and true;  // true.
false or false; // false.
true or false;  // true.
```
#### - Precedence and Grouping:
All of these operators have the same precedence and associativity that you’d expect coming from C.
```javascript
var average = (min + max) / 2;
```

### Statements
A statement's main job is to product a side effect, unlike an expression. Since, by definition, statements don’t evaluate to a value, to be useful they have to otherwise change the world in some way—usually modifying some state, reading input, or producing output.

```
"some expression";
```

```javascript
print "Hello, World!";
```

```javascript
{
  print "One statement.";
  print "Two statements.";
}
```

### Variables

```javascript
var imAVariable = "here is my value";
var iAmNil;
var breakfast = "bagels";
print breakfast; // "bagels".
breakfast = "beignets";
print breakfast; // "beignets".
```

### Control Flow

#### - Conditionals:
```javascript
if (condition) {
  print "yes";
} else {
  print "no";
}
```
#### - Loops:
```javascript
var a = 1;
while (a < 10) {
  print a;
  a = a + 1;
}

for (var a = 1; a < 10; a = a + 1) {
  print a;
}
```

### Functions
```javascript
fun sayHello(name) {
  print "Hello, " + name + "!";
}

sayHello("Lox");
```
#### - Closures:
```javascript
fun returnFunction() {
  var outside = "outside";

  fun inner() {
    print outside;
  }

  return inner;
}

var fn = returnFunction();
fn();
```

## Development

### Prerequisites

- Java Development Kit (JDK) 21 or higher

### Directory Structure

- **src/lox:** Contains the main source code.
- **src/tool:** Contains handy dev tool scripts.
- **bin:** Contains dev bash scripts.
- **scripts:** Contains test Lox scripts.

## Contributing

Contributions are welcome! Please follow these steps to contribute:

1. Fork the repository.
2. Create a new branch for your feature or bugfix.
3. Commit your changes and push to your fork.
4. Create a pull request with a detailed description of your changes.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
