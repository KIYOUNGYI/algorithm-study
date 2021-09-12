package com.study.bj.b2021.step1.brute_force.recursion;

import java.util.Scanner;

public class P2529_v2 {

  static boolean flag2 = false;
  static boolean flag1 = false;
  static int[] a;
  static String[] buho;
  static int n;
  static boolean[] visit = new boolean[10];

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();

    buho = new String[n + 1];
    a = new int[n + 2];
    for (int i = 1; i <= n; i++) {
      String t = scan.next();
      buho[i] = t;
    }

    recursion1(1);
    visit = new boolean[10];
    a = new int[n + 2];
    recursion2(1);
  }

  //big
  private static void recursion1(int depth) {

    if (flag1) {
      return;
    }

    if (depth == n + 2) {
//      System.out.println(Arrays.toString(a));
      printArr();
      flag1 = true;
      return;
    }

    if (depth == 1) {
      for (int i = 9; i >= 0; i--) {
        if (!visit[i]) {
          a[depth] = i;
          visit[i] = true;
          recursion1(depth + 1);
          visit[i] = false;
        }
      }
    }
    if (depth >= 2) {
      for (int i = 9; i >= 0; i--) {

        if (!visit[i] && buho[depth - 1].equals(">") && a[depth - 1] > i) {
          a[depth] = i;
          visit[i] = true;
          recursion1(depth + 1);
          visit[i] = false;
        }
        if (!visit[i] && buho[depth - 1].equals("<") && a[depth - 1] < i) {
          a[depth] = i;
          visit[i] = true;
          recursion1(depth + 1);
          visit[i] = false;
        }

      }
    }
  }


  private static void recursion2(int depth) {

    if (flag2) {
      return;
    }

    if (depth == n + 2) {
//      System.out.println(Arrays.toString(a));
      printArr();
      flag2 = true;
      return;
    }

    if (depth == 1) {
      for (int i = 0; i <= 9; i++) {
        if (!visit[i]) {
          a[depth] = i;
          visit[i] = true;
          recursion2(depth + 1);
          visit[i] = false;
        }
      }
    }
    if (depth >= 2) {
      for (int i = 0; i <= 9; i++) {

        if (!visit[i] && buho[depth - 1].equals(">") && a[depth - 1] > i) {
          a[depth] = i;
          visit[i] = true;
          recursion2(depth + 1);
          visit[i] = false;
        }
        if (!visit[i] && buho[depth - 1].equals("<") && a[depth - 1] < i) {
          a[depth] = i;
          visit[i] = true;
          recursion2(depth + 1);
          visit[i] = false;
        }

      }
    }
  }

  private static void printArr() {

    for (int i = 1; i <= n + 1; i++) {
      System.out.print(a[i]);
    }
    System.out.println();

  }

}
