package com.niuhp.basic.jvm;

public class FinalizeEscapeGC {
  private static FinalizeEscapeGC SAVE_HOOK = null;

  @Override
  protected void finalize() throws Throwable {
    super.finalize();
    SAVE_HOOK = this;
    System.out.println("finalize method executed !");
  }

  public static void main(String[] args) throws InterruptedException {
    SAVE_HOOK = new FinalizeEscapeGC();

    /*第 1 次回收失败，对象成功拯救自己*/
    tryCollectHook();

    /*第 2 次回收成功*/
    tryCollectHook();
  }

  private static void tryCollectHook() throws InterruptedException {
    SAVE_HOOK = null;
    System.gc();
    /*由于 finalize 方法优先级较低，这里暂停 5 秒以等待它*/
    Thread.sleep(5000);
    if (SAVE_HOOK == null) {
      System.out.println("SAVE_HOOK is dead :(");
    } else {
      System.out.println("SAVE_HOOK is still alive :)");
    }
  }
}
