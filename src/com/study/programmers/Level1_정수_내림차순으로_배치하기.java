package com.study.programmers;

import java.util.Arrays;

public class Level1_정수_내림차순으로_배치하기 {

  public static long solution(long n) {

    String s = String.valueOf(n);
    String[] split = s.split("");
    int len = split.length;
    int[] arr = new int[len];

    for (int i = 0; i < split.length; i++) {
      arr[i] = Integer.valueOf(split[i]);
    }

    Arrays.sort(arr);

    int idx = 0;
    int[] brr = new int[len];
    for (int i = arr.length - 1; i >= 0; i--) {
      brr[idx++] = arr[i];
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < brr.length; i++) {
      sb.append(brr[i]);
    }

    return Long.valueOf(sb.toString());
  }

  public static void main(String[] args) {
    System.out.println(solution(118372));
  }

}
