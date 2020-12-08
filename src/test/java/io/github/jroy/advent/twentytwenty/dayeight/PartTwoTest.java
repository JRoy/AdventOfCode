package io.github.jroy.advent.twentytwenty.dayeight;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PartTwoTest {

  @Test
  public void testSampleInput() {
    List<String> input = List.of("nop +0",
        "acc +1",
        "jmp +4",
        "acc +3",
        "jmp -3",
        "acc -99",
        "acc +1",
        "jmp -4",
        "acc +6");
    assertEquals(8, PartTwo.executeBootCode(PartOne.parseBootCode(input)));
  }
}
