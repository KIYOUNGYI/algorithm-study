package com.study.bj.b2021.step3.simulation;

import java.util.Scanner;

public class P1952_달팽이2 {

  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};
  static int sero;
  static int garo;
  static int[][] arr;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    sero = scan.nextInt();
    garo = scan.nextInt();

    arr = new int[sero + 2][garo + 2];

    for (int i = 0; i < sero + 2; i++) {
      arr[i][0] = -1;
      arr[i][garo + 1] = -1;
    }

    for (int i = 0; i < garo + 2; i++) {
      arr[0][i] = -1;
      arr[sero + 1][i] = -1;
    }

    traverse();

//    printArr();

  }


  private static void traverse() {
    int ans = 0;
//    v[1][1] = true;
    arr[1][1] = 1;
    int cnt = 1;
    int i = 0;
    int tx = 1;
    int ty = 1;
    while (cnt != sero * garo) {
      int backupX = tx;
      int backupY = ty;
      tx = tx + dx[i];
      ty = ty + dy[i];

      if (arr[tx][ty] == 0) {
//        System.out.println("tx:"+tx+" ty:"+ty);
        arr[tx][ty] = 1;
        cnt += 1;
      } else {
        tx = backupX;
        ty = backupY;
        i = (i + 1) % 4;
        ans += 1;
      }
    }
    System.out.println(ans);

  }

  private static void printArr() {

    for (int i = 0; i < sero + 2; i++) {
      for (int j = 0; j < garo + 2; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }

  }

}
