package io.github.jroy.advent.twentynineteen.dayone;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class PartTwo {

  public static void main(String[] args) {
    AtomicInteger totalFuel = new AtomicInteger();
    try (Stream<String> stream = Files.lines(Paths.get(PartOne.class.getResource("/twentynineteen/dayone.input").toURI()))) {
      stream.forEach(string -> {
        try {
          totalFuel.addAndGet(recursivelyCalculateFuel(Integer.parseInt(string)));
        } catch (NumberFormatException e) {
          System.out.println("Invalid Mass: " + string);
        }
      });
    } catch (IOException | URISyntaxException e) {
      e.printStackTrace();
    }
    System.out.println("Part Two Answer: " + totalFuel.get());
  }

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
