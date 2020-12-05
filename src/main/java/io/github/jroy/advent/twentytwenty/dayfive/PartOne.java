package io.github.jroy.advent.twentytwenty.dayfive;

import io.github.jroy.advent.common.Utils;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class PartOne {

  public static void main(String[] args) throws IOException {
    BoardingPass highestBidder = null;
    for (String passStr : Utils.getDayInput()) {
      BoardingPass pass = parseBinaryPass(passStr);
      if (highestBidder == null || pass.getSeatId() > highestBidder.getSeatId()) {
        highestBidder = pass;
      }
    }
    assert highestBidder != null;
    System.out.println("Solution: " + highestBidder.toString());
  }

  public static BoardingPass parseBinaryPass(String pass) {
    AtomicInteger lowerBound = new AtomicInteger(0);
    AtomicInteger upperBound = new AtomicInteger(127);
    preformBoundBounce(pass.substring(0, 7), lowerBound, upperBound, 'F', 'B');
    int row = lowerBound.get();

    lowerBound.set(0);
    upperBound.set(7);
    preformBoundBounce(pass.substring(7), lowerBound, upperBound, 'L', 'R');
    int column = lowerBound.get();
    return new BoardingPass(row, column);
  }

  private static void preformBoundBounce(String pass, AtomicInteger lowerBound, AtomicInteger upperBound, char upperChar, char lowerChar) {
    for (char c : pass.toCharArray()) {
      if (c == upperChar) {
        upperBound.set(upperBound.get() - ((upperBound.get() / 2) - (lowerBound.get() / 2)));
      } else if (c == lowerChar) {
        lowerBound.set(lowerBound.get() - ((lowerBound.get() / 2) - ((upperBound.get() + 1) / 2)));
      } else {
        throw new IllegalArgumentException("Invalid boarding pass!");
      }
    }
  }
}
