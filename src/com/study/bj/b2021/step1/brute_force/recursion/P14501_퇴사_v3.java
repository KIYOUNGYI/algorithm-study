package com.study.bj.b2021.step1.brute_force.recursion;

import java.util.Scanner;

public class P14501_퇴사_v3 {

  static int n;
  static int[] t;
  static int[] p;
  static int[] balance;
  static int[] marking;
  static int limit;
  static int max = 0;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    t = new int[n + 1];
    p = new int[n + 1];
    marking = new int[n + 1];
    balance = new int[25];

    for (int i = 1; i <= n; i++) {
      int a = scan.nextInt();
      int b = scan.nextInt();
      t[i] = a;
      p[i] = b;
    }

    for (int i = 1; i <= n; i++) {
      limit = i;
      recursion(1, 0);
      marking = new int[n + 1];
    }
    System.out.println(max);
  }

  private static void recursion(int depth, int sum) {

    if (sum == limit) {
      calculate();
      balance = new int[25];
      return;
    }

    if (depth == n + 1) {
      return;
    }

    marking[depth] = 1;
    recursion(depth + 1, sum + 1);
    marking[depth] = 0;
    recursion(depth + 1, sum);
  }

  private static void calculate() {

    for (int i = 1; i <= n; i++) {
      if (marking[i] == 1) {
        int x = t[i];
        for (int j = i; j < i + x; j++) {
          balance[j] += 1;
        }
      }
    }
    if (check()) {
      int t = sum();
      if (t > max) {
        max = t;
      }
    }
  }

  private static int sum() {
    int sum = 0;
    for (int i = 1; i <= n; i++) {
      if (marking[i] == 1) {
        sum += p[i];
      }
    }
    return sum;
  }

  private static boolean check() {

    //v[i] 중에 2 이상인 것 있으면 거짓
    //balance[n+1] 이후에 1이상인 것이 있으면 거짓
    for (int i = 1; i <= n; i++) {
      if (balance[i] >= 2) {
        return false;
      }
    }

    for (int i = n + 1; i < 25; i++) {
      if (balance[i] >= 1) {
        return false;
      }
    }

    return true;
  }


}
