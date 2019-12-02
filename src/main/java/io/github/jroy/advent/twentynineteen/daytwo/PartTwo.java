package io.github.jroy.advent.twentynineteen.daytwo;

import io.github.jroy.advent.common.Utils;

import java.io.IOException;
import java.util.List;

public class PartTwo {

  public static void main(String[] args) throws IOException {
    for (String line : Utils.readResourceLines("twentynineteen/daytwo.input")) {
      List<Integer> code = PartOne.createIntCode(line);
      for(int noun = 0; noun < 100; ++noun) {
        for(int verb = 0; verb < 100; ++verb) {
          code.set(1, noun);
          code.set(2, verb);
          if (PartOne.processIntCode(code).get(0).equals(19690720)) {
            System.out.println("Answer is: " + (100 * noun + verb));
            System.exit(0);
          }
        }
      }
    }
  }
}
