package com.study.bj;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/2004 조합 0의 개수
 */
public class P2004 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    long n = scan.nextLong();
    long m = scan.nextLong();

    long two = 0;
    long five = 0;
    for (long i = 2; i <= n; i = i * 2) {
      two += n / i;
    }
    for (long i = 2; i <= n - m; i = i * 2) {
      two -= (n - m) / i;
    }
    for (long i = 2; i <= m; i = i * 2) {
      two -= m / i;
    }

    for (long i = 5; i <= n; i = i * 5) {
      five += n / i;
    }
    for (long i = 5; i <= n - m; i = i * 5) {
      five -= (n - m) / i;
    }
    for (long i = 5; i <= m; i = i * 5) {
      five -= m / i;
    }
    System.out.println(min(two, five));

  }

  public static Long min(Long x, Long y) {
      if (x >= y) {
          return y;
      } else {
          return x;
      }
  }

}
