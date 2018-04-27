package com.niuhp.basic.jvm;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class SimpleQueue {


  public static void main(String[] args) {
    final BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

    Runnable prodTask = () -> {
      Random random = new Random();
      while (true) {
        int num = random.nextInt(1000000);
        int mills = random.nextInt(1000);
        queue.offer(num);
        System.out.println("thread[" + Thread.currentThread().getName() + "] offer " + num + " to queue and then sleep " + mills + " ms");
        try {
          Thread.sleep(mills);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    };

    Runnable conTask = () -> {
      Random random = new Random();
      while (true) {
        int mills = random.nextInt(1000);
        try {
          Integer num = queue.poll(mills, TimeUnit.MILLISECONDS);
          System.out.println("thread[" + Thread.currentThread().getName() + "] poll " + num + " with in " + mills + " ms");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    };

    ExecutorService threadPool = Executors.newFixedThreadPool(4);
    threadPool.execute(prodTask);
    threadPool.execute(prodTask);
    threadPool.execute(conTask);
    threadPool.execute(conTask);
  }
}
