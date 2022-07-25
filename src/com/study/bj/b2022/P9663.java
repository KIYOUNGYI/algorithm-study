package com.study.bj.b2022;

import java.util.Arrays;
import java.util.Scanner;

public class P9663 {

  static int N, ans = 0;
  static int[] col;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    N = scan.nextInt();
    col = new int[N + 1];
    recursion(1);
    System.out.println(ans);
  }

  public static void recursion(int row) {

    if (row == N + 1) {
      if (validityCheck()) {
        System.out.println("Arrays.toString(col) = " + Arrays.toString(col));
        ans += 1;
      }
    } else {

      for (int c = 1; c <= N; c++) {
        col[row] = c;
        recursion(row + 1);
        col[row] = 0;
      }

    }

  }

  private static boolean validityCheck() {

    for (int i = 1; i <= N; i++) {
      //i, col[i]
      //j, col[j]
      for (int j = 1; j <= N; j++) {
        if (i == j) {
          continue;
        }
        if (attackAble(i, col[i], j, col[j])) {
          return false;
        }
      }
    }

    return true;
  }

  private static boolean attackAble(int x1, int y1, int x2, int y2) {

    if (y1 == y2) {
      return true;
    }
    if (x1 == x2) {
      return true;
    }
    if (x1 - y1 == x2 - y2) {
      return true;
    }
    if (x1 + y1 == x2 + y2) {
      return true;
    }

    return false;
  }

}
