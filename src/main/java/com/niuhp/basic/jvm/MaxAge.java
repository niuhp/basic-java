package com.niuhp.basic.jvm;

public class MaxAge {

  public static void main(String[] args) {
    byte[] _1mb = new byte[1024 * 1024];
    for (int i = 1; i <= 5; i++) {
      System.out.println(String.format("----- System.gc start,i=%s -----", i));
      System.gc();
      System.out.println(String.format("----- System.gc end,i=%s -----", i));
    }
  }

}
