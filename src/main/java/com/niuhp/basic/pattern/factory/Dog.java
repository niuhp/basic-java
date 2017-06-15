package com.niuhp.basic.pattern.factory;

/**
 * Created by niuhaipeng on 2017/4/13.
 */
public class Dog implements Animal {
  private String sex;

  public Dog() {
    System.out.println("creating dog ........");
  }

  public Dog(String sex) {
    this.sex = sex;
    System.out.println("creating " + sex + " dog ........");
  }
}
