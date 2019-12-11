package io.github.jroy.advent.common.intcode;

import io.github.jroy.advent.common.intcode.model.OpCode;
import io.github.jroy.advent.common.intcode.opcodes.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class OpCodes {

  private final static Map<Integer, OpCode> codes;

  public static Map<Integer, OpCode> getCodes() {
    return codes;
  }

  public final static OpCode ONE = new OpCodeOne();

  public final static OpCode TWO = new OpCodeTwo();

  public final static OpCode THREE = new OpCodeThree();

  public final static OpCode FOUR = new OpCodeFour();

  public final static OpCode FIVE = new OpCodeFive();

  public final static OpCode SIX = new OpCodeSix();

  public final static OpCode SEVEN = new OpCodeSeven();

  public final static OpCode EIGHT = new OpCodeEight();

  public final static OpCode NINE = new OpCodeNine();

  static {
    codes = new HashMap<>();
    for (Field field : OpCodes.class.getDeclaredFields()) {
      if (Modifier.isStatic(field.getModifiers()) && Modifier.isPublic(field.getModifiers())) {
        try {
          OpCode code = (OpCode) field.get(null);
          codes.put(code.getCode(), code);
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
