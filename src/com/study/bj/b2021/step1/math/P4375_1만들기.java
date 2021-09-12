package com.study.bj.b2021.step1.math;

import java.io.IOException;
import java.util.Scanner;

public class P4375_1만들기 {


  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(System.in);
    while (sc.hasNextInt()) {
      int baesu = sc.nextInt();
      int num = 0;
      for (int j = 1; ; j++) {
        num = (num % baesu * 10 + 1 % baesu) % baesu;
        if (num == 0) {
          System.out.println(j);
          break;
        }
      }
    }
  }
}
