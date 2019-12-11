package io.github.jroy.advent.twentynineteen.dayfive;

import io.github.jroy.advent.common.Utils;
import io.github.jroy.advent.common.intcode.Intcode;

import java.io.IOException;

public class PartTwo {

  public static void main(String[] args) throws IOException {
    System.out.println("Part Two Answer: " + new Intcode(Utils.readResourceLines("twentynineteen/dayfive.input").get(0)).execute(5L).get(0));
    System.exit(0);
  }
}
