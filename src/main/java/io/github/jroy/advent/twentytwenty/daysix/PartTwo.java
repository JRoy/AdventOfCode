package io.github.jroy.advent.twentytwenty.daysix;

import io.github.jroy.advent.common.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartTwo {

  public static void main(String[] args) throws IOException {
    System.out.println("Solution: " + countUniqueGroupAnsweredQuestions(Utils.getDayInput()));
  }

  public static int countUniqueGroupAnsweredQuestions(List<String> input) {
    input = new ArrayList<>(input); //Input may be immutable
    input.add(""); // end of input may not have line break
    int total = 0;
    int personCount = 0;
    Map<Character, Integer> groupMap = new HashMap<>();
    for (String line : input) {
      if (line.trim().isEmpty()) {
        for (Map.Entry<Character, Integer> entry : groupMap.entrySet()) {
          if (entry.getValue().equals(personCount)) {
            total++;
          }
        }
        personCount = 0;
        groupMap.clear();
        continue;
      }

      personCount++;
      for (char ch : line.trim().toCharArray()) {
        groupMap.put(ch, groupMap.getOrDefault(ch, 0) + 1);
      }
    }
    return total;
  }
}
