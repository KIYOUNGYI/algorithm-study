package com.study.bj;

import java.util.Scanner;

/**
 * 1로 만들기 https://www.acmicpc.net/problem/1463
 * DP [bottom-up]
 */
public class P1463DP {

  static int[] d = new int[1000020];
  static int n;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    d[1] = 0;
    d[2] = 1;
    d[3] = 1;
    if (n == 1 || n == 2 || n == 3) {
      System.out.println(d[n]);
      return;
    }
    for (int i = 4; i <= n; i++) {
      d[i] = i;
    }

    for (int i = 4; i <= n; i++) {
      d[i] = min(d[i], d[i - 1] + 1);
      if (i % 2 == 0) {
        d[i] = min(d[i], d[i / 2] + 1);
      }
      if (i % 3 == 0) {
        d[i] = min(d[i], d[i / 3] + 1);
      }
    }
    System.out.println(d[n]);
  }

  public static int min(int a, int b) {
    return a > b ? b : a;
  }
}
