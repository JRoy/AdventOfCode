package io.github.jroy.advent.common.intcode.opcodes;

import io.github.jroy.advent.common.IndexedIterator;
import io.github.jroy.advent.common.intcode.Intcode;
import io.github.jroy.advent.common.intcode.ParameterMode;
import io.github.jroy.advent.common.intcode.model.OpCode;

public class OpCodeFive extends OpCode {

  public OpCodeFive() {
    super(5, 2);
  }

  @Override
  protected void onExecute(Intcode intcode, IndexedIterator<Long> inputs, long[] args, ParameterMode... modes) {
    if (args[0] == 0L) {
      return;
    }
    intcode.getIterator().setIndex(args[1]);
  }
}
