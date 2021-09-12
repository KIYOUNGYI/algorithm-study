package com.study.bj.b2021.step1.dynamic_programming.part1;

import java.util.Scanner;

public class P9095_1_2_3_더하기_다이나믹으로 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();

    int[] arr = new int[12];
    arr[1] = 1;
    arr[2] = 2;
    arr[3] = 4;
    arr[4] = 7;

    for (int i = 5; i < 12; i++) {
      arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
    }

    for (int i = 0; i < t; i++) {
      int j = scan.nextInt();
      System.out.println(arr[j]);
    }

  }
}
