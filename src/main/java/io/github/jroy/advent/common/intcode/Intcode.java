package io.github.jroy.advent.common.intcode;

import io.github.jroy.advent.common.IndexedIterator;

import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Intcode {

  private static boolean debugMode = false;

  private HashMap<Long, Long> code;
  private final IndexedIterator<Long> iterator;
  private long relativeBase = 0L;

  private List<Long> outputs = new ArrayList<>();

  public Intcode(String input) {
    this(createIntCode(input));
  }

  public Intcode(HashMap<Long, Long> code) {
    this.code = code;
    this.iterator = new IndexedIterator<>(code);
    this.iterator.setDefaultValue(0L);
  }

  public List<Long> execute() throws InvalidObjectException {
    return execute(new ArrayList<>());
  }

  public List<Long> execute(Long... inputs) throws InvalidObjectException {
    return execute(Arrays.asList(inputs));
  }

  public List<Long> execute(List<Long> inputs) throws InvalidObjectException {
    outputs.clear();
    IndexedIterator<Long> inputsIterator = new IndexedIterator<>(inputs);

    while (iterator.hasNext()) {
      //Parse OP-Code and Parameter Modes
      ParameterMode arg1Mode = ParameterMode.NORMAL;
      ParameterMode arg2Mode = ParameterMode.NORMAL;
      ParameterMode arg3Mode = ParameterMode.NORMAL;
      int opCode = iterator.next().intValue();
      char[] opCodeChars = String.valueOf(opCode).toCharArray();
      if (opCodeChars.length == 3) {
        opCode = Integer.parseInt(String.valueOf(opCode).substring(1));
        arg1Mode = extractParameterMode(opCodeChars[0]);
      } else if (opCodeChars.length == 4) {
        opCode = Integer.parseInt(String.valueOf(opCode).substring(2));
        arg1Mode = extractParameterMode(opCodeChars[1]);
        arg2Mode = extractParameterMode(opCodeChars[0]);
      } else if (opCodeChars.length == 5) {
        opCode = Integer.parseInt(String.valueOf(opCode).substring(3));
        arg1Mode = extractParameterMode(opCodeChars[2]);
        arg2Mode = extractParameterMode(opCodeChars[1]);
        arg3Mode = extractParameterMode(opCodeChars[0]);
      }

      //Execute OP Codes
      if (opCode == 99) {
        return outputs;
      }

      if (!OpCodes.getCodes().containsKey(opCode)) {
        throw new InvalidObjectException("Invalid OP-Code: " + opCode + "\n" + code);
      }
      if (debugMode) {
        System.out.println("[Debug] " + "Processing OP-Code: " + opCode);
      }
      OpCodes.getCodes().get(opCode).execute(this, inputsIterator, arg1Mode, arg2Mode, arg3Mode);
    }
    return outputs;
  }

  public static HashMap<Long, Long> createIntCode(String string) {
    HashMap<Long, Long> code = new HashMap<>();
    long index = 0;
    for (String curString : string.split(",")) {
      try {
        code.put(index, Long.parseLong(curString.trim()));
        index++;
      } catch (NumberFormatException e) {
        System.out.println("Invalid OP-Code: " + curString);
      }
    }
    return code;
  }

  private ParameterMode extractParameterMode(char mode) {
    return mode == '1' ? ParameterMode.IMMEDIATE : mode == '2' ? ParameterMode.RELATIVE : ParameterMode.NORMAL;
  }

  public HashMap<Long, Long> getCode() {
    return code;
  }

  public IndexedIterator<Long> getIterator() {
    return iterator;
  }

  public long getRelativeBase() {
    return relativeBase;
  }

  public void setRelativeBase(long relativeBase) {
    this.relativeBase = relativeBase;
  }

  public List<Long> getOutputs() {
    return outputs;
  }

  public static boolean isDebugMode() {
    return debugMode;
  }

  public static void setDebugMode(boolean debugMode) {
    Intcode.debugMode = debugMode;
  }
}
