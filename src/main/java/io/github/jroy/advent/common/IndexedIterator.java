package io.github.jroy.advent.common;

import java.util.HashMap;
import java.util.List;

public class IndexedIterator<T> {

  private long index = 0L;
  private T defaultValue = null;
  private HashMap<Long, T> map;

  public IndexedIterator(HashMap<Long, T> map) {
    this.map = map;
  }

  public IndexedIterator(List<T> list) {
    this.map = new HashMap<>();
    for (long i = 0L; i < list.size(); i++) {
      map.put(i, list.get(Math.toIntExact(i)));
    }
  }

  public boolean hasNext() {
    return map.size() > index;
  }

  public T next() {
    index++;
    return map.computeIfAbsent(index - 1L, (x) -> defaultValue);
  }

  public void replaceNext(T replacement) {
    map.put(index, replacement);
    index++;
  }

  public long getIndex() {
    return index;
  }

  public void setIndex(long index) {
    this.index = index;
  }

  public void setDefaultValue(T defaultValue) {
    this.defaultValue = defaultValue;
  }

  public void setList(List<T> list) {
    this.map = new HashMap<>();
    for (long i = 0L; i < list.size(); i++) {
      map.put(i, list.get(Math.toIntExact(i)));
    }
  }
}
