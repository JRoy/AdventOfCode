package io.github.jroy.advent.twentytwenty.dayone;

import io.github.jroy.advent.common.Utils;

import java.io.IOException;
import java.util.List;

public class PartTwo {

  public static void main(String[] args) throws IOException {
    List<String> input = Utils.getDayInput();
    for (String str : input) {
      for (String str2 : input) {
        for (String str3 : input) {
          int i = Integer.parseInt(str);
          int i2 = Integer.parseInt(str2);
          int i3 = Integer.parseInt(str3);
          if (i + i2 + i3 == 2020) {
            System.out.println("Solution: " + i * i2 * i3);
            return;
          }
        }
      }
    }
  }
}
