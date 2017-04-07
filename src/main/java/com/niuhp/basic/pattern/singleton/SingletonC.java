package com.niuhp.basic.pattern.singleton;

/**
 * Created by niuhaipeng on 2017/4/4.
 */
public class SingletonC {

  private static SingletonC instance = null;

  private SingletonC() {
  }

  public static synchronized SingletonC getInstance() {
    if (instance == null) {
      instance = new SingletonC();
    }
    return instance;
  }
}
