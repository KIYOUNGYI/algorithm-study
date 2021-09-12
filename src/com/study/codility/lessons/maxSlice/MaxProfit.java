package com.study.codility.lessons.maxSlice;

import java.util.Arrays;

public class MaxProfit {

//  static

  public static void main(String[] args) {
    int[] a = {5, 7, 3, 5, 2, 4, 1};
    int[] b = {23171, 21011, 21123, 21366, 21013, 21367};
    int[] c = {3, 2, 1};
    int[] d = {};
    int[] e = {0, 20_000};
//    System.out.println(Arrays.toString(a));
    System.out.println(solution(b));
  }

  //https://app.codility.com/demo/results/trainingWXNJYX-ZH6/
  public static int solution77(int[] arr) {

    int max = Integer.MIN_VALUE;
    int[] minArr = new int[arr.length];
    int[] maxArr = new int[arr.length];

    minArr[0] = arr[0];

    for (int i = 1; i < arr.length; i++) {
      minArr[i] = min(arr[i], minArr[i - 1]);
    }
    System.out.println(Arrays.toString(minArr));

    maxArr[arr.length - 1] = arr[arr.length - 1];
    for (int i = arr.length - 1; i >= 1; i--) {
      maxArr[i - 1] = max(maxArr[i], arr[i - 1]);
    }
    System.out.println(Arrays.toString(maxArr));

    for (int i = arr.length - 1; i >= 1; i--) {
      int t = maxArr[i] - minArr[i - 1];
      if (t > max) {
        max = t;
      }
    }

    return max;
  }


  public static int solutionBro(int[] c){

    return 0;
  }

  //https://app.codility.com/demo/results/trainingV5CN6M-M3U/
  public static int solution(int[] arr) {

    if (arr.length == 0) {
      return 0;
    }

    int max = Integer.MIN_VALUE;

    int[] minArr = new int[arr.length];
    int[] maxArr = new int[arr.length];

    int[] temp = new int[arr.length];

    minArr[0] = arr[0];

    for (int i = 1; i < arr.length; i++) {
      minArr[i] = min(arr[i], minArr[i - 1]);
    }
    System.out.println(Arrays.toString(minArr));

    maxArr[arr.length - 1] = arr[arr.length - 1];
    for (int i = arr.length - 1; i >= 1; i--) {
      maxArr[i - 1] = max(maxArr[i], arr[i - 1]);
    }



    System.out.println(Arrays.toString(maxArr));

    for (int i = arr.length - 1; i >= 1; i--) {
      int t = maxArr[i] - minArr[i - 1];
      if (t > max) {
        max = t;
      }
    }
    if (max < 0) {
      max = 0;
    }
    return max;
  }

  public static int max(int a, int b) {
    return a > b ? a : b;
  }

  public static int min(int a, int b) {
    return a < b ? a : b;
  }
}
