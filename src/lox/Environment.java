package lox;

import java.util.HashMap;
import java.util.Map;

class Environment {
  public record Entry(Object value, boolean didInit) {}
  private final Map<String, Entry> values = new HashMap<>();
  final Environment enclosing;

  Environment() { enclosing = null; }

  Environment(Environment enclosing) { this.enclosing = enclosing; }

  void define(String name, Entry entry) { values.put(name, entry); }

  Object get(Token name) {
    if (values.containsKey(name.lexeme) && values.get(name.lexeme).didInit) {
      return values.get(name.lexeme).value;
    }

    if (enclosing != null)
      return enclosing.get(name);

    throw new RuntimeError(name, "Undefined variable '" + name.lexeme + "'.");
  }

  void assign(Token name, Object value) {
    if (values.containsKey(name.lexeme)) {
      values.put(name.lexeme, new Entry(value, true));
      return;
    }

    if (enclosing != null) {
      enclosing.assign(name, value);
      return;
    }

    throw new RuntimeError(name, "Undefined variable '" + name.lexeme + "'.");
  }
}
