package com.study.bj;

import java.util.Scanner;

/**
 * 알파벳 개수 https://www.acmicpc.net/problem/10808
 */
public class P10808 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int[] charTable = new int[26];
    String s = scan.nextLine();
    int[] input = new int[s.length()];
    for (int i = 0; i < s.length(); i++) {
      int x = (int) s.charAt(i) - 97;
      charTable[x] += 1;
    }
    for (int i = 0; i < 26; i++) {
      System.out.print(charTable[i] + " ");
    }
    System.out.println();
  }
}
