package com.study.programmers;

import java.util.Arrays;

public class Level1_소수만들기 {

  static final int MAX = 3001;
  static boolean[] isPrime = new boolean[MAX];

  public static int solution(int[] nums) {

    setIsPrime();

    int len = nums.length;

    Arrays.sort(nums);
    int cnt = 0;
    for (int i = 0; i < len; i++) {
      for (int j = i + 1; j < len; j++) {
        for (int k = j + 1; k < len; k++) {

          int t = nums[i] + nums[j] + nums[k];
          if (isPrime[t]) {
            cnt += 1;
          }
        }
      }
    }

    return cnt;
  }

  private static void setIsPrime() {
    Arrays.fill(isPrime, true);
    isPrime[1] = false;

    for (int i = 2; i < MAX; i++) {
      for (int j = i + i; j < MAX; j = j + i) {
//        System.out.println("i = " + i + " j = " + j);
        isPrime[j] = false;
      }
    }
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 7, 6, 4};
    System.out.println(solution(a));
  }
}
