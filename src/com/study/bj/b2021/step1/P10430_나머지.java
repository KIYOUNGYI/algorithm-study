package com.study.bj.b2021.step1;

import java.util.Scanner;

public class P10430_나머지 {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    int a = scan.nextInt();
    int b = scan.nextInt();
    int c = scan.nextInt();

    solve(a, b, c);

  }

  private static void solve(int a, int b, int c) {

    int f1 = (a + b) % c;
    int f2 = ((a % c) + (b % c)) % c;
    int f3 = (a * b) % c;
    int f4 = ((a % c) * (b % c)) % c;

    System.out.println(f1);
    System.out.println(f2);
    System.out.println(f3);
    System.out.println(f4);
  }
}
