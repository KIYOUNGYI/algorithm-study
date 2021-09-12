package com.study.bj.b2021.step1.queue_and_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P2178_미로_탐색_2 {

  static int sero, garo;
  static int[][] arr;
  static int[][] score;
  static boolean[][] visit;

  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    inputAndInit();
    visit[1][1] = true;
    score[1][1] = 1;

    bfs(1, 1);
    System.out.println(score[sero][garo]);
  }

  private static void bfs(int x, int y) {

    Queue<Point> q = new LinkedList<>();

    visit[x][y] = true;
    q.add(new Point(x, y));

    while (!q.isEmpty()) {

      Point pt = q.poll();

      for (int i = 0; i < 4; i++) {
        int tx = pt.x + dx[i];
        int ty = pt.y + dy[i];

        //다음 장소
        if (tx >= 1 && ty >= 1 && tx <= sero && ty <= garo) {

          if (visit[tx][ty] == false && score[tx][ty] == 0 && arr[tx][ty] == 1) {
            visit[tx][ty] = true;
            score[tx][ty] = score[pt.x][pt.y] + 1;
            q.add(new Point(tx, ty));
          }

          if (tx == sero && ty == garo) {
            score[tx][ty] = score[pt.x][pt.y] + 1 < score[tx][ty] ? score[pt.x][pt.y] + 1 : score[tx][ty];
          }

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

  public static void printScore() {

    for (int i = 1; i <= sero; i++) {
      for (int j = 1; j <= garo; j++) {
        System.out.print(score[i][j] + " ");
      }
      System.out.println();
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

  static class Point {

    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }


  }

}
