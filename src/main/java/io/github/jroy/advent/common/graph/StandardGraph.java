package io.github.jroy.advent.common.graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;

public class StandardGraph {
  private final HashMap<Integer, String> graphMap = new HashMap<>();

  public StandardGraph(Collection<String> input) {
    int x = 0;
    for (String str : input) {
      graphMap.put(x, str);
      x++;
    }
  }

  public Character getCharAt(int x, int y) {
    if (0 > y || y >= getRowCount()) {
      return null;
    }
    String line = graphMap.get(y);
    if (0 > x || x>= line.length()) {
      return null;
    }
    return line.charAt(x);
  }

  public String getRow(int y) {
    return graphMap.get(y);
  }

  public void setCharAt(int x, int y, char newChar) {
    char[] line = graphMap.get(y).toCharArray();
    line[x] = newChar;
    graphMap.put(y, String.valueOf(line));
  }

  public int getRowCount() {
    return graphMap.size();
  }

  public StandardGraph cloneGraph() {
    return new StandardGraph(graphMap.values());
  }

  public void printGraph() {
    System.out.println("=".repeat(graphMap.size() > 0 ? graphMap.get(0).length() : 1));
    for (String line : graphMap.values()) {
      System.out.println(line);
    }
    System.out.println("=".repeat(graphMap.size() > 0 ? graphMap.get(0).length() : 1));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    StandardGraph graph = (StandardGraph) o;
    return Objects.equals(graphMap, graph.graphMap);
  }
}
