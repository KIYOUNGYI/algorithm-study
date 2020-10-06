package com.study.bj;

import java.util.Scanner;

/**
 * 최대값
 * https://www.acmicpc.net/problem/2562
 */
public class P2562 {

  static int max = Integer.MIN_VALUE;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int idx = 1;
    for (int i = 1; i <= 9; i++) {
      int x = scan.nextInt();
      if (x > max) {
        max = x;
        idx = i;
      }
    }
    System.out.println(max);
    System.out.println(idx);
  }
}
