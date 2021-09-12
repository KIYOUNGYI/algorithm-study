package com.study.codility.lessons.timecomplexity;

import java.util.Arrays;

public class TapeEquilibrium23 {

  public static void main(String[] args) {
//    int[] a = {3, 1, 2, 4, 3};
    int[] e = {5, 6, 2, 4, 1};
    int t = solution23(e);
    System.out.println(t);
  }

  static int[] bit;
  static int limit;
  static int min = Integer.MAX_VALUE;
  static int[] copy;

  public static int solution23(int[] arr) {
    copy = arr;
    for(int i=0;i<arr.length;i++){
      copy[i] = arr[i];
    }

    bit = new int[arr.length];

    for (int i = 1; i <= arr.length / 2; i++) {
      limit = i;
      recursion(0, 0);
    }

    return min;
  }

  private static void recursion(int depth, int cnt) {

    if (cnt == limit) {
      System.out.println(Arrays.toString(bit));
      calculate();
      return;
    }
    if (depth == bit.length) {
      return;
    }
    bit[depth] = 1;
    recursion(depth + 1, cnt + 1);
    bit[depth] = 0;
    recursion(depth + 1, cnt);
  }

  private static void calculate() {

    int sum1 = 0;
    int sum2 = 0;

    for (int i = 0; i < bit.length; i++) {
      if (bit[i] == 1) {
        sum1 += copy[i];
      } else {
        sum2 += copy[i];
      }
    }
    System.out.println("sum1:"+sum1);
    System.out.println("sum2:"+sum2);

    int t1 = abs(sum1-sum2);
    System.out.println("abs(sum2-sum1) : " + t1);
    if (t1 < min) {
      min = t1;
    }
  }

  static int abs(int x) {
    return x > 0 ? x : -x;
  }

}
