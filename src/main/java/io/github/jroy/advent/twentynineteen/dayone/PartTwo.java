package io.github.jroy.advent.twentynineteen.dayone;

import io.github.jroy.advent.common.Utils;

import java.io.IOException;

public class PartTwo {

  public static void main(String[] args) throws IOException {
    int totalFuel = 0;
    for (String str : Utils.readResourceLines("twentynineteen/dayone.input")) {
      try {
        totalFuel += recursivelyCalculateFuel(Integer.parseInt(str));
      } catch (NumberFormatException e) {
        System.out.println("Invalid Mass: " + str);
      }
    }
    System.out.println("Part Two Answer: " + totalFuel);
  }

  /**
   * Calculates the amount of fuel needed to lift a given
   * module and recursively calculates the amount of fuel
   * needed to carry that fuel. This ends its calculation
   * once the amount of fuel needed to carry the previous
   * amount of fuel is less than or equal to zero.
   *
   * @param mass The mass of the given module
   * @return The amount of fuel needed to lift the given
   * module and its subsequent fuel.
   */
  public static int recursivelyCalculateFuel(int mass) {
    int totalFuel = 0;
    int fuel = PartOne.calculateFuel(mass);
    while (fuel > 0) {
      totalFuel += fuel;
      fuel = PartOne.calculateFuel(fuel);
    }
    return totalFuel;
  }
}
