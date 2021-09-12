package com.study.bj.b2021.step1.dynamic_programming.part2;

import java.util.Scanner;

public class P11055_가장_큰_증가_부분_수열 {

  static int n;
  static int[] a;
  static int[] d;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    a = new int[n + 1];
    d = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      a[i] = scan.nextInt();
    }


    for (int i = 1; i <= n; i++) {
      d[i] = a[i];

      for (int j = 1; j < i; j++) {
//        System.out.println(i + " " + j);
        //30 > 10
        if (a[j] < a[i] && d[i] < d[j] + a[i]) {
          d[i] = d[j] + a[i];
        }

      }
//      System.out.println("---");
    }

//    System.out.println(Arrays.toString(d));

    int ans = d[0];
    for (int i = 1; i <= n; i++) {
      if (ans < d[i]) {
        ans = d[i];
      }
    }
    System.out.println(ans);
  }

}
