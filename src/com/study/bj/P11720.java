package com.study.bj;

import java.util.Scanner;

/**
 * 숫자의 합
 * https://www.acmicpc.net/problem/11720
 */
public class P11720 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    scan.nextLine();
    String temp = scan.nextLine();
    int sum = 0;
    for (int i = 0; i < temp.length(); i++) {
      sum += ((int) temp.charAt(i) - '0');
    }
    System.out.println(sum);
  }
}
