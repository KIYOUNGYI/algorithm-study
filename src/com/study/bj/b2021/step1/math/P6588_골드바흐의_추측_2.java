package com.study.bj.b2021.step1.math;

import java.util.Scanner;

public class P6588_골드바흐의_추측_2 {

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

    for (; ; ) {
      int input = scan.nextInt();
      if (input == 0) {
        return;
      }
      int a = 0;
      int b = 0;
      boolean flag = false;
      for (int i = 3; i <= input / 2; i++) {
        if (isPrime[i]) {
          a = i;
          b = input - a;
          if (isPrime[b]) {
            flag = true;
            System.out.println(input + " = " + a + " + " + b);
            break;
          }
        }
      }
      if (!flag) {
        System.out.println("Goldbach's conjecture is wrong.");
      }
    }


  }
}
