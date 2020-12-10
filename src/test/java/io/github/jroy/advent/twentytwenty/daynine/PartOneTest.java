package io.github.jroy.advent.twentytwenty.daynine;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PartOneTest {

  @Test
  public void testSampleInput() {
    List<Long> list = List.of(
        35L,
        20L,
        15L,
        25L,
        47L,
        40L,
        62L,
        55L,
        65L,
        95L,
        102L,
        117L,
        150L,
        182L,
        127L,
        219L,
        299L,
        277L,
        309L,
        576L);
    assertEquals(127, new XmasParser(list, 5).getFirstViolatingNumber());
  }
}
