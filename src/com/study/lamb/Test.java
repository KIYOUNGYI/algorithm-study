package com.study.lamb;

public class Test
{
  private static Runnable lambdatTest(Runnable runnable)
  {
    runnable.run();
    return () -> System.out.println("return lambda");
  }

  public static void main(String[] args)
  {
    lambdatTest(() -> System.out.println("yanolza lambda")).run();
  }
}
