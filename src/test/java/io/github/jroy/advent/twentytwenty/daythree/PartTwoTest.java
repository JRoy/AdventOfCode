package io.github.jroy.advent.twentytwenty.daythree;

import org.junit.Test;

import java.util.List;

import static io.github.jroy.advent.twentytwenty.daythree.PartOne.getHitTrees;
import static org.junit.Assert.assertEquals;

public class PartTwoTest {

  @Test
  public void testSampleInput() {
    List<String> input = List.of(
        "..##.......",
        "#...#...#..",
        ".#....#..#.",
        "..#.#...#.#",
        ".#...##..#.",
        "..#.##.....",
        ".#.#.#....#",
        ".#........#",
        "#.##...#...",
        "#...##....#",
        ".#..#...#.#");
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
    assertEquals(336, result);
  }
}
