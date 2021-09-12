package com.study.bj.b2021.step1.math;

import java.util.Scanner;

public class P1929_소수_구하기_2 {

  static final int size = 1_000_050;
  static int n;
  static boolean[] isPrime = new boolean[size];

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    isPrime[1] = false;
    for (int i = 2; i < size; i++) {
      isPrime[i] = true;
    }

    for (int i = 2; i < size; i++) {
      for (int j = i + i; j < size; j = j + i) {
        isPrime[j] = false;
      }
    }

    int x = scan.nextInt();
    int y = scan.nextInt();
    for (int i = x; i <= y; i++) {
      if (isPrime[i]) {
        System.out.println(i);
      }
    }
  }
}
