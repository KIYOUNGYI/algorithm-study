package com.study.test;


public class Main {

  public static void main(String[] args) {
    Square s = new Square();
  }

  public static class Square {

    int x;
    int y;
    boolean b = true;

    {
      System.out.println("초기화 블럭 호출");
    }

    public Square() {
      System.out.println("생성자 호출");
    }
  }
}