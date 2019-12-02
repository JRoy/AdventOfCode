package io.github.jroy.advent.twentynineteen.daytwo;

import io.github.jroy.advent.common.Utils;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PartOne {

  public static void main(String[] args) throws IOException {
    System.out.println("Part One Answer: " + processIntCode(createIntCode(Utils.readResourceLines("twentynineteen/daytwo.input").get(0))).get(0));
  }

  public static List<Integer> createIntCode(String string) {
    List<Integer> code = new ArrayList<>();
    for (String curString : string.split(",")) {
      try {
        code.add(Integer.parseInt(curString));
      } catch (NumberFormatException e) {
        System.out.println("Invalid OP-Code: " + curString);
      }
    }
    return code;
  }

  public static List<Integer> processIntCode(List<Integer> code) throws InvalidObjectException {
    Iterator<Integer> iterator = code.iterator();
    int opCode;
    while (iterator.hasNext()) {
      opCode = iterator.next();
      if (opCode == 1) {
        int arg1 = code.get(iterator.next());
        int arg2 = code.get(iterator.next());
        code.set(iterator.next(), arg1 + arg2);
      } else if (opCode == 2) {
        int arg1 = code.get(iterator.next());
        int arg2 = code.get(iterator.next());
        code.set(iterator.next(), arg1 * arg2);
      } else if (opCode == 99) {
        return code;
      } else {
        throw new InvalidObjectException("Invalid OP-Code: " + opCode);
      }
    }
    System.out.println("Didn't receive exit op-code!");
    return code;
  }
}
