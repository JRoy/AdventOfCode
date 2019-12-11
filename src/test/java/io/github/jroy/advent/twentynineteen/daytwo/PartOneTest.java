package io.github.jroy.advent.twentynineteen.daytwo;

import io.github.jroy.advent.common.intcode.Intcode;
import org.junit.Test;

import java.io.InvalidObjectException;

import static org.junit.Assert.assertEquals;

public class PartOneTest {

  @Test
  public void testSampleInput() throws InvalidObjectException {

    Intcode intcode = new Intcode("2,3,0,3,99");
    intcode.execute();
    assertEquals(Long.valueOf(2L), intcode.getCode().get(0L));
    assertEquals(Long.valueOf(3L), intcode.getCode().get(1L));
    assertEquals(Long.valueOf(0L), intcode.getCode().get(2L));
    assertEquals(Long.valueOf(6L), intcode.getCode().get(3L));
    assertEquals(Long.valueOf(99L), intcode.getCode().get(4L));

    intcode = new Intcode("2,4,4,5,99,0");
    intcode.execute();
    assertEquals(Long.valueOf(2L), intcode.getCode().get(0L));
    assertEquals(Long.valueOf(4L), intcode.getCode().get(1L));
    assertEquals(Long.valueOf(4L), intcode.getCode().get(2L));
    assertEquals(Long.valueOf(5L), intcode.getCode().get(3L));
    assertEquals(Long.valueOf(99L), intcode.getCode().get(4L));
    assertEquals(Long.valueOf(9801L), intcode.getCode().get(5L));

    intcode = new Intcode("1,1,1,4,99,5,6,0,99");
    intcode.execute();
    assertEquals(Long.valueOf(30L), intcode.getCode().get(0L));
    assertEquals(Long.valueOf(1L), intcode.getCode().get(1L));
    assertEquals(Long.valueOf(1L), intcode.getCode().get(2L));
    assertEquals(Long.valueOf(4L), intcode.getCode().get(3L));
    assertEquals(Long.valueOf(2L), intcode.getCode().get(4L));
    assertEquals(Long.valueOf(5L), intcode.getCode().get(5L));
    assertEquals(Long.valueOf(6L), intcode.getCode().get(6L));
    assertEquals(Long.valueOf(0L), intcode.getCode().get(7L));
    assertEquals(Long.valueOf(99L), intcode.getCode().get(8L));
  }
}
