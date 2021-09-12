package com.study.bj.b2021.step1.queue_and_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P1261_알고스팟 {

  static int sero, garo;
  static int[][] arr;
  static int[][] score;

  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    inputAndInit();
    bfs();
    System.out.println(score[sero][garo]);
//    printScore();
  }

  private static void bfs() {

    Queue<Point> q = new LinkedList<>();
    Queue<Point> nextQ = new LinkedList<>();
    q.add(new Point(1, 1));
    score[1][1] = 0;

    while (!q.isEmpty()) {

      Point pt = q.poll();
      int px = pt.x;
      int py = pt.y;

      for (int i = 0; i < 4; i++) {
        int tx = px + dx[i];
        int ty = py + dy[i];

        if (tx >= 1 && tx <= sero && ty >= 1 && ty <= garo && score[tx][ty] == -1) {

          if (arr[tx][ty] == 0) {

            score[tx][ty] = score[px][py];
            q.add(new Point(tx, ty));
          } else {//arr[tx][ty]==1
            score[tx][ty] = score[px][py] + 1;
            nextQ.add(new Point(tx, ty));
          }
        }
      }

      if (q.isEmpty()) {
        q = nextQ;
        nextQ = new LinkedList<>();
      }
    }

  }


  private static void inputAndInit() throws IOException {

    String tempInput = br.readLine();
    String[] tempStr = tempInput.split(" ");

    garo = Integer.parseInt(tempStr[0]);
    sero = Integer.parseInt(tempStr[1]);

    arr = new int[sero + 2][garo + 2];
    score = new int[sero + 2][garo + 2];

    for (int i = 1; i <= sero; i++) {
      String input = br.readLine();
      for (int j = 0; j < input.length(); j++) {
        arr[i][j + 1] = Integer.parseInt(String.valueOf(input.charAt(j)));
      }
    }
    for (int i = 1; i <= sero; i++) {
      Arrays.fill(score[i], -1);
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

  public static int min(int a, int b) {
    return a >= b ? b : a;
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
