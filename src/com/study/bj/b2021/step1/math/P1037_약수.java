package com.study.bj.b2021.step1.math;

import java.util.Scanner;

public class P1037_약수 {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {

      int x = scan.nextInt();
      if (x > max) {
        max = x;
      }
      if (x < min) {
        min = x;
      }
    }

    System.out.println(min * max);

  }
}
