package lox;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.List;

public class Lox {
  private static final Interpreter interpreter = new Interpreter();
  static boolean hadError = false;
  static boolean hadRuntimeError = false;

  public static void main(String[] args) throws IOException {
    if (args.length > 1) {
      System.out.println("Usage: lox [script]");
      System.exit(64);
    } else if (args.length == 1) {
      if (validateFilePath(args[0])) {
        runFile(args[0]);
      }
    } else {
      runPrompt();
    }
  }

  private static void runFile(String path) throws IOException {
    byte[] bytes = Files.readAllBytes(Paths.get(path));
    run(new String(bytes, Charset.defaultCharset()));
    if (hadError)
      System.exit(65);
    if (hadRuntimeError)
      System.exit(70);
  }

  private static void runPrompt() throws IOException {
    InputStreamReader input = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(input);

    while (true) {
      System.out.print("  >>> ");
      String line = reader.readLine();
      if (line == null)
        break;
      run(line);
      hadError = false;
    }
  }

  private static void run(String source) {
    Scanner scanner = new Scanner(source);
    List<Token> tokens = scanner.scanTokens();

    Parser parser = new Parser(tokens);
    List<Stmt> statements = parser.parse();

    // Stop if there was a parse error.
    if (hadError)
      return;

    Resolver resolver = new Resolver(interpreter);
    resolver.resolve(statements);

    // Stop if there was a resolution error.
    if (hadError)
      return;

    interpreter.interpret(statements);
  }

  static void error(int line, int column, String message) {
    report(line, column, "", message);
  }

  private static void report(int line, int column, String where,
                             String message) {
    System.err.println("[line " + line + " column " + column + "]: Error" +
                       where + ": " + message);
    hadError = true;
  }

  static void error(Token token, String message) {
    if (token.type == TokenType.EOF) {
      report(token.line, token.column, " at end", message);
    } else {
      report(token.line, token.column, " at '" + token.lexeme + "'", message);
    }
  }

  static void runtimeError(RuntimeError error) {
    System.err.println(error.getMessage() + "\n[line " + error.token.line +
                       " column " + error.token.column + "]");
    hadRuntimeError = true;
  }

  public static boolean validateFilePath(String filePath) {
    try {
      // Check if the path is valid
      Paths.get(filePath);
    } catch (InvalidPathException e) {
      System.out.println("Invalid path: " + filePath);
      return false;
    }

    File file = new File(filePath);

    // Check if the path exists
    if (!file.exists()) {
      System.out.println("Path does not exist: " + filePath);
      return false;
    }

    // Check if it's a file or directory
    if (!file.isFile()) {
      System.out.println("Path is not a file: " + filePath);
      return false;
    }

    // Check read/write permissions
    if (!file.canRead()) {
      System.out.println("Cannot read the file: " + filePath);
      return false;
    }

    String fileName = file.getName();

    int lastIndexOfDot = fileName.lastIndexOf('.');
    if (lastIndexOfDot == -1) {
      return false; // No extension found
    }

    String fileExtension = fileName.substring(lastIndexOfDot + 1);
    return fileExtension.equalsIgnoreCase("lox");
  }
}
