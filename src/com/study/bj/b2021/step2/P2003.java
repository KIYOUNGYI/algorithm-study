package com.study.bj.b2021.step2;

import java.util.Arrays;
import java.util.Scanner;

public class P2003 {

  static int SIZE;
  static int n;
  static long[] a;
  static long k;
  static long cnt = 0;
  static int[] startEnd = new int[3];
  static boolean[] v;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    a = new long[n + 1];
    v = new boolean[n + 1];
    SIZE = n;
    k = scan.nextLong();

    for (int i = 1; i <= n; i++) {
      a[i] = scan.nextLong();
    }

//    recursion(1);
    recursion2(1);
    System.out.println(cnt);
  }


  private static void recursion2(int depth) {
    if (depth == 3) {
      System.out.println(Arrays.toString(startEnd));
      if (calculate() == k) {
        cnt += 1;
      }
      return;
    }

    if (depth == 1) {
      for (int i = 1; i <= n; i++) {
        if (!v[i]) {
          v[i] = true;
          startEnd[depth] = i;
          recursion2(depth + 1);
          v[i] = false;
        }
      }
    }
    if (depth == 2) {
      for (int i = 1; i <= n; i++) {
        if (!v[i] && startEnd[1] < i) {

          long tempSum = 0;
          int j = i;
          for(int t=startEnd[1];t<=j;t++){
            tempSum+=a[t];
            if(tempSum>k){
              return;
            }
          }

          v[i] = true;
          startEnd[depth] = i;
          recursion2(depth + 1);
          v[i] = false;
        }
      }
    }

  }


  private static void recursion(int depth) {

    if (depth == 3) {
//      System.out.println(Arrays.toString(startEnd));
      if (calculate() == k) {
        cnt += 1;
      }
      return;
    }

    if (depth == 1) {
      for (int i = 1; i <= n; i++) {
        if (!v[i]) {
          v[i] = true;
          startEnd[depth] = i;
          recursion(depth + 1);
          v[i] = false;
        }
      }
    }
    if (depth == 2) {
      for (int i = 1; i <= n; i++) {
        if (!v[i] && startEnd[1] < i) {
          v[i] = true;
          startEnd[depth] = i;
          recursion(depth + 1);
          v[i] = false;
        }
      }
    }

  }

  private static long calculate() {
    long sum = 0l;
    for (int i = startEnd[1]; i <= startEnd[2]; i++) {
      sum += a[i];
      if (sum > k) {
        return Long.MAX_VALUE;
      }
    }
    return sum;
  }


}
