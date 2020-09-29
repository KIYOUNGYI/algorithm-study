package com.study.bj;

import java.util.Scanner;

/**
 * 1, 2, 3 더하기 https://www.acmicpc.net/problem/9095 재귀로 풀어봤음 완탐으로 풀어보고 그다음 다시 재귀로 좀 가지고 놀아보고
 */
public class P9095 {

  static int cnt = 0;
  static int[] arr;
  static int n;
  static int limit;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    for (int i = 0; i < n; i++) {
      limit = scan.nextInt();
      arr = new int[limit];
      recursive(0, 0);
      System.out.println(cnt);
      cnt = 0;
    }
    scan.close();
  }

  public static void recursive(int depth, int sum) {
    if (sum == limit) {
      cnt += 1;
      return;
    }

    for (int i = 1; i <= 3; i++) {
      if (sum + i <= limit) {
        arr[depth] = i;
        recursive(depth + 1, sum + i);
        arr[depth] = 0;
      }
    }
  }
}
