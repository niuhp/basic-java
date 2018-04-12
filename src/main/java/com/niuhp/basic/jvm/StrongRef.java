package com.niuhp.basic.jvm;

import java.util.ArrayList;
import java.util.List;

public class StrongRef {
  public static void main(String[] args) {
    List<BigObj> list = new ArrayList<>();
    for (int i = 0; ; i++) {
      list.add(new BigObj());
      System.out.println("add BigObj,i=" + i + ",list.size=" + list.size());
    }
  }
}
