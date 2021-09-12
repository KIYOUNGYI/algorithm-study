package com.study.bj;

import java.util.Scanner;

public class P9095DP {

  static int[] d = new int[20];
  static int n;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    d[1] = 1;
    d[2] = 2;
    d[3] = 4;
    for (int i = 4; i <= 12; i++) {
      d[i] = d[i - 1] + d[i - 2] + d[i - 3];
    }
    for (int j = 0; j < n; j++) {
      int t = scan.nextInt();
      System.out.println(d[t]);
    }
  }
}
