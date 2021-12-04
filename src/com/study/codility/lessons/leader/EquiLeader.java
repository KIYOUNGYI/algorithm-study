package com.study.codility.lessons.leader;

import java.util.Arrays;

/**
 * EquiLeader
 * <p>
 * <p>
 * A non-empty array A consisting of N integers is given.
 * <p>
 * The leader of this array is the value that occurs in more than half of the elements of A.
 * <p>
 * An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 4 A[1] = 3 A[2] = 4 A[3] = 4 A[4] = 4 A[5] = 2 we can find two equi leaders:
 * <p>
 * 0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4. 2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4. The goal is to count the
 * number of equi leaders.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A consisting of N integers, returns the number of equi leaders.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 4 A[1] = 3 A[2] = 4 A[3] = 4 A[4] = 4 A[5] = 2 the function should return 2, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000]; each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
 * <p>
 * <p>
 * https://app.codility.com/demo/results/trainingGV7FGY-CF9/
 */
public class EquiLeader {


  public static int solution(int[] arr) {

    int[] brr = Arrays.copyOf(arr, arr.length);
    Arrays.sort(brr);
//    System.out.println("Arrays.toString(brr) = " + Arrays.toString(brr));
    int dominator = brr[brr.length / 2];
//    System.out.println("dominator = " + dominator);

    int[] recordArr = new int[arr.length];
    int[] revRecordArr = new int[arr.length];

    for (int i = 0, len = arr.length, sum = 0; i < len; i++) {
      if (arr[i] == dominator) {
        sum += 1;
      }
      recordArr[i] = sum;
    }

    for (int i = arr.length - 1, sum = 0; i >= 0; i--) {
      if (arr[i] == dominator) {
        sum += 1;

      }
      revRecordArr[i] = sum;
    }

//    System.out.println("Arrays.toString() = " + Arrays.toString(recordArr));
//    System.out.println("Arrays.toString() = " + Arrays.toString(revRecordArr));

    double leftBunMo = 1;
    double rightBunMo = arr.length - 1;

    int ans = 0;
    for (int index = 0, len = arr.length - 1; index < len; index++) {

      double left = (double) recordArr[index] / leftBunMo;
      double right = (double) revRecordArr[index + 1] / rightBunMo;
//      System.out.println("left = " + left + " right = " + right);
      if (left > 0.5 && right > 0.5) {
        ans += 1;
      }
      leftBunMo += 1;
      rightBunMo -= 1;
    }

    return ans;
  }


  public static void main(String[] args) {
    int[] a = {4, 3, 4, 4, 4, 2};
    System.out.println(solution(a));
  }
}
