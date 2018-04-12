package com.niuhp.basic.jvm;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class SoftRef {
  public static void main(String[] args) {
    List<SoftReference<BigObj>> list = new ArrayList<>();
    for (int i = 0; ; i++) {
      SoftReference<BigObj> softRef = new SoftReference<>(new BigObj());
      list.add(softRef);
      System.out.println("add BigObj for SoftReference ,i=" + i + ",list.size=" + list.size());
      System.out.println("not null index list is : " + RefUtil.getNotNullIndex(list));
    }
  }

}
