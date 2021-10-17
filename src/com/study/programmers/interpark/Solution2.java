package com.study.programmers.interpark;

import java.util.Arrays;

/**
 * 1] 무조건 토일 확보된 [토,일] 값 구하기
 * 2] 전체 일수 % 7 -> 남은 일수
 * 2-1] 남은 일수에 대해 각각 요일에 시작할 경우 (토,일)이 들어가는 경우의 수 구현
 */
public class Solution2 {
  static String[] srr = {"mon", "tue", "wed", "thur", "fri", "sat", "sun"};

  public static long[] solution(long n) {

    long base = (n / 7) * 2;

    int remain = (int) (n % 7);

    int[] score = new int[7];

    //월요일 시작하는 경우
    for (int i = 0; i < remain; i++) {
      String t = srr[i % 7];
      if (t.equals("sat") || t.equals("sun")) {
        score[0] += 1;
      }
    }
    //화요일 시작하는 경우
    for (int i = 0; i < remain; i++) {
      String t = srr[(i + 1) % 7];
      if (t.equals("sat") || t.equals("sun")) {
        score[1] += 1;
      }
    }
    //수요일 시작하는 경우
    for (int i = 0; i < remain; i++) {
      String t = srr[(i + 2) % 7];
      if (t.equals("sat") || t.equals("sun")) {
        score[2] += 1;
      }
    }
    //목요일 시작하는 경우
    for (int i = 0; i < remain; i++) {
      String t = srr[(i + 3) % 7];
      if (t.equals("sat") || t.equals("sun")) {
        score[3] += 1;
      }
    }
    //금요일 시작하는 경우
    for (int i = 0; i < remain; i++) {
      String t = srr[(i + 4) % 7];
      if (t.equals("sat") || t.equals("sun")) {
        score[4] += 1;
      }
    }
    //토요일 시작하는 경우
    for (int i = 0; i < remain; i++) {
      String t = srr[(i + 5) % 7];
      if (t.equals("sat") || t.equals("sun")) {
        score[5] += 1;
      }
    }
    //일요일 시작하는 경우
    for (int i = 0; i < remain; i++) {
      String t = srr[(i + 6) % 7];
      if (t.equals("sat") || t.equals("sun")) {
        score[6] += 1;
      }
    }

    Arrays.sort(score);

    long[] answer = {base + score[0], base + score[6]};
    return answer;
  }
}
