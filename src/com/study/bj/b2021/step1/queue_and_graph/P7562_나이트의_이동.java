package com.study.bj.b2021.step1.queue_and_graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P7562_나이트의_이동 {

  static int tc;
  static int size;
  static int[][] arr;
  static int[][] score;
  static boolean[][] visit;
  static Scanner scan = new Scanner(System.in);
  static int startX, startY;
  static int endX, endY;

  static int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
  static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};


  public static void main(String[] args) {

    tc = scan.nextInt();

    for (int i = 0; i < tc; i++) {

      size = scan.nextInt();
      initArr();

      startX = scan.nextInt();
      startY = scan.nextInt();
      endX = scan.nextInt();
      endY = scan.nextInt();

      bfs(startX, startY);

      initArr();
    }
  }

  private static void bfs(int startX, int startY) {
//    System.out.println("startX = " + startX + ", startY = " + startY);
    Queue<Point> q = new LinkedList<>();
    visit[startX][startY] = true;
    score[startX][startY] = 0;
    q.add(new Point(startX, startY));

    while (!q.isEmpty()) {

      Point node = q.poll();
//      System.out.println("node:" + node.toString());
      int backupX = node.x;
      int backupY = node.y;
      int backupScore = score[backupX][backupY];

      if (backupX == endX && backupY == endY) {
        System.out.println(backupScore);
        return;
      }

      for (int i = 0; i < 8; i++) {

        int tx = backupX + dx[i];
        int ty = backupY + dy[i];

        if (tx >= 0 && tx < size && ty >= 0 && ty < size && visit[tx][ty] == false) {
          visit[tx][ty] = true;
          score[tx][ty] = backupScore + 1;
          q.add(new Point(tx, ty));
        }

      }
    }

    printScore();
  }

  private static void printScore() {

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        System.out.print(score[i][j] + " ");
      }
      System.out.println();
    }

  }

  private static void initArr() {

    arr = new int[size + 2][size + 2];
    score = new int[size + 2][size + 2];
    visit = new boolean[size + 2][size + 2];

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
//1
//8
//0 0
//7 0
