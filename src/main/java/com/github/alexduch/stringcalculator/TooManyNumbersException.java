package com.github.alexduch.stringcalculator;

public class TooManyNumbersException extends RuntimeException {

  public TooManyNumbersException() {
    super("Cannot handle more than 2 numbers");
  }
}
