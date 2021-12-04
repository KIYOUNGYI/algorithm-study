package com.study.codility.lessons.prefixsum;

/**
 * A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the slice contains at least two elements). The
 * average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).
 * <p>
 * For example, array A such that:
 * <p>
 * A[0] = 4 A[1] = 2 A[2] = 2 A[3] = 5 A[4] = 1 A[5] = 5 A[6] = 8 contains the following example slices:
 * <p>
 * slice (1, 2), whose average is (2 + 2) / 2 = 2; slice (3, 4), whose average is (5 + 1) / 2 = 3; slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5. The goal is to find the starting position
 * of a slice whose average is minimal.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A consisting of N integers, returns the starting position of the slice with the minimal average. If there is more than one slice with a minimal average, you should
 * return the smallest starting position of such a slice.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 4 A[1] = 2 A[2] = 2 A[3] = 5 A[4] = 1 A[5] = 5 A[6] = 8 the function should return 1, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [2..100,000]; each element of array A is an integer within the range [−10,000..10,000].
 * <p>
 * <p>
 * 카데인 알고리즘 응용한 풀이 (시간 복잡도 - O(N))
 * <p>
 * <p>
 * https://app.codility.com/demo/results/trainingUEGUEZ-4KT/
 */
public class MinAvgTwoSlice {

  private static int[] start;
  private static int[] jarisu;
  private static double[] avgArr;

  public static int solution(int[] arr) {

    int len = arr.length;
    jarisu = new int[len];
    avgArr = new double[len];
    start = new int[len];

    avgArr[1] = (double) (arr[0] + arr[1]) / 2;
    jarisu[1] = 2;
    start[1] = 0;

    if (len == 2) {
      return 0;
    }

    for (int i = 2; i < len; i++) {

      double d1 = (double) ((arr[i] + arr[i - 1])) / 2;
      double d2 = (avgArr[i - 1] * jarisu[i - 1] + arr[i]) / (jarisu[i - 1] + 1);

      if (d1 < d2) {
        avgArr[i] = d1;
        jarisu[i] = 2;
        start[i] = i - 1;
      } else {
        avgArr[i] = d2;
        jarisu[i] = jarisu[i - 1] + 1;
        start[i] = i - jarisu[i] + 1;
      }
    }

    int idx = 1;
    double val = Double.MAX_VALUE;
    for (int i = 1; i < len; i++) {
      if (avgArr[i] < val) {
        val = avgArr[i];
        idx = i;
      }
    }
//    System.out.println("given = " + Arrays.toString(arr));
//    System.out.println("jarisu = " + Arrays.toString(jarisu));
//    System.out.println("Arrays.toString(avgArr) = " + Arrays.toString(avgArr));
//    System.out.println("startIdx:" + Arrays.toString(start));
    return idx - jarisu[idx] + 1;
  }

  public static void main(String[] args) {

//    int[] a = {4, 2, 2, 5, 1, 8};
//    System.out.println(solution(a));
    int[] b = {10, 2, 3, 4, -5, 10};
    System.out.println(solution(b));
  }
}
