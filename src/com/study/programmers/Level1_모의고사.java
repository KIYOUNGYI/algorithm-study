package com.study.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Level1_모의고사 {

  static final int MAX = 10_001;
//  static final int MAX = 100;

  static int[] supo2Pattern = {1, 3, 4, 5};
  static int supo2Idx = 0;

  static int[] supo3Pattern = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
  static int supo3Idx = 0;

  static int[] supo1 = new int[MAX];
  static int[] supo2 = new int[MAX];
  static int[] supo3 = new int[MAX];


  static int[] score = new int[4];

  public static int[] solution(int[] answers) {

    for (int idx = 0; idx < MAX; idx++) {

      supo1[idx] = (idx + 1) % 5 == 0 ? 5 : (idx + 1) % 5;

      if (idx % 2 == 0) {

        supo2[idx] = 2;

      } else {

        supo2[idx] = supo2Pattern[(supo2Idx++) % 4];
      }

      supo3[idx] = supo3Pattern[(supo3Idx++) % 10];

    }

    calculateScores(answers);

    int[] answer = makeAnswersArray();

    return answer;
  }

  private static int[] makeAnswersArray() {
    int max = 0;
    for (int i = 1; i < 4; i++) {
      if (max < score[i]) {
        max = score[i];
      }
    }

    List<Integer> arrList = new ArrayList<>();
    for (int i = 1; i < 4; i++) {
      if (score[i] == max) {
        arrList.add(i);
      }
    }

    Collections.sort(arrList);

    int len2 = arrList.size();

    int[] answer = new int[len2];
    for (int i = 0; i < len2; i++) {
      answer[i] = arrList.get(i);
    }
    return answer;
  }

  private static void calculateScores(int[] answers) {
    for (int i = 0; i < answers.length; i++) {

      if (answers[i] == supo1[i]) {
        score[1] += 1;
      }

      if (answers[i] == supo2[i]) {
        score[2] += 1;
      }

      if (answers[i] == supo3[i]) {
        score[3] += 1;
      }
    }
  }

  public static void main(String[] args) {

//    int[] answers = {1, 2, 3, 4, 5};
//    System.out.println(Arrays.toString(solution(answers)));

    int[] answer2 = {1, 3, 2, 4, 2};
    System.out.println(Arrays.toString(solution(answer2)));
  }
}
