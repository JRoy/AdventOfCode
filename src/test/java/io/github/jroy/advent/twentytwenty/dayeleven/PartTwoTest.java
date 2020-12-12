package io.github.jroy.advent.twentytwenty.dayeleven;

import io.github.jroy.advent.common.graph.StandardGraph;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PartTwoTest {

  @Test
  public void testSampleInput() {
    List<String> input = List.of(
        ".......#.",
        "...#.....",
        ".#.......",
        ".........",
        "..#L....#",
        "....#....",
        ".........",
        "#........",
        "...#.....");
    assertEquals(8, PartTwo.countAdjRay(3, 4, new StandardGraph(input)));

    input = List.of(
        ".............",
        ".L.L.#.#.#.#.",
        ".............");
    assertEquals(0, PartTwo.countAdjRay(1, 1, new StandardGraph(input)));
    
    input = List.of(
        ".##.##.",
        "#.#.#.#",
        "##...##",
        "...L...",
        "##...##",
        "#.#.#.#",
        ".##.##.");
    assertEquals(0, PartTwo.countAdjRay(3, 3, new StandardGraph(input)));

    input = List.of(
        "L.LL.LL.LL",
        "LLLLLLL.LL",
        "L.L.L..L..",
        "LLLL.LL.LL",
        "L.LL.LL.LL",
        "L.LLLLL.LL",
        "..L.L.....",
        "LLLLLLLLLL",
        "L.LLLLLL.L",
        "L.LLLLL.LL");
    StandardGraph graph = new StandardGraph(input);
    int modifications = -1;
    while (modifications != 0) {
      modifications = PartOne.applyMutation(graph, 5, true);
      graph.printGraph();
    }
    assertEquals(26, PartOne.countOccupied(graph));
  }
}
