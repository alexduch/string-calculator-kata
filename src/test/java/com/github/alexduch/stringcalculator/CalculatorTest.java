package com.github.alexduch.stringcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.IntStream;
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
  void shouldAcceptAnyNumberOfNumbers() {
    assertEquals(6, calculator.add("1,2,3"));
    assertEquals(10, calculator.add("1,2,3,4"));
    assertEquals(4950, calculator.add(generateInput(100)));
  }

  @Test
  void shouldRejectInvalidNumbers() {
    assertThrows(NumberFormatException.class, () -> calculator.add("afm"));
    assertThrows(NumberFormatException.class, () -> calculator.add("afm,zoegjo"));
    assertThrows(NumberFormatException.class, () -> calculator.add("1,zoegjo"));
    assertThrows(NumberFormatException.class, () -> calculator.add("afm,0"));
  }

  @Test
  void shouldAcceptNewLineAsSeparator() {
    assertEquals(6, calculator.add("1\n2,3"));
    assertThrows(NumberFormatException.class, () -> calculator.add("1,\n"));
    assertThrows(NumberFormatException.class, () -> calculator.add("1,\n12"));
  }

  private String generateInput(int max) {
    return IntStream.range(0, max)
        .collect(
            StringBuffer::new,
            (buffer, number) -> buffer.append(number).append(","),
            StringBuffer::append
        )
        .toString()
        .transform(s -> s.substring(0, s.length() -1));
  }
}