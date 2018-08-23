package com.niuhp.basic.permutation;

public class DictOrdinalUtil {

  private DictOrdinalUtil() {
  }

  public static int[] nextPermutation(int[] array) {
    int lastPositive = findLastPositive(array);
    if (lastPositive == -1) {
      return null;
    }
    int[] next = new int[array.length];
    for (int i = 0; i < lastPositive; i++) {
      next[i] = array[i];
    }

    int lastLarge = findLastLarge(array, lastPositive);
    next[lastPositive] = array[lastLarge];
    for (int i = lastPositive + 1; i < next.length; i++) {
      if (i == array.length + lastPositive - lastLarge) {
        next[i] = array[lastPositive];
      } else {
        next[i] = array[array.length + lastPositive - i];
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
