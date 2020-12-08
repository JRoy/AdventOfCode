package io.github.jroy.advent.twentytwenty.dayeight;

import io.github.jroy.advent.common.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PartOne {

  public static void main(String[] args) throws IOException {
    System.out.println("Solution: " + executeBootCode(parseBootCode(Utils.getDayInput()), true));
  }

  public static int executeBootCode(List<InstructionToken> instructions, boolean disableLoopJumps) {
    int register = 0;
    List<Integer> executedIndex = new ArrayList<>();
    for (int i = 0; i < instructions.size();) {
      if (disableLoopJumps && executedIndex.contains(i)) {
        return register;
      }
      executedIndex.add(i);

      InstructionToken token = instructions.get(i);
      switch (token.getInstruction()) {
        case ACC: {
          register += token.getValue();
          break;
        }
        case JMP: {
          i += token.getValue();
          continue;
        }
        case NOP: {
          break;
        }
      }
      i++;
    }
    return register;
  }

  public static List<InstructionToken> parseBootCode(List<String> input) {
    List<InstructionToken> tokens = new ArrayList<>();
    for (String line : input) {
      String[] split = line.split(" ");
      tokens.add(new InstructionToken(Instruction.valueOf(split[0].toUpperCase()), Integer.parseInt(split[1])));
    }
    return tokens;
  }

  public enum Instruction {
    ACC,
    JMP,
    NOP
  }
}
