package io.github.jroy.advent.twentytwenty.dayfourteen;

import io.github.jroy.advent.common.Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PartOne {

  protected final static Pattern MEM_PATTERN = Pattern.compile("mem\\[(\\d+)] = (\\d+)");

  public static void main(String[] args) throws IOException {
    System.out.println("Solution: " + initializeProgram(Utils.getDayInput()));
  }

  public static long initializeProgram(List<String> input) {
    Map<Long, Long> memory = new HashMap<>();
    String maskStr = "";
    for (String line : input) {
      // Check if this line is updating the mask
      String[] maskSplit = line.split("mask = ");
      if (maskSplit.length > 1) {
        maskStr = new StringBuilder(maskSplit[1]).reverse().toString();
        continue;
      }

      // Process mem operation
      Matcher matcher = MEM_PATTERN.matcher(line);
      if (matcher.matches()) {
        long address = Long.parseLong(matcher.group(1));
        long value = Long.parseLong(matcher.group(2));

        // Apply bitmask
        for (int i = 0; i < maskStr.length(); i++) {
          char c = maskStr.charAt(i);
          switch (c) {
            case '1': {
              value |= (1L << i);
              break;
            }
            case '0': {
              value &= ~(1L << i);
              break;
            }
            default: {
              break;
            }
          }
        }

        // Put value into memory
        memory.put(address, value);
      }
    }

    // Sum values in memory
    long sum = 0;
    for (long l : memory.values()) {
      sum += l;
    }
    return sum;
  }
}
