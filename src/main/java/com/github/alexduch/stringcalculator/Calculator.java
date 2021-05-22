package com.github.alexduch.stringcalculator;

import java.util.Arrays;
import java.util.List;

public class Calculator {

  public static final String DEFAULT_DELIMITERS = ",\\n";

  /**
   * The method can take numbers, separated by commas or new lines (or a custom delimiter), and will
   * return their sum.
   * For example “” or “1” or “1,2” as inputs. Negatives are forbidden.
   * For an empty string it will return 0.*
   * To change a delimiter, the beginning of the string must contain a separate line that looks
   * like this: <code>//[delimiter]\n[numbers…]</code> for example <code>//;\n1;2</code> should
   * return three where the default delimiter is ‘;’.
   *
   * @param numbers the comma-separated numbers to sum
   * @return the sum
   */
  public int add(String numbers) {
    var integers = parseInput(numbers);
    throwIfContainsNegatives(integers);
    return integers.stream().mapToInt(Integer::intValue).sum();
  }

  private List<Integer> parseInput(String numbers) {
    if (numbers.isEmpty()) {
      return List.of();
    }
    DelimitedInput input = determineDelimiter(numbers);
    String[] ints = input.numbers().split("[" + input.delimiter() + "]", -1);
    return Arrays.stream(ints)
        .map(Integer::parseInt)
        .toList();
  }

  private DelimitedInput determineDelimiter(String input) {
    if (input.startsWith("//")) {
      int delimiterEnd = input.indexOf('\n');
      if (delimiterEnd < 3) {
        throw new InvalidDelimiterException();
      }

      return new DelimitedInput(
          input.substring(2, delimiterEnd),
          input.substring(delimiterEnd + 1)
      );
    } else {
      return new DelimitedInput(DEFAULT_DELIMITERS, input);
    }
  }

  private void throwIfContainsNegatives(List<Integer> numbers) {
    var negatives = numbers.stream().filter(i -> i < 0).toList();
    if (negatives != null && !negatives.isEmpty()) {
      throw new NegativesNotAllowedException(negatives);
    }
  }
}
