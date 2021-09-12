package com.study.bj.b2021.step1.math;

import java.util.Scanner;

public class P2609_최대공약수와_최소공배수 {

  //유클리드
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    int a = scan.nextInt();
    int b = scan.nextInt();

    int big = max(a, b);
    int small = min(a, b);

    int gcd = gcd(big, small);
    System.out.println(gcd);
    int lcm = (big / gcd) * (small / gcd) * gcd;
    System.out.println(lcm);
  }

  private static int gcd(int big, int small) {

    for (; ; ) {
      int remain = big % small;
      if (remain == 0) {
        return small;
      }
//      System.out.println("b:"+big+" s:"+small+" remain:"+remain);
      big = small;
      small = remain;
    }

  }

  private static int min(int a, int b) {
    return a > b ? b : a;
  }

  private static int max(int a, int b) {
    return a > b ? a : b;
  }
}
