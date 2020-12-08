package io.github.jroy.advent.twentytwenty.dayeight;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PartOneTest {

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
    assertEquals(5, PartOne.executeBootCode(PartOne.parseBootCode(input), true));
  }
}
