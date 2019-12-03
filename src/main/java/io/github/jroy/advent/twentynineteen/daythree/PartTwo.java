package io.github.jroy.advent.twentynineteen.daythree;

import io.github.jroy.advent.common.Utils;

import java.io.IOException;
import java.util.List;

public class PartTwo {

  public static void main(String[] args) throws IOException {
    List<String> instructions = Utils.readResourceLines("twentynineteen/daythree.input");
    List<OrderedPair> wire1 = PartOne.createWire(instructions.get(0));
    List<OrderedPair> wire2 = PartOne.createWire(instructions.get(1));
    List<OrderedPair> dupWire1 = PartOne.createWire(instructions.get(0), true);
    List<OrderedPair> dupWire2 = PartOne.createWire(instructions.get(1), true);
    DistantOrderedPair closest = getClosestSteps(wire1, wire2, dupWire1, dupWire2);
    System.out.println("Part Two Answer: " + closest.getDistance() + " @ " + closest.getPair().format());
  }

  public static DistantOrderedPair getClosestSteps(List<OrderedPair> wire1, List<OrderedPair> wire2, List<OrderedPair> dupWire1, List<OrderedPair> dupWire2) {
    DistantOrderedPair distantOrderedPair = null;
    for (OrderedPair pair : wire1) {
      if (wire2.contains(pair)) {
        int distance1 = dupWire1.indexOf(pair) + 1;
        int distance2 = dupWire2.indexOf(pair) + 1;
        int distance = distance1 + distance2;
        if ((distantOrderedPair == null || distance < distantOrderedPair.getDistance()) && distance1 >= 0 && distance2 >= 0) {
          distantOrderedPair = new DistantOrderedPair(pair, distance);
        }
      }
    }
    return distantOrderedPair;
  }
}
