package com.study.bj;

import java.util.Scanner;

/**
 * 알파벳 찾기
 * https://www.acmicpc.net/problem/10809
 */
public class P10809 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String s = scan.nextLine();
    int[] memo = new int[26];
    for (int i = 0; i < 26; i++) {
      memo[i] = -1;
    }

    for (int idx = 0; idx < s.length(); idx++) {
      int x = s.charAt(idx) - 97;
      if (memo[x] == -1) {
        memo[x] = idx;
      }
    }

    for (int i = 0; i < 26; i++) {
      System.out.print(memo[i] + " ");
    }
    System.out.println();
  }
}
