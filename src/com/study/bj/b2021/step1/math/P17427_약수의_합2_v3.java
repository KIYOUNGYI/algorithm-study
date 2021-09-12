package com.study.bj.b2021.step1.math;

import java.util.Scanner;

public class P17427_약수의_합2_v3 {

  static long ans = 0;
  static long[] arr;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    arr = new long[n + 1];

    ans = 0;
    for (int i = 1; i <= n; i++) {
      ans = ans + (i) * (n / i);
    }

    System.out.println(ans);
  }
}
