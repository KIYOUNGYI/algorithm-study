package com.study.bj.b2021.step1.brute_force.n_and_m;

import java.util.Scanner;

public class P18920_NM과_K_1 {

  static int sero, garo, cnt;
  static Point[] arr;
  static int[][] map;
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};
  static int[] answer1;
  static int limit;
  static int max = Integer.MIN_VALUE;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    sero = scan.nextInt();
    garo = scan.nextInt();
    cnt = scan.nextInt();
    map = new int[sero + 1][garo + 1];

    answer1 = new int[cnt + 1];

    limit = sero * garo;
    arr = new Point[sero * garo + 1];

    int idx = 1;

    for (int i = 1; i <= sero; i++) {
      for (int j = 1; j <= garo; j++) {
        map[i][j] = scan.nextInt();
        Point p = new Point(i, j);
        arr[idx++] = p;
      }
    }
//    System.out.println(Arrays.toString(arr));
    recursion(1);
    System.out.println(max);
  }

  private static void recursion(int depth) {

    if (depth == cnt + 1) {
//      printArr1();
      if (validation()) {
//        printArr1();
        int t = calculate();
        if (max < t) {
          max = t;
        }
      }
      return;
    }

    if (depth == 1) {
      for (int i = 1; i <= limit; i++) {
        answer1[depth] = i;
        recursion(depth + 1);
      }
    }
    if (depth >= 2) {
      for (int i = 1; i <= limit; i++) {

        if (answer1[depth - 1] < i) {
          answer1[depth] = i;
          recursion(depth + 1);
        }

      }
    }


  }

  private static boolean validation() {
    Point[] temp = new Point[cnt + 1];

//    System.out.println(Arrays.toString(answer1));

    for (int i = 1; i <= cnt; i++) {
      temp[i] = arr[answer1[i]];
    }

//    System.out.println(Arrays.toString(temp));

    for (int i = 1; i <= cnt; i++) {

      //기준
      Point pt = temp[i];

      int tx = pt.x;
      int ty = pt.y;

      for (int j = i + 1; j <= cnt; j++) {

        if (i == j) {
          continue;
        }

        Point pt2 = temp[j];//검사

        int tx2 = pt2.x;
        int ty2 = pt2.y;

        for (int k = 0; k < 4; k++) {
          int px = tx2 + dx[k];
          int py = ty2 + dy[k];
          if (px == tx && py == ty) {
            return false;
          }
        }
      }
    }

    return true;
  }

  private static int calculate() {
    int sum = 0;
    for (int i = 1; i <= cnt; i++) {
      int t = answer1[i];
      Point pt = arr[t];
      sum += map[pt.x][pt.y];
    }
    return sum;
  }

  private static void printArr1() {
    for (int i = 1; i <= cnt; i++) {
      System.out.print(answer1[i] + " ");
    }
    System.out.println();
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
