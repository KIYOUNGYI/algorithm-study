package com.study.bj.b2021.step1.queue_and_graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//bfs로 풀기
public class P2667_단지번호_붙이기_bfs_v1_박살남 {

  static int N;
  static int[][] arr;
  static boolean[][] visit;
  static int cnt = 0;
  static int groupCnt = 0;
  static List<Integer> arrList = new ArrayList<>();

  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    inputAndInt();

//    printArr();

    solution();


  }


  private static void solution() {

    for (int x = 1; x <= N; x++) {

      for (int y = 1; y <= N; y++) {

        if (!visit[x][y] && arr[x][y] == 1) {
          visit[x][y] = true;
          bfs(x, y);
          if (cnt > 0) {
            groupCnt += 1;
            arrList.add(cnt);
            cnt = 0;
          }
        }

      }
    }

    Collections.sort(arrList);

    System.out.println(groupCnt);
    for (int i = 0; i < arrList.size(); i++) {
      System.out.println(arrList.get(i));
    }

  }

  private static void bfs(int x, int y) {

    Queue<Point> q = new LinkedList<>();

    Point p = new Point(x, y);
    q.add(p);

    while (!q.isEmpty()) {

      Point poll = q.poll();
      cnt += 1;//이녀석
      int originalX = poll.getX();
      int originalY = poll.getY();

      for (int i = 0; i < 4; i++) {

        int tempX = originalX + dx[i];
        int tempY = originalY + dy[i];

        if (tempX >= 1 && tempY >= 1 && tempX <= N && tempY <= N && arr[tempX][tempY] == 1 && !visit[tempX][tempY]) {

          visit[tempX][tempY] = true;
          Point nextPoint = new Point(tempX, tempY);
          q.add(nextPoint);

        }

      }

    }

  }


  private static void inputAndInt() throws IOException {

    N = Integer.parseInt(br.readLine());

    arr = new int[N + 2][N + 2];
    visit = new boolean[N + 2][N + 2];

    for (int i = 1; i <= N; i++) {
      String input = br.readLine();
      for (int j = 0; j < input.length(); j++) {
        arr[i][j + 1] = Integer.parseInt(String.valueOf(input.charAt(j)));
      }
    }
  }

  public static void printArr() {

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int getX() {
      return x;
    }

    public void setX(int x) {
      this.x = x;
    }

    public int getY() {
      return y;
    }

    public void setY(int y) {
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
