package com.study.bj;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1929
 * 소수 구하기 easy
 */
public class P1929 {

  static int a, b;
  public static boolean[] isPrime = new boolean[1000050];

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    initPrime();
    a = scan.nextInt();
    b = scan.nextInt();
    printPrime();
//        int n = scan.nextInt();

//        for(int i=0;i<n;i++)
//        {
//            String x = scan.next();
//            String y = scan.next();
//            System.out.println(x+" "+y);
//            problem(x,y);
//        }

  }

  public static void problem(String input1, String input2) {

  }

  public static void initPrime() {

    for (int i = 1; i < 1000050; i++) {
      isPrime[i] = true;
    }
    isPrime[1] = false;
    for (int i = 2; i < 1000050; i++) {
      for (int j = i + i; j < 1000050; j = j + i) {
        isPrime[j] = false;
      }
    }
  }

  public static void printPrime() {
    for (int i = a; i <= b; i++) {
      if (isPrime[i] == true) {
        System.out.println(i);
      }
    }
  }
}
