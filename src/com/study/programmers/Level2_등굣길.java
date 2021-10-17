package com.study.programmers;

import java.util.Arrays;

public class Level2_등굣길 {


  static boolean[][] check;
  static int[][] arr;
  static int sero;
  static int garo;
  static final int mod = 1_000_000_007;

  public static int solution(int m, int n, int[][] puddles) {

    garo = m;
    sero = n;

    arr = new int[sero + 1][garo + 1];
    check = new boolean[sero + 1][garo + 1];

    for (int i = 0; i < puddles.length; i++) {
      int[] t = puddles[i];
      System.out.println(Arrays.toString(t));
      check[t[0]][t[1]] = true;
    }

    arr[1][1] = 1;

    for (int i = 1; i <= sero; i++) {
      for (int j = 1; j <= garo; j++) {
        if (i == 1 && j == 1) {
          continue;
        }
        if (!check[i][j]) {
//          System.out.println("i = " + i + " j = " + j);
          arr[i][j] = (arr[i - 1][j] + arr[i][j - 1]) % mod;

        }

      }
    }

//    print();

    return arr[sero][garo];
  }


  private static void print() {

    for (int i = 1; i <= sero; i++) {
      for (int j = 1; j <= garo; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {

    int[][] puddles = {};
    System.out.println(solution(2, 2, puddles));
  }
}
