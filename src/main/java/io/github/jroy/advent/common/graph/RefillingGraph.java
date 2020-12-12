package io.github.jroy.advent.common.graph;

import java.util.HashMap;
import java.util.List;

public class RefillingGraph {

  private final HashMap<Integer, String> graphMap = new HashMap<>();

  public RefillingGraph(List<String> input) {
    int x = 0;
    for (String str : input) {
      graphMap.put(x, str);
      x++;
    }
  }

  public char getCharAt(int x, int y) {
    String line = graphMap.get(y);
    return line.charAt(x%line.length());
  }

  public int getRowCount() {
    return graphMap.size();
  }
}
