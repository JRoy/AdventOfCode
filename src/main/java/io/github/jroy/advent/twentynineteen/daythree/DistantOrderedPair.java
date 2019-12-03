package io.github.jroy.advent.twentynineteen.daythree;

public class DistantOrderedPair {

  private final OrderedPair pair;
  private final int distance;

  public DistantOrderedPair(OrderedPair pair, int distance) {
    this.pair = pair;
    this.distance = distance;
  }

  public int getDistance() {
    return distance;
  }

  public OrderedPair getPair() {
    return pair;
  }
}
