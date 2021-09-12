package com.study.bj.b2021.step1.brute_force.brute;

import java.util.Scanner;

public class P1748_수_이어_쓰기_2 {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();
    int x = jarisu(n);

    int sum = 0;
    for (int i = 1; i <= x - 1; i++) {
      int t = ((pow(i) - 1) - pow(i - 1) + 1) * i;
      sum += t;
    }

    int remain = (n - pow(x - 1) + 1) * x;

    System.out.println(sum + remain);

  }

  private static int pow(int n) {
    int x = 1;
    for (int j = 1; j <= n; j++) {
      x = x * 10;
    }
    return x;
  }

  private static int jarisu(int n) {
    return Integer.toString(n).length();
  }
}
