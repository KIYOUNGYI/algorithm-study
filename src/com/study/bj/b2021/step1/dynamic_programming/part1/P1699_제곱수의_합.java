package com.study.bj.b2021.step1.dynamic_programming.part1;

import java.util.Scanner;

public class P1699_제곱수의_합 {

  static int n;
  static int[] d;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    n = scan.nextInt();
    d = new int[n + 1];

    boolean[] jegop = new boolean[1001 * 1001];

    for (int i = 1; i <= n; i++) {
      d[i] = i;

    }
    for (int i = 1; i < 1001; i += 1) {
      jegop[i * i] = true;
    }

    for (int i = 1; i <= n; i++) {
      if (jegop[i]) {
        d[i] = 1;
      } else {
        for (int j = 1; j <= i / 2; j++) {
//          System.out.println(" i : " + i + " j : " + j + " i-j : " + (i - j));
          int t = d[j] + d[i - j];
          if (t < d[i]) {
            d[i] = t;
          }
        }
      }
    }

    System.out.println(d[n]);

  }


  private static int min(int a, int b) {
    return a > b ? b : a;
  }

}
