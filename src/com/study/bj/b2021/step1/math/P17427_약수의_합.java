package com.study.bj.b2021.step1.math;

import java.util.Scanner;

public class P17427_약수의_합 {

  static long[] arr;
  //1_000_000
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();//1000000
    arr = new long[1_000_050];
    int sum = 0;
    for (int i = 1; i < 1_000_050; i++) {
      sum += (n / i) * i;
      arr[i] = sum;
    }



    System.out.println(arr[n]);

  }

}
