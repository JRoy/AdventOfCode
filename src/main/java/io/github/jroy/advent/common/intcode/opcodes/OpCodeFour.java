package io.github.jroy.advent.common.intcode.opcodes;

import io.github.jroy.advent.common.IndexedIterator;
import io.github.jroy.advent.common.intcode.Intcode;
import io.github.jroy.advent.common.intcode.ParameterMode;
import io.github.jroy.advent.common.intcode.model.OpCode;

public class OpCodeFour extends OpCode {

  public OpCodeFour() {
    super(4, 1);
  }

  @Override
  protected void onExecute(Intcode intcode, IndexedIterator<Long> inputs, long[] args, ParameterMode... modes) {
    intcode.getOutputs().add(args[0]);
    System.out.println("Output Provided: " + args[0]);
  }
}
