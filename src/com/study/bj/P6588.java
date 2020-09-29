package com.study.bj;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/6588 골드바흐의 추측 static [] arr 뿐만 아니라 벡터를 같이 이용하는 것도 방법일 수 있구나
 */
public class P6588 {

  static boolean[] primeList = new boolean[1000020];

  public static void main(String[] args) {

    init();
    Scanner scan = new Scanner(System.in);

    int x = scan.nextInt();

    while (true) {
      if (x == 0) {
        break;
      }
      soulution(x);
      x = scan.nextInt();
    }

  }

  private static void soulution(int x) {
    int a = x - 3, b = 3;
    while (true) {
      if (isPirme(a) && isPirme(b)) {
        System.out.println(x + " =" + " " + b + " + " + a);
        return;
      } else {
        a = a - 1;
        b = b + 1;
      }
      if (a == b) {
        break;
      }
    }
    System.out.println("Goldbach's conjecture is wrong.");

  }

  private static void init() {
    for (int i = 0; i < 1000020; i++) {
      primeList[i] = true;
    }
    for (int i = 2; i < 1000020; i++) {
      for (int j = i + i; j < 1000020; j = j + i) {
        primeList[j] = false;
      }
    }
  }

  private static boolean isPirme(int x) {
    return primeList[x] ? true : false;
  }

}
