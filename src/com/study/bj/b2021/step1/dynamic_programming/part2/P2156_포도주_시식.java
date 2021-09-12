package com.study.bj.b2021.step1.dynamic_programming.part2;

import java.util.Scanner;

public class P2156_포도주_시식 {

  static int[] arr;
  static int[] d;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    arr = new int[n + 1];
    d = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      arr[i] = scan.nextInt();
    }

    if (n == 1) {
      System.out.println(arr[1]);
      return;
    }
    if (n == 2) {
      System.out.println(arr[1] + arr[2]);
      return;
    }
    d[1] = arr[1];
    d[2] = arr[1] + arr[2];

    for (int i = 3; i <= n; i++) {
      d[i] = max(max(d[i - 1], d[i - 2] + arr[i]), arr[i] + arr[i - 1] + d[i - 3]);
    }

    System.out.println(d[n]);
  }

  private static int max(int a, int b) {
    return a > b ? a : b;
  }

}
