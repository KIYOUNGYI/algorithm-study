package com.study.bj.b2021.step1.brute_force.permutation;

import java.util.Scanner;

public class P10974_모든순열 {

  static int n;
  static int[] arr;
  static boolean[] visit;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    n = scan.nextInt();
    arr = new int[n + 1];
    visit = new boolean[n + 1];

    dfs(1);

  }

  private static void dfs(int depth) {

    if (depth == n + 1) {
      print();
      return;
    }

    for (int i = 1; i <= n; i++) {

      if (!visit[i]) {
        visit[i] = true;
        arr[depth] = i;
        dfs(depth + 1);
        visit[i] = false;
      }
    }
  }

  private static void print() {

    for (int i = 1; i <= n; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
}
