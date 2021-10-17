package com.study.programmers.heap_study;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42628/solution_groups?language=java&type=all
 */
public class 이중우선순위큐 {


  public static int[] solution(String[] operations) {

    PriorityQueue<Integer> minQueue = new PriorityQueue<>();//최소값 먼저 날라감
    PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());

    for (String operation : operations) {

      String[] temp = operation.split(" ");

      if (temp[0].equals("I")) {

        minQueue.add(Integer.parseInt(temp[1]));
        maxQueue.add(Integer.parseInt(temp[1]));

      } else {

        if (operation.equals("D 1")) {//최대값 삭제

          if (!maxQueue.isEmpty() && !minQueue.isEmpty()) {
            int t = maxQueue.remove();
            minQueue.remove(t);
          }

        } else if (operation.equals("D -1")) {//최소값 삭제

          if (!maxQueue.isEmpty() && !minQueue.isEmpty()) {
            int t = minQueue.remove();
            maxQueue.remove(t);
          }
        }
      }

    }

//    System.out.println("min:" + minQueue.toString());
//    System.out.println("max:" + maxQueue.toString());

    if (minQueue.isEmpty() && maxQueue.isEmpty()) {
      return new int[]{0, 0};
    }

    Integer max = maxQueue.peek() != null ? maxQueue.peek() : 0;
    Integer min = minQueue.peek() != null ? minQueue.peek() : 0;

    return new int[]{max, min};
  }

  public static void main(String[] args) {

    String[] operations1 = {"I 16", "D 1"};

    String[] operations2 = {"I 7", "I 5", "I -5", "D -1"};

//    System.out.println(Arrays.toString(solution(operations1)));
//
//    System.out.println(Arrays.toString(solution(operations2)));

    String[] operations3 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
    System.out.println(Arrays.toString(solution(operations3)));
  }

}
