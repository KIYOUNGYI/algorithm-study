package com.study.bj.b2021.step1.brute_force.recursion;

import java.util.Scanner;

public class P9095_1_2_3_더하기 {

  static int cnt;
  static int t;
  static int n;
  static int[] arr;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    t = scan.nextInt();
    for (int i = 1; i <= t; i++) {
      cnt = 0;
      n = scan.nextInt();
      arr = new int[n + 1];
      recursion(1, 0);
      System.out.println(cnt);

    }
  }

  private static void recursion(int depth, int sum) {

    if (sum == n) {
      cnt += 1;
//      System.out.println(Arrays.toString(arr));
      return;
    }
    if (sum > n) {
      return;
    }
    if (depth == n + 1) {
      return;
    }

    for (int i = 1; i <= 3; i++) {

//      if (sum + i <= n) {//(b)
      arr[depth] = i;
      recursion(depth + 1, sum + i);
      arr[depth] = 0;//(a)
//      }
    }

  }

  private static boolean checkSum() {

    return sum() == n ? true : false;
  }

  private static int sum() {
    int sum = 0;
    for (int i = 1; i <= n; i++) {
      sum += arr[i];
    }
    return sum;
  }
}
