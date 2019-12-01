package io.github.jroy.advent.common;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Utils {

  public static List<String> readResourceLines(String name) throws IOException {
    return FileUtils.readLines(new File(Utils.class.getResource("/" + name).getPath()), "utf-8");
  }
}
