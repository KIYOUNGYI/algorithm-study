package com.study.bj.b2021.step1.brute_force.n_and_m;

import java.util.Arrays;
import java.util.Scanner;

public class P15654_N과M_5 {

  static Scanner scan = new Scanner(System.in);
  static int n, m;
  static int[] arr;
  static boolean[] visit;
  static int[] answer;

  public static void main(String[] args) {

    n = scan.nextInt();
    m = scan.nextInt();

    arr = new int[n + 1];
    visit = new boolean[n + 1];
    answer = new int[m + 1];

    for (int i = 1; i <= n; i++) {
      arr[i] = scan.nextInt();
    }

    Arrays.sort(arr);

    dfs(1);

  }

  private static void dfs(int depth) {

    if (depth == m + 1) {
      printArr();
      return;
    }

    for (int i = 1; i <= n; i++) {
      if (!visit[i]) {
        visit[i] = true;
        answer[depth] = arr[i];
        dfs(depth + 1);
        visit[i] = false;
      }
    }

  }

  private static void printArr() {
    for (int i = 1; i <= m; i++) {
      System.out.print(answer[i] + " ");
    }
    System.out.println();
  }


}
