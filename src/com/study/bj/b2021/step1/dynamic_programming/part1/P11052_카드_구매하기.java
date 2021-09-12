package com.study.bj.b2021.step1.dynamic_programming.part1;

import java.util.Scanner;

public class P11052_카드_구매하기 {

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
      d[i] = Integer.MIN_VALUE;
    }
    d[1] = a[1];

    for (int j = 2; j <= n; j++) {

      for (int k = 1; k <= j; k++) {
//        System.out.println("j(장 구매 경우의 수) : "+j+" k: "+k+" j-k : "+(j-k)+"");
        int t = a[k] + d[j - k];
//        System.out.println(t);
        if (d[j] < t) {
          d[j] = t;
        }

      }
    }

//    System.out.println(Arrays.toString(d));
    System.out.println(d[n]);

  }

}
