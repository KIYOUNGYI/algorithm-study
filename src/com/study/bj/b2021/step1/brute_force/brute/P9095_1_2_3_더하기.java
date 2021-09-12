package com.study.bj.b2021.step1.brute_force.brute;

import java.util.Scanner;

public class P9095_1_2_3_더하기 {

  public static int loopCnt;
  public static int cnt = 0;
  public static int n;
  public static int[] arr = new int[15];

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    loopCnt = scan.nextInt();
    for (int i = 0; i < loopCnt; i++) {
      n = scan.nextInt();
      dfs(0, 0);
      System.out.println(cnt);
      cnt = 0;
    }

  }

  private static void dfs(int depth, int sum) {

    if (depth == n + 1) {
      return;
    }

    if (sum >= n) {
      cnt += 1;
      return;
    }

    for (int i = 1; i <= 3; i++) {
      if (sum + i <= n) {
        sum += i;
        arr[depth] = i;
        dfs(depth + 1, sum);
        sum -= i;
        arr[depth] = 0;
      }
    }
  }

}
