package io.github.jroy.advent.twentytwenty.daythirteen;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PartTwoTest {

  @Test
  public void testSampleInput() {
    assertEquals(1068781, PartTwo.findMatchingTimestamp("7,13,x,x,59,x,31,19"));
    assertEquals(3417, PartTwo.findMatchingTimestamp("17,x,13,19"));
    assertEquals(754018, PartTwo.findMatchingTimestamp("67,7,59,61"));
    assertEquals(779210, PartTwo.findMatchingTimestamp("67,x,7,59,61"));
    assertEquals(1261476, PartTwo.findMatchingTimestamp("67,7,x,59,61"));
    assertEquals(1202161486, PartTwo.findMatchingTimestamp("1789,37,47,1889"));
  }
}
