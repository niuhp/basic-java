package com.niuhp.basic.alg.pc;

public class DictSeq {
  private int[] current;

  public DictSeq(int[] current) {
    this.current = current;
  }

  public int[] next() {
    int lastPositive = findLastPositive(current);
    if (lastPositive == -1) {
      return null;
    }
    int[] next = new int[current.length];
    for (int i = 0; i < lastPositive; i++) {
      next[i] = current[i];
    }

    int lastLarge = findLastLarge(current, lastPositive);
    next[lastPositive] = current[lastLarge];
    for (int i = lastPositive + 1; i < next.length; i++) {
      if (i == current.length + lastPositive - lastLarge) {
        next[i] = current[lastPositive];
      } else {
        next[i] = current[current.length + lastPositive - i];
      }
    }
    return next;
  }

  private static int findLastPositive(int[] array) {
    for (int i = array.length - 2; i >= 0; i--) {
      if (array[i] < array[i + 1]) {
        return i;
      }
    }
    return -1;
  }

  private static int findLastLarge(int[] array, int fromIndex) {
    for (int i = array.length - 1; i > fromIndex; i--) {
      if (array[i] > array[fromIndex]) {
        return i;
      }
    }
    return -1;
  }
}
