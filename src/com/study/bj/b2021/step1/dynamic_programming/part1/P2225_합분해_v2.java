package com.study.bj.b2021.step1.dynamic_programming.part1;

import java.util.Scanner;

public class P2225_합분해_v2 {

  static final int mod = 1_000_000_000;
  static int n;
  static int k;
  static long[][] d;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    k = scan.nextInt();
    d = new long[k + 1][n + 1];

    d[0][0] = 1;

    for (int i = 1; i <= k; i++) {

      for (int j = 0; j <= n; j++) {

//        System.out.println("[i:" + i + " j:" + j + "]");
        long sum = 0;
        for (int l = 0; l <= j; l++) {
//          System.out.println("\t " + (i - 1) + " " + (l));
          sum = (sum + d[i - 1][l]) % mod;
        }
        d[i][j] = sum % mod;
      }
    }
    System.out.println(d[k][n]);
  }
}
