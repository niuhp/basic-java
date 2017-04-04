package com.niuhp.basic.java.pattern.singleton;

/**
 * Created by niuhaipeng on 2017/4/4.
 */
public class SingletonF {

  private SingletonF() {
  }

  private static class SingletonHolder {

    static final SingletonF instance = new SingletonF();
  }

  public static SingletonF getInstance() {
    return SingletonHolder.instance;
  }
}
