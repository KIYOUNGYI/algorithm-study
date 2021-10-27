package com.study.codility.lessons.maxSlice;

/**
 * A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A. The sum of a slice (P, Q) is the total of A[P] + A[P+1] +
 * ... + A[Q].
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns the maximum sum of any slice of A.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 3  A[1] = 2  A[2] = -6 A[3] = 4  A[4] = 0 the function should return 5 because:
 * <p>
 * (3, 4) is a slice of A that has sum 4, (2, 2) is a slice of A that has sum −6, (0, 1) is a slice of A that has sum 5, no other slice of A has sum greater than (0, 1). Write an efficient algorithm
 * for the following assumptions:
 * <p>
 * N is an integer within the range [1..1,000,000]; each element of array A is an integer within the range [−1,000,000..1,000,000]; the result will be an integer within the range
 * [−2,147,483,648..2,147,483,647].
 * <p>
 * <p>
 * https://app.codility.com/demo/results/trainingR7YSZP-XTA/
 */
public class MaxSliceSum {

  public static int solution(int[] arr) {

    int[] sum = new int[arr.length];

    sum[0] = arr[0];

    for (int i = 1; i < arr.length; i++) {
      sum[i] = Math.max(sum[i - 1] + arr[i], arr[i]);
    }
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      if (max < sum[i]) {
        max = sum[i];
      }
    }
    return max;
  }

  public static void main(String[] args) {
    int[] a = {1, 1};
    System.out.println(solution(a));
  }
}
