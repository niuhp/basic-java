package com.niuhp.basic.pattern.factory.abs;

import com.niuhp.basic.pattern.factory.Animal;
import com.niuhp.basic.pattern.factory.Dog;

/**
 * Created by niuhaipeng on 2017/4/13.
 */
public class DogFactory implements AnimalFactory {
  @Override
  public Animal createAnimal() {
    return new Dog();
  }
}
