package com.study.bj.b2021.step2;

import java.util.Scanner;

public class P14225_부분수열의_합 {

  static int n;
  static int[] result;
  static int[] a;
  static boolean[] v;
  static int visitLimit;
  static boolean[] score = new boolean[2_500_001];

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    n = scan.nextInt();
    a = new int[n + 1];//[x,1,2,3]
    v = new boolean[n + 1];//[x,1,2,3]

    for (int i = 1; i <= n; i++) {
      a[i] = scan.nextInt();
    }

    for (int i = 1; i <= n; i++) {
      visitLimit = i + 1;
      result = new int[visitLimit];
      recursion(1);
    }

    for (int i = 1; i < 2_500_001; i++) {
      if (!score[i]) {
        System.out.println(i);
        return;
      }
    }

  }

  private static int sum() {
    int sum = 0;
    for (int i = 1; i < visitLimit; i++) {
      sum += a[result[i]];
    }
    return sum;
  }

  private static void recursion(int depth) {

    if (depth == visitLimit) {
//      System.out.println(Arrays.toString(result));
      int x = sum();
      if (!score[x]) {
        score[x] = true;
      }
      return;
    }

    if (depth == 1) {

      for (int i = 1; i <= n; i++) {
        if (!v[i]) {
          v[i] = true;
          result[depth] = i;
          recursion(depth + 1);
          v[i] = false;
        }
      }
    } else if (depth >= 2) {

      for (int i = 1; i <= n; i++) {
        if (!v[i] && result[depth - 1] < i) {
          v[i] = true;
          result[depth] = i;
          recursion(depth + 1);
          v[i] = false;
        }
      }
    }

  }
}
