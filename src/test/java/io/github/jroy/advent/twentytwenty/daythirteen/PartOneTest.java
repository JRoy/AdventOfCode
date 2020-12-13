package io.github.jroy.advent.twentytwenty.daythirteen;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PartOneTest {

  @Test
  public void testSampleInput() {
    assertEquals(295, PartOne.getWaitTime(939, PartOne.getBusIds("7,13,x,x,59,x,31,19")));
  }
}
