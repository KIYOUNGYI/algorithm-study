package com.study.bj.b2021.step1.brute_force.brute;

import java.util.Scanner;

public class P1748_수_이어_쓰기_1 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();

    if (n >= 1 && n <= 10 * 1 - 1) {

    } else if (n >= 10 && n <= 10 * 10 - 1) {

    }

    int t = 0;
    for (int i = 1; i <= n; i++) {
      if (i >= 1 && i <= 10 * 1 - 1) {
        t = t + 1;
      } else if (i >= 10 && i <= 10 * 10 - 1) {
        t = t + 2;
      } else if (i >= 10 * 10 && i <= 10 * 10 * 10 - 1) {
        t = t + 3;
      } else if (i >= 10 * 10 * 10 && i <= 10 * 10 * 10 * 10 - 1) {
        t = t + 4;
      } else if (i >= 10 * 10 * 10 * 10 && i <= 10 * 10 * 10 * 10 * 10 - 1) {
        t = t + 5;
      } else if (i >= 10 * 10 * 10 * 10 * 10 && i <= 10 * 10 * 10 * 10 * 10 * 10 - 1) {
        t = t + 6;
      } else if (i >= 10 * 10 * 10 * 10 * 10 * 10 && i <= 10 * 10 * 10 * 10 * 10 * 10 * 10 - 1) {
        t = t + 7;
      } else if (i >= 10 * 10 * 10 * 10 * 10 * 10 * 10 && i <= 10 * 10 * 10 * 10 * 10 * 10 * 10 * 10 - 1) {
        t = t + 8;
      } else if (i >= 10 * 10 * 10 * 10 * 10 * 10 * 10 * 10 && i <= 10 * 10 * 10 * 10 * 10 * 10 * 10 * 10 * 10 - 1) {
        t = t + 9;
      }
    }
    System.out.println(t);

  }
}
