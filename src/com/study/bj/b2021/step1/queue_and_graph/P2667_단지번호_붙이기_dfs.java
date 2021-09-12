package com.study.bj.b2021.step1.queue_and_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P2667_단지번호_붙이기_dfs {

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
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (arr[i][j] != 0 && !v[i][j]) {
          danjiCnt = 1;
          v[i][j] = true;
          dfs(i, j);
          arrList.add(danjiCnt);
          danjiCnt = 0;
        }
      }
    }
    System.out.println(arrList.size());
    Collections.sort(arrList);
    for (Integer v : arrList) {
      System.out.println(v);
    }
//    System.out.println(arrList.toString());
//    System.out.println(danjiCnt);
//    printArr();
  }

  private static void dfs(int x, int y) {

//    System.out.println("x = " + x + ", y = " + y);

    for (int a = 0; a < 4; a++) {
      int tx = x + dx[a];
      int ty = y + dy[a];
      if (tx >= 0 && ty >= 0 && tx < n && ty < n && !v[tx][ty] && arr[tx][ty] != 0) {
        v[tx][ty] = true;
        danjiCnt += 1;
        dfs(tx, ty);
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
}
