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

- **Interpreted Language:** Executes directly from source code, allowing for quick testing and development.
- **Garbage Collection**: Implements automatic memory management to handle memory cleanup, improving reliability and developer productivity.
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

## Examples

### Hello, World!

```c
print "Hello, World!";
```

### Variables

```c
var a = 10;
var b = 20;
print a + b; // 30
print a - b; // -10
print a * b; // 200
print a / b; // 0.5
print a % b; // 10
```

### Functions

```c
fun sayHello(name) {
  print "Hello, " + name + "!";
}

sayHello("Lox");
```

### Control Flow

```c
var x = 10;

if (x > 5) {
  print "x is greater than 5";
} else {
  print "x is not greater than 5";
}
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
