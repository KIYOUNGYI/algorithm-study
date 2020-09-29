package com.study.bj;

import java.util.Scanner;

/**
 * 괄호 https://www.acmicpc.net/problem/9012
 */
public class P9012 {

  static int N;
  static String input;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    N = scan.nextInt();
    scan.nextLine();
    for (int i = 0; i < N; i++) {
      int cnt = 0;
      input = scan.nextLine();
      if (input.length() % 2 == 0) {
        for (int j = 0; j < input.length(); j++) {
          if (input.charAt(j) == '(') {
            cnt += 1;
          } else//)
          {
            cnt -= 1;
            if (cnt <= -1) {
              break;
            }
            ;
          }
        }
        if (cnt == 0) {
          System.out.println("YES");
        } else {
          System.out.println("NO");
        }
      } else {
        System.out.println("NO");
      }

    }

  }
}
