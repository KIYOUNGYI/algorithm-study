package com.study.bj.b2021.step1.brute_force.permutation;

import java.util.Scanner;

public class P10819_차이를_최대로_2 {

  static int n;
  static boolean[] v;
  static int[] a;
  static int[] result;
  static int max = Integer.MIN_VALUE;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    a = new int[n + 1];
    v = new boolean[n + 1];
    result = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      a[i] = scan.nextInt();
    }

    recursion(1);
    System.out.println(max);
  }

  private static void recursion(int depth) {

    if (depth == n + 1) {
//      System.out.println(Arrays.toString(result));
      calculate();
      return;
    }

    for (int i = 1; i <= n; i++) {
      if (!v[i]) {
        v[i] = true;
        result[depth] = a[i];
        recursion(depth + 1);
        v[i] = false;
      }
    }
  }

  private static void calculate() {

    int sum = 0;
    for (int i = 1; i <= n - 1; i++) {
//      System.out.println(i + " " + (i + 1));
      sum = sum + abs(result[i] - result[i + 1]);
    }
    if (sum > max) {
      max = sum;
    }
//    System.out.println("---");
  }

  private static int abs(int i) {
    return i > 0 ? i : -i;
  }

}
