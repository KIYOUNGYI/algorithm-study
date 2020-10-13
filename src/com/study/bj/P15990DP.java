package com.study.bj;

import java.util.Scanner;

/**
 * 다이나믹 프로그래밍 (re)
 * https://www.acmicpc.net/problem/15990
 * 다시 풀어야 함 (기억이 희미해지면)
 */
public class P15990DP {

  static long mod = 1_000_000_009;
  static int n;
  static long[][] d = new long[100_020][4];

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    d[1][1] = 1;
    d[2][2] = 1;
    d[3][1] = 1;
    d[3][2] = 1;
    d[3][3] = 1;

    for (int i = 4; i < 100_020; i++) {
      d[i][1] = (d[i - 1][2] + d[i - 1][3]) % mod;
      d[i][2] = (d[i - 2][1] + d[i - 2][3]) % mod;
      d[i][3] = (d[i - 3][1] + d[i - 3][2]) % mod;
    }

    long ans = 0;
    for (int t = 0; t < n; t++) {
      int x = scan.nextInt();
      ans = ((d[x][1] + d[x][2]) % mod + d[x][3]) % mod;
      System.out.println(ans);
      ans = 0;
    }
  }
}
