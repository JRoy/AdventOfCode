package io.github.jroy.advent.twentytwenty.daytwo;

import io.github.jroy.advent.common.Utils;

import java.io.IOException;
import java.util.regex.Matcher;

import static io.github.jroy.advent.twentytwenty.daytwo.PartOne.PASSWORD_POLICY_PATTERN;

public class PartTwo {

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
   * Preforms {@link String#charAt(int)} (int)} checks on str.
   */
  public static boolean isValidPassword(String password, char targetChar, int index1, int index2) {
    boolean pass = false;
    if (password.length() >= index1) {
      pass = password.charAt(index1 - 1) == targetChar;
    }

    if (password.length() >= index2 && password.charAt(index2 - 1) == targetChar) {
      return !pass; // Both chars cannot match for the password to be valid!
    }

    return pass;
  }
}
