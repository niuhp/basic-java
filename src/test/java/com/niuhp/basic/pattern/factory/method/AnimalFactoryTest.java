package com.niuhp.basic.pattern.factory.method;

import com.niuhp.basic.pattern.factory.Animal;

import org.junit.Test;

/**
 * Created by niuhaipeng on 2017/4/13.
 */
public class AnimalFactoryTest {
  @Test
  public void testCreateAnimal() {
    AnimalFactory cf = new CatFactory();
    Animal cat = cf.createAnimal();
    AnimalFactory df = new DogFactory();
    Animal dog = df.createAnimal();
  }
}
