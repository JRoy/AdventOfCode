package io.github.jroy.advent.twentytwenty.dayseven;

import io.github.jroy.advent.common.Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartOne {

  public static void main(String[] args) throws IOException {
    System.out.println("Solution: " + countContainingBag("SHINY_GOLD", parseBagRules(Utils.getDayInput())));
  }

  public static int countContainingBag(String key, Map<String, BagRule> map) {
    int count = 0;
    for (Map.Entry<String, BagRule> entry : map.entrySet()) {
      if (entry.getValue().getContents().containsKey(key) || traverse(entry.getKey(), key, map)) {
        count++;
      }
    }
    return count;
  }

  private static boolean traverse(String key, String target, Map<String, BagRule> map) {
    for (String content : map.get(key).getContents().keySet()) {
      if (content.equals(target) || traverse(content, target, map)) {
        return true;
      }
    }
    return false;
  }

  public static Map<String, BagRule> parseBagRules(List<String> input) {
    Map<String, BagRule> bagRules = new HashMap<>();
    for (String str : input) {
      String[] tokens = str.split(" ");
      BagRule rule = new BagRule(tokens[0], tokens[1]);
      if (!str.trim().endsWith("contain no other bags.")) {
        String[] contents = str.replace(tokens[0] + " " + tokens[1] + " bags contain ", "").split(", ");
        for (String bag : contents) {
          String[] bagSplit = bag.split(" ");
          rule.addContent(bagSplit[1].toUpperCase() + "_" + bagSplit[2].toUpperCase().replace(".", ""), Integer.parseInt(bagSplit[0]));
        }
      }
      bagRules.put(rule.getKey(), rule);
    }
    return bagRules;
  }
}
