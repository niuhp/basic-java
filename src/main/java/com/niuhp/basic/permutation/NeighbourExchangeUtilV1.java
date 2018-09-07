package com.niuhp.basic.permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NeighbourExchangeUtilV1 {
  private NeighbourExchangeUtilV1() {
  }

  public static List<int[]> getAllPermutation(int[] arr) {
    if (arr.length == 1) {
      return Collections.singletonList(arr);
    }
    int lastValue = arr[arr.length - 1];
    int[] subArr = new int[arr.length - 1];
    System.arraycopy(arr, 0, subArr, 0, arr.length - 1);
    List<int[]> subArrs = getAllPermutation(subArr);

    List<int[]> list = new ArrayList<>();
    subArrs.forEach(tmpArr -> {
      List<int[]> subList = getPermutations(tmpArr, lastValue);
      list.addAll(subList);
    });

    return list;
  }

  private static List<int[]> getPermutations(int[] subArr, int value) {
    int len = subArr.length + 1;
    List<int[]> list = new ArrayList<>(len);
    for (int i = subArr.length; i >= 0; i--) {
      int[] tmp = new int[len];
      System.arraycopy(subArr, 0, tmp, 0, i);
      tmp[i] = value;
      System.arraycopy(subArr, i, tmp, i + 1, subArr.length - i);
      list.add(tmp);
    }
    return list;
  }

}
