package com.study.bj.b2021.middleclass1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P16197_두_동전 {


  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};
  static int n, m;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {
    String[][] map;
    boolean[][] visit;

    String t1 = br.readLine();
    String[] t2 = t1.split(" ");
    System.out.println(Arrays.toString(t2));
    n = Integer.parseInt(t2[0]);
    m = Integer.parseInt(t2[1]);
    map = new String[n + 2][m + 2];
    visit = new boolean[n + 2][m + 2];

    Point[] ptArr = new Point[2];
    int idx = 0;
    for (int i = 1; i <= n; i++) {
      String t3 = br.readLine();
      bw.write(t3 + "\n");
      for (int j = 0; j < t3.length(); j++) {
        map[i][j + 1] = String.valueOf(t3.charAt(j));
        if (map[i][j + 1].equals("o")) {
          ptArr[idx++] = new Point(i, j + 1);
        }
      }
    }
    for (int i = 0; i < 4; i++) {

      solution(map, ptArr, 0);
    }

    printMap(map);
    br.close();
    bw.close();
  }

  private static void solution(String[][] map, Point[] ptArr, int depth) {

    if (depth > 10) {
      return;
    }




  }

  private static void printMap(String[][] map) throws IOException {

    for (int i = 0; i < n + 2; i++) {
      for (int j = 0; j < m + 2; j++) {
        bw.write(map[i][j] + " ");
      }
      bw.write("\n");
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
