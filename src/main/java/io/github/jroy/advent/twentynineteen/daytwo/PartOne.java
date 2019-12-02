package io.github.jroy.advent.twentynineteen.daytwo;

import io.github.jroy.advent.common.Utils;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PartOne {

  public static void main(String[] args) throws IOException {
    for (String line : Utils.readResourceLines("twentynineteen/daytwo.input")) {
      StringBuilder builder = new StringBuilder();
      for (Integer curResult : processIntCode(createIntCode(line))) {
        builder.append(curResult).append(',');
      }
      System.out.println(builder);
    }
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
    List<Integer> outputCode = new ArrayList<>(code);
    Collections.copy(outputCode, code);
    Iterator<Integer> iterator = code.iterator();
    int opCode;
    while (iterator.hasNext()) {
      opCode = iterator.next();
      if (opCode == 1) {
        int arg1 = outputCode.get(iterator.next());
        int arg2 = outputCode.get(iterator.next());
        outputCode.set(iterator.next(), arg1 + arg2);
      } else if (opCode == 2) {
        int arg1 = outputCode.get(iterator.next());
        int arg2 = outputCode.get(iterator.next());
        outputCode.set(iterator.next(), arg1 * arg2);
      } else if (opCode == 99) {
        return outputCode;
      } else {
        throw new InvalidObjectException("Invalid OP-Code: " + opCode);
      }
    }
    System.out.println("Didn't receive exit op-code!");
    return outputCode;
  }
}
