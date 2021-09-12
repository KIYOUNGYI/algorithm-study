package com.study.bj.b2021.step1.brute_force.n_and_m;

import java.util.Scanner;

public class P15649_N과M_1_v2 {

  static boolean[] v;
  static int[] arr;
  static int n;
  static int r;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    n = scan.nextInt();
    r = scan.nextInt();
    arr = new int[r + 1];
    v = new boolean[n + 1];

    recursion(1);

  }

  private static void recursion(int depth) {

    if (depth == r + 1) {
//      System.out.println(Arrays.toString(arr));
      printArr();
      return;
    }

    for (int i = 1; i <= n; i++) {
      if (!v[i]) {
        v[i] = true;
        arr[depth] = i;
        recursion(depth + 1);
        v[i] = false;
      }
    }

  }

  private static void printArr() {
    for (int i = 1; i <= r; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
}
