package com.study.codility.lessons.maxSlice;

import java.util.HashMap;
import java.util.Map;

/**
 * [score - 46]
 * <p>
 * https://app.codility.com/demo/results/trainingKKDF2N-KTT/
 */
public class MaxDoubleSliceSum {

  public static int solution(int[] input) {

    Map<String, Integer> myMap = new HashMap<>();

    int len = input.length;
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < len; i++) {
      for (int j = i + 1; j < len; j++) {
        for (int k = j + 1; k < len; k++) {

//          System.out.println(i + " " + j + " " + k);
          int sum1 = 0;
          if (myMap.containsKey(i + "_" + j)) {
            sum1 = myMap.get(i + "_" + j);
          } else {
            for (int x = i + 1; x < j; x++) {
              sum1 += input[x];
            }
            myMap.put(i + "_" + j, sum1);
          }

          int sum2 = 0;
          if (myMap.containsKey(j + "_" + k)) {

            sum2 = myMap.get(j + "_" + k);

          } else {

            for (int x = j + 1; x < k; x++) {
              sum2 += input[x];
            }
            myMap.put(j + "_" + k, sum2);
          }

          if (max < sum1 + sum2) {
            max = sum1 + sum2;
          }
        }
      }
    }

    return max;
  }

  public static void main(String[] args) {
    int[] a = {3, 2, 6, -1, 4, 5, -1, 2};
    System.out.println(solution(a));
  }
}
