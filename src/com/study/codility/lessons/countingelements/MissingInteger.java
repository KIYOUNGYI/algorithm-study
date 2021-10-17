package com.study.codility.lessons.countingelements;

/**
 * This is a demo task.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 * <p>
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * <p>
 * Given A = [1, 2, 3], the function should return 4.
 * <p>
 * Given A = [−1, −3], the function should return 1.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000]; each element of array A is an integer within the range [−1,000,000..1,000,000].
 * <p>
 * https://app.codility.com/demo/results/trainingWTDVSJ-DYE/
 */
public class MissingInteger {

  public static int solution(int[] arr) {

    int[] a = new int[1_000_001];

    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
      if (arr[i] < min) {
        min = arr[i];
      }

      if (arr[i] > 0) {
        a[arr[i]] += 1;
      }
    }

    if (min < 0 && max < 0) {
      return 1;
    }

    int idx = 0;
    for (int i = 1; i < 1_000_001; i++) {
      if (a[i] == 0) {
        idx = i;
        break;
      }
    }

    return idx;
  }

  public static void main(String[] args) {

  }
}
