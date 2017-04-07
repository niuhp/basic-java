package com.niuhp.basic.pattern.singleton;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by niuhaipeng on 2017/4/7.
 */
public class SingletonHTest {

  @Test
  public void testSingleton() {
    ExecutorService pool = Executors.newFixedThreadPool(5);
    for (int i = 0; i < 100; i++) {
      pool.submit(new Runnable() {
        @Override
        public void run() {
          long id = Thread.currentThread().getId();
          String name = Thread.currentThread().getName();
          SingletonH instance = SingletonH.getInstance();
          int status = instance.getStatus();
          System.out.println(String.format("thread[id=%s,name=%s],instance.status=%s", id, name, status));
        }
      });
      if (i % 5 == 0) {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
