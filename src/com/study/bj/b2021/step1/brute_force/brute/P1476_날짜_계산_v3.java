package com.study.bj.b2021.step1.brute_force.brute;

import java.util.Scanner;

public class P1476_날짜_계산_v3 {

  static final int MAX = 15 * 28 * 19 + 50;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    int inputA = scan.nextInt() - 1;
    int inputB = scan.nextInt() - 1;
    int inputC = scan.nextInt() - 1;

    int e = 0;
    int s = 0;
    int m = 0;

    for (int j = 0; j < MAX; j++) {
      if(inputA==e && inputB==s && inputC==m){
//        System.out.println(j + " " + e + " " + s + " " + m);
        System.out.println(j+1);
        return;
      }
//      System.out.println(j + " " + e + " " + s + " " + m);
      e = (j + 1) % 15;
      s = (j + 1) % 28;
      m = (j + 1) % 19;
    }

  }


}
