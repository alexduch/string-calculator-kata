package com.github.alexduch.stringcalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

  private final Calculator calculator = new Calculator();

  @Test
  void shouldReturn0WhenGivenAnEmptyString() {
    assertEquals(0, calculator.add(""));
  }
}