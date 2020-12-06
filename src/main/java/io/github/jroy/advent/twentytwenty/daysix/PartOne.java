package io.github.jroy.advent.twentytwenty.daysix;

import io.github.jroy.advent.common.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PartOne {

  public static void main(String[] args) throws IOException {
    System.out.println("Solution: " + countGroupAnsweredQuestions(Utils.getDayInput()));
  }

  public static int countGroupAnsweredQuestions(List<String> input) {
    int total = 0;
    List<Character> groupChars = new ArrayList<>();
    for (String line : input) {
      if (line.trim().isEmpty()) {
        groupChars.clear();
      }
      for (char ch : line.trim().toCharArray()) {
        if (!groupChars.contains(ch)) {
          total++;
          groupChars.add(ch);
        }
      }
    }
    return total;
  }
}
