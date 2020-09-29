package com.study.bj;

import java.util.Scanner;

/**
 * 팩토리얼
 * 재귀로 풀었으니 다음번엔 반복문으로 풀어보자
 * https://www.acmicpc.net/problem/10872
 */
public class P10872
{
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    int r = factorial(N);
    System.out.println(r);
  }

  private static int factorial(int n) {
    if(n==1 || n==0)return 1;
    return n*factorial(n-1);
  }
}
