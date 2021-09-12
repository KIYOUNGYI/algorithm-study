package com.study.bj.b2021.step1.brute_force.permutation;

import java.util.Scanner;

public class P10819_차이를_최대로 {

  static int max = -1;
  static int n;
  static int[] input;
  static boolean[] visit;
  static int[] arr;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    n = scan.nextInt();
    input = new int[n];
    visit = new boolean[n];
    arr = new int[n];

    for (int i = 0; i < n; i++) {
      input[i] = scan.nextInt();
    }

    dfs(0);

    System.out.println(max);

  }

  private static void dfs(int depth) {

    if (depth == n) {
//      System.out.println(Arrays.toString(arr));
      sum();
      return;
    }

    for (int i = 0; i < n; i++) {

      if (!visit[i]) {

        visit[i] = true;
        arr[depth] = input[i];

        dfs(depth + 1);

        visit[i] = false;

      }

    }
  }

  private static void sum() {

    int sum = 0;
    for (int i = 0; i < n - 1; i++) {
      sum += abs(arr[i], arr[i + 1]);
    }

    if (max < sum) {
      max = sum;
    }

  }

  private static int abs(int a, int b) {
    return Math.abs(a - b);
  }

}
