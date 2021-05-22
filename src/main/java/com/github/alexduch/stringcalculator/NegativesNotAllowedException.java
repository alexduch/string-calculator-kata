package com.github.alexduch.stringcalculator;

import static java.util.stream.Collectors.joining;

import java.util.List;

public class NegativesNotAllowedException extends RuntimeException {

  private final List<Integer> negatives;

  public NegativesNotAllowedException(List<Integer> negatives) {
    super("Negatives are not allowed");
    this.negatives = List.copyOf(negatives);
  }

  @Override
  public String getMessage() {
    return super.getMessage() + ": " +
        negatives.stream().map(i -> i.toString()).collect(joining(", "));
  }

  public List<Integer> getNegatives() {
    return negatives;
  }
}
