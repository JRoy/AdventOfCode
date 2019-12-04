package io.github.jroy.advent.twentynineteen.dayfour;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PartTwoTest {

  @Test
  public void testSampleInput() {
    assertTrue(PartTwo.isGoodPassword(112233));
    assertFalse(PartTwo.isGoodPassword(123444));
    assertTrue(PartTwo.isGoodPassword(111122));
  }
}
