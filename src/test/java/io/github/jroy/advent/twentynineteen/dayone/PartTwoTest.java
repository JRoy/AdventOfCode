package io.github.jroy.advent.twentynineteen.dayone;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PartTwoTest {

  @Test
  public void testSampleInput() {
    assertEquals(2, PartTwo.recursivelyCalculateFuel(14));
    assertEquals(966, PartTwo.recursivelyCalculateFuel(1969));
    assertEquals(50346, PartTwo.recursivelyCalculateFuel(100756));
  }
}
