package com.study.bj;

import java.util.Scanner;

/**
 * 별찍기 7
 * https://www.acmicpc.net/problem/2444
 * 문제 너무 더럽
 */
public class P2444V2 {

  static int n;
  static int len;
  static int[][] arr;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    len = 2 * n - 1;
    int cntLen = 0;

    arr = new int[len + 1][len + 1];
    for (int i = 0; i < len + 1; i++) {
      for (int j = 0; j < len + 1; j++) {
        arr[i][j] = 0;
      }
    }
    for (int i = 1; i <= len / 2 + 1; i++) {
      cntLen = i * 2 - 1;
      int cnt = 0;
      for (int j = 1; j <= len; j++) {
        if (i + j <= n) {
//          arr[i][j] = 0;
        } else {
          cnt += 1;
          arr[i][j] = 1;
        }
        if (cnt == cntLen) {
          break;
        }
      }
    }
    int t = n;
    for (int i = n + 1; i <= len; i++) {
      t = t - 1;
      for (int j = 1; j <= len; j++) {
        arr[i][j] = arr[t][j];
      }
    }

    print();
  }

  public static void print() {
    int cnt = 0;

    for (int i = 1; i <= len; i++) {
      int t = 0;
      if (i <= len / 2 + 1) {
        cnt = 2 * i - 1;
      } else {
        cnt = cnt - 2;
      }
//      System.out.println(cnt);
      for (int j = 1; j <= len; j++) {
        if (arr[i][j] == 1) {
          t += 1;
          System.out.print("*");
          if (t == cnt) {
            break;
          }
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
}
