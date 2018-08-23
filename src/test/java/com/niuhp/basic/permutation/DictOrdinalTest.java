package com.niuhp.basic.permutation;

import org.junit.Test;

public class DictOrdinalTest {

  @Test
  public void testDictSeq() {
    int[] array = {2, 3, 5, 7, 9};
    while (array != null) {
      printArray(array);
      array = DictOrdinalUtil.nextPermutation(array);
    }
  }

  private static void printArray(int[] array) {
    for (int a : array) {
      System.out.print(a + "  ");
    }
    System.out.println();
  }

}
