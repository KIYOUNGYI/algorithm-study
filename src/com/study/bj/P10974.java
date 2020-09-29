package com.study.bj;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/10974 순열 구하기 easy
 */
public class P10974 {

  static int n;
  static int[] arr;
  static boolean[] visited;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    arr = new int[n + 1];
    visited = new boolean[n + 1];
    f(0);
    scan.close();
  }

  public static void f(int depth) {
    if (depth == n) {
      for (int i = 0; i < n; i++) {
        System.out.print(arr[i] + " ");
      }
      System.out.println();
      return;
    }

    for (int i = 1; i <= n; i++) {
      if (!visited[i]) {
        visited[i] = true;
        arr[depth] = i;
        f(depth + 1);
        visited[i] = false;
      }
    }
  }
}
