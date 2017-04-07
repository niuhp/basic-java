package com.niuhp.basic.pattern.singleton;

/**
 * Created by niuhaipeng on 2017/4/4.
 */
public class SingletonB {

  private static SingletonB instance = null;

  private SingletonB() {
  }

  public static SingletonB getInstance() {
    if (instance == null) {
      instance = new SingletonB();
    }
    return instance;
  }
}
