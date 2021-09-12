package com.study.bj.b2021.step1.dynamic_programming.part2;

import java.util.Scanner;
import java.util.Stack;

public class P11722_v1 {

  static int n;
  static int[] a;
  static int[] d;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    a = new int[n + 1];
    d = new int[n + 1];

    Stack<Integer> s = new Stack<>();
    for (int i = 1; i <= n; i++) {
      int t = scan.nextInt();
      s.push(t);
    }
    int idx = 1;
    while (!s.isEmpty()) {
      int t = s.pop();
      a[idx] = t;
      idx += 1;
    }

//    System.out.println(Arrays.toString(a));

    for (int std = 1; std <= n; std++) {

      d[std] = 1;

      for (int i = 1; i < std; i++) {
//        System.out.println(i + " " + std);

        if (a[std] > a[i] && d[std] < d[i] + 1) {
          d[std] = d[i] + 1;
        }

      }
//      System.out.println("=======");
    }
//    System.out.println(Arrays.toString(d));
    int res = -1;
    for (int i = 1; i <= n; i++) {
      if (d[i] > res) {
        res = d[i];
      }
    }
    System.out.println(res);
  }
}
