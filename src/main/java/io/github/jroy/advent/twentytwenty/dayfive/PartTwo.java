package io.github.jroy.advent.twentytwenty.dayfive;

import io.github.jroy.advent.common.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.github.jroy.advent.twentytwenty.dayfive.PartOne.parseBinaryPass;

public class PartTwo {

  public static void main(String[] args) throws IOException {
    List<Integer> seatIds = new ArrayList<>();
    for (String passStr : Utils.getDayInput()) {
      seatIds.add(parseBinaryPass(passStr).getSeatId());
    }
    seatIds.sort(Integer::compareTo);
    int lastInt = seatIds.get(0);
    for (int i : seatIds) {
      if (lastInt == i) {
        continue;
      }

      if ((lastInt + 1) != i) {
        System.out.println("Solution: " + (lastInt + 1));
        return;
      }
      lastInt = i;
    }
    System.out.println("No solution! (Invalid input?)");
  }
}
