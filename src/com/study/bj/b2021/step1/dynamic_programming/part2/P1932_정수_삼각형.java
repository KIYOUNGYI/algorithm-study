package com.study.bj.b2021.step1.dynamic_programming.part2;

import java.util.Scanner;

public class P1932_정수_삼각형 {

  static int[][] d;
  static int[][] arr;
  static int n;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    n = scan.nextInt();
    arr = new int[n][n];
    d = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= i; j++) {
        arr[i][j] = scan.nextInt();
      }
    }

    d[0][0] = arr[0][0];

    for (int i = 1; i < n; i++) {
      d[i][0] = d[i - 1][0] + arr[i][0];
    }

    for (int i = 1; i < n; i++) {
      d[i][i] = d[i - 1][i - 1] + arr[i][i];
    }

    for (int j = 2; j < n; j++) {

      for (int k = 1; k < j; k++) {
        d[j][k] = max(d[j - 1][k - 1], d[j - 1][k]) + arr[j][k];
      }
    }

//    printArr();
//    printSum();

    findMax();

  }

  private static void findMax() {
    int max = -1;
    for (int i = 0; i < n; i++) {
      int t = d[n - 1][i];
      if (t > max) {
        max = t;
      }
    }
    System.out.println(max);
  }


  private static int max(int a, int b) {
    return a > b ? a : b;
  }

  private static void printArr() {

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static void printSum() {

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(d[i][j] + " ");
      }
      System.out.println();
    }
  }

}
