package io.github.jroy.advent.twentynineteen.dayfive;

import io.github.jroy.advent.common.Utils;

import javax.swing.*;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PartOne {

  public static void main(String[] args) throws IOException {
    processIntCode(createIntCode(Utils.readResourceLines("twentynineteen/dayfive.input").get(0)));
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

  public static void processIntCode(List<Integer> code) throws InvalidObjectException {
    Iterator<Integer> iterator = code.iterator();
    int opCode;
    while (iterator.hasNext()) {
      boolean arg1Immediate = false;
      boolean arg2Immediate = false;
      opCode = iterator.next();
      char[] opCodeChars = String.valueOf(opCode).toCharArray();
      if (opCodeChars.length == 3) {
        opCode = Integer.parseInt(String.valueOf(opCode).substring(1));
        arg1Immediate = opCodeChars[0] == '1';
      } else if (opCodeChars.length == 4) {
        opCode = Integer.parseInt(String.valueOf(opCode).substring(2));
        arg1Immediate = opCodeChars[1] == '1';
        arg2Immediate = opCodeChars[0] == '1';
      }
      if (opCode == 1) {
        int arg1 = arg1Immediate ? iterator.next() : code.get(iterator.next());
        int arg2 = arg2Immediate ? iterator.next() : code.get(iterator.next());
        code.set(iterator.next(), arg1 + arg2);
      } else if (opCode == 2) {
        int arg1 = arg1Immediate ? iterator.next() : code.get(iterator.next());
        int arg2 = arg2Immediate ? iterator.next() : code.get(iterator.next());
        code.set(iterator.next(), arg1 * arg2);
      } else if (opCode == 3) {
        code.set(iterator.next(), Integer.parseInt(JOptionPane.showInputDialog(new JFrame("input"), "Input Requested")));
      } else if (opCode == 4) {
        System.out.println("Output Provided: " + code.get(iterator.next()));
      } else if (opCode == 99) {
        return;
      } else {
        throw new InvalidObjectException("Invalid OP-Code: " + opCode + "\n" + code);
      }
    }
    System.out.println("Didn't receive exit op-code!");
  }
}
