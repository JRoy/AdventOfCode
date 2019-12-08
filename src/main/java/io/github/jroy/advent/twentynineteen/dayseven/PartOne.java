package io.github.jroy.advent.twentynineteen.dayseven;

import io.github.jroy.advent.common.IndexedIterator;
import io.github.jroy.advent.common.Utils;
import org.apache.commons.collections4.iterators.PermutationIterator;

import javax.swing.*;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartOne {

  public static void main(String[] args) throws IOException {
    int answer = 0;
    List<Integer> code = io.github.jroy.advent.twentynineteen.dayfive.PartOne.createIntCode(Utils.readResourceLines("twentynineteen/dayseven.input").get(0));
    PermutationIterator<Integer> perms = new PermutationIterator<>(Arrays.asList(0, 1, 2, 3, 4));
    while (perms.hasNext()) {
      List<Integer> curPerm = perms.next();
      int result = processIntCode(code, curPerm.get(4),
          processIntCode(code, curPerm.get(3),
              processIntCode(code, curPerm.get(2),
                  processIntCode(code, curPerm.get(1),
                      processIntCode(code, curPerm.get(0), 0).get(0)).get(0)).get(0)).get(0)).get(0);
      if (result > answer) {
        answer = result;
      }
    }
    System.out.println("Part One Answer: " + answer);
    System.exit(0);
  }

  public static List<Integer> processIntCode(List<Integer> code, Integer... inputs) throws InvalidObjectException {
    List<Integer> outputs = new ArrayList<>();
    IndexedIterator<Integer> iterator = new IndexedIterator<>(code);
    IndexedIterator<Integer> inputsIterator = new IndexedIterator<>(Arrays.asList(inputs));
    int opCode;
    while (iterator.hasNext()) {
      boolean arg1Immediate = false;
      boolean arg2Immediate = false;
      boolean arg3Immediate = false;
      opCode = iterator.next();
      char[] opCodeChars = String.valueOf(opCode).toCharArray();
      if (opCodeChars.length == 3) {
        opCode = Integer.parseInt(String.valueOf(opCode).substring(1));
        arg1Immediate = opCodeChars[0] == '1';
      } else if (opCodeChars.length == 4) {
        opCode = Integer.parseInt(String.valueOf(opCode).substring(2));
        arg1Immediate = opCodeChars[1] == '1';
        arg2Immediate = opCodeChars[0] == '1';
      } else if (opCodeChars.length == 5) {
        opCode = Integer.parseInt(String.valueOf(opCode).substring(3));
        arg1Immediate = opCodeChars[2] == '1';
        arg2Immediate = opCodeChars[1] == '1';
        arg3Immediate = opCodeChars[0] == '1';
      }
      if (opCode == 1) {
        int arg1 = arg1Immediate ? iterator.next() : code.get(iterator.next());
        int arg2 = arg2Immediate ? iterator.next() : code.get(iterator.next());
        if (arg3Immediate) {
          iterator.replaceNext(arg1 + arg2);
          continue;
        }
        code.set(iterator.next(), arg1 + arg2);
      } else if (opCode == 2) {
        int arg1 = arg1Immediate ? iterator.next() : code.get(iterator.next());
        int arg2 = arg2Immediate ? iterator.next() : code.get(iterator.next());
        if (arg3Immediate) {
          iterator.replaceNext(arg1 * arg2);
          continue;
        }
        code.set(iterator.next(), arg1 * arg2);
      } else if (opCode == 3) {
        int input = inputsIterator.hasNext() ? inputsIterator.next() : Integer.parseInt(JOptionPane.showInputDialog(new JFrame("input"), "Input Requested"));
        if (arg1Immediate) {
          iterator.replaceNext(input);
        }
        code.set(iterator.next(), input);
      } else if (opCode == 4) {
        int output = (arg1Immediate ? iterator.next() : code.get(iterator.next()));
        outputs.add(output);
        System.out.println("Output Provided: " + output);
      } else if (opCode == 5) {
        int arg1 = arg1Immediate ? iterator.next() : code.get(iterator.next());
        int arg2 = arg2Immediate ? iterator.next() : code.get(iterator.next());
        if (arg1 == 0) {
          continue;
        }
        iterator.setIndex(arg2);
      } else if (opCode == 6) {
        int arg1 = arg1Immediate ? iterator.next() : code.get(iterator.next());
        int arg2 = arg2Immediate ? iterator.next() : code.get(iterator.next());
        if (arg1 != 0) {
          continue;
        }
        iterator.setIndex(arg2);
      } else if (opCode == 7) {
        int arg1 = arg1Immediate ? iterator.next() : code.get(iterator.next());
        int arg2 = arg2Immediate ? iterator.next() : code.get(iterator.next());
        int result = arg1 < arg2 ? 1 : 0;
        if (arg3Immediate) {
          iterator.replaceNext(result);
          continue;
        }
        code.set(iterator.next(), result);
      } else if (opCode == 8) {
        @SuppressWarnings("DuplicatedCode") int arg1 = arg1Immediate ? iterator.next() : code.get(iterator.next());
        int arg2 = arg2Immediate ? iterator.next() : code.get(iterator.next());
        int result = arg1 == arg2 ? 1 : 0;
        if (arg3Immediate) {
          iterator.replaceNext(result);
          continue;
        }
        code.set(iterator.next(), result);
      } else if (opCode == 99) {
        return outputs;
      } else {
        throw new InvalidObjectException("Invalid OP-Code: " + opCode + "\n" + code);
      }
    }
    System.out.println("Didn't receive exit op-code!");
    return outputs;
  }
}
