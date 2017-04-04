package com.niuhp.basic.java.pattern.singleton;

/**
 * Created by niuhaipeng on 2017/4/4.
 */
public class SingletonA {

  private static SingletonA instance = new SingletonA();

  private SingletonA() {
  }

  public static SingletonA getInstance() {
    return instance;
  }
}
