package com.niuhp.basic.jvm;

public class MemAllocation {
  private static final int _1MB = 1021 * 1024;

  public static void main(String[] args) throws InterruptedException {
    byte[] _2mb_1 = tryAllocation(2);
    System.out.println("---------- allocation 2 MB memory ----------");
    byte[] _2mb_2 = tryAllocation(2);
    System.out.println("---------- allocation 2 MB memory ----------");
    byte[] _2mb_3 = tryAllocation(2);
    System.out.println("---------- allocation 2 MB memory ----------");
    byte[] _4mb = tryAllocation(4);
    System.out.println("---------- allocation 4 MB memory ----------");
    Thread.sleep(5000);
    System.out.println("---------- allocation test finish ----------");
  }

  private static byte[] tryAllocation(int xmb) {
    return new byte[_1MB * xmb];
  }
}
