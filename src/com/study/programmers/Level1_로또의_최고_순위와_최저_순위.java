package com.study.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Level1_로또의_최고_순위와_최저_순위 {

  static int[] rank = {6,6,5,4,3,2,1};
  public static int[] solution(int[] lottos, int[] win_nums) {

    List<Integer> arrList = new ArrayList<>();
    int zeroCnt = 0;
    for (int i = 0; i < lottos.length; i++) {
      if (lottos[i] == 0) {
        zeroCnt += 1;
      } else {
        arrList.add(lottos[i]);
      }
    }

    int containCnt = 0;
    for (int i = 0; i < win_nums.length; i++) {
      if (arrList.contains(win_nums[i])) {
        containCnt += 1;
      }
    }

    int maxCnt = zeroCnt + containCnt;
    int minCnt = containCnt;

    int[] answer = {rank[maxCnt],rank[minCnt]};
    return answer;
  }


  public static void main(String[] args) {

    int[] lottos1 = {44, 1, 0, 0, 31, 25};
    int[] winNums1 = {31, 10, 45, 1, 6, 19};

    System.out.println(Arrays.toString(solution(lottos1,winNums1)));

    int[] lottos2 = {0, 0, 0, 0, 0, 0};
    int[] winNums2 = {38, 19, 20, 40, 15, 25};

    System.out.println(Arrays.toString(solution(lottos2,winNums2)));


    int[] lottos3 = {45, 4, 35, 20, 3, 9};
    int[] winNums3 = {20, 9, 3, 45, 4, 35};
    System.out.println(Arrays.toString(solution(lottos3,winNums3)));


  }
}
