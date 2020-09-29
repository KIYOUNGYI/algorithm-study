package com.study.bj;

import java.util.Scanner;

/**
 * 별 찍기 - 1
 * https://www.acmicpc.net/problem/2438
 */
public class P2438 {

  //루프 idx 만큼 * 을 찍는다.
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}

