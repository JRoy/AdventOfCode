package io.github.jroy.advent.twentynineteen.dayone;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PartOneTest {

  @Test
  public void testSampleInput() {
    assertEquals(2, PartOne.calculateFuel(12));
    assertEquals(2, PartOne.calculateFuel(14));
    assertEquals(654, PartOne.calculateFuel(1969));
    assertEquals(33583, PartOne.calculateFuel(100756));
  }

}
