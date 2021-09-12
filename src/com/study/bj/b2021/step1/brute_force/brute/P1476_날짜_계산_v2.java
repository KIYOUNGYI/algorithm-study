package com.study.bj.b2021.step1.brute_force.brute;

import java.util.Scanner;

public class P1476_날짜_계산_v2 {

  static final int MAX = 15 * 28 * 19 + 50;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    int inputA = scan.nextInt();
    int inputB = scan.nextInt();
    int inputC = scan.nextInt();

    int e = 1;
    int s = 1;
    int m = 1;

    for (int j = 1; j < MAX; j++) {

      if (inputA == e && inputB == s && inputC == m) {
        System.out.println(j);
        return;
      }

      e += 1;
      s += 1;
      m += 1;
      if (e == 16) {
        e = 1;
      }
      if (s == 29) {
        s = 1;
      }
      if (m == 20) {
        m = 1;
      }
    }

  }


}
