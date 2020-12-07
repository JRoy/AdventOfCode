package io.github.jroy.advent.twentytwenty.dayseven;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class PartOneTest {

  @Test
  public void testSampleInput() {
    List<String> input = List.of("light red bags contain 1 bright white bag, 2 muted yellow bags.", //
        "dark orange bags contain 3 bright white bags, 4 muted yellow bags.", //
        "bright white bags contain 1 shiny gold bag.", //
        "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.", //
        "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.", //
        "dark olive bags contain 3 faded blue bags, 4 dotted black bags.", //
        "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.", //
        "faded blue bags contain no other bags.", //
        "dotted black bags contain no other bags."); //
    Map<String, BagRule> rules = PartOne.parseBagRules(input);

    assertEquals(9, rules.size());
    assertEquals(0, rules.get("FADED_BLUE").getContents().size());
    assertEquals(11, rules.get("VIBRANT_PLUM").getTotalContents());
    assertEquals(4, PartOne.countContainingBag("SHINY_GOLD", rules));
  }
}
