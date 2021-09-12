package com.study.bj.b2021.step1.brute_force.brute;

import java.util.Scanner;

public class P3085_사탕_게임_v2 {

  static int max = 0;
  static int answer = 0;
  static Scanner scan = new Scanner(System.in);
  static int n;
  static int[][] candyMap;
  static int[][] backup;
  static boolean[][] visit;
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};

  public static void main(String[] args) {

    inputAndInit();
    solution();
//    traverse();
    System.out.println(answer);

  }


  private static void solution() {

    for (int x = 1; x <= n; x++) {
      for (int y = 1; y <= n; y++) {
//    for (int x = 1; x <= 1; x++) {
//      for (int y = 1; y <= 1; y++) {

        int tempX = x;
        int tempY = y;
        int backupVal = candyMap[tempX][tempY];

        for (int t = 0; t < 4; t++) {
//        for (int t = 0; t < 1; t++) {

          int tx = tempX + dx[t];
          int ty = tempY + dy[t];

          if (tx >= 1 && tx <= n && ty >= 1 && ty <= n) {
            //swap
//            System.out.println("[" + tempX + "][" + tempY + "] 와 [" + tx + "][" + ty + "] swap");
            candyMap[tempX][tempY] = candyMap[tx][ty];
            candyMap[tx][ty] = backupVal;
          }

          //dfs
//          core();
          traverse();

          //rollback
          recover();
          initVisit();
        }
      }
    }

  }

  private static void traverse() {

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {

        int tx = i;
        int ty = j;

        int cnt1 = garo(tx, ty);
        int cnt2 = sero(tx, ty);
        int max = max(cnt1, cnt2);
        if (max > answer) {
          answer = max;
        }
//        System.out.println("[" + i + "][" + j + "]:" + max);
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
    int pivot = candyMap[tx][ty];

    for (int i = cx + 1; i <= n; i++) {
      if (candyMap[i][cy] == pivot) {
        cnt += 1;
      } else {
        break;
      }
    }

    for (int i = cx - 1; i >= 1; i--) {
      if (candyMap[i][cy] == pivot) {
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
    int pivot = candyMap[tx][ty];

    for (int i = cy + 1; i <= n; i++) {
      if (candyMap[cx][i] == pivot) {
        cnt += 1;
      } else {
        break;
      }
    }

    for (int i = cy - 1; i >= 1; i--) {
      if (candyMap[cx][i] == pivot) {
        cnt += 1;
      } else {
        break;
      }
    }

    return cnt;
  }

  private static void recover() {

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        candyMap[i][j] = backup[i][j];
      }
    }
  }

  private static void initVisit() {
    visit = new boolean[n + 2][n + 2];
  }

  private static void inputAndInit() {
    n = scan.nextInt();
    scan.nextLine();

    candyMap = new int[n + 2][n + 2];
    backup = new int[n + 2][n + 2];
    visit = new boolean[n + 2][n + 2];
    for (int i = 1; i <= n; i++) {
      String temp = scan.nextLine();
//      System.out.println(temp);
      for (int j = 1; j <= n; j++) {
        char c = temp.charAt(j - 1);
        candyMap[i][j] = c;
        backup[i][j] = c;
      }
    }
  }


  private static void printArr() {

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        System.out.print(candyMap[i][j] + " ");
      }
      System.out.println();
    }
  }
}
