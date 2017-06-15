package com.niuhp.basic.pattern.factory.abs;

import com.niuhp.basic.pattern.factory.Animal;

/**
 * Created by niuhaipeng on 2017/6/15.
 */
public interface AnimalFactory {
  Animal createMale();

  Animal createFemale();
}
