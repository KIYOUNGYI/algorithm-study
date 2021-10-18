package com.study.codility.lessons.sorting;

import java.util.Arrays;

/**
 * A non-empty array A consisting of N integers is given. The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).
 * <p>
 * For example, array A such that:
 * <p>
 * A[0] = -3 A[1] = 1 A[2] = 2 A[3] = -2 A[4] = 5 A[5] = 6 contains the following example triplets:
 * <p>
 * (0, 1, 2), product is −3 * 1 * 2 = −6 (1, 2, 4), product is 1 * 2 * 5 = 10 (2, 4, 5), product is 2 * 5 * 6 = 60 Your goal is to find the maximal product of any triplet.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A, returns the value of the maximal product of any triplet.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = -3 A[1] = 1 A[2] = 2 A[3] = -2 A[4] = 5 A[5] = 6 the function should return 60, as the product of triplet (2, 4, 5) is maximal.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [3..100,000]; each element of array A is an integer within the range [−1,000..1,000].
 * <p>
 * [score - 100]
 * <p>
 * https://app.codility.com/demo/results/trainingPY5QAT-DU7/
 * <p>
 * <p>
 * [score - 44]
 * <p>
 * https://app.codility.com/demo/results/trainingHGEEYX-YFJ/
 */
public class MaxProductOfThree {

  public static int solution44(int[] A) {
    // write your code in Java SE 8
    int len = A.length;
    Arrays.sort(A);

    return A[len - 1] * A[len - 2] * A[len - 3];
  }

  public static int solution(int[] A) {

    int len = A.length;
    int minusCnt = 0;

    for (int i = 0; i < A.length; i++) {
      if (A[i] < 0) {
        minusCnt += 1;
      }
    }

    Arrays.sort(A);

    if (minusCnt >= 2) {

      return Math.max(A[0] * A[1] * A[len - 1], A[len - 1] * A[len - 2] * A[len - 3]);

    } else {

      return A[len - 1] * A[len - 2] * A[len - 3];
    }

  }


  public static void main(String[] args) {
    int[] a = {-5, 5, -5, 4};

    System.out.println(solution(a));
  }


}
