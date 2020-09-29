package com.study.bj;

import java.util.Scanner;

/**
 * 로또 https://www.acmicpc.net/problem/6603 난 재귀로 풀었다. dfs로 풀 수도 있다.
 */
public class P6603 {

  static int n;
  static int[] arr, brr;
  static boolean[] v;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    while (true) {
      n = scan.nextInt();
      if (n == 0) {
        break;
      }

      arr = new int[n];
      brr = new int[n];

      for (int i = 0; i < n; i++) {
        arr[i] = scan.nextInt();
      }

      f(0, 0);
      System.out.println();
    }
    scan.close();
  }

  public static void f(int depth, int cnt) {
    if (cnt == 6) {
      printLotto();
      return;
    }

    if (depth == n) {
      return;
    }

    brr[depth] = 1;
    f(depth + 1, cnt + 1);
    brr[depth] = 0;
    f(depth + 1, cnt);

  }

  public static void printLotto() {
    for (int i = 0; i < n; i++) {
      if (brr[i] == 1) {
        System.out.print(arr[i] + " ");
      }
    }
    System.out.println();
  }
}
