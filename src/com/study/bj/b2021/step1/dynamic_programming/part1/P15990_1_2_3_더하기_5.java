package com.study.bj.b2021.step1.dynamic_programming.part1;

import java.util.Scanner;

//폭파 시킴
//모듈러 신경
public class P15990_1_2_3_더하기_5 {


  static final int mod = 1_000_000_009;
  static int n;
  static long[][] a = new long[100_050][4];

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();

    a[1][1] = 1;
    a[2][2] = 1;
    a[3][1] = 1;
    a[3][2] = 1;
    a[3][3] = 1;

    for (int j = 4; j < 100_050; j++) {
      a[j][1] = (a[j - 1][2] + a[j - 1][3]) % mod;
      a[j][2] = (a[j - 2][1] + a[j - 2][3]) % mod;
      a[j][3] = (a[j - 3][1] + a[j - 3][2]) % mod;
      a[j][0] = (a[j][1]  + a[j][2]  + a[j][3]) % mod;

    }

    for (int t = 0; t < n; t++) {
      int x = scan.nextInt();
      System.out.println(a[x]);
    }

  }
}
