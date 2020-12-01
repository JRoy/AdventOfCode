package io.github.jroy.advent.common;

import java.util.Objects;

public class OrderedPair {

  private final int x;
  private final int y;

  public OrderedPair(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public String format() {
    return "(" + x + ", " + y + ")";
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof OrderedPair)) {
      return false;
    }

    OrderedPair other = (OrderedPair) o;

    return getX() == other.getX() && getY() == other.getY();
  }

//  public double distance() {
//    return Math.sqrt()
//  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}

