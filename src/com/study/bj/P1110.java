package com.study.bj;

import java.util.Scanner;

/**
 * 더하기 사이클
 * https://www.acmicpc.net/problem/1110
 * 수학,구현
 */
public class P1110 {

  static String begin;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String input = scan.nextLine();
    if (input.length() == 1) {
      input = "0" + input;
    }
    problem(input);
    scan.close();
  }

  public static void problem(String input) {
    begin = new String(input);
    int begin0 = begin.charAt(0) - '0';
    int begin1 = begin.charAt(1) - '0';

    int a = input.charAt(0) - '0';
    int b = input.charAt(1) - '0';
    int m = 0;
    int ans = 0;
    for (int i = 1; i < Integer.MAX_VALUE; i++) {
      m = a + b;
      if (m >= 10) {
        m = m % 10;
      }
      a = b;
      b = m;
      if (a == begin0 && b == begin1) {
        ans = i;
        break;
      }
    }
    System.out.println(ans);
  }
}
