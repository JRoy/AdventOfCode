package io.github.jroy.advent.twentytwenty.dayten;

import io.github.jroy.advent.common.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartTwo {

  public static void main(String[] args) throws IOException {
    System.out.println("Solution: " + getJoltAmounts(Utils.getDayInputInts()));
  }

  public static long getJoltAmounts(List<Integer> adapters) {
    adapters = adapters instanceof ArrayList ? adapters : new ArrayList<>(adapters);
    Collections.sort(adapters);
    adapters.add(0, 0); //Outlet
    adapters.add(adapters.get(adapters.size() - 1) + 3); //Device

    long[] solutions = new long[adapters.size()];
    solutions[0] = 1;
    for (int i = 1; i < adapters.size(); i++) {
      for (int i2 = 1 - 3; i2 < i; i2++) {
        if (i2 >= 0 && adapters.get(i) - adapters.get(i2) <= 3) {
          solutions[i] += solutions[i2];
        }
      }
    }
    return solutions[solutions.length - 1];
  }
}
