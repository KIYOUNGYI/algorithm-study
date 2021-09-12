package com.study.bj.b2021.step1.brute_force.n_and_m;

import java.util.Arrays;
import java.util.Scanner;

public class P15655_수_N과_M_6 {

  static int n;
  static int m;
  static int[] a;
  static int[] answer;
  static boolean[] v;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    m = scan.nextInt();

    a = new int[n + 1];
    answer = new int[m + 1];
    v = new boolean[n + 1];

    for (int i = 1; i <= n; i++) {
      a[i] = scan.nextInt();
    }
    Arrays.sort(a);
//    System.out.println(Arrays.toString(a));
    recursion(1);

  }

  private static void recursion(int depth) {

    if (depth == m + 1) {
      printArr();
      return;
    }

    if (depth == 1) {
      for (int i = 1; i <= n; i++) {
        if (!v[i]) {
          answer[depth] = a[i];
          v[i] = true;
          recursion(depth + 1);
          v[i] = false;
        }
      }
    }
    if (depth >= 2) {
      for (int i = 1; i <= n; i++) {
        if (answer[depth - 1] < a[i]) {
          if (!v[i]) {
            answer[depth] = a[i];
            v[i] = true;
            recursion(depth + 1);
            v[i] = false;
          }
        }
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
