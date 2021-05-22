package com.github.alexduch.stringcalculator;

public class Calculator {

  /**
   * The method can take up to two numbers, separated by commas, and will return their sum.
   * For example “” or “1” or “1,2” as inputs.
   * For an empty string it will return 0
   *
   * @param numbers the comma-separated numbers to sum
   * @return the sum
   */
  public int add(String numbers) {
    NumbersToSum toSum = parseInput(numbers);
    return toSum.number1() + toSum.number2();
  }

  private NumbersToSum parseInput(String numbers) {
    if (numbers.isEmpty()) {
      return new NumbersToSum(0, 0);
    }
    String[] ints = numbers.split(",");
    if (ints.length > 2) {
      throw new TooManyNumbersException();
    }
    int number1 = Integer.parseInt(ints[0]);
    int number2 = 0;
    if (ints.length > 1) {
      number2 += Integer.parseInt(ints[1]);
    }
    return new NumbersToSum(number1, number2);
  }
}
