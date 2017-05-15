package com.niuhp.basic.loading;

/**
 * Created by niuhaipeng on 2017/5/10.
 */
public class Parent {
  private static int staticVar1 = staticPrint("var", 1);

  static {
    staticPrint("code", 1);
  }

  private static int staticVar2 = staticPrint("var", 2);

  static {
    staticPrint("code", 2);
  }

  private int var1 = print("var", 1);

  {
    print("code", 1);
  }

  private int var2 = print("var", 2);

  {
    print("code", 2);
  }

  public Parent() {
    System.out.println("--->constructor--->" + Parent.class.getSimpleName());
  }

  private class InnnerA {
    public InnnerA() {
      System.out.println("----innerA");
    }
  }

  private static class InnnerB {
    public InnnerB() {
      System.out.println("----innerB");
    }
  }

  private static int staticVar3 = staticPrint("var", 3);

  static {
    staticPrint("code", 3);
  }

  private static int staticVar4 = staticPrint("var", 4);

  static {
    staticPrint("code", 4);
  }

  private int var3 = print("var", 3);

  {
    print("code", 3);
  }

  private int var4 = print("var", 4);

  {
    print("code", 4);
  }


  private static int staticPrint(String type, int value) {
    System.out.println("--->static " + type + " " + value + "--->" + Parent.class.getSimpleName());
    return 0;
  }

  private int print(String type, int value) {
    System.out.println("--->" + type + " " + value + "--->" + Parent.class.getSimpleName());
    return 0;
  }

  private void innerA() {
    InnnerA innnerA = new InnnerA();
  }

  private static void innerB() {
    InnnerB innnerB = new InnnerB();
  }

  public static void main(String[] args) {
    Parent parent = new Parent();
    parent.innerA();

    Parent.innerB();
  }
}
