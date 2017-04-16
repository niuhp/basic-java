package com.niuhp.basic.pattern.factory.method;

import com.niuhp.basic.pattern.factory.Animal;
import com.niuhp.basic.pattern.factory.Cat;

/**
 * Created by niuhaipeng on 2017/4/13.
 */
public class CatFactory implements AnimalFactory {
  @Override
  public Animal createAnimal() {
    return new Cat();
  }
}
