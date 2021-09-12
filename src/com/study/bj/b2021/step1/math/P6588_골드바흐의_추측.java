package com.study.bj.b2021.step1.math;

import java.util.Scanner;

//틀림
//6 -> 100 [오류 케이스]
public class P6588_골드바흐의_추측 {

  //  static final int MAX = 1_001;
  static final int MAX = 1_000_001;
  static final String exMessage = "Goldbach's conjecture is wrong.";
  static Scanner scan = new Scanner(System.in);
  static boolean[] isPrime = new boolean[MAX];

  public static void main(String[] args) {

    init();
    eratos();

    solution();
  }

  private static void solution() {

    int input = scan.nextInt();

    int t = input;

    while (t != 0) {
      int x = getBigPrime(t);
      int y = input - x;
      if (isPrime[y]) {
        System.out.println(input + " = " + y + " + " + x);
        input = scan.nextInt();
        t = input;

        if (t == 0) {
          return;
        }
      } else {
        t = t - 1;
      }

      if (x < y) {
        System.out.println(exMessage);
        input = scan.nextInt();
        t = input;
        if (t == 0) {
          return;
        }
      }
    }
  }

  private static int getBigPrime(int t) {
    if (isPrime[t]) {
      return t;
    }

    while (isPrime[t] == false) {
      t = t - 1;
      if (isPrime[t]) {
        return t;
      }
    }

    return t;
  }

  private static void init() {

    isPrime[1] = false;

    for (int i = 2; i < MAX; i++) {
      isPrime[i] = true;
    }
  }

  private static void eratos() {

    for (int i = 2; i < MAX; i++) {

      for (int j = i + i; j < MAX; j = j + i) {
        isPrime[j] = false;
      }
    }

//    for(int i=2;i<MAX;i++){
//      System.out.println(i+" "+isPrime[i]);
//    }
  }
}
