package com.study.bj.b2021.step1.brute_force.n_and_m;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

//96%
public class P18290_NM과K_1_v2 {

  static int total;
  static int n, m, k;
  static int[][] arr;
  static boolean[][] visit;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};
  static int MAX = Integer.MIN_VALUE;
  static List<Integer> arrList = new ArrayList<>();
  static int[] firstArr;
  static Point[] pointArr;

  public static void main(String[] args) throws IOException {

    inputAndInit();
    solution();
    System.out.println(MAX);
  }


  private static void solution() {
    dfs(0, 1);
  }

  private static void dfs(int depth, int value) {

    if (depth == k) {

      if (!validation()) {
        rollbackVisit();
        return;
      }

      calculate();
      rollbackVisit();
      return;
    } else if (value == total + 1) {
      rollbackVisit();
      return;
    }

    arrList.add(value);
    dfs(depth + 1, value + 1);
    int len = arrList.size();
    arrList.remove(len - 1);
    dfs(depth, value + 1);
  }


  private static void calculate() {
    int sum = 0;
    for (int i = 0; i < arrList.size(); i++) {
      int t1 = arrList.get(i);
      sum += firstArr[t1];
    }
    if (MAX < sum) {
      MAX = sum;
    }
  }

  private static boolean validation() {

    for (int i = 0; i < arrList.size(); i++) {
      int t = arrList.get(i);
      Point p = pointArr[t];
      visit[p.x][p.y] = true;
    }

    for (int i = 0; i < arrList.size(); i++) {

      int t = arrList.get(i);
      Point p = pointArr[t];
      int x = p.x;
      int y = p.y;
      for (int k = 0; k < 4; k++) {
        int tx = x + dx[k];
        int ty = y + dy[k];
        if (visit[tx][ty] == true) {
          return false;
        }
      }
    }
//    System.out.println("pass");
    return true;
  }


  private static void printVisit() {
    System.out.println("===================");
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (visit[i][j]) {
          System.out.print("o ");
        } else {
          System.out.print("x ");
        }
//        System.out.print(visit[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println("===================");
  }

  private static void rollbackVisit() {
    //rollback;
    visit = new boolean[n + 2][m + 2];
  }

  private static void inputAndInit() throws IOException {

    String input1 = br.readLine();
    String[] temp1 = input1.split(" ");
    n = Integer.parseInt(temp1[0]);
    m = Integer.parseInt(temp1[1]);
    k = Integer.parseInt(temp1[2]);
    arr = new int[n + 2][m + 2];
    visit = new boolean[n + 2][m + 2];

    total = n * m;
    firstArr = new int[total + 1];
    pointArr = new Point[total + 1];

    int tempIdx = 1;

    for (int i = 1; i <= n; i++) {
      String input2 = br.readLine();
      String[] temp2 = input2.split(" ");
      for (int j = 0; j < temp2.length; j++) {

        firstArr[tempIdx] = Integer.parseInt(temp2[j]);
        pointArr[tempIdx] = new Point(i, j + 1);
        tempIdx += 1;
        arr[i][j + 1] = Integer.parseInt(temp2[j]);

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
//4 4 4
//1 0 0 1
//0 0 0 0
//0 0 0 0
//1 0 0 1