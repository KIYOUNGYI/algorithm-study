package com.study.programmers.weekly.week1;

public class Solution {

  public static long solution(int price, int money, int count) {

    long spent;

    if (count % 2 == 0) {

      spent = (price + (long) price * (long) count) * (count / 2);

    } else {

      spent = (price + (long) price * (long) count) * (count / 2) + (price + (price * count)) / 2;
    }

    return spent - money > 0 ? spent - money : 0;

  }

  public static void main(String[] args) {
    int price = 3;
    int money = 20;
    int count = 5;
    System.out.println(solution(price, money, count));
  }
}
