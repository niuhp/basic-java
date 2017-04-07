package com.niuhp.basic.pattern.singleton;

/**
 * Created by niuhaipeng on 2017/4/4.
 */
public class SingletonE {

  private static volatile SingletonE instance = null;
  private static final Object lockObj = new Object();

  private SingletonE() {
  }

  public static SingletonE getInstance() {
    if (instance == null) {
      synchronized (lockObj) {
        if (instance == null) {
          instance = new SingletonE();
        }
      }
    }
    return instance;
  }
}
