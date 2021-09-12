package com.study.bj.b2021.step1.practice;

import java.util.Scanner;

public class P14890 {

  static int n;
  static int l;
  static int[][] a;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    l = scan.nextInt();

    a = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        a[i][j] = scan.nextInt();
      }
    }
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      int[] arr = new int[n];
      boolean[] c = new boolean[n];
      for (int j = 0; j < n; j++) {
        arr[j] = a[i][j];
      }
      if (check(arr, c)) {
        cnt += 1;
      }
    }

    for (int i = 0; i < n; i++) {
      int[] arr = new int[n];
      boolean[] c = new boolean[n];
      for (int j = 0; j < n; j++) {
        arr[j] = a[j][i];
      }
      if (check(arr, c)) {
        cnt += 1;
      }
    }

    System.out.println(cnt);
  }

  private static boolean check(int[] arr, boolean[] c) {
    int len = arr.length;

    for (int i = 0; i < len - 1; i++) {

      // 인접한 것이 2 이상 차이 false
      if (abs(arr[i] - arr[i + 1]) >= 2) {
        return false;
      } else if (arr[i] - arr[i + 1] == 1) {// [2,1]

        for (int k = 0; k < l; k++) {

          //범위
          if (i + 1 + k >= n) {
            return false;
          }
          if (c[i + 1 + k]) {
            return false;
          }

          if (arr[i + 1] == arr[i + 1 + k]) {
            c[i + 1 + k] = true;
          } else {
            return false;
          }
        }


      } else if (arr[i] - arr[i + 1] == -1) {

        for (int k = 0; k < l; k++) {

          if (i - k < 0) {
            return false;
          }
          if (c[i - k]) {
            return false;
          }
          if (arr[i] == arr[i - k]) {
            c[i - k] = true;
          } else {
            return false;
          }

        }

      }

    }

    return true;
  }

  private static int abs(int x) {
    return x > 0 ? x : -x;
  }

}
