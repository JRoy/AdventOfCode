package io.github.jroy.advent.twentytwenty.dayone;

import io.github.jroy.advent.twentytwenty.daytwo.PartOne;
import org.junit.Test;

import static org.junit.Assert.*;

public class PartOneTest {

  @Test
  public void testSampleInput() {
    assertTrue(PartOne.isValidPassword("abcde", 'a', 1, 3));
    assertFalse(PartOne.isValidPassword("cdefg", 'b', 1, 3));
    assertTrue(PartOne.isValidPassword("ccccccccc", 'c', 2, 9));
  }
}
