package com.study.bj;

import java.util.Scanner;

/**
 * 적록색약
 * https://www.acmicpc.net/problem/10026 bfs
 */
public class P100626 {

  static boolean[][] visit;
  static int[][] arr;
  static int N;
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};

  public static void main(String[] args) {
//    System.out.println((int) 'R');//82
//    System.out.println((int) 'G');//71
//    System.out.println((int) 'B');//66
    Scanner scan = new Scanner(System.in);
    N = scan.nextInt();
    arr = new int[N][N];
    visit = new boolean[N][N];

    scan.nextLine();
    for (int i = 0; i < N; i++) {
      String temp = scan.nextLine();
      for (int j = 0; j < N; j++) {
        arr[i][j] = temp.charAt(j);
      }
    }
    solveProblem();


  }

  public static void solveProblem() {
    int cnt1 = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visit[i][j]) {
          visit[i][j] = true;
          cnt1 += 1;
          dfs1(i, j);
        }
      }
    }
//    System.out.println(cnt1);
    int cnt2 = 0;

    initVisit();

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visit[i][j]) {
          visit[i][j] = true;
          cnt2 += 1;
          dfs2(i, j);
        }
      }
    }
    System.out.println(cnt1 + " " + cnt2);
    return;
  }

  public static void dfs1(int x, int y) {
    int color = arr[x][y];

    for (int t = 0; t < 4; t++) {
      int tx = x + dx[t];
      int ty = y + dy[t];
      if (tx >= 0 && ty >= 0 && tx < N && ty < N) {
        if (!visit[tx][ty] && color == arr[tx][ty]) {
          visit[tx][ty] = true;
          dfs1(tx, ty);
        }
      }
    }
  }

  public static void dfs2(int x, int y) {
    int color = arr[x][y];
//    System.out.println((int) 'R');//82
//    System.out.println((int) 'G');//71

    for (int t = 0; t < 4; t++) {
      int tx = x + dx[t];
      int ty = y + dy[t];
      if (tx >= 0 && ty >= 0 && tx < N && ty < N) {
        if (!visit[tx][ty] && color == arr[tx][ty]) {
          visit[tx][ty] = true;
          dfs2(tx, ty);
        } else if (!visit[tx][ty] && color == 82 && arr[tx][ty] == 71) {
          visit[tx][ty] = true;
          dfs2(tx, ty);
        } else if (!visit[tx][ty] && color == 71 && arr[tx][ty] == 82) {
          visit[tx][ty] = true;
          dfs2(tx, ty);
        }
      }
    }
  }

  private static void initVisit() {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        visit[i][j] = false;
      }
    }
  }


  private static void printArr() {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

}
