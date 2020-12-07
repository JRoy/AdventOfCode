package io.github.jroy.advent.twentytwenty.dayseven;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PartTestTest {

  @Test
  public void testSampleInput() {
    List<String> input = List.of("shiny gold bags contain 2 dark red bags.",
        "dark red bags contain 2 dark orange bags.",
        "dark orange bags contain 2 dark yellow bags.",
        "dark yellow bags contain 2 dark green bags.",
        "dark green bags contain 2 dark blue bags.",
        "dark blue bags contain 2 dark violet bags.",
        "dark violet bags contain no other bags.");

    assertEquals(126, PartTwo.countTotalBags("SHINY_GOLD", PartOne.parseBagRules(input)));
  }
}
