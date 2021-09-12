package com.study.bj.b2021.step1.queue_and_graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P7576_토마토_v2 {

  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};

  static int sero, garo;
  static boolean[][] v;
  static int[][] arr;
  static int[][] score;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    garo = scan.nextInt();
    sero = scan.nextInt();

    arr = new int[sero][garo];
    score = new int[sero][garo];
    v = new boolean[sero][garo];

    for (int i = 0; i < sero; i++) {
      for (int j = 0; j < garo; j++) {
        arr[i][j] = scan.nextInt();
      }
    }

    //예외 처리
    if (arrNoZero()) {
      System.out.println(0);
      return;
    }

    bfs();

    if (check()) {
      System.out.println(findMaxScore());
    } else {
      System.out.println(-1);
    }

  }

  private static boolean check() {
    for (int i = 0; i < sero; i++) {
      for (int j = 0; j < garo; j++) {
        if (v[i][j] == false && arr[i][j] == 0) {
          return false;
        }
      }
    }
    return true;
  }

  private static int findMaxScore() {
    int max = -1;
    for (int i = 0; i < sero; i++) {
      for (int j = 0; j < garo; j++) {
        int t = score[i][j];
        if (t > max) {
          max = t;
        }
      }
    }
    return max;
  }

  private static void bfs() {

    Queue<Point> q = new LinkedList<>();

    for (int i = 0; i < sero; i++) {
      for (int j = 0; j < garo; j++) {

        if (arr[i][j] == 1) {
          v[i][j] = true;
          q.add(new Point(i, j));
        }
      }
    }

    while (!q.isEmpty()) {

      Point pt = q.poll();

      for (int i = 0; i < 4; i++) {

        int tx = pt.x + dx[i];
        int ty = pt.y + dy[i];

        if (tx >= 0 && ty >= 0 && tx < sero && ty < garo && !v[tx][ty] && arr[tx][ty] == 0) {
          v[tx][ty] = true;
          score[tx][ty] = score[pt.x][pt.y] + 1;
          q.add(new Point(tx, ty));
        }
      }

    }

  }

  private static boolean noVisitContains() {

    for (int i = 0; i < sero; i++) {
      for (int j = 0; j < garo; j++) {
        if (v[i][j] == false) {
          return false;
        }
      }
    }
    return true;
  }

  private static boolean arrNoZero() {

    for (int i = 0; i < sero; i++) {
      for (int j = 0; j < garo; j++) {
        if (arr[i][j] == 0) {
          return false;
        }
      }
    }
    return true;
  }

  private static void printScore() {

    for (int i = 0; i < sero; i++) {
      for (int j = 0; j < garo; j++) {
        System.out.print(score[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static void printArr() {

    for (int i = 0; i < sero; i++) {
      for (int j = 0; j < garo; j++) {
        System.out.print(score[i][j] + " ");
      }
      System.out.println();
    }
  }


  static class Point {

    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
