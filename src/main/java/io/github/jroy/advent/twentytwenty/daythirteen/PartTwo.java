package io.github.jroy.advent.twentytwenty.daythirteen;

import io.github.jroy.advent.common.Utils;

import java.io.IOException;
import java.util.ArrayList;

public class PartTwo {

  public static void main(String[] args) throws IOException {
    System.out.println("Solution: " + findMatchingTimestamp(Utils.getDayInput().get(1)));
  }

  public static long findMatchingTimestamp(String input) {
    ArrayList<Integer> busIds = new ArrayList<>();
    ArrayList<Integer> offsets = new ArrayList<>();
    ArrayList<Long> product = new ArrayList<>();
    ArrayList<Integer> productInverse = new ArrayList<>();

    String[] inputSplit = input.split(",");
    long globalProduct = 1L;
    for (int i = 0; i < inputSplit.length; i++) {
      if (!inputSplit[i].equals("x")) {
        int busId = Integer.parseInt(inputSplit[i]);
        busIds.add(busId);
        offsets.add((i * -1) % busId + busId);
        globalProduct *= busId;
      }
    }

    for (int i = 0; i < busIds.size(); i++) {
      product.add(globalProduct / busIds.get(i));

      //calculate inverse
      int y = 1;
      while ((product.get(i) * y) % busIds.get(i) != 1) {
        y++;
      }
      productInverse.add(y);
    }

    long sum = 0;
    for (int i = 0; i < busIds.size(); i++) {
      sum += offsets.get(i) * product.get(i) * productInverse.get(i);
    }
    return sum % globalProduct;
  }
}
