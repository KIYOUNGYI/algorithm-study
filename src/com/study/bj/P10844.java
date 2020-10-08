package com.study.bj;

import java.util.Scanner;

/**
 * 쉬운계단수
 * 다시 점화식 써보자
 *
 */
public class P10844 {

  static long mod = 1_000_000_000;
  static int n;
  static long[][] d = new long[110][10];

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    init();
    for (int a = 1; a <= n; a++) {
      for (int b = 0; b <= 9; b++) {
        if (b == 0) {
          d[a][0] = (d[a - 1][1]) % mod;
        } else if (b >= 1 && b <= 8) {
          d[a][b] = (d[a - 1][b - 1] + d[a - 1][b + 1]) % mod;
        } else if (b == 9) {
          d[a][9] = (d[a - 1][8]) % mod;
        }
      }
    }
    long sum = 0;
    for (int a = 0; a <= 9; a++) {
      sum += (d[n - 1][a] % mod);
    }
    System.out.println(sum % mod);
  }

  public static void init() {
    d[0][0] = 0;
    for (int i = 1; i <= 9; i++) {
      d[0][i] = 1;
    }
  }
}
