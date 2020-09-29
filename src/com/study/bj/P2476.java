package com.study.bj;

import java.util.Scanner;

/**
 * 주사위 게임 https://www.acmicpc.net/problem/2476 [1] a,b,c 로 품 [2] 다음엔 배열로 풀자
 */
public class P2476 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int max = 0;
    int N = scan.nextInt();
    for (int i = 0; i < N; i++) {
      int total = 0;
      int a = scan.nextInt();
      int b = scan.nextInt();
      int c = scan.nextInt();
      if (a == b && b == c) {
        total = 10000 + a * 1000;
      } else if ((a == b) && (b != c)) {
        total = 1000 + a * 100;
      } else if ((a == c) && (a != b)) {
        total = 1000 + a * 100;
      } else if ((b == c) && (a != b)) {
        total = 1000 + b * 100;
      } else if (a != b && b != c) {
        total = max(max(a, b), c) * 100;
      }
      if (total > max) {
        max = total;
      }
    }
    System.out.println(max);

    scan.close();
  }

  public static int max(int a, int b) {
    if (a >= b) {
      return a;
    } else {
      return b;
    }
  }

}
