package com.study.bj.b2021.middleclass1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P14502_연구소 {

  static int sero, garo;
  static int[][] map;
  static int[][] original;
  static int ans = -1;
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    sero = scan.nextInt();
    garo = scan.nextInt();
    map = new int[sero][garo];
    original = new int[sero][garo];

    for (int i = 0; i < sero; i++) {
      for (int j = 0; j < garo; j++) {
        map[i][j] = scan.nextInt();
        original[i][j] = map[i][j];
      }
    }
    int cnt = 0;
    for (int i = 0; i < sero; i++) {
      for (int j = 0; j < garo; j++) {

        for (int k = 0; k < sero; k++) {
          for (int l = 0; l < garo; l++) {

            if (k == i && j == l) {
              continue;
            }

            for (int m = 0; m < sero; m++) {
              for (int n = 0; n < garo; n++) {

                if (m == k && n == l) {
                  continue;
                }

                if (m == i && n == j) {
                  continue;
                }
//                System.out.println(i + " " + j + " " + k + " " + l + " " + m + " " + n);

                if (map[i][j] == 0 && map[k][l] == 0 && map[m][n] == 0) {
//                  System.out.println("!!!");
                  cnt += 1;
                  map[i][j] = 1;
                  map[k][l] = 1;
                  map[m][n] = 1;

                  bfs();

//                  map[i][j] = 0;
//                  map[k][l] = 0;
//                  map[m][n] = 0;
//                  System.out.println("!!!");
                  rollback();

                } else {
//                  System.out.println("???");
                  rollback();
                  continue;
                }

              }
            }

          }
        }

      }
    }

    System.out.println(ans);

  }

  private static void rollback() {
    for (int i = 0; i < sero; i++) {
      for (int j = 0; j < garo; j++) {
        map[i][j] = original[i][j];
      }
    }
  }

  private static void bfs() {

    Queue<Point> q = new LinkedList<>();

    for (int i = 0; i < sero; i++) {
      for (int j = 0; j < garo; j++) {
        if (map[i][j] == 2) {
          q.add(new Point(i, j));
        }
      }
    }
//    System.out.println("q:" + q.toString());
    while (!q.isEmpty()) {

      Point poll = q.poll();
      int tx = poll.x;
      int ty = poll.y;

      for (int i = 0; i < 4; i++) {

        int ax = tx + dx[i];
        int ay = ty + dy[i];

        if (ax >= 0 && ay >= 0 && ax < sero && ay < garo && map[ax][ay] == 0) {
          map[ax][ay] = 2;
          q.add(new Point(ax, ay));
        }
      }
    }
    int t = countZero();
//    System.out.println("t:" + t);
    if (ans < t) {
      ans = t;
    }

  }

  private static int countZero() {
    int cnt = 0;
    for (int i = 0; i < sero; i++) {
      for (int j = 0; j < garo; j++) {

        if (map[i][j] == 0) {
          cnt += 1;
        }

      }
    }
    return cnt;
  }

  static class Point {

    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public String toString() {
      return "Point{" +
          "x=" + x +
          ", y=" + y +
          '}';
    }
  }

}
