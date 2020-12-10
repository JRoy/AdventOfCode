package io.github.jroy.advent.twentytwenty.daynine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class XmasParser {
  private final List<Long> queue;
  private final List<Long> buffer = new ArrayList<>();
  private final List<Long> expiredBuffer = new ArrayList<>();

  public XmasParser(List<Long> array, int preambleLength) {
    this.queue = new ArrayList<>(array);

    //Allocate starting buffer
    for (int i = preambleLength - 1; i >= 0; i--) {
      buffer.add(queue.get(i));
      expiredBuffer.add(queue.get(i));
      queue.remove(i);
    }
    Collections.reverse(buffer);
    Collections.reverse(expiredBuffer);
  }

  public long getFirstViolatingNumber() {
    for (long next : queue) {
      boolean found = false;
      search:
      for (int index1 = 0; index1 < buffer.size(); index1++) {
        for (int index2 = 0; index2 < buffer.size(); index2++) {
          if (index1 != index2 && buffer.get(index1) + buffer.get(index2) == next) {
            buffer.remove(0);
            expiredBuffer.add(next);
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

  public long getEncryptionWeakness(long failNum) {
    startIndex:
    for (int i = 0; i < expiredBuffer.size(); i++) {
      List<Long> used = new ArrayList<>();
      long cur = expiredBuffer.get(i);
      long result = cur;
      used.add(cur);
      for (int i2 = i + 1; i2 < expiredBuffer.size(); i2++) {
        long cur2 = expiredBuffer.get(i2);
        result += cur2;
        used.add(cur2);
        if (result == failNum) {
          Collections.sort(used);
          return used.get(0) + used.get(used.size() - 1);
        } else if (result > failNum) {
          continue startIndex;
        }
      }
    }
    return -1;
  }
}
