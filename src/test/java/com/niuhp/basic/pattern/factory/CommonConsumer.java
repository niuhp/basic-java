package com.niuhp.basic.pattern.factory;

import org.junit.Test;

/**
 * Created by niuhaipeng on 2017/4/13.
 */
public class CommonConsumer {
  @Test
  public void testCreateAnimal() {
    Animal cat = new Cat();
    Animal dog = new Dog();
  }
}
