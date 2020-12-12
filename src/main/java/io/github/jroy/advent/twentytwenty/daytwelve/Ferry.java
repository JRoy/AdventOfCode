package io.github.jroy.advent.twentytwenty.daytwelve;

import io.github.jroy.advent.common.Direction;

import java.util.List;

public class Ferry {
  private Direction facing;
  private int x;
  private int y;
  private int wX = 10;
  private int wY = 1;

  public Ferry() {
    this(0, 0, Direction.EAST);
  }

  public Ferry(int initialX, int initialY, Direction facing) {
    this.x = initialX;
    this.y = initialY;
    this.facing = facing;
  }

  public Ferry parseInstructions(List<String> instructions) {
    for (String instruction : instructions) {
      parseInstruction(instruction);
    }
    return this;
  }

  public Ferry parseWaypoints(List<String> instructions) {
    for (String instruction : instructions) {
      parseWaypoint(instruction);
    }
    return this;
  }

  public void parseWaypoint(String instruction) {
    int i = Integer.parseInt(instruction.substring(1));
    switch (instruction.charAt(0)) {
      case 'N': {
        wY += i;
        break;
      }
      case 'S': {
        wY -= i;
        break;
      }
      case 'E': {
        wX += i;
        break;
      }
      case 'W': {
        wX -= i;
        break;
      }
      case 'L': {
        rotateWaypoint(-i / 90);
        break;
      }
      case 'R': {
        rotateWaypoint(i / 90);
        break;
      }
      case 'F': {
        x += (wX * i);
        y += (wY * i);
        break;
      }
    }
  }

  @SuppressWarnings("SuspiciousNameCombination")
  private void rotateWaypoint(int turns) {
    int copyX = wX;
    int copyY = wY;

    switch (turns) {
      case 1:
      case -3: {
        wX = copyY;
        wY = -copyX;
        break;
      }
      case 2:
      case -2: {
        wX = -copyX;
        wY = -copyY;
        break;
      }
      case -1:
      case 3: {
        wX = -copyY;
        wY = copyX;
        break;
      }
    }
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
