package com.study.test;

public class App {

  private int number;

  {
    this.number = 10;
    System.out.println("init block");
  }

  public App() {
    this.number = 100;
    System.out.println("constructor");
  }

  public static void main(String[] args) {
    App init = new App();
    System.out.println(init.number);
  }
}
