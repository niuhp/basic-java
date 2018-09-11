package com.niuhp.basic.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NeighbourExchangeUtilV2 {

  private NeighbourExchangeUtilV2() {
  }

  public static List<int[]> getAllPermutation(int[] arr) {

    List<int[]> result = new ArrayList<>();
    result.add(arr);

    DirectionalInt[] directionalInts = Arrays.stream(arr).mapToObj(DirectionalInt::new).toArray(DirectionalInt[]::new);

    DirectionalInt[] nextDirectionalInts = nextPermutation(directionalInts);
    while (nextDirectionalInts != null) {
      int[] nextArray = Arrays.stream(nextDirectionalInts).mapToInt(DirectionalInt::getValue).toArray();
      result.add(nextArray);
      nextDirectionalInts = nextPermutation(nextDirectionalInts);
    }

    return result;
  }


  private static DirectionalInt[] nextPermutation(DirectionalInt[] directionalInts) {
    int maxActiveIndex = -1;
    DirectionalInt maxActive = null;
    for (int i = 0; i < directionalInts.length; i++) {
      DirectionalInt current = directionalInts[i];
      if (current.isLeft() && i > 0) {
        DirectionalInt pre = directionalInts[i - 1];
        if ((pre.getValue() < current.getValue()) && (maxActive == null || maxActive.getValue() < current.getValue())) {
          maxActiveIndex = i;
          maxActive = current;
        }
      }

      if (current.isRight() && i < directionalInts.length - 1) {
        DirectionalInt next = directionalInts[i + 1];
        if ((next.getValue() < current.getValue()) && (maxActive == null || maxActive.getValue() < current.getValue())) {
          maxActiveIndex = i;
          maxActive = current;
        }
      }

    }
    if (maxActive == null) {
      return null;
    }
    if (maxActive.isLeft()) {
      swap(directionalInts, maxActiveIndex, maxActiveIndex - 1);
    } else if (maxActive.isRight()) {
      swap(directionalInts, maxActiveIndex, maxActiveIndex + 1);
    }

    for (DirectionalInt directionalInt : directionalInts) {
      if (directionalInt.getValue() > maxActive.getValue()) {
        directionalInt.reverse();
      }
    }

    return directionalInts;
  }

  private static void swap(DirectionalInt[] directionalInts, int i, int j) {
    DirectionalInt tmp = directionalInts[i];
    directionalInts[i] = directionalInts[j];
    directionalInts[j] = tmp;
  }

  static class DirectionalInt {
    private int value;
    private int direction; // 0 向左，1 向右

    public DirectionalInt(int value) {
      this.value = value;
    }

    public boolean isLeft() {
      return this.direction == 0;
    }

    public boolean isRight() {
      return !isLeft();
    }

    public void reverse() {
      this.direction = this.direction ^ 1;
    }

    public int getValue() {
      return value;
    }

    public int getDirection() {
      return direction;
    }
  }
}
