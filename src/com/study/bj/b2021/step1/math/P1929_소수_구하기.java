package com.study.bj.b2021.step1.math;

import java.util.Scanner;

public class P1929_소수_구하기 {

  static final int MAX = 1_000_001;
  static Scanner scan = new Scanner(System.in);
  static int M, N;
  static boolean[] isPrime = new boolean[MAX];

  public static void main(String[] args) {

    input();
    initPrimeArr();
    eratos();
    printAnswer();
  }

  private static void initPrimeArr() {

    isPrime[1] = false;//1은 소수가 아니다.

    for (int i = 2; i <= N; i++) {
      isPrime[i] = true;
    }
  }

  //1,000,000  1000000
  private static void printAnswer() {

    for (int i = M; i <= N; i++) {
      if (isPrime[i]) {
        System.out.println(i);
      }
    }
    System.out.println();
  }

  private static void eratos() {

    for (int i = 2; i <= N; i++) {

      for (int j = i + i; j <= N; j = j + i) {
        isPrime[j] = false;
      }
    }

  }


  private static void input() {
    M = scan.nextInt();
    N = scan.nextInt();
  }

}
