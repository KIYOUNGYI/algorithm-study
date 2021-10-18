package com.study.codility.lessons.sorting;

import java.util.Arrays;

/**
 * https://app.codility.com/programmers/lessons/6-sorting/triangle/
 * <p>
 * An array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:
 * <p>
 * A[P] + A[Q] > A[R], A[Q] + A[R] > A[P], A[R] + A[P] > A[Q]. For example, consider array A such that:
 * <p>
 * A[0] = 10    A[1] = 2    A[2] = 5 A[3] = 1     A[4] = 8    A[5] = 20 Triplet (0, 2, 4) is triangular.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns 1 if there exists a triangular triplet for this array and returns 0 otherwise.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 10    A[1] = 2    A[2] = 5 A[3] = 1     A[4] = 8    A[5] = 20 the function should return 1, as explained above. Given array A such that:
 * <p>
 * A[0] = 10    A[1] = 50    A[2] = 5 A[3] = 1 the function should return 0.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..100,000]; each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 * <p>
 * <p>
 * [100 점] https://app.codility.com/demo/results/trainingX2HY3N-AWF/
 * <p>
 * <p>
 * [96 점]
 * <p>
 * https://app.codility.com/demo/results/training43FQZP-6E6/
 */
public class Triangle {

  public static int solution(int[] A) {

    Arrays.sort(A);

    int len = A.length;

    for (int i = len - 1; i >= 2; i--) {
      long pivot = A[i];
      long atom1 = A[i - 1];
      long atom2 = A[i - 2];
      if (atom1 + atom2 > pivot) {
        return 1;
      }
    }
    return 0;
  }

  public static void main(String[] args) {

//    int[] A = {10, 2, 5, 1, 8, 20};
//    System.out.println(solution(A));

    int[] B = {10, 50, 5, 1};
    System.out.println(solution(B));
  }
}
