package com.study.bj;

import java.util.Scanner;

/**
 * 연속 합
 * https://www.acmicpc.net/problem/1912
 * 현재값 vs 이전까지의 합 큰거 비교
 */
public class P1912 {

  public static long MAX = Long.MIN_VALUE;
  public static int n;
  public static long[] a, d;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    a = new long[n];
    d = new long[n];//a[i] 를 포함한 최대값
    for (int i = 0; i < n; i++) {
      a[i] = scan.nextLong();
    }
    d[0] = a[0];
    MAX = d[0];
    for (int i = 1; i < n; i++) {
      d[i] = max(a[i], d[i - 1] + a[i]);
      if (MAX < d[i]) {
        MAX = d[i];
      }
    }
//    System.out.println(Arrays.toString(d));
    System.out.println(MAX);
  }

  public static long max(long a, long b) {
    return a > b ? a : b;
  }
}
