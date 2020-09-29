package com.study.bj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 단지번호 붙이기 https://www.acmicpc.net/problem/2667 [1] dfs 로 풀었음 (무난)
 */
public class P2667 {

  static int[] dx = new int[]{0, 1, 0, -1};
  static int[] dy = new int[]{1, 0, -1, 0};
  static int n;
  static int[][] arr;
  static boolean[][] visited;
  static int cnt = 0;
  static int vil = 0;
  static ArrayList<Integer> arrList = new ArrayList<>();

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    n = scan.nextInt();
    arr = new int[n][n];
    visited = new boolean[n][n];
    scan.nextLine();
    for (int i = 0; i < n; i++) {
      String input = scan.nextLine();
      for (int j = 0; j < input.length(); j++) {
        arr[i][j] = input.charAt(j) - 48;
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (arr[i][j] != 0 && visited[i][j] == false) {

          dfs(i, j);
          cnt += 1;
          arrList.add(vil);
          vil = 0;
        }
      }
    }

    System.out.println(cnt);
    Collections.sort(arrList);
    for (int i = 0; i < arrList.size(); i++) {
      System.out.println(arrList.get(i));
    }

    scan.close();
  }

  public static void dfs(int x, int y) {
    vil += 1;
    visited[x][y] = true;
    for (int i = 0; i < 4; i++) {
      int cx = x + dx[i];
      int cy = y + dy[i];
      if (cx >= 0 && cy >= 0 && cx < n && cy < n && visited[cx][cy] == false && arr[cx][cy] == 1) {
        dfs(cx, cy);
      }
    }
  }
}
