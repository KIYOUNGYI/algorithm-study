package com.study.bj.b2021.step1.math;

import java.util.Scanner;

public class P1978_소수_찾기2 {

  static final int size = 1001;
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
    int cnt = 0;
    n = scan.nextInt();
    for (int i = 1; i <= n; i++) {
      int t = scan.nextInt();
      if (isPrime[t]) {
        cnt += 1;
      }
    }
    System.out.println(cnt);

  }
}
