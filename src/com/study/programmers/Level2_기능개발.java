package com.study.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Level2_기능개발 {

  public static int[] solutionBad2(int[] progresses, int[] speeds) {

    List<Integer> arrList = new ArrayList<>();

    int len = progresses.length;

    int[] rank = new int[len];

    setRank(progresses, speeds, len, rank);
//    System.out.println(Arrays.toString(rank));

    Stack<Integer> stack = new Stack<>();

    stack.push(rank[0]);

    for (int i = 1; i < len; i++) {

      if (stack.peek() < rank[i]) {
        int size = stack.size();
        arrList.add(size);
        while (!stack.isEmpty()) {
          stack.pop();
        }
      }
      stack.push(rank[i]);
    }

    arrList.add(stack.size());

    int[] answer = arrListToarray(arrList);
//    System.out.println("->" + Arrays.toString(answer));
    return answer;
  }

  private static int[] arrListToarray(List<Integer> arrList) {
    int[] answer = new int[arrList.size()];
    for (int i = 0; i < answer.length; i++) {
      answer[i] = arrList.get(i);
    }
    return answer;
  }


  private static void setRank(int[] progresses, int[] speeds, int len, int[] rank) {

    int idx = 1;

    boolean flag;

    int loopCnt = 0;
    while (loopCnt < 100) {

      flag = false;

      for (int i = 0; i < len; i++) {

        if (progresses[i] != -1) {
          progresses[i] = progresses[i] + speeds[i];
        }
      }

//      System.out.println(Arrays.toString(progresses));

      for (int i = 0; i < len; i++) {
        if (progresses[i] >= 100) {
          flag = true;
          rank[i] = idx;
          progresses[i] = -1;
        }
      }

      if (flag) {
        idx += 1;
      }
      loopCnt += 1;

    }
  }

  public static void main(String[] args) {

    int[] progress1 = {93, 30, 55};
    int[] speed1 = {1, 30, 5};
    System.out.println(Arrays.toString(solutionBad2(progress1, speed1)));

    int[] progress2 = {95, 90, 99, 99, 80, 99};
    int[] speed2 = {1, 1, 1, 1, 1, 1};
    System.out.println(Arrays.toString(solutionBad2(progress2, speed2)));

    int[] progress3 = {10, 10, 10, 10, 10, 10};
    int[] speed3 = {2, 3, 3, 3, 3, 3};
    System.out.println(Arrays.toString(solutionBad2(progress3, speed3)));

  }

  public static int[] solutionBad(int[] progresses, int[] speeds) {

    int len = progresses.length;

    int[] rank = new int[len];

    setRank(progresses, speeds, len, rank);
//    System.out.println(Arrays.toString(rank));

    List<Integer> arrList = new ArrayList<>();
    int cnt = 1;
    int t1;
    int t2;

    for (int i = 0; i < len - 1; i++) {

      t1 = rank[i];
      t2 = rank[i + 1];

      if (t1 < t2) {
        arrList.add(cnt);
        cnt = 1;
      } else {
        cnt += 1;
      }
    }
    arrList.add(cnt);

//    System.out.println(arrList.toString());

    int[] answer = new int[arrList.size()];

    for (int i = 0; i < answer.length; i++) {
      answer[i] = arrList.get(i);
    }

    return answer;
  }

}
