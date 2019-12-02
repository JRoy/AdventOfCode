package io.github.jroy.advent.twentynineteen.daytwo;

import io.github.jroy.advent.common.Utils;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.List;

public class PartTwo {

  public static void main(String[] args) throws IOException {
    List<Integer> code = PartOne.createIntCode(Utils.readResourceLines("twentynineteen/daytwo.input").get(0));
    for (int noun = 0; noun < 100; ++noun) {
      for (int verb = 0; verb < 100; ++verb) {
        List<Integer> caseCode = new ArrayList<>(code);
        caseCode.set(1, noun);
        caseCode.set(2, verb);
        try {
          if (PartOne.processIntCode(caseCode).get(0).equals(19690720)) {
            System.out.println("Part Two Answer: " + (100 * noun + verb));
            System.exit(0);
          }
        } catch (InvalidObjectException ignored) {
          //This noun and verb pair produces invalid Intcode
        }
      }
    }
  }
}
