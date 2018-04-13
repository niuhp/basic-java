package com.niuhp.basic.jvm;

import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashSet;
import java.util.Set;

public class ConstantGc {
  public static void main(String[] args) throws MalformedURLException {
    Set<Class<?>> classSet = new HashSet<>();
    for (Integer i = 0; i < 100000; i++) {
      URL url = new File("").toURI().toURL();
      URL[] urls = new URL[]{url};
      ClassLoader loader = new URLClassLoader(urls);
      InvocationHandler invocationHandler = (proxy, method, args1) -> method.invoke(proxy, args1);
      Object obj = Proxy.newProxyInstance(loader, BigObj.class.getInterfaces(), invocationHandler);
      classSet.add(obj.getClass());
    }
    classSet.clear();
    System.gc();
  }
}
