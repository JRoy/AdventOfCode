package io.github.jroy.advent.common.intcode.opcodes;

import io.github.jroy.advent.common.IndexedIterator;
import io.github.jroy.advent.common.intcode.Intcode;
import io.github.jroy.advent.common.intcode.ParameterMode;
import io.github.jroy.advent.common.intcode.model.OpCode;

import javax.swing.*;

public class OpCodeThree extends OpCode {

  public OpCodeThree() {
    super(3, 0);
  }

  @Override
  protected void onExecute(Intcode intcode, IndexedIterator<Long> inputs, long[] args, ParameterMode... modes) {
    long input = inputs.hasNext() ? inputs.next() : Long.parseLong(JOptionPane.showInputDialog(new JFrame("input"), "Input Requested"));
    if (modes[0] == ParameterMode.IMMEDIATE) {
      intcode.getIterator().replaceNext(input);
      return;
    }
    intcode.getCode().put(intcode.getIterator().next() + (modes[0] == ParameterMode.RELATIVE ? intcode.getRelativeBase() : 0L), input);
  }
}
