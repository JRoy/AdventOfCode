package io.github.jroy.advent.twentynineteen.dayseven;

import io.github.jroy.advent.common.Utils;
import io.github.jroy.advent.common.intcode.Intcode;
import org.apache.commons.collections4.iterators.PermutationIterator;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PartOne {

  public static void main(String[] args) throws IOException {
    int answer = 0;
    List<Integer> code = io.github.jroy.advent.twentynineteen.dayfive.PartOne.createIntCode(Utils.readResourceLines("twentynineteen/dayseven.input").get(0));
    PermutationIterator<Integer> perms = new PermutationIterator<>(Arrays.asList(0, 1, 2, 3, 4));
    while (perms.hasNext()) {
      List<Integer> curPerm = perms.next();
      int result = new Intcode(code).execute(curPerm.get(4),
          new Intcode(code).execute(curPerm.get(3),
              new Intcode(code).execute(curPerm.get(2),
                  new Intcode(code).execute(curPerm.get(1),
                      new Intcode(code).execute(curPerm.get(0), 0).get(0)).get(0)).get(0)).get(0)).get(0);
      if (result > answer) {
        answer = result;
      }
    }
    System.out.println("Part One Answer: " + answer);
    System.exit(0);
  }
}
