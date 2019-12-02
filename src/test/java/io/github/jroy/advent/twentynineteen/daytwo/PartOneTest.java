package io.github.jroy.advent.twentynineteen.daytwo;

import org.junit.Test;

import java.io.InvalidObjectException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PartOneTest {

  @Test
  public void testSampleInput() throws InvalidObjectException {
    List<Integer> result = PartOne.processIntCode(PartOne.createIntCode("1,0,0,0,99"));
    assertEquals(Integer.valueOf(2), result.get(0));
    assertEquals(Integer.valueOf(0), result.get(1));
    assertEquals(Integer.valueOf(0), result.get(2));
    assertEquals(Integer.valueOf(0), result.get(3));
    assertEquals(Integer.valueOf(99), result.get(4));

    result = PartOne.processIntCode(PartOne.createIntCode("2,3,0,3,99"));
    assertEquals(Integer.valueOf(2), result.get(0));
    assertEquals(Integer.valueOf(3), result.get(1));
    assertEquals(Integer.valueOf(0), result.get(2));
    assertEquals(Integer.valueOf(6), result.get(3));
    assertEquals(Integer.valueOf(99), result.get(4));

    result = PartOne.processIntCode(PartOne.createIntCode("2,4,4,5,99,0"));
    assertEquals(Integer.valueOf(2), result.get(0));
    assertEquals(Integer.valueOf(4), result.get(1));
    assertEquals(Integer.valueOf(4), result.get(2));
    assertEquals(Integer.valueOf(5), result.get(3));
    assertEquals(Integer.valueOf(99), result.get(4));
    assertEquals(Integer.valueOf(9801), result.get(5));

    result = PartOne.processIntCode(PartOne.createIntCode("1,1,1,4,99,5,6,0,99"));
    assertEquals(Integer.valueOf(1), result.get(0));
    assertEquals(Integer.valueOf(1), result.get(1));
    assertEquals(Integer.valueOf(1), result.get(2));
    assertEquals(Integer.valueOf(4), result.get(3));
    assertEquals(Integer.valueOf(2), result.get(4));
    assertEquals(Integer.valueOf(5), result.get(5));
    assertEquals(Integer.valueOf(6), result.get(6));
    assertEquals(Integer.valueOf(0), result.get(7));
    assertEquals(Integer.valueOf(99), result.get(8));
  }
}
