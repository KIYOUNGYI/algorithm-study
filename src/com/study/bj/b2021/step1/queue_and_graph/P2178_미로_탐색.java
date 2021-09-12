package com.study.bj.b2021.step1.queue_and_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class P2178_미로_탐색 {

  static int sero, garo;
  static int[][] arr;
  static int[][] score;
  static boolean[][] visit;

  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    inputAndInit();

//    printArr();

    solution();

//    printScore();

    printAnswer();

  }

  private static void printAnswer() {
    System.out.println(score[sero][garo]);
  }

  private static void solution() {

    if (arr[1][1] == 1) {
      bfs(1, 1);
    } else {
      System.out.println(0);
    }

  }


  private static void bfs(int x, int y) {

    Queue<Point> q = new LinkedList<>();
    visit[x][y] = true;
    q.add(new Point(x, y));
    score[x][y] = 1;

    while (!q.isEmpty()) {

      Point poll = q.poll();
      int cx = poll.x;
      int cy = poll.y;

      for (int j = 0; j < 4; j++) {

        int tx = cx + dx[j];
        int ty = cy + dy[j];

        if (tx >= 1 && tx <= sero && ty >= 1 && ty <= garo && visit[tx][ty] == false && arr[tx][ty] == 1 && score[tx][ty] == 0) {

          visit[tx][ty] = true;
          q.add(new Point(tx, ty));

          score[tx][ty] = score[cx][cy] + 1;
        }

      }

    }

  }

  private static void inputAndInit() throws IOException {

    String tempInput = br.readLine();
    String[] tempStr = tempInput.split(" ");

    sero = Integer.parseInt(tempStr[0]);
    garo = Integer.parseInt(tempStr[1]);

    arr = new int[sero + 2][garo + 2];
    visit = new boolean[sero + 2][garo + 2];
    score = new int[sero + 2][garo + 2];

    for (int i = 1; i <= sero; i++) {
      String input = br.readLine();
      for (int j = 0; j < input.length(); j++) {
        arr[i][j + 1] = Integer.parseInt(String.valueOf(input.charAt(j)));
      }
    }
  }

  public static void printArr() {

    for (int i = 1; i <= sero; i++) {
      for (int j = 1; j <= garo; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void printScore() {

    for (int i = 1; i <= sero; i++) {
      for (int j = 1; j <= garo; j++) {
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

    @Override
    public String toString() {
      return "Point{" +
          "x=" + x +
          ", y=" + y +
          '}';
    }
  }
}
