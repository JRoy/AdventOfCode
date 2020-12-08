package io.github.jroy.advent.twentytwenty.dayeight;

import io.github.jroy.advent.common.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PartTwo {

  public static void main(String[] args) throws IOException {
    System.out.println("Solution: " + executeBootCode(PartOne.parseBootCode(Utils.getDayInput())));
  }

  public static int executeBootCode(List<InstructionToken> instructions) {
    int register = 0;
    int index = 0;
    HashSet<Integer> executed = new HashSet<>();

    while (index < instructions.size()) {
      InstructionToken token = instructions.get(index);
      switch (token.getInstruction()) {
        case ACC: {
          register += token.getValue();
          index++;
          break;
        }
        case JMP: {
          List<InstructionToken> attemptFixInstructions = new ArrayList<>(instructions);
          attemptFixInstructions.set(index, new InstructionToken(PartOne.Instruction.NOP, token.getValue()));
          Integer fixResult = attemptFix(attemptFixInstructions, index, register, new HashSet<>(executed));
          if (fixResult != null) {
            return fixResult;
          }
          index += token.getValue();
          break;
        }
        case NOP: {
          List<InstructionToken> attemptFixInstructions = new ArrayList<>(instructions);
          attemptFixInstructions.set(index, new InstructionToken(PartOne.Instruction.JMP, token.getValue()));
          Integer fixResult = attemptFix(attemptFixInstructions, index, register, new HashSet<>(executed));
          if (fixResult != null) {
            return fixResult;
          }
          index++;
          break;
        }
      }
    }
    return register;
  }

  private static Integer attemptFix(List<InstructionToken> instructions, int index, int register, HashSet<Integer> executed) {
    boolean continueWalk = true;
    while (continueWalk && index < instructions.size()) {
      InstructionToken token = instructions.get(index);
      switch (token.getInstruction()) {
        case ACC: {
          register += token.getValue();
          index++;
          break;
        }
        case JMP: {
          index += token.getValue();
          break;
        }
        case NOP: {
          index++;
          break;
        }
      }
      continueWalk = executed.add(index);
    }
    return continueWalk ? register : null;
  }
}
