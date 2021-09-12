package com.study.bj.b2021.step1.dynamic_programming.part2;

import java.util.Scanner;

public class P11057_오르막수 {

  static final int mod = 10_007;
  static final int SIZE = 1001;
  static long[][] d = new long[SIZE][10];

  public static void main(String[] args) {

    for (int i = 0; i <= 9; i++) {
      d[1][i] = 1;
    }

    for (int j = 2; j < SIZE; j++) {

      for (int k = 0; k < 10; k++) {

        long sum = 0;
        for (int l = 0; l <= k; l++) {
          sum = sum + d[j - 1][k];
        }
        d[j][k] = sum % mod;

      }

//      d[j][0] = (d[j - 1][0]) % mod;
//      d[j][1] = (d[j - 1][0] + d[j - 1][1]) % mod;
//      d[j][2] = (d[j - 1][0] + d[j - 1][1] + d[j - 1][2]) % mod;
//      d[j][3] = (d[j - 1][0] + d[j - 1][1] + d[j - 1][2] + d[j - 1][3]) % mod;
//      d[j][4] = (d[j - 1][0] + d[j - 1][1] + d[j - 1][2] + d[j - 1][3] + d[j - 1][4]) % mod;
//      d[j][5] = (d[j - 1][0] + d[j - 1][1] + d[j - 1][2] + d[j - 1][3] + d[j - 1][4] + d[j - 1][5]) % mod;
//      d[j][6] = (d[j - 1][0] + d[j - 1][1] + d[j - 1][2] + d[j - 1][3] + d[j - 1][4] + d[j - 1][5] + d[j - 1][6]) % mod;
//      d[j][7] = (d[j - 1][0] + d[j - 1][1] + d[j - 1][2] + d[j - 1][3] + d[j - 1][4] + d[j - 1][5] + d[j - 1][6] + d[j - 1][7]) % mod;
//      d[j][8] = (d[j - 1][0] + d[j - 1][1] + d[j - 1][2] + d[j - 1][3] + d[j - 1][4] + d[j - 1][5] + d[j - 1][6] + d[j - 1][7] + d[j - 1][8]) % mod;
//      d[j][9] = (d[j - 1][0] + d[j - 1][1] + d[j - 1][2] + d[j - 1][3] + d[j - 1][4] + d[j - 1][5] + d[j - 1][6] + d[j - 1][7] + d[j - 1][8] + +d[j - 1][9]) % mod;

    }

    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int sum = 0;
    for (int i = 0; i <= 9; i++) {
      sum += d[n][i];
    }
    System.out.println(sum % mod);
  }

}
