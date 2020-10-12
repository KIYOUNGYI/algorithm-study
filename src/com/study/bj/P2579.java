package com.study.bj;

import java.util.Scanner;

/**
 * 계단 오르기
 * https://www.acmicpc.net/problem/2579
 */
public class P2579 {

  static int n;
  static long[] a, d;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    a = new long[n + 1];
    d = new long[n + 1];
    for (int i = 1; i <= n; i++) {
      a[i] = scan.nextInt();
    }
    d[1] = a[1];
    if(n==1)
    {
      System.out.println(d[1]);
      return;
    }
    d[2] = a[1] + a[2];
    if(n==2)
    {
      System.out.println(d[2]);
      return;
    }
    for(int i=3;i<=n;i++)
    {
      d[i] = max(d[i-2]+a[i],a[i]+a[i-1]+d[i-3]);
    }
    System.out.println(d[n]);
  }

  public static long max(long a, long b) {
    return a > b ? a : b;
  }
}
