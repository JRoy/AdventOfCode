package io.github.jroy.advent.twentynineteen.daythree;

import io.github.jroy.advent.common.OrderedPair;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PartOneTest {

  @Test
  public void testSampleInput() {
    List<OrderedPair> wire1 = PartOne.createWire("R75,D30,R83,U83,L12,D49,R71,U7,L72");
    List<OrderedPair> wire2 = PartOne.createWire("U62,R66,U55,R34,D71,R55,D58,R83");
    assertEquals(159, PartOne.getClosestIntersection(wire1, wire2).getDistance());

    wire1 = PartOne.createWire("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51");
    wire2 = PartOne.createWire("U98,R91,D20,R16,D67,R40,U7,R15,U6,R7");
    assertEquals(135, PartOne.getClosestIntersection(wire1, wire2).getDistance());
  }
}
