package com.niuhp.basic.pattern.factory;

/**
 * Created by niuhaipeng on 2017/4/13.
 */
public class Cat implements Animal {
  private String sex;

  public Cat() {
    System.out.println("creating cat ........");
  }

  public Cat(String sex) {
    this.sex = sex;
    System.out.println("creating " + sex + " cat ........");
  }
}
