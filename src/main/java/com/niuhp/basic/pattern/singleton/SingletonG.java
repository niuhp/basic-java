package com.niuhp.basic.pattern.singleton;

/**
 * Created by niuhaipeng on 2017/4/4.
 */
public enum SingletonG {

  instance;

  public static SingletonG getInstance() {
    return instance;
  }
}
