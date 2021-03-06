package io.github.jroy.advent.twentynineteen.dayfive;

import io.github.jroy.advent.common.Utils;
import io.github.jroy.advent.common.intcode.Intcode;

import java.io.IOException;

public class PartOne {

  public static void main(String[] args) throws IOException {
    System.out.println("Part One Answer: " + new Intcode(Utils.readResourceLines("twentynineteen/dayfive.input").get(0)).execute(1L).get(9));
    System.exit(0);
  }
}
