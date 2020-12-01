package io.github.jroy.advent.twentynineteen.dayten;

import io.github.jroy.advent.common.OrderedPair;

public class Asteroid {

  private final double rotation;
//  private final double distance;
  private final OrderedPair location;

  public Asteroid(OrderedPair center, OrderedPair location) {
    this.location = location;
    this.rotation = 0.1;
//    this.distance
  }
}
