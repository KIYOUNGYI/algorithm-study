package com.study.bj.b2021.step1.queue_and_graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class P7576_토마토 {

  static Scanner scan = new Scanner(System.in);
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int garo, sero;
  static int[][] arr;
  static int[][] score;
  static boolean[][] visit;
  static List<Point> pointList = new ArrayList<>();
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};

  public static void main(String[] args) throws IOException {

    inputAndInit();
    bfs();

  }

  private static void bfs() {

    Queue<Point> q = new LinkedList<>();
    int backupScore = 0;

    for (int i = 0; i < pointList.size(); i++) {
      Point pt = pointList.get(i);
      visit[pt.x][pt.y] = true;
      q.add(pt);
    }

    while (!q.isEmpty()) {

      Point node = q.poll();
      int backupX = node.x;
      int backupY = node.y;
      backupScore = score[backupX][backupY];

      for (int j = 0; j < 4; j++) {
        int tx = backupX + dx[j];
        int ty = backupY + dy[j];

        if (tx >= 1 && ty >= 1 && tx <= sero && ty <= garo && arr[tx][ty] != -1 && visit[tx][ty] == false) {
          visit[tx][ty] = true;
          score[tx][ty] = backupScore + 1;
          arr[tx][ty] = 1;
          q.add(new Point(tx, ty));
        }
      }

    }

    if (isZeroContain()) {
      System.out.println(-1);
    } else {
      System.out.println(backupScore);
    }

  }


  private static boolean isZeroContain() {

    for (int i = 1; i <= sero; i++) {
      for (int j = 1; j <= garo; j++) {

        if (arr[i][j] == 0) {
          return true;
        }
      }
    }

    return false;
  }

  private static void inputAndInit() {

    garo = scan.nextInt();
    sero = scan.nextInt();
    arr = new int[sero + 2][garo + 2];
    visit = new boolean[sero + 2][garo + 2];
    score = new int[sero + 2][garo + 2];

    for (int i = 1; i <= sero; i++) {
      for (int j = 1; j <= garo; j++) {
        arr[i][j] = scan.nextInt();
      }
    }

    //method 추출
    for (int i = 1; i <= sero; i++) {
      for (int j = 1; j <= garo; j++) {
        if (arr[i][j] == 1) {
          pointList.add(new Point(i, j));
          score[i][j] = 0;
        }
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
