package com.study.exception_propagation;

public class ExceptionPropagationExample {

  public static void main(String[] args) {

    System.out.println("1. Main start");
    ExceptionPropagationExample example = new ExceptionPropagationExample();

    try {

      example.doSomething();

    } catch (Exception e) {

      System.out.println("5. Catch exception");
      e.printStackTrace();

    }
  }

  private void doSomething() {
    System.out.println("2. execute something");
    try {
      occursException();
    } finally {
      System.out.println("4. finally block");
    }
  }

  private void occursException() {
    System.out.println("3. Exception occurs");
    String code = null;
    code.length();  //NPE occurs
  }

}
