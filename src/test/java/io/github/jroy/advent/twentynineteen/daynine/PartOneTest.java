package io.github.jroy.advent.twentynineteen.daynine;

import io.github.jroy.advent.common.intcode.Intcode;
import org.junit.Test;

import java.io.InvalidObjectException;

public class PartOneTest {

  @Test
  public void testSampleInput() throws InvalidObjectException {
    new Intcode("109,1,204,-1,1001,100,1,100,1008,100,16,101,1006,101,0,99").execute();
//    assertEquals(16, new Intcode("1102,34915192,34915192,7,4,7,99,0").execute().get(0).toString().length());
//    assertEquals(Long.parseLong("1125899906842624"), (long) new Intcode("104,1125899906842624,99").execute().get(0));
//    assertTrue();
//    assertTrue(PartTwo.isGoodPassword(111122));
  }
}
