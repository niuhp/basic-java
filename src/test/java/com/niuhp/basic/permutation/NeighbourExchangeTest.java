package com.niuhp.basic.permutation;

import com.niuhp.basic.ArrayUtil;

import org.junit.Test;

import java.util.List;


public class NeighbourExchangeTest {
  @Test
  public void testV1() {
    List<int[]> list = NeighbourExchangeV1.getAllPermutation(new int[]{1, 2, 3, 4});
    list.forEach(ArrayUtil::printArray);
  }

  @Test
  public void testV2() {
    List<int[]> list = NeighbourExchangeV2.getAllPermutation(new int[]{1, 2, 3, 4});
    list.forEach(ArrayUtil::printArray);
  }
}
