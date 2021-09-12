package com.study.bj.b2021.step1.brute_force.recursion;

import java.util.Scanner;

public class P14501_백준_풀이 {

  static int n;
  static int[] t;
  static int[] p;
  static int max = Integer.MIN_VALUE;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    t = new int[n + 1];
    p = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      t[i] = scan.nextInt();
      p[i] = scan.nextInt();
    }
//    System.out.println(Arrays.toString(t));
//    System.out.println(Arrays.toString(p));

    go(1, 0);
    System.out.println(max);
  }

  private static void go(int day, int sum) {
    //정답
    if (day == n + 1) { //n+1일날 퇴사를 한다.
      if (max < sum) {
        max = sum;
      }
    }
    //불가능한 경우
    if (day >= n + 1) {//퇴사일도 포함시켜야지(이날은 일 안하니까)
      return;
    }

    //상담 한다.
    go(day + t[day], sum + p[day]);

    //상담 안한다.
    go(day + 1, sum);
  }
}
