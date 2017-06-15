package com.niuhp.basic.pattern.factory.abs;


import com.niuhp.basic.pattern.factory.Animal;

import org.junit.Test;

/**
 * Created by niuhaipeng on 2017/4/13.
 */
public class AnimalFactoryTest {
  @Test
  public void testCreateAnimal() {
    AnimalFactory cf = new CatFactory();
    Animal maleCat = cf.createMale();
    Animal femaleCat = cf.createFemale();
    AnimalFactory df = new DogFactory();
    Animal maleDog = df.createMale();
    Animal femaleDog = df.createFemale();
  }
}
