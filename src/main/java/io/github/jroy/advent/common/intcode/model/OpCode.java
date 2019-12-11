package io.github.jroy.advent.common.intcode.model;

import io.github.jroy.advent.common.IndexedIterator;
import io.github.jroy.advent.common.intcode.Intcode;
import io.github.jroy.advent.common.intcode.ParameterMode;

public abstract class OpCode {

  private final int code;
  private final int args;

  public OpCode(int code, int args) {
    this.code = code;
    if (args > 3 || args < 0) {
      throw new IllegalArgumentException("Invalid amount of arguments");
    }
    this.args = args;
  }

  public final void execute(Intcode intcode, IndexedIterator<Long> inputs, ParameterMode... modes) {
    long[] args = new long[this.args];
    for (int i = 0; i < this.args; i++) {
      ParameterMode mode = modes.length <= i ? null : modes[i];
      if (Intcode.isDebugMode()) {
        System.out.println("[Debug] Parsing argument `" + i + "` with mode `" + (mode == null ? "null" : mode.name()) + "`");
      }
      long curArg;
      if (mode == ParameterMode.IMMEDIATE) {
        curArg = intcode.getIterator().next();
      } else if (mode == ParameterMode.RELATIVE) {
        long relBase = intcode.getRelativeBase();
        long nextIndex = intcode.getIterator().next();
        if (Intcode.isDebugMode()) {
          System.out.println("[Debug] Current Relative Base: " + relBase);
          System.out.println("[Debug] Next Index: " + nextIndex);
        }
        curArg = intcode.getCode().computeIfAbsent(nextIndex + relBase, f -> 0L);
      } else {
        long nextIndex = intcode.getIterator().next();
        if (Intcode.isDebugMode()) {
          System.out.println("[Debug] Next Index: " + nextIndex);
        }
        curArg = intcode.getCode().computeIfAbsent(nextIndex, f -> 0L);
      }
      if (Intcode.isDebugMode()) {
        System.out.println("[Debug] Argument value resolved as " + curArg);
      }

      args[i] = curArg;

//      args[i] = mode == ParameterMode.IMMEDIATE ? intcode.getIterator().next() :
//          intcode.getCode().get(intcode.getIterator().next() + (mode == ParameterMode.RELATIVE ? intcode.getRelativeBase() : 0L));
    }
    onExecute(intcode, inputs, args, modes);
  }

  protected abstract void onExecute(Intcode intcode, IndexedIterator<Long> inputs, long[] args, ParameterMode... modes);

  public int getCode() {
    return code;
  }
}
