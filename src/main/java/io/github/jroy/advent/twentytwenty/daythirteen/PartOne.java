package io.github.jroy.advent.twentytwenty.daythirteen;

import io.github.jroy.advent.common.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartOne {

  public static void main(String[] args) throws IOException {
    List<String> input = Utils.getDayInput();
    System.out.println("Solution: " + getWaitTime(Long.parseLong(input.get(0)), getBusIds(input.get(1))));
  }

  public static long getWaitTime(long departStartTime, List<Long> busIds) {
    long shortestBusId = -1;
    long shortestTime = Long.MAX_VALUE;
    for (long busId : busIds) {
      boolean cont = true;
      long multiplier = departStartTime / busId;
      while (cont) {
        long wait = busId * multiplier;
        if (wait >= departStartTime) {
          if (wait < shortestTime) {
            shortestTime = wait;
            shortestBusId = busId;
          }
          cont = false;
          continue;
        }
        multiplier++;
      }
    }
    return (shortestTime - departStartTime) * shortestBusId;
  }

  public static List<Long> getBusIds(String line) {
    List<Long> list = new ArrayList<>();
    for (String id : line.split(",")) {
      if (id.equals("x")) {
        continue;
      }
      list.add(Long.parseLong(id));
    }
    Collections.sort(list);
    return list;
  }
}
