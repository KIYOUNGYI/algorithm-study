package com.study.bj.b2021.step1.simulation;

import java.util.Scanner;

//폭파
public class P14504_로봇_청소기_v1 {

  static int cnt = 0;
  static int sero, garo;
  static int x, y, dir;
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, 1, 0, -1};
  static Scanner scan = new Scanner(System.in);
  static int[][] arr;

  public static void main(String[] args) {

    inputAndInit();

    traverse();

    System.out.println(cnt);

  }

  private static void traverse() {

    int sx = x;
    int sy = y;
    int d = dir;

    for (; ; ) {

      if (arr[sx][sy] == 0) {
        arr[sx][sy] = 2;
      }

      if (arr[sx + 1][sy] != 0 && arr[sx - 1][sy] != 0 && arr[sx][sy + 1] != 0 && arr[sx][sy - 1] != 0) {

        if (arr[sx - dx[d]][sy - dy[d]] == 1) {
          break;
        } else {
          sx -= dx[d];
          sy -= dy[d];
        }
      } else {
        d = (d + 3) % 4;
        if (arr[sx + dx[d]][sy + dy[d]] == 0) {
          sx += dx[d];
          sy += dy[d];
        }
      }
    }

//    printArr();
    for (int i = 1; i <= sero; i++) {
      for (int j = 1; j <= garo; j++) {
        if (arr[i][j] == 2) {
          cnt += 1;
        }
      }
    }


  }


  private static void inputAndInit() {

    sero = scan.nextInt();
    garo = scan.nextInt();
    x = scan.nextInt();
    y = scan.nextInt();
    x = x + 1;
    y = y + 1;
    dir = scan.nextInt();
    arr = new int[sero + 1][garo + 1];

    for (int i = 1; i <= sero; i++) {
      for (int j = 1; j <= garo; j++) {
        arr[i][j] = scan.nextInt();
      }
    }

  }

  private static void printArr() {
    for (int i = 1; i <= sero; i++) {
      for (int j = 1; j <= garo; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

}
