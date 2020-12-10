package io.github.jroy.advent.common;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

  private final static Pattern PACKAGE_PATTERN = Pattern.compile("io\\.github\\.jroy\\.advent\\.(\\w+)\\.(\\w+)\\..+");

  public static List<String> readResourceLines(String name) throws IOException {
    return FileUtils.readLines(new File(Utils.class.getResource("/" + name).getPath()), "utf-8");
  }

  public static List<String> getDayInput() throws IOException {
    StackTraceElement[] elements = Thread.currentThread().getStackTrace();
    for (StackTraceElement element : elements) {
      if (!element.getClassName().equals(Utils.class.getName()) && !element.getClassName().contains("java.lang.Thread")) {
        Matcher matcher = PACKAGE_PATTERN.matcher(element.getClassName());
        if (matcher.matches()) {
          return readResourceLines(matcher.group(1) + "/" + matcher.group(2) + ".input");
        }
      }
    }
    throw new IllegalCallerException("Method called out of correct package spec! (Update regex?)");
  }

  public static List<Long> getDayInputLongs() throws IOException {
    List<Long> list = new ArrayList<>();
    for (String str : getDayInput()) {
      list.add(Long.parseLong(str.trim()));
    }
    return list;
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
