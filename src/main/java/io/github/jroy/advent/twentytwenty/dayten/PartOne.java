package io.github.jroy.advent.twentytwenty.dayten;

import io.github.jroy.advent.common.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartOne {

  public static void main(String[] args) throws IOException {
    JoltCountToken token = getJoltAmounts(Utils.getDayInputInts());
    System.out.println("Solution: " + (token.getOneCount() * token.getThreeCount()));
  }

  public static JoltCountToken getJoltAmounts(List<Integer> adapters) {
    adapters = adapters instanceof ArrayList ? adapters : new ArrayList<>(adapters);
    Collections.sort(adapters);
    adapters.add(adapters.get(adapters.size() - 1) + 3); //The device we're connecting to is also "an adaptor"
    int oneCount = 0;
    int threeCount = 0;

    int i1 = 0; //The outlet will always have a jolt rating of 0
    for (int i2 : adapters) {
      if (i2 - i1 == 3) {
        threeCount++;
      } else if (i2 - i1 == 1) {
        oneCount++;
      } else {
        System.out.println(i2 + " - " + i1);
      }
      i1 = i2;
    }
    return new JoltCountToken(oneCount, threeCount);
  }

  static class JoltCountToken {
    private final int oneCount;
    private final int threeCount;

    public JoltCountToken(int oneCount, int threeCount) {
      this.oneCount = oneCount;
      this.threeCount = threeCount;
    }

    public int getOneCount() {
      return oneCount;
    }

    public int getThreeCount() {
      return threeCount;
    }
  }
}
