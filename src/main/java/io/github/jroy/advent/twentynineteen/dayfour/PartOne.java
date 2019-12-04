package io.github.jroy.advent.twentynineteen.dayfour;

import io.github.jroy.advent.common.Utils;

import java.io.IOException;

public class PartOne {

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
    System.out.println("Part One Answer: " + goodPasswords);
  }

  public static boolean isGoodPassword(int password) {
    int lastInt = -1;
    String pass = String.valueOf(password);
    if (pass.length() != 6) {
      return false;
    }
    boolean adjacentDigits = false;
    for (char curChar : pass.toCharArray()) {
      int curInt = Integer.parseInt(String.valueOf(curChar));
      if (curInt < lastInt) {
        return false;
      } else if (curInt == lastInt) {
        adjacentDigits = true;
      }
      lastInt = curInt;
    }
    return adjacentDigits;
  }
}
