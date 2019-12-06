package io.github.jroy.advent.common;

import java.util.List;

public class IndexedIterator<T> {

  private int index = 0;
  private final List<T> list;

  public IndexedIterator(List<T> list) {
    this.list = list;
  }

  public boolean hasNext() {
    return list.size() > index;
  }

  public T next() {
    index++;
    return list.get(index - 1);
  }

  public void replaceNext(T replacement) {
    list.set(index, replacement);
    index++;
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }
}
