package com.study.programmers;

public class Level2_숫자표현 {

  static final int MAX = 10_000;

  public static int solution(int n) {

    int cnt = 0;

    for (int s = 1; s < MAX; s++) {

      int sum = s;

      for (int t = s + 1; t < MAX; t++) {
        sum += t;
        if (sum > n) {
          break;
        } else if (sum == n) {
          cnt+=1;
          break;
        }
      }
    }

    return cnt+1;
  }

  public static void main(String[] args) {

    System.out.println(solution(15));
  }
}
