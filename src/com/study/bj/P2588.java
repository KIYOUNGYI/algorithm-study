package com.study.bj;

import java.util.Scanner;

public class P2588 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String x = scan.nextLine();
    String y = scan.nextLine();
    mul(x, y);
    scan.close();
  }

  private static void mul(String x, String y) {
    int a = Integer.parseInt(x) * (int) (y.charAt(0) - '0');
    int b = Integer.parseInt(x) * (int) (y.charAt(1) - '0');
    int c = Integer.parseInt(x) * (int) (y.charAt(2) - '0');
    System.out.println(c);
    System.out.println(b);
    System.out.println(a);
    System.out.println(Integer.parseInt(x) * Integer.parseInt(y));
  }
}
