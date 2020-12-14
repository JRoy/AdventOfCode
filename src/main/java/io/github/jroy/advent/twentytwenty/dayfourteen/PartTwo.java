package io.github.jroy.advent.twentytwenty.dayfourteen;

import io.github.jroy.advent.common.Utils;

import java.io.IOException;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.github.jroy.advent.twentytwenty.dayfourteen.PartOne.MEM_PATTERN;

public class PartTwo {

  public static void main(String[] args) throws IOException {
    System.out.println("Solution: " + initializeProgram(Utils.getDayInput()));
  }

  public static long initializeProgram(List<String> input) {
    Map<BigInteger, Long> memory = new HashMap<>();
    String maskStr = "";
    for (String line : input) {
      // Check if this line is updating the mask
      String[] maskSplit = line.split("mask = ");
      if (maskSplit.length > 1) {
        maskStr = maskSplit[1];
//        maskStr = new StringBuilder(maskSplit[1]).reverse().toString();
        continue;
      }

      // Process mem operation
      Matcher matcher = MEM_PATTERN.matcher(line);
      if (matcher.matches()) {
        long address = Long.parseLong(matcher.group(1));
        long value = Long.parseLong(matcher.group(2));

        // Apply bitmask
        String[] binaryAddress = String.format("%36s", Long.toBinaryString(address)).replace(" ", "0").split("");
        Set<String[]> addresses = applyMask(maskStr.split(""), binaryAddress);
        addresses.stream()
            .map(sa -> String.join("", sa))
            .map(binStr -> new BigInteger(binStr, 2))
            .forEach(adr -> memory.put(adr, value));
      }
    }

    // Sum values in memory
    return memory.values().stream().map(BigInteger::valueOf).reduce(BigInteger.ZERO, BigInteger::add).longValue();
  }

  public static Set<String[]> applyMask(String[] mask, String[] binAddress) {
    List<Integer> xIndices = new ArrayList<>();
    for (int i = 0; i < mask.length; i++) {
      switch (mask[i].toUpperCase()) {
        case "X": {
          xIndices.add(i);
          break;
        }
        case "1": {
          binAddress[i] = mask[i];
          break;
        }
        default: {
          break;
        }
      }
    }
    Set<String[]> permutations = new HashSet<>();
    permutations.add(binAddress);
    for (int index : xIndices) {
      permutations = permutations.stream()
          .flatMap(a -> {
            String[] scenario0 = Arrays.stream(a).toArray(String[]::new);
            scenario0[index] = "0";
            a[index] = "1";
            return Stream.of(scenario0, a);
          })
          .collect(Collectors.toSet());
    }
    return new HashSet<>(permutations);
  }
}
