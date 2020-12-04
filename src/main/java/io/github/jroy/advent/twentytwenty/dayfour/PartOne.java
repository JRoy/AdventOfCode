package io.github.jroy.advent.twentytwenty.dayfour;

import io.github.jroy.advent.common.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PartOne {

  public static void main(String[] args) throws IOException {
    System.out.println("Solution: " + processPassportBatch(Utils.getDayInput()).size());
  }

  public static List<Passport> processPassportBatch(List<String> input) {
    input = new ArrayList<>(input); //Input may be immutable
    input.add(""); // end of input may not have line break
    List<Passport> valid = new ArrayList<>();
    Passport curPassport = new Passport();
    StringBuilder buffer = new StringBuilder();
    for (String line : input) {
      //Empty line means passport data over, validate passport
      if (line.trim().isEmpty()) {
        if (curPassport.isValid()) {
          valid.add(curPassport);
        }
        curPassport = new Passport();
        buffer = new StringBuilder();
        continue;
      }
      buffer.append(line).append(" ");

      for (String element : line.trim().split(" ")) {
        String[] prop = element.split(":");
        if (prop.length == 2) {
          curPassport.addProperty(prop[0].trim(), prop[1].trim());
        }
      }
    }
    return valid;
  }
}
