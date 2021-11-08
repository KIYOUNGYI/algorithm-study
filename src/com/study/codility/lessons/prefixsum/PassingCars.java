package com.study.codility.lessons.prefixsum;

/**
 * A non-empty array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.
 * <p>
 * Array A contains only 0s and/or 1s:
 * <p>
 * 0 represents a car traveling east, 1 represents a car traveling west. The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is passing when P is traveling to
 * the east and Q is traveling to the west.
 * <p>
 * For example, consider array A such that:
 * <p>
 * A[0] = 0 A[1] = 1 A[2] = 0 A[3] = 1 A[4] = 1 We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A of N integers, returns the number of pairs of passing cars.
 * <p>
 * The function should return −1 if the number of pairs of passing cars exceeds 1,000,000,000.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 0 A[1] = 1 A[2] = 0 A[3] = 1 A[4] = 1 the function should return 5, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000]; each element of array A is an integer that can have one of the following values: 0, 1.
 * <p>
 * https://app.codility.com/demo/results/training27AJJS-GC5/
 */
public class PassingCars {

  public static int solution(int[] arr) {

    boolean[] check = new boolean[arr.length];
    int[] sum = new int[arr.length];

    int temp = 0;
    for (int i = arr.length - 1; i >= 0; i--) {

      if (arr[i] == 1) {
        temp += arr[i];
      } else {
        check[i] = true;
      }
      sum[i] = temp;
    }

    int v = 0;
    for (int i = 0; i < arr.length; i++) {
      if (check[i]) {
        v += sum[i];
      }
      if (v > 1_000_000_000) {
        return -1;
      }
    }

    return v <= 1_000_000_000 ? v : -1;
  }


  public static void main(String[] args) {

    int[] A = {0, 1, 0, 1, 1};
    System.out.println(solution(A));

//    int[] B = {0, 1, 0, 1, 0, 1, 0, 1};
//    System.out.println(solution(B));
//
//    int[] C = {1,1,1,1,1,1};
//    System.out.println(solution(C));
//
//    int[] D = {1,0,0,0};
//    System.out.println(solution(D));
  }

}
