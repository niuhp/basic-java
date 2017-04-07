package com.niuhp.basic.pattern.singleton;

/**
 * Created by niuhaipeng on 2017/4/4.
 */
public class SingletonH {

  private SingletonH() {
  }

  private static class SingletonHolder {

    static final ThreadLocal<SingletonH> instanceThreadLocal = new ThreadLocal<SingletonH>();
  }

  public static SingletonH getInstance() {
    return SingletonHolder.instanceThreadLocal.get();
  }
}
