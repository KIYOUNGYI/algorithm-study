package com.study.bj.b2021.step1.brute_force.brute;

import java.util.Scanner;

public class P3085_사탕_게임 {

  static int max = 0;//deprecated
  static int maxX = 0;
  static int maxY = 0;
  static int cnt = 0;
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
    System.out.println(maxX);
    System.out.println(maxY);
//    printArr();
//    System.out.println(max);
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
          core2();

          //rollback
          recover();
          initVisit();
        }
      }
    }

  }

  private static void core2() {

    int garoMax = 0;
    int seroMax = 0;

    for (int x = 1; x <= n; x++) {

      for (int y = 1; y <= n; y++) {

        int tx = x;
        int ty = y;
        int pivot = candyMap[tx][ty];

        for (int i = tx + 1; i <= n; i++) {
          if (candyMap[i][ty] == pivot && visit[i][ty] == false) {
            seroMax += 1;
            visit[i][ty] = true;
          } else {
            System.out.println("return 1");
            break;
          }
        }
        for (int i = tx - 1; i >= 1; i--) {
          if (candyMap[i][ty] == pivot && visit[i][ty] == false) {
            seroMax += 1;
            visit[i][ty] = true;
          } else {
            System.out.println("return 2");
            break;
          }
        }

        for (int j = ty + 1; j <= n; j++) {
          if (candyMap[tx][j] == pivot && visit[tx][j] == false) {
            garoMax += 1;
            visit[tx][j] = true;
          } else {
            System.out.println("return 3");
            break;
          }
        }
        for (int j = ty - 1; j >= 1; j--) {
          if (candyMap[tx][j] == pivot && visit[tx][j] == false) {
            garoMax += 1;
            visit[tx][j] = true;
          } else {
            System.out.println("return 4");
            break;
          }
        }
      }

      if(garoMax>maxX){
        maxX = garoMax;
      }
      if(seroMax>maxY){
        maxY = seroMax;
      }
      garoMax = 0;
      seroMax = 0;

    }

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
      System.out.println(temp);
      for (int j = 1; j <= n; j++) {
        char c = temp.charAt(j - 1);
        candyMap[i][j] = c;
        backup[i][j] = c;
      }
    }
  }

  private static void core() {

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {

        int t = candyMap[i][j];
        if (!visit[i][j]) {
          visit[i][j] = true;
          dfs(i, j, t);
          System.out.println(cnt);
          if (cnt > max) {
            max = cnt;
          }
          cnt = 0;
        }
      }
    }
  }

  private static void dfs(int x, int y, int t) {
//    System.out.println("x = " + x + ", y = " + y + ", t = " + t);
    cnt += 1;
    for (int i = 0; i < 4; i++) {

      int tx = x + dx[i];
      int ty = y + dy[i];

      if (tx >= 1 && ty >= 1 && tx <= n && ty <= n && visit[tx][ty] == false && candyMap[tx][ty] == t) {
        visit[tx][ty] = true;
        dfs(tx, ty, t);
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
