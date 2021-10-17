package com.study.programmers;

import java.util.Arrays;

public class Level1_소수_찾기 {

  static final int MAX = 1_000_001;
  static boolean[] isPrime = new boolean[MAX];

  public static int solution(int n) {

    Arrays.fill(isPrime, true);
    isPrime[1] = false;

    for (int i = 2; i < MAX; i++) {
      for (int j = i + i; j < MAX; j = j + i) {
        isPrime[j] = false;
      }
    }

    int cnt = 0;
    for (int i = 1; i <= n; i++) {
      if (isPrime[i]) {
        cnt += 1;
      }
    }

    return cnt;
  }

  public static void main(String[] args) {
    System.out.println(solution(10));
    System.out.println(solution(5));
  }
}
