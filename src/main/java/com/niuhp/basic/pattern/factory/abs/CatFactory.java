package com.niuhp.basic.pattern.factory.abs;

import com.niuhp.basic.pattern.factory.Animal;
import com.niuhp.basic.pattern.factory.Cat;

/**
 * Created by niuhaipeng on 2017/4/13.
 */
public class CatFactory implements AnimalFactory {

  @Override
  public Animal createMale() {
    return new Cat("male");
  }

  @Override
  public Animal createFemale() {
    return new Cat("female");
  }
}
