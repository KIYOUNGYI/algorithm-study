package com.study.bj.b2021.step1.brute_force.brute;

import java.util.Scanner;

public class 사각형_교차_구현_연습 {

  static Scanner scan = new Scanner(System.in);
  static int n;
  static int[][] arr;

  public static void main(String[] args) {

    input();
    traverse();
//    printArr();


  }

  private static void traverse() {

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {

        int tx = i;
        int ty = j;

        int cnt1 = garo(tx, ty);
        int cnt2 = sero(tx, ty);
        int max = max(cnt1, cnt2);

        System.out.println("[" + i + "][" + j + "]:" + max);
      }
    }
  }

  private static int max(int a, int b) {
    return a > b ? a : b;
  }

  private static int sero(int tx, int ty) {
    int cnt = 1;
    int cx = tx;
    int cy = ty;
    int pivot = arr[tx][ty];

    for (int i = cx + 1; i <= n; i++) {
      if (arr[i][cy] == pivot) {
        cnt += 1;
      } else {
        break;
      }
    }

    for (int i = cx - 1; i >= 1; i--) {
      if (arr[i][cy] == pivot) {
        cnt += 1;
      } else {
        break;
      }
    }

    return cnt;
  }

  private static int garo(int tx, int ty) {
    int cnt = 1;
    int cx = tx;
    int cy = ty;
    int pivot = arr[tx][ty];

    for (int i = cy + 1; i <= n; i++) {
      if (arr[cx][i] == pivot) {
        cnt += 1;
      } else {
        break;
      }
    }

    for (int i = cy - 1; i >= 1; i--) {
      if (arr[cx][i] == pivot) {
        cnt += 1;
      } else {
        break;
      }
    }

    return cnt;
  }

  private static void input() {
    n = scan.nextInt();
    arr = new int[n + 2][n + 2];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        arr[i][j] = scan.nextInt();
      }
    }
  }

  private static void printArr() {

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }
}
