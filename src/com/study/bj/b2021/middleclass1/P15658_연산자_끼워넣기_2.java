package com.study.bj.b2021.middleclass1;

import java.util.Arrays;
import java.util.Scanner;

public class P15658_연산자_끼워넣기_2 {

  static int MAX = Integer.MIN_VALUE;
  static int MIN = Integer.MAX_VALUE;
  static int t;
  static int[] giho, arr;
  static boolean[] v;
  static int cnt = 0;
  static int[] delta;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scan.nextInt();
    }

    int a = scan.nextInt();//add
    int b = scan.nextInt();//sub
    int c = scan.nextInt();//mul
    int d = scan.nextInt();//div

    t = n - 1;
    giho = new int[t];
    delta = new int[t];
    v = new boolean[t];
    for (int w = 0; w <= a; w++) {
      for (int x = 0; x <= b; x++) {
        for (int y = 0; y <= c; y++) {
          for (int z = 0; z <= d; z++) {
            if (w + x + y + z == t) {
//              System.out.println("+ : "+w+" - : "+x+" * : "+y+" / : "+z);
              int idx = 0;
              for (int i = 0; i < w; i++) {
                giho[idx++] = 1;
              }
              for (int i = 0; i < x; i++) {
                giho[idx++] = 2;
              }
              for (int i = 0; i < y; i++) {
                giho[idx++] = 3;
              }
              for (int i = 0; i < z; i++) {
                giho[idx++] = 4;
              }
              System.out.println(Arrays.toString(giho));
              johab(0);
            }
          }
        }
      }
    }
  }

  private static void johab(int depth) {
    if (depth == t) {
      cnt += 1;
      System.out.println("->"+Arrays.toString(delta));
//      calculate();
      return;
    }

    for (int i = 0; i < t; i++) {
      if (!v[i]) {
        v[i] = true;
        delta[depth] = giho[i];
        johab(depth + 1);
        v[i] = false;
      }
    }
  }
}
