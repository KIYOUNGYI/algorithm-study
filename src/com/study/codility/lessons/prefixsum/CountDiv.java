package com.study.codility.lessons.prefixsum;

/**
 * https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int A, int B, int K); }
 * <p>
 * that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:
 * <p>
 * { i : A ≤ i ≤ B, i mod K = 0 }
 * <p>
 * For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * A and B are integers within the range [0..2,000,000,000]; K is an integer within the range [1..2,000,000,000]; A ≤ B. Copyright 2009–2021 by Codility Limited. All Rights Reserved. Unauthorized
 * copying, publication or disclosure prohibited.
 * <p>
 * <p>
 * <p>
 * [result]
 * <p>
 * https://app.codility.com/demo/results/trainingGB8Q6T-KD8/
 */
public class CountDiv {

  public static int solution(int A, int B, int K) {

    int t1 = A;
    for (; ; ) {
      if (isDivisible(t1, K)) {
        break;
      }
      t1 += 1;
    }

    int t2 = B;
    for (; ; ) {
      if (isDivisible(t2, K)) {
        break;
      }
      t2 -= 1;
    }

    return (t2 - t1) / K + 1;
  }

  private static boolean isDivisible(int t1, int k) {
    return t1 % k == 0;
  }


}
