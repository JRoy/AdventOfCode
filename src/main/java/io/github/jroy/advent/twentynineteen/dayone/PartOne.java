package io.github.jroy.advent.twentynineteen.dayone;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class PartOne {

  public static void main(String[] args) {
    AtomicInteger totalFuel = new AtomicInteger();
    try (Stream<String> stream = Files.lines(Paths.get(PartOne.class.getResource("/twentynineteen/dayone.input").toURI()))) {
      stream.forEach(string -> {
        try {
          totalFuel.addAndGet(calculateFuel(Integer.parseInt(string)));
        } catch (NumberFormatException e) {
          System.out.println("Invalid Mass: " + string);
        }
      });
    } catch (IOException | URISyntaxException e) {
      e.printStackTrace();
    }
    System.out.println("Part One Answer: " + totalFuel.get());
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
