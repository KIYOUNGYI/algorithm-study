package com.study.bj;

import java.util.Scanner;

/**
 * 날짜 계산 https://www.acmicpc.net/problem/1476 - 범위 초과하는거 생각 - 배열 안 쓰고 풀어보자 다음엔
 */
public class P1476 {

  static final int limit = 15 * 28 * 19 + 20;
  static int[][] universe = new int[limit][4];

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int e = scan.nextInt();
    int s = scan.nextInt();
    int m = scan.nextInt();
    init();

    for (int i = 0; i < limit; i++) {
      if (universe[i][1] == e && universe[i][2] == s && universe[i][3] == m) {
        System.out.println(i);
        break;
      }
    }
  }

  private static void init() {
    for (int i = 1; i < limit; i++) {
      int t = i % 15;
      if (t == 0) {
        t = 15;
      }
      universe[i][1] = t;
    }
    for (int i = 1; i < limit; i++) {
      int t = i % 28;
      if (t == 0) {
        t = 28;
      }
      universe[i][2] = t;
    }
    for (int i = 1; i < limit; i++) {
      int t = i % 19;
      if (t == 0) {
        t = 19;
      }
      universe[i][3] = t;
    }
  }
}
