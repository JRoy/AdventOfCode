package io.github.jroy.advent.twentytwenty.daytwelve;

import io.github.jroy.advent.common.Direction;

import java.util.List;

public class Ferry {
  private Direction facing = Direction.EAST;
  private int x;
  private int y;

  public Ferry parseInstructions(List<String> instructions) {
    for (String instruction : instructions) {
      parseInstruction(instruction);
    }
    return this;
  }

  public void parseInstruction(String instruction) {
    int i = Integer.parseInt(instruction.substring(1));
    switch (instruction.charAt(0)) {
      case 'N': {
        y += i;
        break;
      }
      case 'S': {
        y -= i;
        break;
      }
      case 'E': {
        x += i;
        break;
      }
      case 'W': {
        x -= i;
        break;
      }
      case 'L': {
        facing = facing.getRelative(-i);
        break;
      }
      case 'R': {
        facing = facing.getRelative(i);
        break;
      }
      case 'F': {
        x += (facing.getXAdd() * i);
        y += (facing.getYAdd() * i);
        break;
      }
    }
  }

  public int getAbsSum() {
    return Math.abs(x) + Math.abs(y);
  }
}
