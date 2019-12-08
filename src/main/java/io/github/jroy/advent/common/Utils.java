package io.github.jroy.advent.common;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utils {

  public static List<String> readResourceLines(String name) throws IOException {
    return FileUtils.readLines(new File(Utils.class.getResource("/" + name).getPath()), "utf-8");
  }

  /**
   * https://stackoverflow.com/a/3760193
   */
  public static List<String> splitEqually(String text, int size) {
    List<String> ret = new ArrayList<>((text.length() + size - 1) / size);
    for (int start = 0; start < text.length(); start += size) {
      ret.add(text.substring(start, Math.min(text.length(), start + size)));
    }
    return ret;
  }
}
