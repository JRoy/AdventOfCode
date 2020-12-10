package io.github.jroy.advent.twentytwenty.daynine;

import io.github.jroy.advent.common.Utils;

import java.io.IOException;

public class PartOne {

  public static void main(String[] args) throws IOException {
    System.out.println("Solution: " + new XmasParser(Utils.getDayInputLongs(), 25).getFirstViolatingNumber());
  }
}
