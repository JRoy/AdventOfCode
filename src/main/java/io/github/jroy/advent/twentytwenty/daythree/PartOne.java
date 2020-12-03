package io.github.jroy.advent.twentytwenty.daythree;

import io.github.jroy.advent.common.Utils;
import io.github.jroy.advent.common.graph.Graph;

import java.io.IOException;
import java.util.List;

public class PartOne {

  public static void main(String[] args) throws IOException {
    System.out.println("Solution: " + getHitTrees(Utils.getDayInput(), 3, 1));
  }

  public static long getHitTrees(List<String> input, int xOffset, int yOffset) {
    Graph graph = new Graph(input);
    int x = 0;
    int y = 0;
    int hit = 0;
    while (y < graph.getRowCount()) {
      if (graph.getCharAt(x, y) == '#') {
        hit++;
      }
      x += xOffset;
      y += yOffset;
    }
    return hit;
  }
}
