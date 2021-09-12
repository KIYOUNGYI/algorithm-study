package com.study.bj.b2021.step1.math;

import java.util.Scanner;

public class P2609_최대공약수와_최소공배수_2 {

  //유클리드 호제법
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int a = scan.nextInt();
    int b = scan.nextInt();
    int big = max(a, b);
    int small = min(a, b);

    int g = gcd(big, small);
    int l = (big / g) * (small / g) * g;

    System.out.println(g);
    System.out.println(l);

  }

  private static int gcd(int big, int small) {

    for (; ; ) {
      int mok = big / small;
      int rem = big % small;
      if (rem == 0) {
        return small;
      }
      big = small;
      small = rem;
    }
  }

  private static int min(int a, int b) {
    return a > b ? b : a;
  }

  private static int max(int a, int b) {
    return a >= b ? a : b;
  }


}
