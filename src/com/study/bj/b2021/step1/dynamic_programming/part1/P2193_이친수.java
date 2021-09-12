package com.study.bj.b2021.step1.dynamic_programming.part1;

import java.util.Scanner;

public class P2193_이친수 {

  static int n;
  static long[][] a;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    n = scan.nextInt();
    if (n == 1) {
      System.out.println(1);
      return;
    }
    if (n == 2) {
      System.out.println(1);
      return;
    }

    a = new long[n + 1][2];

    a[1][1] = 1;
    a[2][1] = 1;

    for (int j = 3; j <= n; j++) {
      a[j][0] = a[j - 1][0] + a[j - 1][1];
      a[j][1] = a[j - 2][0] + a[j - 2][1];
    }

    System.out.println(a[n][0] + a[n][1]);

    scan.close();
  }

}
