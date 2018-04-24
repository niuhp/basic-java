package com.niuhp.basic.jvm;

import java.util.ArrayList;
import java.util.List;

public class JMapOom {
  private static final int _1M = 1024 * 1024;

  public static void main(String[] args) throws InterruptedException {
    List<Byte[]> list = new ArrayList<>();
    while (true) {
      list.add(new Byte[_1M]);
      Thread.sleep(1000);
    }
  }
}
