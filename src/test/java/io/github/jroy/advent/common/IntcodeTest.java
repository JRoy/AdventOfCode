package io.github.jroy.advent.common;

import io.github.jroy.advent.common.intcode.Intcode;
import org.junit.Test;

import java.io.InvalidObjectException;

import static org.junit.Assert.assertEquals;

public class IntcodeTest {

  @Test
  public void testSampleInput() throws InvalidObjectException {
    assertEquals(-1, new Intcode("109,-1,4,1,99").execute().get(0).intValue());
    assertEquals(1, new Intcode("109, -1, 104, 1, 99").execute().get(0).intValue());
    assertEquals(109, new Intcode("109, -1, 204, 1, 99").execute().get(0).intValue());
    assertEquals(204, new Intcode("109, 1, 9, 2, 204, -6, 99").execute().get(0).intValue());
    assertEquals(204, new Intcode("109, 1, 109, 9, 204, -6, 99").execute().get(0).intValue());
    assertEquals(204, new Intcode("109, 1, 209, -1, 204, -106, 99").execute().get(0).intValue());
    assertEquals(69, new Intcode("109, 1, 3, 3, 204, 2, 99").execute(69L).get(0).intValue());
    assertEquals(420, new Intcode("109, 1, 3, 3, 204, 2, 99").execute(420L).get(0).intValue());
  }
}
