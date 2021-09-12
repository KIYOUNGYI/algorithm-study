package com.study.bj.b2021.step1.brute_force.brute;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P1107_리모컨_v2 {

  //  static final int SIZE = 10_050;
  static final int SIZE = 1_000_050;
  static int c;
  static int n;
  static int[] a = new int[SIZE];
  static int[] b = new int[SIZE];
  static int[] bArr;
  static Map<Integer, Integer> brokenButtonMap = new HashMap<>();

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    c = scan.nextInt();
    n = scan.nextInt();
    bArr = new int[n];
    for (int i = 0; i < n; i++) {
      int t = scan.nextInt();
      brokenButtonMap.put(t, t);
    }

    if (c == 100) {
      System.out.println(0);
      return;
    }

    //초기 (+,-) 버튼만 누른 것
    for (int i = 0; i < SIZE; i++) {
      a[i] = abs(100 - i);
    }

    solution();


  }

  private static void solution() {

    //100에서 해당 채널까지 가는 최소값
    for (int i = 0; i < SIZE; i++) {
      if (possible2(i)) {
        a[i] = min(jarisu(i), a[i]);
      }
    }

    //각 채널에 목표 채널까지 가는 횟수 계산
    for (int i = 0; i < SIZE; i++) {
      b[i] = abs(c - i) + a[i];
    }

    //그 중에서 최소값 구하는 영역
    int x = Integer.MAX_VALUE;
    for (int i = 0; i < SIZE; i++) {
      if (b[i] < x) {
        x = b[i];
      }
    }

    System.out.println(x);


  }

  static boolean possible2(int x) {
    String s = Integer.toString(x);
    for (int i = 0; i < s.length(); i++) {
      int t = s.charAt(i) - 48;
      if (brokenButtonMap.containsKey(t)) {
        return false;
      }
    }
    return true;
  }

  private static boolean possible(int x) {

    String s = Integer.toString(x);
    String[] temp = s.split("");
    for (int j = 0; j < temp.length; j++) {
      int t = Integer.parseInt(temp[j]);
      for (int k = 0; k < bArr.length; k++) {
        if (bArr[k] == t) {
          return false;
        }
      }
    }

    return true;
  }

  static int jarisu(int x) {
    return Integer.toString(x).length();
  }

  static int abs(int x) {
    return x > 0 ? x : -x;
  }

  static int min(int a, int b) {
    return a > b ? b : a;
  }
}
