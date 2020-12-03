package io.github.jroy.advent.twentytwenty.daytwo;

import io.github.jroy.advent.common.Utils;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PartOne {

  protected final static Pattern PASSWORD_POLICY_PATTERN = Pattern.compile("(\\d+)-(\\d+) (\\S): (\\w+)");

  public static void main(String[] args) throws IOException {
    int valid = 0;
    for (String policy : Utils.getDayInput()) {
      Matcher matcher = PASSWORD_POLICY_PATTERN.matcher(policy);
      if (!matcher.matches()) {
        System.out.println("Invalid policy string: \"" + policy + "\"");
        continue;
      }

      if (isValidPassword(matcher.group(4), matcher.group(3).charAt(0), Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)))) {
        valid ++;
      }
    }

    System.out.println("Solution: " + valid);
  }

  /**
   * Counts freq. of char in string.
   */
  public static boolean isValidPassword(String password, char requiredChar, int minFrequency, int maxFrequency) {
    int freq = 0;
    for (char c : password.toCharArray()) {
      if (c == requiredChar) {
        freq++;
        if (freq > maxFrequency) {
          return false;
        }
      }
    }
    return freq >= minFrequency;
  }
}
