package io.github.jroy.advent.twentytwenty.daynine;

import io.github.jroy.advent.common.Utils;

import java.io.IOException;

public class PartTwo {

  public static void main(String[] args) throws IOException {
    XmasParser parser = new XmasParser(Utils.getDayInputLongs(), 25);
    System.out.println("Solution: " + parser.getEncryptionWeakness(parser.getFirstViolatingNumber()));
  }
}
