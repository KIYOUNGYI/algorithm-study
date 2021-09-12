package com.study.bj.b2021.step1.simulation;

import java.util.Scanner;

public class P16926_배열돌리기1_v1 {

  static int sero;
  static int garo;
  static int shiftCount;
  static int[][] arr1;
  static int[][] arr2;
  static boolean[][] visit1;
  static boolean[][] visit2;
  static int[] dx = {1, 0, 0, -1};
  static int[] dy = {0, 1, -1, 0};
  static int cnt = 0;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    input(scan);

    solution();

  }

  private static void solution() {

    int j = 0;
    int startX = 1;
    int startY = 1;
    arr2[1][1] = arr1[1][2];

    visit1[startX][startY] = true;
    cnt += 1;

    while (cnt < sero * garo) {
      int tempX = startX;
      int tempY = startY;
      int temp = arr1[tempX][tempY];
      int tx = startX + dx[j % 4];
      int ty = startY + dy[j % 4];


//      System.out.println("tx : " + tx + " ty : " + ty);
//      System.out.println("cnt = " + cnt);
      if (!visit1[tx][ty] && arr1[tx][ty] != 0) {
        visit1[tx][ty] = true;
        cnt += 1;
        arr2[tx][ty] = temp;
        System.out.println("tx:"+tx+" ty:"+ty+" temp:"+arr2[tx][ty]);
        startX = tx;
        startY = ty;

      } else {
        j += 1;
        startX = tempX;
        startY = tempY;
      }

    }

    print(arr2);

  }


  private static void input(Scanner scan) {
    sero = scan.nextInt();
    garo = scan.nextInt();
    shiftCount = scan.nextInt();
    arr1 = new int[sero + 2][garo + 2];
    arr2 = new int[sero + 2][garo + 2];
    visit1 = new boolean[sero + 2][garo + 2];
    visit2 = new boolean[sero + 2][garo + 2];

    for (int i = 1; i <= sero; i++) {
      for (int j = 1; j <= garo; j++) {
        arr1[i][j] = scan.nextInt();
      }
    }
  }


  public static void print(int[][] arr) {
    for (int i = 1; i <= sero; i++) {
      for (int j = 1; j <= garo; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }
}
