package io.github.jroy.advent.twentytwenty.dayten;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PartOneTest {

  @Test
  public void testSampleInput() {
    List<Integer> input = List.of(28, 33, 18, 42, 31, 14, 46, 20,
        48, 47, 24, 23, 49, 45, 19, 38, 39, 11, 1, 32, 25, 35, 8,
        17, 7, 9, 4, 2, 34, 10, 3);
    PartOne.JoltCountToken token = PartOne.getJoltAmounts(input);
    assertEquals(22, token.getOneCount());
    assertEquals(10, token.getThreeCount());
  }
}
