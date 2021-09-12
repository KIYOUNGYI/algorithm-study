package com.study.bj.b2021.step1.practice;

import java.util.Scanner;

public class P16935 {

  static int n, m, cnt;
  static int[][] arr, temp;
  static int[] typeArr;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    m = scan.nextInt();
    cnt = scan.nextInt();
    typeArr = new int[cnt + 1];

    arr = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        arr[i][j] = scan.nextInt();
      }
    }
    for (int i = 1; i <= cnt; i++) {
      typeArr[i] = scan.nextInt();
    }

    for (int i = 1; i <= cnt; i++) {

      int sero = arr.length;
      int garo = arr[0].length;

      if (typeArr[i] == 1) {

        temp = new int[sero][garo];
        type1(sero, garo);

      } else if (typeArr[i] == 2) {

        temp = new int[sero][garo];
        type2(sero, garo);

      } else if (typeArr[i] == 3) {

        temp = new int[garo][sero];
        type3();


      } else if (typeArr[i] == 4) {

        temp = new int[garo][sero];
        type4();

      } else if (typeArr[i] == 5) {

        temp = new int[sero][garo];
        type5();

      } else if (typeArr[i] == 6) {

        temp = new int[sero][garo];
        type6();

      }
      //copy -> arr
      recover();
    }
    int sero = arr.length;
    int garo = arr[0].length;
    printResult(sero, garo);
  }

  private static void type6() {

    int s1 = temp.length;//8
    int g1 = temp[0].length;//6

    for (int i = 0; i < s1 / 2; i++) {
      for (int j = 0; j < g1 / 2; j++) {
        temp[i + s1 / 2][j] = arr[i][j];
      }
    }

    for (int i = 0; i < s1 / 2; i++) {
      for (int j = g1 / 2; j < g1; j++) {
        temp[i][j - g1 / 2] = arr[i][j];
      }
    }

    for (int i = s1 / 2; i < s1; i++) {
      for (int j = g1 / 2; j < g1; j++) {
        temp[i - s1 / 2][j] = arr[i][j];
      }
    }

    for (int i = s1 / 2; i < s1; i++) {
      for (int j = 0; j < g1 / 2; j++) {
        temp[i][j + g1 / 2] = arr[i][j];
      }
    }

  }

  private static void type5() {

    int s1 = temp.length;//8
    int g1 = temp[0].length;//6

    for (int i = 0; i < s1 / 2; i++) {
      for (int j = 0; j < g1 / 2; j++) {
        temp[i][j + g1 / 2] = arr[i][j];
      }
    }

    for (int i = 0; i < s1 / 2; i++) {
      for (int j = g1 / 2; j < g1; j++) {
        temp[i + s1 / 2][j] = arr[i][j];
      }
    }

    for (int i = s1 / 2; i < s1; i++) {
      for (int j = g1 / 2; j < g1; j++) {

        temp[i][j - g1 / 2] = arr[i][j];

      }
    }

    for (int i = s1 / 2; i < s1; i++) {
      for (int j = 0; j < g1 / 2; j++) {
        temp[i - s1 / 2][j] = arr[i][j];
      }
    }

  }

  private static void type4() {
    int s1 = temp.length;//8
    int g1 = temp[0].length;//6

    for (int i = 0; i < g1; i++) {
      int y = s1 - 1;
      for (int j = 0; j < s1; j++) {
        temp[y][i] = arr[i][j];
        y = y - 1;
      }
    }
  }

  //좀 걸렸다.
  private static void type3() {

    int s1 = temp.length;
    int g1 = temp[0].length;
    int x = g1 - 1;
    for (int i = 0; i < g1; i++) {

      for (int j = 0; j < s1; j++) {
        temp[j][x] = arr[i][j];
      }
      x = x - 1;
    }


  }

  private static void printResult(int sero, int garo) {
    for (int i = 0; i < sero; i++) {
      for (int j = 0; j < garo; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }

  }

  private static void type1(int s, int g) {

    int t1 = s - 1;

    for (int i = 0; i < s; i++) {
      for (int j = 0; j < g; j++) {
        temp[t1][j] = arr[i][j];
      }
      t1 = t1 - 1;
    }
  }


  private static void type2(int s, int g) {

    for (int i = 0; i < s; i++) {
      int t1 = g - 1;
      for (int j = 0; j < g; j++) {
        temp[i][t1] = arr[i][j];
        t1 -= 1;
      }

    }
  }

  private static void recover() {

    int sero = temp.length;
    int garo = temp[0].length;

    arr = new int[sero][garo];

    for (int i = 0; i < sero; i++) {
      for (int j = 0; j < garo; j++) {
        arr[i][j] = temp[i][j];
      }
    }
  }

}
