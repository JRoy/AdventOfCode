package io.github.jroy.advent.twentytwenty.daythree;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PartOneTest {

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
    assertEquals(7, PartOne.getHitTrees(input, 1, 3));
  }
}
