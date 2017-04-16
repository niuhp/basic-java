package com.niuhp.basic.pattern.factory.simple;

import com.niuhp.basic.pattern.factory.Animal;
import com.niuhp.basic.pattern.factory.Cat;
import com.niuhp.basic.pattern.factory.Dog;

/**
 * Created by niuhaipeng on 2017/4/13.
 */
public class AnimalFactory {

  public Animal createAnimal(String type) {
    switch (type) {
      case "cat":
        return new Cat();
      case "dog":
        return new Dog();
      default:
        return null;
    }
  }

}
