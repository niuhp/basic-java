package com.niuhp.basic.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class GoodsDetailService {
  private ExecutorService stockPool = Executors.newFixedThreadPool(5);
  private ExecutorService pricePool = Executors.newFixedThreadPool(5);
  private AtomicInteger badCount = new AtomicInteger();

  public int getStockCount(String skuId) {

    Future<Integer> future = stockPool.submit(() -> {
      System.out.println("开始查询 " + skuId + " 的库存信息");
      long waitMills = 20;
      if (Math.random() > 0.5) {
        //50%的请求耗时较长
        System.out.println("---->要坏了，这是第 " + badCount.incrementAndGet() + " 个了");
        waitMills = 600000;
      }
      try {
        Thread.sleep(waitMills);
      } catch (InterruptedException e) {
      }
      System.out.println("结束查询 " + skuId + " 的库存信息");
      return 100;
    });

    try {
      return future.get();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return 0;
  }

  public Double getPrice(String skuId) {
    Future<Double> future = pricePool.submit(() -> {
      System.out.println("开始查询 " + skuId + " 的价格信息");
      try {
        Thread.sleep(30);
      } catch (InterruptedException e) {
      }
      System.out.println("结束查询 " + skuId + " 的价格信息");
      return 99.99d;
    });
    try {
      return future.get();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return 0d;
  }

  public static void main(String[] args) {
    GoodsDetailService goodsDetailService = new GoodsDetailService();
    ExecutorService executorService = Executors.newFixedThreadPool(30);
    int i = 0;
    while (true) {
      String skuId = String.format("sku-%03d", ++i);
      System.out.println("第 " + i + " 个用户来查询 " + skuId + " 的信息了");
      executorService.execute(() -> goodsDetailService.getStockCount(skuId));
      executorService.execute(() -> goodsDetailService.getPrice(skuId));
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
      }
    }
  }
}
