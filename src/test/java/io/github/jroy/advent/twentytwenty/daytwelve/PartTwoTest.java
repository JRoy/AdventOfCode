package io.github.jroy.advent.twentytwenty.daytwelve;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PartTwoTest {

  @Test
  public void testSampleInput() {
    List<String> input = List.of(
        "F10",
        "N3",
        "F7",
        "R90",
        "F11");
    assertEquals(286, new Ferry().parseWaypoints(input).getAbsSum());
  }
}
