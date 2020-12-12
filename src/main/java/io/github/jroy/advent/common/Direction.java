package io.github.jroy.advent.common;

public enum Direction {
  NORTH(0, 1),
  SOUTH(0, -1),
  EAST(1, 0),
  WEST(-1, 0);

  private final int xAdd;
  private final int yAdd;

  Direction(int xAdd, int yAdd) {
    this.xAdd = xAdd;
    this.yAdd = yAdd;
  }

  public int getXAdd() {
    return xAdd;
  }

  public int getYAdd() {
    return yAdd;
  }

  public Direction getRelative(int offset) {
    Direction dir = this;
    boolean clockwise = offset > 0;
    while (offset != 0) {
      switch (dir) {
        case NORTH: {
          dir = clockwise ? EAST : WEST;
          break;
        }
        case EAST: {
          dir = clockwise ? SOUTH : NORTH;
          break;
        }
        case SOUTH: {
          dir = clockwise ? WEST : EAST;
          break;
        }
        case WEST: {
          dir = clockwise ? NORTH : SOUTH;
          break;
        }
      }
      offset -= clockwise ? 90 : -90;
    }
    return dir;
  }
}
