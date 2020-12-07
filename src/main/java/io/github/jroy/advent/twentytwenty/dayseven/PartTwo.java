package io.github.jroy.advent.twentytwenty.dayseven;

import io.github.jroy.advent.common.Utils;

import java.io.IOException;
import java.util.Map;

public class PartTwo {

  public static void main(String[] args) throws IOException {
    System.out.println("Solution: " + countTotalBags("SHINY_GOLD", PartOne.parseBagRules(Utils.getDayInput())));
  }

  public static int countTotalBags(String key, Map<String, BagRule> map) {
    int total = 0;
    for (Map.Entry<String, Integer> entry : map.get(key).getContents().entrySet()) {
      total += (entry.getValue() * (countTotalBags(entry.getKey(), map) + 1));
    }
    return total;
  }
}
