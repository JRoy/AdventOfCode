package io.github.jroy.advent.twentynineteen.dayone;

import io.github.jroy.advent.common.Utils;

import java.io.IOException;

public class PartOne {

  public static void main(String[] args) throws IOException {
    int totalFuel = 0;
    for (String str : Utils.readResourceLines("twentynineteen/dayone.input")) {
      try {
        totalFuel += calculateFuel(Integer.parseInt(str));
      } catch (NumberFormatException e) {
        System.out.println("Invalid Mass: " + str);
      }
    }
    System.out.println("Part One Answer: " + totalFuel);
  }

  /**
   * Calculates the amount of fuel needed to lift the given
   * module based on its mass.
   *
   * @param mass The mass of the given module
   * @return The amount of the fuel needed to lift the
   * module
   */
  public static int calculateFuel(int mass) {
    return Math.floorDiv(mass, 3) - 2;
  }
}
