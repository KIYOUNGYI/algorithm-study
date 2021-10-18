package com.study.programmers;

import java.util.Arrays;

public class Level1_제일_작은_수_제거하기 {

  public static int[] solution(int[] arr) {

    if (arr.length == 1) {
      return new int[]{-1};
    }

    int min = Integer.MAX_VALUE;
    int minIdx = 0;

    for (int i = 0; i < arr.length; i++) {
      if (min > arr[i]) {
        min = arr[i];
        minIdx = i;
      }
    }

    int[] temp = new int[arr.length - 1];

    int idx = 0;
    for (int i = 0; i < arr.length; i++) {

      if (i == minIdx) {
        continue;
      }
      temp[idx++] = arr[i];
    }

    return temp;
  }

  public static void main(String[] args) {
    int[] arr1 = {10};
    System.out.println(Arrays.toString(solution(arr1)));
  }
}
