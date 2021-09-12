package com.study.bj.b2021.step1.brute_force.brute;

import java.util.Scanner;

public class P1476_날짜_계산 {

  static final int MAX = 15 * 28 * 19 + 50;
  static Point[] ptArr = new Point[MAX];

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    int e = scan.nextInt();
    int s = scan.nextInt();
    int m = scan.nextInt();

    for (int j = 1; j < MAX; j++) {
      ptArr[j] = new Point(j);
      if (ptArr[j].e == e && ptArr[j].s == s && ptArr[j].m == m) {
        System.out.println(j);
        return;
      }

    }

  }

  static class Point {

    int e;
    int s;
    int m;

    public Point(int x) {
      e = x % 15;
      if (e == 0) {
        e = 15;
      }
      s = x % 28;
      if (s == 0) {
        s = 28;
      }
      m = x % 19;
      if (m == 0) {
        m = 19;
      }
    }

    @Override
    public String toString() {
      return "Point{" +
          "e=" + e +
          ", s=" + s +
          ", m=" + m +
          '}';
    }
  }
}
