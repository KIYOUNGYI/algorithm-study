package com.study.bj.b2021.step1.queue_and_graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P7562_나이트의_이동_v2 {


  static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
  static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
  static int tc;
  static int n;
  static int sx, sy;
  static int ex, ey;
  static int[][] map;
  static int[][] score;
  static boolean[][] v;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    tc = scan.nextInt();

    for (int i = 1; i <= tc; i++) {

      n = scan.nextInt();
      map = new int[n][n];
      score = new int[n][n];
      v = new boolean[n][n];

      sx = scan.nextInt();
      sy = scan.nextInt();
      ex = scan.nextInt();
      ey = scan.nextInt();
      bfs(sx, sy);

    }


  }

  private static void bfs(int sx, int sy) {

    Queue<Point> q = new LinkedList<>();
    q.add(new Point(sx, sy));
    v[sx][sy] = true;

    while (!q.isEmpty()) {

      Point pt = q.poll();
      int tempX = pt.x;
      int tempY = pt.y;
      if (pt.x == ex && pt.y == ey) {
        System.out.println(score[ex][ey]);
        return;
      }

      for (int i = 0; i < 8; i++) {

        int tx = pt.x + dx[i];
        int ty = pt.y + dy[i];

        if (tx >= 0 && tx < n && ty >= 0 && ty < n && v[tx][ty] == false) {
          v[tx][ty] = true;
          score[tx][ty] = score[pt.x][pt.y] + 1;
          q.add(new Point(tx, ty));
        }

      }

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
