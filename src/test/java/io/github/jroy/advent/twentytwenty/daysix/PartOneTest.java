package io.github.jroy.advent.twentytwenty.daysix;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PartOneTest {

  @Test
  public void testSampleInput() {
    List<String> input = List.of(
        "abc",
        "",
        "a",
        "b",
        "c",
        "",
        "ab",
        "ac",
        "",
        "a",
        "a",
        "a",
        "a",
        "",
        "b"
    );
    assertEquals(11, PartOne.countGroupAnsweredQuestions(input));
  }
}
