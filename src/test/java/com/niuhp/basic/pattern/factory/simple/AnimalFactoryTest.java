package com.niuhp.basic.pattern.factory.simple;

import com.niuhp.basic.pattern.factory.Animal;

import org.junit.Test;

/**
 * Created by niuhaipeng on 2017/4/13.
 */
public class AnimalFactoryTest {
  @Test
  public void testCreateAnimal() {
    AnimalFactory af = new AnimalFactory();
    Animal cat = af.createAnimal("cat");
    Animal dog = af.createAnimal("dog");
  }
}
