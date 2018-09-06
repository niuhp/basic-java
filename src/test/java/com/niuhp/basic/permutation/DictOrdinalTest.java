package com.niuhp.basic.permutation;

import com.niuhp.basic.ArrayUtil;

import org.junit.Test;

public class DictOrdinalTest {

  @Test
  public void testDictSeq() {
    int[] array = {2, 3, 5, 7, 9};
    while (array != null) {
      ArrayUtil.printArray(array);
      array = DictOrdinalUtil.nextPermutation(array);
    }
  }

}
