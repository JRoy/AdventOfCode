package io.github.jroy.advent.twentynineteen.daysix;

import io.github.jroy.advent.common.Utils;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

public class PartOne {

  public static void main(String[] args) throws IOException {
    MultiValuedMap<String, String> orbits = new ArrayListValuedHashMap<>();
    for (String str : Utils.readResourceLines("twentynineteen/daysix.input")) {
      orbits.put(str.split("\\)")[0], str.split("\\)")[1]);
    }

    int result = 0;
    for (Map.Entry<String, Collection<String>> curEntry : orbits.asMap().entrySet()) {
      result += findOrbits(curEntry.getKey(), orbits);
    }
    System.out.println("Part One Answer: " + result);
  }

  public static int findOrbits(String key, MultiValuedMap<String, String> map) {
    int result = 0;
    for (String str : map.get(key)) {
      result++;
      result += findOrbits(str, map);
    }
    return result;
  }
}
