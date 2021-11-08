package com.study.codility.lessons.countingelements;

import java.util.Arrays;

/**
 * <구글링 출처>
 * <p>
 * https://cchoimin.tistory.com/entry/CodilityMaxCounters
 * <p>
 * https://jackjeong.tistory.com/23
 * <p>
 * https://hong-yp-ml-records.tistory.com/75
 * <p>
 * <p>
 * <p>
 * <p>
 * [score => 100]
 * <p>
 * https://app.codility.com/demo/results/trainingVTFN7E-S5N/
 * <p>
 * <p>
 * [score => 88]
 * <p>
 * https://app.codility.com/demo/results/training8AMHCY-VT4/
 * <p>
 * <p>
 * [score => 77]
 * <p>
 * https://app.codility.com/demo/results/trainingNKZ7XZ-W7N/
 */
public class MaxCounter {


  public static int[] solution(int n, int[] input) {

    int[] result = new int[n];
    int max = 0;

    int allMax = 0;

    for (int i = 0, len = input.length; i < len; i++) {

      int now = input[i] - 1;

      if (now >= n) {

        allMax = max;

      } else {

        result[now] = Math.max(allMax, result[now]) + 1;
        max = Math.max(max, result[now]);
      }
      System.out.println(Arrays.toString(result));
      System.out.println();
    }

    for (int i = 0, len = n; i < len; i++) {
      result[i] = Math.max(result[i], allMax);
    }

    return result;
  }

  public static void main(String[] args) {
    int[] a = {3, 4, 4, 6, 1, 4, 4};
    solution(5, a);
  }
}
