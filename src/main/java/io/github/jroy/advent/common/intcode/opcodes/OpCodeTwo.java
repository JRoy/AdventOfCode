package io.github.jroy.advent.common.intcode.opcodes;

import io.github.jroy.advent.common.IndexedIterator;
import io.github.jroy.advent.common.intcode.Intcode;
import io.github.jroy.advent.common.intcode.ParameterMode;
import io.github.jroy.advent.common.intcode.model.OpCode;

public class OpCodeTwo extends OpCode {

  public OpCodeTwo() {
    super(2, 2);
  }

  @Override
  protected void onExecute(Intcode intcode, IndexedIterator<Long> inputs, long[] args, ParameterMode... modes) {
    if (modes[2] == ParameterMode.IMMEDIATE) {
      intcode.getIterator().replaceNext(args[0] * args[1]);
      return;
    }
    intcode.getCode().put(intcode.getIterator().next() + (modes[2] == ParameterMode.RELATIVE ? intcode.getRelativeBase() : 0L), args[0] * args[1]);
  }
}
