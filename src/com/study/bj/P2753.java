package com.study.bj;

import java.util.Scanner;

/**
 * 윤년
 * https://www.acmicpc.net/problem/2753
 */
public class P2753 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    if (n % 4 == 0 && (n % 100 != 0)) {
      System.out.println(1);
    } else if (n % 4 == 0 && (n % 400 == 0)) {
      System.out.println(1);
    } else {
      System.out.println(0);
    }
    scan.close();
  }
}
