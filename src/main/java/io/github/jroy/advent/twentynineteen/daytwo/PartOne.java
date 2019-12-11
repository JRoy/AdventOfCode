package io.github.jroy.advent.twentynineteen.daytwo;

import io.github.jroy.advent.common.Utils;
import io.github.jroy.advent.common.intcode.Intcode;

import java.io.IOException;

public class PartOne {

  public static void main(String[] args) throws IOException {
    Intcode intcode = new Intcode(Utils.readResourceLines("twentynineteen/daytwo.input").get(0));
    intcode.execute();
    System.out.println("Part One Answer: " + intcode.getCode().get(0L));
  }
}
