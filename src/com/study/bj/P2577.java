package com.study.bj;

import java.util.Scanner;

/**
 * 숫자의 개수
 * https://www.acmicpc.net/problem/2577
 */
public class P2577 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int a = scan.nextInt();
    int b = scan.nextInt();
    int c = scan.nextInt();
    int r = a * b * c;
    String val = String.valueOf(r);
    int[] arr = new int[10];
    for (int i = 0; i < val.length(); i++) {
      arr[(val.charAt(i) - '0')] += 1;
    }
    for (int i = 0; i < 10; i++) {
      System.out.println(arr[i]);
    }
  }
}
