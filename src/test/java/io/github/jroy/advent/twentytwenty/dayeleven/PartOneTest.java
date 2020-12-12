package io.github.jroy.advent.twentytwenty.dayeleven;

import io.github.jroy.advent.common.graph.StandardGraph;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PartOneTest {

  @Test
  public void testSampleInput() {
    List<String> input = List.of(
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
      modifications = PartOne.applyMutation(graph, 4, false);
    }
    assertEquals(37, PartOne.countOccupied(graph));
  }
}
