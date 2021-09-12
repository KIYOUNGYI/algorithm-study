package com.study.bj.b2021.step1.practice;

import java.util.Scanner;

public class P14503 {

  static int n, m;
  static int[][] a;
  static int sx, sy;
  static int dir;
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    n = scan.nextInt();
    m = scan.nextInt();
    a = new int[n][m];
    sx = scan.nextInt();
    sy = scan.nextInt();
    dir = scan.nextInt();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        a[i][j] = scan.nextInt();
      }
    }

    solution();
//    printArr();
    calculate();
  }

  private static void solution() {

    int d = dir;
    int tx = sx;
    int ty = sy;

    for (; ; ) {

      if (a[tx][ty] == 0) {
        a[tx][ty] = 2;
      }

      if (a[tx - 1][ty] != 0 && a[tx + 1][ty] != 0 && a[tx][ty - 1] != 0 && a[tx][ty + 1] != 0) {//4방향 청소할 곳이 없으면

        //뒤로 빠꾸
        tx = tx - dx[d];
        ty = ty - dy[d];
        //뒤로 빠꾸했는데 벽이면 종료
        if (a[tx][ty] == 1) {
          break;
        }
      } else {

        d = (d + 3) % 4;//0->3 ,
        if (a[tx + dx[d]][ty + dy[d]] == 0) {
          tx = tx + dx[d];
          ty = ty + dy[d];
        }
      }

    }

  }


  private static void printArr() {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(a[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static void calculate() {
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (a[i][j] == 2) {
          cnt += 1;
        }
      }
    }
    System.out.println(cnt);
  }

}
