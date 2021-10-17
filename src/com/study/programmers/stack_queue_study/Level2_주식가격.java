package com.study.programmers.stack_queue_study;

import java.util.Arrays;

/**
 * 스택 스택 스택
 * https://programmers.co.kr/learn/courses/30/lessons/42584/solution_groups?language=java
 */
public class Level2_주식가격 {

  public static int[] solution(int[] prices) {

    int len = prices.length;

    int[] answers = new int[len];

    for (int i = 0; i < len; i++) {

      for (int j = i + 1; j < len; j++) {

        answers[i]++;

        if (prices[i] > prices[j]) {
          break;
        }

      }

    }

    return answers;
  }

  public int[] solution2(int[] prices) {
    int[] answer = new int[prices.length];

    for (int i = 0; i < prices.length; i++) {
      for (int j = i + 1; j < prices.length; j++) {
        answer[i]++;
        if (prices[i] > prices[j]) {
          break;
        }
      }
    }

    return answer;
  }


  public static void main(String[] args) {
    int[] a = {1, 2, 3, 2, 3};
    System.out.println(Arrays.toString(solution(a)));
  }
}
