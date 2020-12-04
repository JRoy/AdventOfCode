package io.github.jroy.advent.twentytwenty.dayfour;

import java.util.HashMap;
import java.util.Map;

public class Passport {
  private final HashMap<String, String> keys = new HashMap<>();

  public Passport() {
    keys.put("byr", null); //Birth Year
    keys.put("iyr", null); //Issue Year
    keys.put("eyr", null); //Expiration Year
    keys.put("hgt", null); //Height
    keys.put("hcl", null); //Hair Color
    keys.put("ecl", null); //Eye Colo
    keys.put("pid", null); //Passport ID
    keys.put("cid", null); //Country ID
  }

  public void addProperty(String key, String value) {
    keys.put(key, value);
  }

  public boolean isValid() {
    for (Map.Entry<String, String> entry : keys.entrySet()) {
//      Ignores country id because adventofcode told me fraud is ok
      if (entry.getValue() == null && !entry.getKey().equalsIgnoreCase("cid")) {
        return false;
      }
    }
    return true;
  }
}
