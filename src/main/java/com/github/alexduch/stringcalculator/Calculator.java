package com.github.alexduch.stringcalculator;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Calculator {

  /**
   * The method can take numbers, separated by commas, and will return their sum.
   * For example “” or “1” or “1,2” as inputs.
   * For an empty string it will return 0
   *
   * @param numbers the comma-separated numbers to sum
   * @return the sum
   */
  public int add(String numbers) {
    return parseInput(numbers).sum();
  }

  private IntStream parseInput(String numbers) {
    if (numbers.isEmpty()) {
      return IntStream.builder().build();
    }
    String[] ints = numbers.split(",");
    return Arrays.stream(ints)
        .mapToInt(Integer::parseInt);
  }
}
