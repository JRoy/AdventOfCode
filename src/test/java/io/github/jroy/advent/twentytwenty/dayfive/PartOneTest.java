package io.github.jroy.advent.twentytwenty.dayfive;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PartOneTest {

  @Test
  public void testSampleInput() {
    BoardingPass pass = PartOne.parseBinaryPass("BFFFBBFRRR");
    assertEquals(70, pass.getRow());
    assertEquals(7, pass.getColumn());
    assertEquals(567, pass.getSeatId());

    pass = PartOne.parseBinaryPass("FFFBBBFRRR");
    assertEquals(14, pass.getRow());
    assertEquals(7, pass.getColumn());
    assertEquals(119, pass.getSeatId());

    pass = PartOne.parseBinaryPass("BBFFBBFRLL");
    assertEquals(102, pass.getRow());
    assertEquals(4, pass.getColumn());
    assertEquals(820, pass.getSeatId());
  }
}
