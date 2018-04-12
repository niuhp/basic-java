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

      List<Integer> indexList = RefUtil.getNotNullIndexList(list);
      System.out.println("i=" + i + ",before gc,not null index list is :" + indexList);
      System.gc();
      indexList = RefUtil.getNotNullIndexList(list);
      System.out.println("i=" + i + ",after gc,not null index list is :" + indexList);

    }
  }
}
