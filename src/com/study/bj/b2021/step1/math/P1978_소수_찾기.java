package com.study.bj.b2021.step1.math;

import java.util.Scanner;

public class P1978_소수_찾기 {

  static final int MAX = 1001;
  static Scanner scan = new Scanner(System.in);
  static int N;
  static int[] candidate;
  static boolean[] isPrime = new boolean[1050];

  public static void main(String[] args) {

    input();
    initPrimeArr();
    eratos();
    printAnswer();
  }

  private static void initPrimeArr() {

    isPrime[1] = false;//1은 소수가 아니다.
    for (int i = 2; i < 1050; i++) {
      isPrime[i] = true;
    }
  }

  //1,000,000  1000000
  private static void printAnswer() {
    int cnt = 0;

    for (int i = 0; i < N; i++) {
//      System.out.println("candidate->"+candidate[i]);
      if (isPrime[candidate[i]]) {
        cnt += 1;
      }
    }

    System.out.println(cnt);
  }

  private static void eratos() {

    for (int i = 2; i <= 1001; i++) {

      for (int j = i + i; j <= 1001; j = j + i) {
        isPrime[j] = false;
      }
    }

//    for(int i=2;i<=1001;i++){
//      System.out.println(i+" "+isPrime[i]);
//    }

  }


  private static void input() {

    N = scan.nextInt();
    candidate = new int[N];

    for (int i = 0; i < N; i++) {
      candidate[i] = scan.nextInt();
    }
  }
}
