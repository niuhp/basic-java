package com.niuhp.basic.pattern;

import java.util.ArrayList;
import java.util.List;

public class Test {

  private static void showResult(int result, int... args) {
    if (args == null || args.length == 0) {
      return;
    }

    List<char[]> groups = getGroups();
    for (char[] group : groups) {
      int index = 0;
      int tmp = args[index++];
      for (char op : group) {
        switch (op) {
          case '+': {
            tmp += args[index++];
            break;
          }
          case '-': {
            tmp -= args[index++];
            break;
          }
          case '*': {
            tmp *= args[index++];
            break;
          }
          case '/': {
            tmp /= args[index++];
            break;
          }
        }
      }
      if (tmp == result) {
        for (int i = 0; i < args.length; i++) {
          System.out.print(args[i]);
          if (i < args.length - 1) {
            System.out.print(" " + group[i] + " ");
          }
        }
        System.out.println(" = " + result);
      }
    }
    for (int i = 1; i < args.length; i++) {

    }
  }

  private static List<char[]> getGroups() {
    char[] ops = {'+', '-', '*', '/'};
    List<char[]> groups = new ArrayList<>();
    for (int i = 0; i < ops.length; i++) {
      for (int j = 0; j < ops.length; j++) {
        char[] group = new char[2];
        group[0] = ops[i];
        group[1] = ops[j];
        groups.add(group);
      }
    }
    return groups;
  }


  public static void main(String[] args) {
    for (int num = 2; num <= 9; num++) {
      showResult(6, num, num, num);
    }
  }
}
