package com.study.bj.b2021.step1.brute_force.brute;

import java.util.Scanner;

public class P3085_사탕_게임_v4 {

  static int max = 0;
  static Scanner scan = new Scanner(System.in);
  static int n;
  static int[][] arr;
  static int[] dx = {0, 1};
  static int[] dy = {1, 0};

  public static void main(String[] args) {

    inputAndInit();
    solution();
    System.out.println(max);
  }

  private static void solution() {

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {

        for (int t = 0; t < 2; t++) {
          int di = i + dx[t];
          int dj = j + dy[t];
          if (di >= 1 && dj >= 1 && di <= n && dj <= n) {
//            System.out.println(i + " " + j + " " + di + " " + dj);
            //swap
            int temp = arr[i][j];
            int temp2 = arr[di][dj];
            arr[i][j] = temp2;
            arr[di][dj] = temp;

            //calculate
//            calculate();
            calculate2();

            //recover
            arr[i][j] = temp;
            arr[di][dj] = temp2;
          }
        }

      }
    }
  }

  private static void calculate2() {

    for (int a = 1; a <= n; a++) {

      for (int b = 1; b <= n; b++) {

        int cnt1 = arr[a][b];
        for(int c=1;c<=n;c++){

        }


        for(;;){

        }

      }
    }

  }

  private static void calculate() {

    for (int a = 1; a <= n; a++) {

      for (int b = 1; b <= n; b++) {

        int x = arr[a][b];
        int cnt1 = 1;
        int cnt2 = 1;
        //위
        for (int c = a - 1; c >= 1; c--) {
          if (x == arr[c][b]) {
            cnt1 += 1;
          } else {
            break;
          }
        }
        //아래
        for (int c = a + 1; c <= n; c++) {
          if (x == arr[c][b]) {
            cnt1 += 1;
          } else {
            break;
          }
        }

        for (int c = b - 1; c >= 1; c--) {
          if (x == arr[a][c]) {
            cnt2 += 1;
          } else {
            break;
          }
        }

        for (int c = b + 1; c <= n; c++) {
          if (x == arr[a][c]) {
            cnt2 += 1;
          } else {
            break;
          }
        }

        int t1 = max(cnt1, cnt2);
        max = max(t1, max);
      }
    }
  }

  static int max(int a, int b) {
    return a > b ? a : b;
  }


  private static void inputAndInit() {
    n = scan.nextInt();
    scan.nextLine();

    arr = new int[n + 2][n + 2];

    for (int i = 1; i <= n; i++) {
      String temp = scan.nextLine();
      for (int j = 1; j <= n; j++) {
        char c = temp.charAt(j - 1);
        arr[i][j] = c;
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
