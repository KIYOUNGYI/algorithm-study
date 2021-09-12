package com.study.bj.b2021.step1.dynamic_programming.part1;

import java.util.Scanner;

public class P11726_2xn_타일링 {

  static int n;
  static long[] arr;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    n = scan.nextInt();
    arr = new long[1050];
    arr[0] = 0;
    arr[1] = 1;
    arr[2] = 2;
    arr[3] = 3;

    if (n <= 3) {
      System.out.println(arr[n]);
      return;
    }

    for (int i = 4; i <= n; i++) {
      arr[i] = (arr[i - 1] + arr[i - 2]) % 10_007;
    }
    System.out.println(arr[n]);
  }
}
