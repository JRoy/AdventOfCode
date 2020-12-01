package io.github.jroy.advent.twentynineteen.dayten;

import io.github.jroy.advent.common.Utils;
import io.github.jroy.advent.common.OrderedPair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PartOne {

  public static void main(String[] args) throws IOException {
    List<String> map = Utils.readResourceLines("twentynineteen/dayten.input");
    List<OrderedPair> asteroids = IntStream.range(0, map.size()).boxed()
        .flatMap(index -> IntStream.range(0, map.get(index).length())
            .mapToObj(y -> new OrderedPair(index, y)))
        .filter(p -> map.get(p.getY()).charAt(p.getX()) == '#')
        .collect(Collectors.toList());
    List<Long> visible = new ArrayList<>();
    for (int i = 0; i < visible.size(); i++) {
//      visible.set(i, asteroids.stream().map(p -> new ))
    }
  }
}
