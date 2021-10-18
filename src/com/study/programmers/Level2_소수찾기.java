package com.study.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 시간 충분함
 */
public class Level2_소수찾기 {

  private static final int MAX = 1_0000_020;
  private static boolean[] isPrime = new boolean[MAX];
  private static boolean[] visit;
  private static char[] input;
  private static char[] ans;
  private static int limit;
  private static List<Integer> arrList = new ArrayList<>();

  private static void initIsPrime() {

    Arrays.fill(isPrime, true);

    isPrime[0] = false;
    isPrime[1] = false;

    for (int i = 2; i < MAX; i++) {
      for (int j = i + i; j < MAX; j = j + i) {
        isPrime[j] = false;
      }
    }
  }

  public static int solution(String numbers) {

    initIsPrime();

    int len = numbers.length();
    input = numbers.toCharArray();
    visit = new boolean[len];

    for (int i = 1; i <= len; i++) {
      limit = i;
      ans = new char[i];
      recursion(0);
    }

    int cnt = 0;
    for (Integer x : arrList) {
      if (isPrime[x]) {
        cnt += 1;
      }
    }

    return cnt;
  }

  private static void recursion(int depth) {

    if (depth == limit) {

      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < ans.length; i++) {
        sb.append(ans[i]);
      }
      Integer t = Integer.parseInt(sb.toString());

      if (!arrList.contains(t)) {
        arrList.add(t);
      }

      return;
    }

    for (int i = 0; i < input.length; i++) {
      if (!visit[i]) {
        visit[i] = true;
        ans[depth] = input[i];
        recursion(depth + 1);
        visit[i] = false;
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(solution("17"));
  }

}
