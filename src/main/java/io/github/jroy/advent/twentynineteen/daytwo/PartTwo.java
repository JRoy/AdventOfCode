package io.github.jroy.advent.twentynineteen.daytwo;

import io.github.jroy.advent.common.Utils;
import io.github.jroy.advent.common.intcode.Intcode;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.util.HashMap;

public class PartTwo {

  public static void main(String[] args) throws IOException {
    HashMap<Long, Long> code = Intcode.createIntCode(Utils.readResourceLines("twentynineteen/daytwo.input").get(0));
    for (long noun = 0L; noun < 100; ++noun) {
      for (long verb = 0L; verb < 100; ++verb) {
        HashMap<Long, Long> caseCode = new HashMap<>(code);
        caseCode.put(1L, noun);
        caseCode.put(2L, verb);
        try {
          Intcode intcode = new Intcode(caseCode);
          intcode.execute();
          if (intcode.getCode().get(0L).equals(19690720L)) {
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
