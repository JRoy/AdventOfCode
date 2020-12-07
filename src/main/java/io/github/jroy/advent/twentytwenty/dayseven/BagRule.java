package io.github.jroy.advent.twentytwenty.dayseven;

import java.util.HashMap;
import java.util.Map;

public class BagRule {
  private final String parentAdjective;
  private final String parentColor;
  private final Map<String, Integer> contents = new HashMap<>();

  public BagRule(String parentAdjective, String parentColor) {
    this.parentAdjective = parentAdjective;
    this.parentColor = parentColor;
  }

  public void addContent(String key, int quantity) {
    contents.put(key, quantity);
  }

  public String getKey() {
    return parentAdjective.toUpperCase() + "_" + parentColor.toUpperCase();
  }

  public Map<String, Integer> getContents() {
    return contents;
  }

  public int getTotalContents() {
    return contents.values().stream().mapToInt(Integer::intValue).sum();
  }
}
