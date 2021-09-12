package com.study.codility.lessons.timecomplexity;

public class TapeEquilibrium100 {

  public static void main(String[] args) {
    int[] a = {3, 1, 2, 4, 3};
    int[] e = {5, 6, 2, 4, 1};
    int t = solution(a);
    System.out.println(t);
  }


  public static int solution(int[] arr) {

    int min = 0;
    int sum1 = arr[0];
    int sum2 = 0;
    for (int i = 1; i < arr.length; i++) {
      sum2 += arr[i];
    }
    min = abs(sum1 - sum2);

    for (int i = 1; i < arr.length - 1; i++) {
      sum1 += arr[i];
      sum2 -= arr[i];
      if (abs(sum1 - sum2) < min) {
        min = abs(sum1 - sum2);
      }
    }

    return min;
  }


  static int abs(int x) {
    return x > 0 ? x : -x;
  }

}
