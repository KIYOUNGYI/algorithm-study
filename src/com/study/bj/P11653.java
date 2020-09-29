package com.study.bj;

import java.util.Scanner;

/**
 * 소인수 분해 시간 복잡도 https://www.acmicpc.net/problem/11653
 */
public class P11653 {//3:22

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();

    for (int i = 2; i * i <= n; i++) {
      while (n % i == 0) {
        System.out.println(i);
        n = n / i;
      }
    }
    if (n != 1) {
      System.out.println(n);
    }

  }
}
