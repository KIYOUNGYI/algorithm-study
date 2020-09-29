package com.study.bj;

import java.util.Scanner;

/**
 * 별 찍기 - 2
 * https://www.acmicpc.net/problem/2439
 */
public class P2439 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    int a = N - 1;
    int b = 1;
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= a; j++) {
        System.out.print(" ");
      }
      for (int k = 1; k <= b; k++) {
        System.out.print("*");
      }
      System.out.println();
      a -= 1;
      b += 1;
    }

    scan.close();
  }
}
