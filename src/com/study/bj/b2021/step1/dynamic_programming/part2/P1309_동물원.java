package com.study.bj.b2021.step1.dynamic_programming.part2;

import java.util.Scanner;

public class P1309_동물원 {

  static final int size = 100_001;
  static long[][] d = new long[size][3];
  static int n;

  public static void main(String[] args) {

    d[1][0] = 1;
    d[1][1] = 1;
    d[1][2] = 1;

    for (int i = 2; i < size; i++) {
      d[i][0] = (d[i - 1][0] + d[i - 1][1] + d[i - 1][2]) % 9901;
      d[i][1] = (d[i - 1][0] + d[i - 1][2]) % 9901;
      d[i][2] = (d[i - 1][0] + d[i - 1][1]) % 9901;
    }

    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();

    long t = (d[n][0] + d[n][1] + d[n][2]) % 9901;
    System.out.println(t);

  }
}
