package com.study.programmers.heap_study;

import java.util.PriorityQueue;

public class 더맵게 {

  public static int solution(int[] scoville, int K) {

    PriorityQueue<Integer> q = new PriorityQueue<>();

    for (int i : scoville) {
      q.add(i);
    }

    int idx;
    for (idx = 1; ; idx++) {

      int firstWeak = q.remove();
      int secondWeak = q.remove();

      int score = firstWeak + 2 * secondWeak;

      q.add(score);

      if (check(q, K)) {
        break;
      }

      if (q.size() == 1 && !check(q, K)) {
        return -1;
      }

    }

    return idx;
  }

  private static boolean check(PriorityQueue<Integer> q, int k) {

    for (int x : q) {
      if (x < k) {
        return false;
      }
    }
    return true;
  }


  public static void main(String[] args) {

    int[] scoville = {1, 2, 3, 9, 10, 12};
    int K = 7;

    System.out.println(solution(scoville, K));


  }
}
