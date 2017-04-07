package com.niuhp.basic.pattern.singleton;

/**
 * Created by niuhaipeng on 2017/4/4.
 */
public class SingletonH {

  private static ThreadLocal<SingletonH> instanceLocal = new ThreadLocal<SingletonH>();

  private int status;

  private SingletonH() {
    status = (int) (Math.random() * 100);
  }

  public static SingletonH getInstance() {
    SingletonH instance = instanceLocal.get();
    if (instance == null) {
      instance = new SingletonH();
      instanceLocal.set(instance);
    }
    return instance;
  }
}
