package io.github.jroy.advent.twentytwenty.daytwelve;

import io.github.jroy.advent.common.Utils;

import java.io.IOException;

public class PartTwo {

  public static void main(String[] args) throws IOException {
    System.out.println("Solution: " + new Ferry().parseWaypoints(Utils.getDayInput()).getAbsSum());
  }
}
