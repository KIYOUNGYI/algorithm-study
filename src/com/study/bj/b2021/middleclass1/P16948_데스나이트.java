package com.study.bj.b2021.middleclass1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class P16948_데스나이트 {

  static int[] dx = {-2, -2, 0, 0, 2, 2};
  static int[] dy = {-1, 1, -2, 2, -1, 1};
  static int[][] map, score;
  static int n;
  static int stx, sty, edx, edy;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {
    String s = br.readLine();
    n = Integer.parseInt(s);
    map = new int[n][n];
    score = new int[n][n];

    String s1 = br.readLine();
    String[] s2 = s1.split(" ");
    stx = Integer.parseInt(s2[0]);
    sty = Integer.parseInt(s2[1]);
    edx = Integer.parseInt(s2[2]);
    edy = Integer.parseInt(s2[3]);

    bfs(stx, sty);
    System.out.println(score[edx][edy] == 0 ? -1 : score[edx][edy]);
  }

  private static void bfs(int x, int y) {

    Queue<Point> q = new LinkedList<>();
    score[x][y] = 0;
    q.add(new Point(x, y));

    while (!q.isEmpty()) {

      Point poll = q.poll();

      int tx = poll.x;
      int ty = poll.y;
      int tempScore = score[tx][ty];

      for (int i = 0; i <= 5; i++) {

        int ax = tx + dx[i];
        int ay = ty + dy[i];

        if (ax >= 0 && ay >= 0 && ax < n && ay < n && score[ax][ay] == 0) {
          score[ax][ay] = tempScore + 1;
          if (ax == edx && ay == edy) {
            break;
          }
          q.add(new Point(ax, ay));
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

    @Override
    public String toString() {
      return "Point{" +
          "x=" + x +
          ", y=" + y +
          '}';
    }
  }
}
