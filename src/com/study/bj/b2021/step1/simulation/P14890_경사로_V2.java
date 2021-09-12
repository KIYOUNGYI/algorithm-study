package com.study.bj.b2021.step1.simulation;

import java.util.Scanner;

/**
 * 폭파
 */
public class P14890_경사로_V2 {

  static int n, l;
  static int[][] arr;
  static boolean[][] visit;
  static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {

    input();

    solution();

  }

  private static void solution() {
    int cnt = 0;
    for (int j = 1; j <= n; j++) {

      boolean r1 = determineSero(j);
//      System.out.println(r1);
//      System.out.println("----------");
      boolean r2 = determineGaro(j);
//      System.out.println(r2);
      if (r1) {
        cnt += 1;
      } else {
        visit = new boolean[n + 50][n + 50];
      }

      if (r2) {
        cnt += 1;
      } else {
        visit = new boolean[n + 50][n + 50];
      }
    }
    System.out.println(cnt);


  }


  private static boolean determineSero(int y) {

    for (int curX = 1; curX <= n - 1; curX++) {
      int next = curX + 1;

      //[1] 낮은 높은 칸 차이 1 아닌 경우
      if (abs(arr[curX][y] - arr[next][y]) >= 2) {
        visit = new boolean[n + 50][n + 50];
        return false;
      }

      //   [2]
      //[1][2]
      if (arr[curX][y] + 1 == arr[next][y]) {

        int std = arr[curX][y];
        int cnt1 = 0;

        for (int k = curX; k > (curX - l); k--) {

          if (k >= 1 && visit[k][y] == false && arr[k][y] == std) {

            visit[k][y] = true;
            cnt1 += 1;

          } else {
            visit = new boolean[n + 50][n + 50];
            return false;
          }
        }

        if (cnt1 != l) {
          visit = new boolean[n + 50][n + 50];
          return false;
        }
      }

      //[2]
      //[2][1]
      if (arr[curX][y] == arr[next][y] + 1) {

        int std = arr[next][y];
        int cnt1 = 0;

        for (int k = curX + 1; k < (curX + l + 1); k++) {

          if (k <= n && visit[k][y] == false && arr[k][y] == std) {

            visit[k][y] = true;
            cnt1 += 1;

          } else {
            visit = new boolean[n + 50][n + 50];
            return false;
          }
        }

        if (cnt1 != l) {
          visit = new boolean[n + 50][n + 50];
          return false;
        }
      }
    }

    visit = new boolean[n + 50][n + 50];
    return true;
  }


  private static boolean determineGaro(int x) {

    for (int curY = 1; curY <= n - 1; curY++) {
      int next = curY + 1;

      //[1] 낮은 높은 칸 차이 1 아닌 경우
      if (abs(arr[x][curY] - arr[x][next]) >= 2) {
        visit = new boolean[n + 50][n + 50];
        return false;
      }

      //   [2]
      //[1][2]
      if (arr[x][curY] + 1 == arr[x][next]) {

        int std = arr[x][curY];
        int cnt1 = 0;

        for (int k = curY; k > (curY - l); k--) {

          if (k >= 1 && visit[x][k] == false && arr[x][k] == std) {

            visit[x][k] = true;
            cnt1 += 1;

          } else {
            visit = new boolean[n + 50][n + 50];
            return false;
          }
        }

        if (cnt1 != l) {
          visit = new boolean[n + 50][n + 50];
          return false;
        }
      }

      //[2]
      //[2][1]
      if (arr[x][curY] == arr[x][next] + 1) {

        int std = arr[x][next];
        int cnt1 = 0;

        for (int k = curY + 1; k < (curY + l + 1); k++) {

          if (k <= n && visit[x][k] == false && arr[x][k] == std) {

            visit[x][k] = true;
            cnt1 += 1;

          } else {
            visit = new boolean[n + 50][n + 50];
            return false;
          }
        }

        if (cnt1 != l) {
          visit = new boolean[n + 50][n + 50];
          return false;
        }
      }
    }

    visit = new boolean[n + 50][n + 50];
    return true;
  }


  private static int abs(int x) {
    return x > 0 ? x : -x;
  }

  private static void input() {
    n = scan.nextInt();
    l = scan.nextInt();
    arr = new int[n + 50][n + 50];
    visit = new boolean[n + 50][n + 50];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        arr[i][j] = scan.nextInt();
      }
    }
  }

  private static void printArr() {

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

}
