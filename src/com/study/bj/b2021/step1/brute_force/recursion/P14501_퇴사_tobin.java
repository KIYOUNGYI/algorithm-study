package com.study.bj.b2021.step1.brute_force.recursion;

import java.util.Scanner;

public class P14501_퇴사_tobin {

  static int[] visit;
  static int n;
  static int r;
  static int[] t;
  static int[] p;
  static int max = Integer.MIN_VALUE;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    visit = new int[n];
    t = new int[n];
    p = new int[n];

    for (int i = 0; i < n; i++) {
      t[i] = scan.nextInt();
      p[i] = scan.nextInt();
    }

    for (int i = 0; i <= n; i++) {
      r = i;
      dfs(0, 0);
    }

    System.out.println(max);

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
    visit[depth] = 1;
    dfs(depth + 1, 1);
    visit[depth] = 0;
    dfs(depth + 1, 0);
  }

  public static int sum() {

    int t = 0;
    for (int i = 0; i < n; i++) {
      t += visit[i];
    }
    return t;
  }

  public static void print() {

    int[] temp = new int[n];
    for (int i = 0; i < n; i++) {

      if (visit[i] == 1) {

        int left = n - i;
        int tVal = t[i];

        if (tVal > left) {
          return;
        }

        if (left < 0) {
          return;
        }

        int score = t[i];//3
        for (int j = 0; j < score; j++) {
          temp[i + j] += 1;
        }
      }
    }

    for (int i = 0; i < n; i++) {
      if (temp[i] >= 2) {
        return;
      }
    }


    int sum = 0;
    for (int i = 0; i < n; i++) {
      if (visit[i] == 1) {
        sum += p[i];
      }
    }

    if (max < sum) {
      max = sum;
    }
  }
}
