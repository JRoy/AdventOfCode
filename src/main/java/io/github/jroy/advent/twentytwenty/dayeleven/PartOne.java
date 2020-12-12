package io.github.jroy.advent.twentytwenty.dayeleven;

import io.github.jroy.advent.common.Utils;
import io.github.jroy.advent.common.graph.StandardGraph;

import java.io.IOException;

public class PartOne {

  public static void main(String[] args) throws IOException {
    StandardGraph graph = new StandardGraph(Utils.getDayInput());
    int modifications = -1;
    while (modifications != 0) {
      modifications = PartOne.applyMutation(graph, 4, false);
    }
    System.out.println("Solution: " + PartOne.countOccupied(graph));
  }

  public static int applyMutation(StandardGraph graph, int crowdCapacity, boolean useRaytracing) {
    StandardGraph clone = graph.cloneGraph(); //Base decisions on clone because the operation applies simultaneously.
    
    int y = 0;
    int modifications = 0;
    while (y < clone.getRowCount()) {
      int x = -1;
      for (char curChar : clone.getRow(y).toCharArray()) {
        x++;
        if (curChar == '.') {
          continue;
        }

        int adj = useRaytracing ? PartTwo.countAdjRay(x, y, clone) : countAdj(x, y, clone, '#');
        if (curChar == 'L') {
          if (adj == 0) {
            graph.setCharAt(x, y, '#');
            modifications++;
          }
        } else if (curChar == '#') {
          if (adj >= crowdCapacity) {
            graph.setCharAt(x, y, 'L');
            modifications++;
          }
        }
      }
      y++;
    }
    return modifications;
  }

  public static int countOccupied(StandardGraph graph) {
    int count = 0;
    for (int y = 0; y < graph.getRowCount(); y++) {
      for (char c : graph.getRow(y).toCharArray()) {
        if (c == '#') {
          count++;
        }
      }
    }
    return count;
  }

  private static int countAdj(int startX, int startY, StandardGraph graph, Character c) {
    int count = 0;

    //fuck you this is how im doing it
    if (c.equals(graph.getCharAt(startX + 1, startY))) {
      count++;
    }
    if (c.equals(graph.getCharAt(startX - 1, startY))) {
      count++;
    }
    if (c.equals(graph.getCharAt(startX, startY + 1))) {
      count++;
    }
    if (c.equals(graph.getCharAt(startX, startY - 1))) {
      count++;
    }
    if (c.equals(graph.getCharAt(startX + 1, startY + 1))) {
      count++;
    }
    if (c.equals(graph.getCharAt(startX - 1, startY - 1))) {
      count++;
    }
    if (c.equals(graph.getCharAt(startX - 1, startY + 1))) {
      count++;
    }
    if (c.equals(graph.getCharAt(startX + 1, startY - 1))) {
      count++;
    }

    return count;
  }
}
