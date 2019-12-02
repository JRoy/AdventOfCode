package io.github.jroy.advent.twentynineteen.daytwo;

import io.github.jroy.advent.common.Utils;

import java.io.IOException;
import java.util.List;

public class PartTwo {

  public static void main(String[] args) throws IOException {
    List<Integer> code = PartOne.createIntCode(Utils.readResourceLines("twentynineteen/daytwo.input").get(0));
    for (int noun = 0; noun < 100; ++noun) {
      for (int verb = 0; verb < 100; ++verb) {
        code.set(1, noun);
        code.set(2, verb);
        if (PartOne.processIntCode(code).get(0).equals(19690720)) {
          System.out.println("Part Two Answer: " + (100 * noun + verb));
          System.exit(0);
        }
      }
    }
  }
}
