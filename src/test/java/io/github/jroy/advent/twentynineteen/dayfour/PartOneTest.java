package io.github.jroy.advent.twentynineteen.dayfour;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PartOneTest {

  @Test
  public void testSampleInput() {
    assertTrue(PartOne.isGoodPassword(111111));
    assertFalse(PartOne.isGoodPassword(223450));
    assertFalse(PartOne.isGoodPassword(123789));
  }
}
