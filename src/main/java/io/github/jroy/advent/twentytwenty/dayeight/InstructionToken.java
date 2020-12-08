package io.github.jroy.advent.twentytwenty.dayeight;

public class InstructionToken {
  private final PartOne.Instruction instruction;
  private final int value;

  public InstructionToken(PartOne.Instruction instruction, int value) {
    this.instruction = instruction;
    this.value = value;
  }

  public PartOne.Instruction getInstruction() {
    return instruction;
  }

  public int getValue() {
    return value;
  }
}
