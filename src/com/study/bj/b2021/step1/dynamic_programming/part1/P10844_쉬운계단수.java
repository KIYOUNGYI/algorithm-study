package com.study.bj.b2021.step1.dynamic_programming.part1;

import java.util.Scanner;

public class P10844_쉬운계단수 {

  static final int mod = 1_000_000_000;
  static long[][] a = new long[101][10];

  public static void main(String[] args) {

    for (int i = 1; i <= 9; i++) {
      a[1][i] = 1;
    }

    for (int j = 2; j <= 100; j++) {

      for (int i = 1; i <= 9; i++) {
        a[j][i] = a[j][i] + a[j - 1][i - 1];
      }

      for (int i = 0; i <= 8; i++) {
        a[j][i] = a[j][i] + a[j - 1][i + 1];
      }

      for (int i = 0; i <= 9; i++) {
        a[j][i] = a[j][i] % mod;
      }

    }

    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    long sum = 0;
    for (int i = 0; i <= 9; i++) {
      sum += a[n][i];
    }
    System.out.println(sum % mod);
  }
}
