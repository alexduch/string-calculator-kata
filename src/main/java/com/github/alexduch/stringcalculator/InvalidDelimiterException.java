package com.github.alexduch.stringcalculator;

public class InvalidDelimiterException extends RuntimeException {

  public InvalidDelimiterException() {
    super("Invalid custom delimiter");
  }
}
