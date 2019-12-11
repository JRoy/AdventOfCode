package io.github.jroy.advent.common.intcode.opcodes;

import io.github.jroy.advent.common.IndexedIterator;
import io.github.jroy.advent.common.intcode.Intcode;
import io.github.jroy.advent.common.intcode.ParameterMode;
import io.github.jroy.advent.common.intcode.model.OpCode;

public class OpCodeNine extends OpCode {

  public OpCodeNine() {
    super(9, 1);
  }

  @Override
  protected void onExecute(Intcode intcode, IndexedIterator<Long> inputs, long[] args, ParameterMode... modes) {
    intcode.setRelativeBase(intcode.getRelativeBase() + args[0]);
  }
}
