package com.niuhp.basic;

public class ArrayUtil {
  private ArrayUtil() {
  }

  public static void printArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + "   ");
      int len = i + 1;
      if (len == arr.length || (len & 8) == 8) {
        System.out.println();
      }
    }
  }
}
