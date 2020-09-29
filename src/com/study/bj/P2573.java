package com.study.bj;

import java.util.Scanner;

/**
 * 빙산 (하아)
 * https://www.acmicpc.net/problem/2573
 */
public class P2573 {

  static int[] dx = new int[]{0, 1, 0, -1};
  static int[] dy = new int[]{1, 0, -1, 0};
  static int garo, sero;
  static int[][] map;
  static int[][] temp;
  static boolean[][] visit;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    sero = scan.nextInt();
    garo = scan.nextInt();
    map = new int[sero][garo];
    temp = new int[sero][garo];
    visit = new boolean[sero][garo];
    for (int i = 0; i < sero; i++) {
      for (int j = 0; j < garo; j++) {
        map[i][j] = scan.nextInt();
      }
    }
    iceberg();
    scan.close();
  }

  public static void iceberg() {
    int ans = 0;
    for (int time = 1; time <= 5000; time++) {
      decreaseHeight();
      if (check()) {
        ans = 0;
        break;
      }
      int cnt = 0;

      for (int i = 0; i < sero; i++) {
        for (int j = 0; j < garo; j++) {
          if (map[i][j] != 0 && visit[i][j] == false) {
            visit[i][j] = true;
            dfs(i, j);
            cnt += 1;
          }
        }
      }
      initVisit();
      if (cnt >= 2) {
        ans = time;
        break;
      }
      cnt = 0;
    }
    System.out.println(ans);

  }

  private static void initVisit() {
    for (int i = 0; i < sero; i++) {
      for (int j = 0; j < garo; j++) {
        visit[i][j] = false;
      }
    }
  }


  public static void dfs(int x, int y) {
    for (int i = 0; i < 4; i++) {
      int tx = x + dx[i];
      int ty = y + dy[i];

      if (tx >= 1 && ty >= 1 && tx <= sero && ty <= garo) {
        if (visit[tx][ty] == false && map[tx][ty] != 0) {
          visit[tx][ty] = true;
          dfs(tx, ty);
        }
      }
    }
  }


  public static void decreaseHeight() {

    for (int i = 0; i < sero; i++) {
      for (int j = 0; j < garo; j++) {

        if (map[i][j] != 0) {
          int cnt = 0;
          for (int k = 0; k < 4; k++) {
            int tx = i + dx[k];
            int ty = j + dy[k];

            if (tx >= 0 && tx < sero && ty >= 0 && ty < garo) {
              if (map[tx][ty] == 0) {
                cnt += 1;
              }
            }
          }
          temp[i][j] = cnt;
        }
      }
    }

    for (int i = 0; i < sero; i++) {
      for (int j = 0; j < garo; j++) {
        map[i][j] = map[i][j] - temp[i][j];
        if (map[i][j] < 0) {
          map[i][j] = 0;
        }
        temp[i][j] = 0;
      }
    }

  }

  public static boolean check() {
    for (int i = 0; i < sero; i++) {
      for (int j = 0; j < garo; j++) {
        if (map[i][j] != 0) {
          return false;
        }
      }
    }
    return true;
  }


  public static void printArr() {
    for (int i = 0; i < sero + 2; i++) {
      for (int j = 0; j < garo + 2; j++) {
        System.out.print(map[i][j] + " ");
      }
      System.out.println();
    }
  }
}
