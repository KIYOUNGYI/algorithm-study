package com.study.bj.b2021.step1.brute_force;

import java.util.Scanner;

public class TOBIN {

  static int[] arr;
  static int n;
  static int r;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    r = scan.nextInt();
    arr = new int[n];

    dfs(0, 0);

    scan.close();
  }

  private static void dfs(int depth, int v) {

    if (sum() == r) {
      print();
      return;
    }

    if (depth == n) {
      return;
    }

    arr[depth] = 1;
    dfs(depth + 1, 1);
    arr[depth] = 0;
    dfs(depth + 1, 0);
  }

  public static int sum() {

    int t = 0;
    for (int i = 0; i < n; i++) {
      t += arr[i];
    }
    return t;
  }

  public static void print() {
    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
}
