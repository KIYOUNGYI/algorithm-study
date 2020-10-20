package com.study.bj;

import java.util.Scanner;

public class P8393 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    long a = scan.nextLong();
    long sum = 0;
    for (long i = 0; i <= a; i++) {
      sum += i;
    }
    System.out.println(sum);
  }
}
