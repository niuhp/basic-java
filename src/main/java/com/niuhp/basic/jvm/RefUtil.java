package com.niuhp.basic.jvm;

import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.List;

public class RefUtil {
  private RefUtil() {
  }

  public static <T> List<Integer> getNotNullIndexList(List<? extends Reference<T>> list) {
    List<Integer> indexList = new ArrayList<>();
    if (list != null) {
      for (int index = 0; index < list.size(); index++) {
        Reference<T> ref = list.get(index);
        T t = ref.get();
        if (t != null) {
          indexList.add(index);
        }
      }
    }
    return indexList;
  }
}
