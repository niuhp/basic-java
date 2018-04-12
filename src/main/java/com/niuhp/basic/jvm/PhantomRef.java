package com.niuhp.basic.jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Field;
import java.util.concurrent.Executors;

public class PhantomRef {
  public static void main(String[] args) {

    final ReferenceQueue<BigObj> referenceQueue = new ReferenceQueue<>();
    Runnable runnable = () -> {
      while (true) {
        Reference<? extends BigObj> reference = referenceQueue.poll();
        if (reference == null) {
          continue;
        }
        try {
          Field rereferent = Reference.class.getDeclaredField("referent");
          rereferent.setAccessible(true);
          Object obj = rereferent.get(reference);
          System.out.println("gc will collect BigObj instance : " + obj.getClass() + "@" + obj.hashCode());
        } catch (NoSuchFieldException e) {
          e.printStackTrace();
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        }
      }
    };
    Executors.newSingleThreadExecutor().execute(runnable);

    BigObj bigObj = new BigObj();
    System.out.println("new BigObj instance is : " + bigObj.getClass() + "@" + bigObj.hashCode());
    PhantomReference<BigObj> phantomReference = new PhantomReference<>(bigObj, referenceQueue);//这里一定要把 new 的对象赋值给一个变量
    bigObj = null;
    System.gc();
    System.out.println("---------------------gc 1 ------------------");
    bigObj = new BigObj();
    System.out.println("new BigObj instance is : " + bigObj.getClass() + "@" + bigObj.hashCode());
    phantomReference = new PhantomReference<>(bigObj, referenceQueue);//这里一定要把 new 的对象赋值给一个变量
    bigObj = null;
    System.gc();
    System.out.println("---------------------gc 2 ------------------");
  }
}
