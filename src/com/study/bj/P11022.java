package com.study.bj;

import java.util.Scanner;

/**
 * 다시는 풀지 말자
 */
public class P11022 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    for (int i = 1; i <= t; i++) {
      int a = scan.nextInt();
      int b = scan.nextInt();
      System.out.println("Case #" + i + ": " + a + " + " + b + " = " + (a + b));
    }
  }
}
