package io.github.jroy.advent.twentynineteen.dayeight;

import io.github.jroy.advent.common.Utils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.List;

public class PartOne {

  public static final int LAYER_SIZE = 25 * 6;

  public static void main(String[] args) throws IOException {
    List<String> layers = Utils.splitEqually(Utils.readResourceLines("twentynineteen/dayeight.input").get(0), LAYER_SIZE);
    int targetIndex = -1;
    int fewestZeros = Integer.MAX_VALUE;
    for (int i = 0; i < layers.size(); i++) {
      int matches = StringUtils.countMatches(layers.get(i), '0');
      if (fewestZeros > matches) {
        fewestZeros = matches;
        targetIndex = i;
      }
    }
    System.out.println("Part One Answer: " + (StringUtils.countMatches(layers.get(targetIndex), '1') * StringUtils.countMatches(layers.get(targetIndex), '2')));
  }
}
