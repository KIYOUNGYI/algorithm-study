package com.study.bj;

import java.util.Scanner;

/**
 * 최대값 https://www.acmicpc.net/problem/2566
 */
public class P2566 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int[][] arr = new int[10][10];
    int max = -1;
    int t1 = 0, t2 = 0;
    for (int i = 1; i <= 9; i++) {
      for (int j = 1; j <= 9; j++) {
        arr[i][j] = scan.nextInt();

      }
    }

    for (int i = 1; i <= 9; i++) {
      for (int j = 1; j <= 9; j++) {
        if (max < arr[i][j]) {
          max = arr[i][j];
          t1 = i;
          t2 = j;
        }
      }
    }

    System.out.println(max);
    System.out.println(t1 + " " + t2);


  }
}
