package com.study.bj;

import java.util.Scanner;

/**
 * 자리배정 https://www.acmicpc.net/problem/10157 세부 보정하는 로직이 썩 깔끔하진 못했다.
 */
public class P10157 {

  static int t;
  static int garo, sero;
  static int[][] map;
  static int[] dx = new int[]{0, 1, 0, -1};
  static int[] dy = new int[]{1, 0, -1, 0};

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    garo = scan.nextInt();
    sero = scan.nextInt();
    map = new int[garo + 20][sero + 20];
    init();
    problem();
    t = scan.nextInt();

    if (t > garo * sero) {
      System.out.println(0);
      return;
    }
    find();
//        printArr();
    scan.close();
  }

  private static void find() {
    for (int i = 1; i <= garo; i++) {
      for (int j = 1; j <= sero; j++) {
        if (t == map[i][j]) {
          System.out.println(i + " " + j);
          return;
        }
      }
    }
  }

  private static void problem() {
    int x = 1;
    int y = 0;

    int v = 0;

    int mod = 0;
    while (true) {
      if (v == garo * sero) {
        break;
      }
      if (map[x + dx[mod]][y + dy[mod]] != 0) {
        mod = (mod + 1) % 4;
      } else {
        x = x + dx[mod];
        y = y + dy[mod];
        v += 1;
        map[x][y] = v;
      }
    }
  }


  private static void init() {
    for (int i = 0; i < garo + 20; i++) {
      for (int j = 0; j < sero + 20; j++) {
        map[i][j] = -1;
      }
    }
    for (int i = 1; i <= garo; i++) {
      for (int j = 1; j <= sero; j++) {
        map[i][j] = 0;
      }
    }
  }

  private static void printArr() {
    for (int i = 0; i < garo + 5; i++) {
      for (int j = 0; j < sero + 5; j++) {
        System.out.print(map[i][j] + " ");
      }
      System.out.println();
    }
  }

}
