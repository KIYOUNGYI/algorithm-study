package com.study.bj.b2021.step1.simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P16927_배열_돌리기2 {

  static int[][] arr;
  static boolean[][] shifted;
  static int[][] temp;
  static int n, m, r;
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {

    input();

    for (int i = 0; i < r; i++) {
      traverse();
      reset();
    }
    printArr();
    bw.close();
  }

  private static void traverse() {

    int stx = 1;
    int sty = 1;
    int i = 0;

    shifted[stx][sty] = true;
    int cnt = 1;

    temp[stx][sty] = arr[1][2];
    int originValue = -1;

    while (cnt != n * m) {

      int originX = stx;
      int originY = sty;

      stx = stx + dx[i];
      sty = sty + dy[i];

      if (stx >= 1 && stx <= n && sty >= 1 && sty <= m && !shifted[stx][sty]) {
        cnt++;
        shifted[stx][sty] = true;
        temp[stx][sty] = arr[originX][originY];

      } else {
        //보정
        if (i == 3) {
          stx = stx + 1;
          sty = sty + 1;
        } else {
          stx = originX;
          sty = originY;
        }
        i = (i + 1) % 4;
      }
    }

  }


  public static void reset() {

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        arr[i][j] = temp[i][j];
        temp[i][j] = 0;
        shifted[i][j] = false;
      }
    }

//    temp = new int[n + 5][m + 5];
//    shifted = new boolean[n + 5][m + 5];
  }

  public static void input() throws IOException {

    String input1 = br.readLine();
    String[] input1Temp = input1.split(" ");

    n = Integer.parseInt(input1Temp[0]);
    m = Integer.parseInt(input1Temp[1]);
    r = Integer.parseInt(input1Temp[2]);

    arr = new int[n + 5][m + 5];
    temp = new int[n + 5][m + 5];
    shifted = new boolean[n + 5][m + 5];

    for (int i = 1; i <= n; i++) {

      String temp = br.readLine();
      String[] inputTemp2 = temp.split(" ");
      for (int j = 1; j <= m; j++) {
        String t1 = inputTemp2[j - 1];
        arr[i][j] = Integer.parseInt(t1);
      }
    }
  }

  public static void printArr() throws IOException {

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        bw.write(arr[i][j] + " ");
      }
      bw.write("\n");
    }
    bw.flush();
  }

  public static void printTemp() {

    for (int i = 0; i < n + 2; i++) {
      for (int j = 0; j < m + 2; j++) {
        System.out.print(temp[i][j] + " ");
      }
      System.out.println();
    }
  }
}
