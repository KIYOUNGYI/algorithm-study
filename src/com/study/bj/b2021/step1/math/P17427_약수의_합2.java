package com.study.bj.b2021.step1.math;

import java.util.Scanner;

public class P17427_약수의_합2 {

  static int[] arr;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();//1000000
    arr = new int[n + 50];
    int sum = 0;
    for (int i = 1; i <= n; i++) {
      sum += (n / i) * i;
    }
    System.out.println(sum);

  }

}
