package com.study.bj.b2021.step1.queue_and_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P2667_단지번호_붙이기_bfs_v2 {

  static int danjiCnt;//7,8,9
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};

  static boolean[][] v;
  static int[][] arr;
  static int n;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    n = Integer.parseInt(br.readLine());
    arr = new int[n][n];
    v = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      String[] split = s.split("");
      for (int j = 0; j < split.length; j++) {
        int k = Integer.parseInt(split[j]);
        arr[i][j] = k;
      }
    }
    List<Integer> arrList = new ArrayList<>();
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (v[i][j] == false && arr[i][j] == 1) {
          cnt += 1;
          bfs(i, j);
          arrList.add(danjiCnt);
          danjiCnt = 0;
        }
      }
    }

    Collections.sort(arrList);
    System.out.println(cnt);
    for (Integer v : arrList) {
      System.out.println(v);
    }
  }

  private static void bfs(int x, int y) {

    Queue<Point> q = new LinkedList<>();
    q.add(new Point(x, y));
    v[x][y] = true;

    while (!q.isEmpty()) {

      Point poll = q.poll();
      danjiCnt += 1;
      int px = poll.x;
      int py = poll.y;

      for (int i = 0; i < 4; i++) {
        int tx = px + dx[i];
        int ty = py + dy[i];

        if (tx >= 0 && ty >= 0 && tx < n && ty < n && v[tx][ty] == false && arr[tx][ty] == 1) {

          v[tx][ty] = true;
          q.add(new Point(tx, ty));
        }
      }
    }
  }

  private static void printArr() {

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
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
