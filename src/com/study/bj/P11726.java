package com.study.bj;

import java.util.Scanner;

/**
 * 2×n 타일링
 * https://www.acmicpc.net/problem/11726
 */
public class P11726 {

  static int n;
  static long[] d = new long[1020];

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    d[1] = 1;
    d[2] = 2;
    if (n == 1 || n == 2) {
      System.out.println(d[n]);
      return;
    }
    for (int i = 3; i <= n; i++) {
      d[i] = (d[i - 1] + d[i - 2])%10_007;
    }
    System.out.println(d[n]);
  }
}
