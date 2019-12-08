package io.github.jroy.advent.twentynineteen.dayeight;

import io.github.jroy.advent.common.Utils;

import java.io.IOException;

public class PartTwo {

  public static void main(String[] args) throws IOException {
    System.out.println("Part Two Answer: ");
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 25; j++) {
        int c = 2;
        int layer = 0;
        while (c == 2) {
          int index = layer * (6 * 25) + i * 25 + j;
          c = Utils.readResourceLines("twentynineteen/dayeight.input").get(0).charAt(index) - '0';
          layer++;
        }
        System.out.print(c == 0 ? " " : "x");
      }
      System.out.println();
    }
  }
}
