package com.study.bj;

import java.util.Scanner;

/**
 * 오르막 수
 * https://www.acmicpc.net/problem/11057
 * 컨셉 자체는 맞았음
 * 그런데 나머지 연산 부분을 예민하게 신경써서 처리해야 함!
 */
public class P11057 {

  static int N;
  static long[][] d = new long[1020][10];
  static long mod = 10007;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    N = scan.nextInt();
    for (int i = 0; i < 10; i++) {
      d[1][i] = 1;
    }
    if (N == 1) {
      System.out.println(10);
      return;
    }
    for (int i = 2; i <= N; i++) {
      for (int j = 0; j < 10; j++) {
        long sum = 0;
        for (int k = 0; k <= j; k++) {
          d[i][j] += d[i - 1][k];
          d[i][j] %= mod;
        }

      }
    }
    long ans = 0;
    for (int i = 0; i < 10; i++) {
      ans += (d[N][i]);
    }
    System.out.println(ans % mod);
  }
}
