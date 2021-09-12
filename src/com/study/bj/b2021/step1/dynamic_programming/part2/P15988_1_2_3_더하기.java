package com.study.bj.b2021.step1.dynamic_programming.part2;

import java.util.Scanner;

public class P15988_1_2_3_더하기 {

  static final int SIZE = 1_000_001;
  static int t;
  static long[] arr = new long[SIZE];

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    t = scan.nextInt();

    arr[1] = 1;
    arr[2] = 2;
    arr[3] = 4;
    arr[4] = 7;

    for (int i = 5; i < SIZE; i++) {
      arr[i] = (arr[i - 1] + arr[i - 2] + arr[i - 3]) % 1_000_000_009;
    }

    for (int i = 0; i < t; i++) {
      int x = scan.nextInt();
      System.out.println(arr[x]);
    }
  }
}
