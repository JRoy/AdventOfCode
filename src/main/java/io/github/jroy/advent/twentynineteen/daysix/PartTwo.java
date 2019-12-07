package io.github.jroy.advent.twentynineteen.daysix;

import io.github.jroy.advent.common.Utils;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class PartTwo {

  public static void main(String[] args) throws IOException {
    MultiValuedMap<String, String> orbits = new ArrayListValuedHashMap<>();
    for (String str : Utils.readResourceLines("twentynineteen/daysix.input")) {
      orbits.put(str.split("\\)")[1], str.split("\\)")[0]);
    }

    Collection<String> sanOrbits = collectOrbits("SAN", orbits);
    Collection<String> youOrbits = collectOrbits("YOU", orbits);

    int sanJumps = 0;
    int youJumps = 0;

    String common = null;
    for (String curOrbit : sanOrbits) {
      if (youOrbits.contains(curOrbit)) {
        common = curOrbit;
        break;
      }
      sanJumps++;
    }

    for (String curOrbit : youOrbits) {
      if (curOrbit.equals(common)) {
        break;
      }
      youJumps++;
    }

    System.out.println("Part Two Answer: " + (sanJumps + youJumps));
  }

  private static Collection<String> collectOrbits(String key, MultiValuedMap<String, String> map) {
    Collection<String> collection = new ArrayList<>();
    for (String cur : map.get(key)) {
      collection.add(cur);
      collection.addAll(collectOrbits(cur, map));
    }
    return collection;
  }
}
