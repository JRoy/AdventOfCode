package io.github.jroy.advent.twentynineteen.daythree;

import io.github.jroy.advent.common.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PartOne {

  public static void main(String[] args) throws IOException {
    List<String> instructions = Utils.readResourceLines("twentynineteen/daythree.input");
    List<OrderedPair> wire1 = PartOne.createWire(instructions.get(0));
    List<OrderedPair> wire2 = PartOne.createWire(instructions.get(1));
    DistantOrderedPair closest = PartOne.getClosestIntersection(wire1, wire2);
    System.out.println("Part One Answer: " + closest.getDistance() + " @ " + closest.getPair().format());
  }

  public static List<OrderedPair> createWire(String instructions) {
    return createWire(instructions, false);
  }

  public static List<OrderedPair> createWire(String instructions, boolean duplicate) {
    List<OrderedPair> pairs = new ArrayList<>();
    int x = 0, y = 0;

    for (String instruction : instructions.split(",")) {
      for (int index = 0; index < Integer.parseInt(instruction.substring(1)); index++) {
        switch (instruction.charAt(0)) {
          case 'R': {
            x += 1;
            break;
          }
          case 'L': {
            x -= 1;
            break;
          }
          case 'U': {
            y += 1;
            break;
          }
          case 'D': {
            y -= 1;
            break;
          }
          default: {
            throw new IllegalStateException("Invalid instruction: " + instruction);
          }
        }
        OrderedPair pair = new OrderedPair(x, y);
        if (!pairs.contains(pair) || duplicate) {
          pairs.add(pair);
        }
      }
    }
    return pairs;
  }

  public static DistantOrderedPair getClosestIntersection(List<OrderedPair> wire1, List<OrderedPair> wire2) {
    DistantOrderedPair closest = null;
    for (OrderedPair pair : wire1) {
      if (wire2.contains(pair)) {
        int distance = Math.abs(pair.getX()) + Math.abs(pair.getY());
        if (closest == null || closest.getDistance() > distance) {
          closest = new DistantOrderedPair(pair, distance);
        }
      }
    }
    return closest;
  }
}
