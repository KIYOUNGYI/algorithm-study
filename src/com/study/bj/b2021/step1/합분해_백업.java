package com.study.bj.b2021.step1;

import java.util.Scanner;

public class 합분해_백업 {

  static final int mod = 1_000_000_000;
  static int n;
  static int k;
  static long[][] d;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    k = scan.nextInt();

    d = new long[k + 1][n + 1];
    d[0][0] = 1l;//0개 합

    for (int i = 1; i <= k; i++) {

      for (int j = 0; j <= n; j++) {
        System.out.println("[k:" + i + "개, 합 : " + j + "]은 아래 다 합한거 ");
        long sum = 0;
        for (int l = 0; l <= j; l++) {

          System.out.println("\t d : " + (i - 1) + " n : " + (l) + " ");
          sum = sum + d[i - 1][l];
        }
        d[i][j] = sum % mod;
      }

    }

    System.out.println(d[k][n]);


  }
}
