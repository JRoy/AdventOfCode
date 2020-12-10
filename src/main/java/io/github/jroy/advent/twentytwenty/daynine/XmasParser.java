package io.github.jroy.advent.twentytwenty.daynine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class XmasParser {
  private final List<Long> array;
  private final List<Long> buffer = new ArrayList<>();

  public XmasParser(List<Long> array, int preambleLength) {
    this.array = new ArrayList<>(array);

    //Allocate starting buffer
    for (int i = preambleLength - 1; i >= 0; i--) {
      buffer.add(this.array.get(i));
      this.array.remove(i);
    }
    Collections.reverse(buffer);
  }

  public long getFirstViolatingNumber() {
    for (long next : array) {
      boolean found = false;
      search:
      for (int index1 = 0; index1 < buffer.size(); index1++) {
        for (int index2 = 0; index2 < buffer.size(); index2++) {
          if (index1 != index2 && buffer.get(index1) + buffer.get(index2) == next) {
            buffer.remove(0);
            buffer.add(next);
            found = true;
            break search;
          }
        }
      }
      if (!found) {
        return next;
      }
    }
    return -1;
  }
}
