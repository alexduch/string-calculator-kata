package com.github.alexduch.stringcalculator;

import java.util.Arrays;
import java.util.List;

class DelimitedInputParser {

  private final String defaultDelimiters;

  DelimitedInputParser(String defaultDelimiters) {
    this.defaultDelimiters = defaultDelimiters;
  }

  List<Integer> parse(String numbers) {
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
      return new DelimitedInput(defaultDelimiters, input);
    }
  }
}
