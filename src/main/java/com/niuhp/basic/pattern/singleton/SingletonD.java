package com.niuhp.basic.pattern.singleton;

/**
 * Created by niuhaipeng on 2017/4/4.
 */
public class SingletonD {

  private static SingletonD instance = null;
  private static final Object lockObj = new Object();

  private SingletonD() {
  }

  public static SingletonD getInstance() {
    synchronized (lockObj) {
      if (instance == null) {
        instance = new SingletonD();
      }
    }
    return instance;
  }
}
