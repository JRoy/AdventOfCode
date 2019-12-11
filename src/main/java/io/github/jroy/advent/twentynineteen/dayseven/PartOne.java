package io.github.jroy.advent.twentynineteen.dayseven;

import io.github.jroy.advent.common.Utils;
import io.github.jroy.advent.common.intcode.Intcode;
import org.apache.commons.collections4.iterators.PermutationIterator;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PartOne {

  public static void main(String[] args) throws IOException {
    long answer = 0;
    HashMap<Long, Long> code = Intcode.createIntCode(Utils.readResourceLines("twentynineteen/dayseven.input").get(0));
    PermutationIterator<Long> perms = new PermutationIterator<>(Arrays.asList(Integer.valueOf(0).longValue(), Integer.valueOf(1).longValue(), Integer.valueOf(2).longValue(), Integer.valueOf(3).longValue(), Integer.valueOf(4).longValue()));
    while (perms.hasNext()) {
      List<Long> curPerm = perms.next();
      long result = new Intcode(code).execute(curPerm.get(4),
          new Intcode(code).execute(curPerm.get(3),
              new Intcode(code).execute(curPerm.get(2),
                  new Intcode(code).execute(curPerm.get(1),
                      new Intcode(code).execute(curPerm.get(0), (long) 0).get(0)).get(0)).get(0)).get(0)).get(0);
      if (result > answer) {
        answer = result;
      }
    }
    System.out.println("Part One Answer: " + answer);
    System.exit(0);
  }
}
