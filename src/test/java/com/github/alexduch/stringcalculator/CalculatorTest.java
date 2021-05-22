package com.github.alexduch.stringcalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

  private final Calculator calculator = new Calculator();

  @Test
  void shouldReturn0WhenGivenAnEmptyString() {
    assertEquals(0, calculator.add(""));
  }

  @Test
  void shouldAcceptOneNumber() {
    assertEquals(1, calculator.add("1"));
    assertEquals(2, calculator.add("2"));
    assertEquals(7, calculator.add("7"));
  }

  @Test
  void shouldAcceptTwoNumbersAndSumThem() {
    assertEquals(1, calculator.add("1,0"));
    assertEquals(1, calculator.add("0,1"));
    assertEquals(2, calculator.add("1,1"));
    assertEquals(11, calculator.add("3,8"));
  }

  @Test
  void shouldRejectMoreThanTwoNumbers() {
    assertThrows(TooManyNumbersException.class, () -> calculator.add("1,2,3"));
    assertThrows(TooManyNumbersException.class, () -> calculator.add("1,2,3,4"));
  }

  @Test
  void shouldRejectInvalidNumbers() {
    assertThrows(NumberFormatException.class, () -> calculator.add("afm"));
    assertThrows(NumberFormatException.class, () -> calculator.add("afm,zoegjo"));
    assertThrows(NumberFormatException.class, () -> calculator.add("1,zoegjo"));
    assertThrows(NumberFormatException.class, () -> calculator.add("afm,0"));
  }
}