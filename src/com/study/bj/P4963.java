package com.study.bj;

import java.util.Scanner;

/**
 * 섬의 개수 https://www.acmicpc.net/problem/4963 dfs로 품 다음엔 bfs로 풀어보자
 */
public class P4963 {

  static int[] dx = {0, 1, 0, -1, -1, -1, 1, 1};
  static int[] dy = {1, 0, -1, 0, -1, 1, -1, 1};
  static int[][] map;
  static boolean[][] visit;
  static int garo, sero;
  static int cnt = 0;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    //1->land, 0->sea
    while (true) {
      garo = scan.nextInt();
      sero = scan.nextInt();
      if (garo == 0 && sero == 0) {
        break;
      }
      map = new int[sero][garo];
      visit = new boolean[sero][garo];
      for (int i = 0; i < sero; i++) {
        for (int j = 0; j < garo; j++) {
          map[i][j] = scan.nextInt();
        }
      }

      for (int i = 0; i < sero; i++) {
        for (int j = 0; j < garo; j++) {
          if (map[i][j] != 0 && visit[i][j] == false) {
            cnt += 1;
            dfs(i, j);
          }
        }
      }
      System.out.println(cnt);
      cnt = 0;
//      printMap();
    }

    scan.close();
  }

  public static void dfs(int x, int y) {
    for (int a = 0; a < 8; a++) {
      int tx = x + dx[a];
      int ty = y + dy[a];
      if (tx >= 0 && tx < sero && ty >= 0 && ty < garo) {
        if (map[tx][ty] == 1 && visit[tx][ty] == false) {
          visit[tx][ty] = true;
          dfs(tx, ty);
        }
      }
    }
  }

  public static void printMap() {
    for (int i = 0; i < sero; i++) {
      for (int j = 0; j < garo; j++) {
        System.out.print(map[i][j] + " ");
      }
      System.out.println();
    }
  }

}
