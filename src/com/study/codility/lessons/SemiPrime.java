package com.study.codility.lessons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *
 * A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are 2, 3, 5, 7, 11 and 13.
 * <p>
 * A semiprime is a natural number that is the product of two (not necessarily distinct) prime numbers. The first few semiprimes are 4, 6, 9, 10, 14, 15, 21, 22, 25, 26.
 * <p>
 * You are given two non-empty arrays P and Q, each consisting of M integers. These arrays represent queries about the number of semiprimes within specified ranges.
 * <p>
 * Query K requires you to find the number of semiprimes within the range (P[K], Q[K]), where 1 ≤ P[K] ≤ Q[K] ≤ N.
 * <p>
 * For example, consider an integer N = 26 and arrays P, Q such that:
 * <p>
 * P[0] = 1    Q[0] = 26 P[1] = 4    Q[1] = 10 P[2] = 16   Q[2] = 20 The number of semiprimes within each of these ranges is as follows:
 * <p>
 * (1, 26) is 10, (4, 10) is 4, (16, 20) is 0. Write a function:
 * <p>
 * class Solution { public int[] solution(int N, int[] P, int[] Q); }
 * <p>
 * that, given an integer N and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M elements specifying the consecutive answers to all the queries.
 * <p>
 * For example, given an integer N = 26 and arrays P, Q such that:
 * <p>
 * P[0] = 1    Q[0] = 26 P[1] = 4    Q[1] = 10 P[2] = 16   Q[2] = 20 the function should return the values [10, 4, 0], as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..50,000]; M is an integer within the range [1..30,000]; each element of arrays P and Q is an integer within the range [1..N]; P[i] ≤ Q[i]. Copyright 2009–2021 by
 * Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 * <p>
 * <p>
 * https://app.codility.com/demo/results/trainingEC9AR2-524/
 */
class SemiPrime {

  static int N;
  static boolean[] isPrime;
  static List<Integer> primeList = new ArrayList<>();
  static List<Integer> semiPrimeList = new ArrayList<>();

  static boolean[] isSemiPrime;
  static int[] isSemiPrimeV2;
  static Map<Integer, Integer> myMap = new HashMap();

  public static int[] solution(int n, int[] p, int[] q) {
    N = n;
    isPrime = new boolean[N + 1];
    isSemiPrime = new boolean[N + 1];
    isSemiPrimeV2 = new int[N + 1];

    initPrime();
    makeSemiPrime();

    int len = p.length;

    int[] ans = new int[len];

    for (int i = 0; i < len; i++) {

      int t1 = p[i];
      int t2 = q[i];

      if (t1 == 0) {
        ans[i] = isSemiPrimeV2[t2];
      } else {
        ans[i] = isSemiPrimeV2[t2] - isSemiPrimeV2[t1 - 1];
      }
    }

    return ans;
  }

  private static void makeSemiPrime() {

    for (int i = 0; i < primeList.size(); i++) {
      for (int j = i; j < primeList.size(); j++) {

        if (primeList.get(i) * primeList.get(j) > N) {
          break;
        }

        if (!semiPrimeList.contains(primeList.get(i) * primeList.get(j))) {

          myMap.put(primeList.get(i) * primeList.get(j), 1);
        }
      }
    }

    int cnt = 0;
    for (int i = 0; i <= N; i++) {
      if (myMap.get(i) != null) {
        cnt += 1;
      }
      isSemiPrimeV2[i] = cnt;
    }

  }

  private static void initPrime() {

    Arrays.fill(isPrime, true);
    isPrime[0] = false;
    isPrime[1] = false;

    for (int i = 2; i <= N; i++) {
      for (int j = i + i; j <= N; j = j + i) {
        isPrime[j] = false;
      }
    }

    for (int i = 0; i < isPrime.length; i++) {
      if (isPrime[i]) {
        primeList.add(i);
      }
    }
  }
}

