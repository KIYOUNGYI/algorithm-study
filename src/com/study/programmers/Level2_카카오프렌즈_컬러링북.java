package com.study.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Level2_카카오프렌즈_컬러링북 {

  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};
  static boolean[][] visit;
  static int sero, garo;

  public static int[] solution(int m, int n, int[][] picture) {

    int numberOfArea = 0;
    int maxSizeOfOneArea = 0;

    visit = new boolean[m][n];
    sero = m;
    garo = n;

    for (int i = 0; i < sero; i++) {

      for (int j = 0; j < garo; j++) {
        if (picture[i][j] != 0 && !visit[i][j]) {
          int t = bfs(i, j, picture);
          maxSizeOfOneArea = Math.max(t, maxSizeOfOneArea);
          numberOfArea += 1;
        }
      }
    }

    int[] answer = new int[2];
    answer[0] = numberOfArea;
    answer[1] = maxSizeOfOneArea;
    return answer;
  }

  private static int bfs(int x, int y, int[][] picture) {

    int pivot = picture[x][y];
    Queue<Point> q = new LinkedList<>();
    q.add(new Point(x, y));
    visit[x][y] = true;
    int cnt = 0;

    while (!q.isEmpty()) {

      Point poll = q.poll();
      int tx = poll.x;
      int ty = poll.y;
      cnt += 1;

      for (int i = 0; i < 4; i++) {

        int ax = tx + dx[i];
        int ay = ty + dy[i];

        if (ax >= 0 && ax < sero && ay >= 0 && ay < garo && !visit[ax][ay] && picture[ax][ay] == pivot) {
          visit[ax][ay] = true;
          q.add(new Point(ax, ay));
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

  public static void main(String[] args) {
    int[][] arr = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
    int[] solution = solution(6, 4, arr);
    System.out.println("Arrays.toString(solution) = " + Arrays.toString(solution));
  }


}
