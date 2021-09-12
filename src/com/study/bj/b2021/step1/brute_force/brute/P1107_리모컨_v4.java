package com.study.bj.b2021.step1.brute_force.brute;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P1107_리모컨_v4 {


  static final int SIZE = 1_000_050;
  //  static final int SIZE = 10_000;
  static int[] s = new int[SIZE];
  static int brokenButtonCount;
  static Map<Integer, Integer> brokenButtonMap = new HashMap<>();
  static int target;
  static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {

    target = scan.nextInt();
    brokenButtonCount = scan.nextInt();

    for (int i = 0; i < brokenButtonCount; i++) {
      int t = scan.nextInt();
      brokenButtonMap.put(t, t);
    }

    for (int i = 0; i < SIZE; i++) {
      s[i] = abs(100 - i);
    }

    if (target == 100) {
      System.out.println(0);
      return;
    }

    for (int i = 0; i < SIZE; i++) {
      if (pass(i)) {
        s[i] = min(s[i], jarisu(i));
      }
    }

    int temp = 0;
    int x = Integer.MAX_VALUE;
    for (int i = 0; i < SIZE; i++) {
      int t = min(x, s[i] + abs(i - target));
      if (t < x) {
        temp = i;
        x = t;
      }
    }
//    System.out.println("temp->"+temp);
//    System.out.println(x);
    int ans = min(s[target], x);
    System.out.println(ans);
  }

  static void printS() {

    for (int i = 0; i < SIZE; i++) {
      System.out.println(i + " " + s[i]);
    }
  }


  static boolean pass(int x) {
    String s = Integer.toString(x);
    for (int i = 0; i < s.length(); i++) {
      int t = s.charAt(i) - 48;
      if (brokenButtonMap.containsKey(t)) {
        return false;
      }
    }
    return true;
  }

  static int jarisu(int x) {
    return Integer.toString(x).length();
  }

  static int abs(int a) {
    return a > 0 ? a : -a;
  }

  static int min(int x, int y) {
    return x > y ? y : x;
  }

}
