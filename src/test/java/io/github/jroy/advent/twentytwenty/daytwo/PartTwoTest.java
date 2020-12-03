package io.github.jroy.advent.twentytwenty.daytwo;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PartTwoTest {

  @Test
  public void testSampleInput() {
    assertTrue(PartTwo.isValidPassword("abcde", 'a', 1, 3));
    assertFalse(PartTwo.isValidPassword("cdefg", 'b', 1, 3));
    assertFalse(PartTwo.isValidPassword("ccccccccc", 'c', 2, 9));
  }
}
