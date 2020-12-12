package io.github.jroy.advent.twentytwenty.daytwelve;

import io.github.jroy.advent.common.Utils;

import java.io.IOException;

public class PartOne {

  public static void main(String[] args) throws IOException {
    System.out.println("Solution: " + new Ferry().parseInstructions(Utils.getDayInput()).getAbsSum());
  }
}
