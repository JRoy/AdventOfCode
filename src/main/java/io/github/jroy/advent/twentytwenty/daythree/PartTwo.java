package io.github.jroy.advent.twentytwenty.daythree;

import io.github.jroy.advent.common.Utils;

import java.io.IOException;
import java.util.List;

import static io.github.jroy.advent.twentytwenty.daythree.PartOne.getHitTrees;

public class PartTwo {

  public static void main(String[] args) throws IOException {
    List<String> input = Utils.getDayInput();
    int[][] slopes = new int[][]{
        new int[]{1, 1},
        new int[]{3, 1},
        new int[]{5, 1},
        new int[]{7, 1},
        new int[]{1, 2}};

    long result = 1;
    for (int[] slope : slopes) {
      result *= getHitTrees(input, slope[0], slope[1]);
    }
    System.out.println("Solution: " + result);
  }
}
