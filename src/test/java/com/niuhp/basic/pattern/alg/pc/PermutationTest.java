package com.niuhp.basic.pattern.alg.pc;

import com.niuhp.basic.alg.pc.DictSeq;

import org.junit.Test;

public class PermutationTest {

  @Test
  public void testDictSeq() {
    int[] array = {1, 2, 3, 4};
    printArray(array);
    DictSeq dictSeq = new DictSeq(array);
    int[] next = dictSeq.next();
    while (next != null) {
      printArray(next);
      dictSeq = new DictSeq(next);
      next = dictSeq.next();
    }
  }

  private static void printArray(int[] array) {
    for (int a : array) {
      System.out.print(a + "  ");
    }
    System.out.println();
  }

}
