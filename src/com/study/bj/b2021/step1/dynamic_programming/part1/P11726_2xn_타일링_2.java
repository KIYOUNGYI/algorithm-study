package com.study.bj.b2021.step1.dynamic_programming.part1;

import java.util.Scanner;

public class P11726_2xn_타일링_2 {

  static final int mod = 10_007;
  static int n;
  static long[] d;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    n = scan.nextInt();
    d = new long[1050];
    d[1] = 1;
    d[2] = 3;

    for (int i = 3; i <= n; i++) {
      d[i] = (d[i - 1] + 2 * d[i - 2]) % mod;
    }

    System.out.println(d[n]);
  }
}
