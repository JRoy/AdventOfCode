package io.github.jroy.advent.twentytwenty.dayfour;

import io.github.jroy.advent.common.Utils;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.IOException;
import java.util.List;

public class PartTwo {
  private final static List<String> VALID_EYES = List.of("amb", "blu", "brn", "gry", "grn", "hzl", "oth");

  public static void main(String[] args) throws IOException {
    System.out.println("Solution: " + countValidPassports(PartOne.processPassportBatch(Utils.getDayInput())));
  }

  public static int countValidPassports(List<Passport> passports) {
    int valid = 0;
    for (Passport pa : passports) {
      //Year Checks
      if (isInvldNum(pa.get("byr"), 1920, 2002) || isInvldNum(pa.get("iyr"), 2010, 2020) || isInvldNum(pa.get("eyr"), 2020, 2030)) {
        continue;
      }

      //Height
      String hgt = pa.get("hgt");
      int len = hgt.length();
      boolean freedom = hgt.endsWith("in");
      if ((!freedom && !hgt.endsWith("cm")) || isInvldNum(hgt.substring(0, len-2), freedom ? 59 : 150, freedom ? 76 : 193)) { //no prefix, totally invalid
        continue;
      }

      //Hair Color
      if (!pa.get("hcl").matches("#[0-9a-f]{6}")) {
        continue;
      }

      //Eye Color
      if (!VALID_EYES.contains(pa.get("ecl"))) {
        continue;
      }

      //Passport ID
      if (pa.get("pid").length() != 9) {
        continue;
      }

      valid++;
    }
    return valid;
  }

  private static boolean isInvldNum(String input, int lowerBound, int upperBound) {
    int i = NumberUtils.toInt(input);
    return lowerBound > i || i > upperBound;
  }
}
