package io.github.jroy.advent.twentytwenty.daytwelve;

import io.github.jroy.advent.common.Direction;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PartOneTest {

  @Test
  public void testSampleInput() {
    assertEquals(Direction.EAST, Direction.NORTH.getRelative(90));
    assertEquals(Direction.NORTH, Direction.EAST.getRelative(-450));

    List<String> input = List.of(
        "F10",
        "N3",
        "F7",
        "R90",
        "F11");
    assertEquals(25, new Ferry().parseInstructions(input).getAbsSum());
  }
}
