package com.study.bj;

import java.util.Scanner;

/**
 * 최대공약수, 최소공배수 https://www.acmicpc.net/problem/2609
 */
public class P2609 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int x = scan.nextInt();
    int y = scan.nextInt();
    int b, s;
    if (x > y) {
      b = x;
      s = y;
    } else {
      b = y;
      s = x;
    }
    int r = -1;
    int m = 0;
    while (r != 0) {
      r = b % s;
      if (r == 0) {
        break;
      }
      b = s;
      s = r;
    }

    int gcd = s;
    int lcm = x / gcd * y / gcd * gcd;

    System.out.println(gcd);
    System.out.println(lcm);
  }
}
