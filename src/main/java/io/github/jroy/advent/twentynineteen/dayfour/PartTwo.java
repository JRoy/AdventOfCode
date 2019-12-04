package io.github.jroy.advent.twentynineteen.dayfour;

import io.github.jroy.advent.common.Utils;

import java.io.IOException;
import java.util.regex.Pattern;

public class PartTwo {

  private static final Pattern pattern = Pattern.compile("(?<!(\\d)(?=\\1))(\\d)\\2(?!\\2)");

  @SuppressWarnings("DuplicatedCode")
  public static void main(String[] args) throws IOException {
    String input = Utils.readResourceLines("twentynineteen/dayfour.input").get(0);
    int min = Integer.parseInt(input.split("-")[0]);
    int max = Integer.parseInt(input.split("-")[1]);
    int goodPasswords = 0;
    while (min != max) {
      if (isGoodPassword(min)) {
        goodPasswords++;
      }
      min++;
    }
    System.out.println("Part Two Answer: " + goodPasswords);
  }

  public static boolean isGoodPassword(int password) {
    return PartOne.isGoodPassword(password) && pattern.matcher(String.valueOf(password)).find();
  }
}
