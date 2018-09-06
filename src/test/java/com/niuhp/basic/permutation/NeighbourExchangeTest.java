package com.niuhp.basic.permutation;

import com.niuhp.basic.ArrayUtil;

import org.junit.Test;

import java.util.List;

import static com.niuhp.basic.permutation.NeighbourExchangeV1.getAllPermutation;

public class NeighbourExchangeTest {
  @Test
  public void testV1() {
    List<int[]> list = getAllPermutation(new int[]{1, 2, 3, 4});
    list.forEach(ArrayUtil::printArray);
  }
}
