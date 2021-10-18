package com.study.programmers.stack_queue_study;

import java.util.LinkedList;
import java.util.Queue;

public class Level2_다리를_지나는_트럭 {

  public static int solution(int bridgeLength, int weight, int[] truckWeights) {

    Queue<Integer> q = new LinkedList<>();

    for (int i = 0; i < truckWeights.length; i++) {
      q.add(truckWeights[i]);
    }

    int[] bridgeArr = new int[bridgeLength];

    int sec;

    for (sec = 1; ; sec++) {

      shiftBridge(bridgeArr);

      if (!q.isEmpty() && bridgeSum(bridgeArr) + q.peek() <= weight) {

        int poll = q.poll();

        bridgeArr[bridgeArr.length - 1] = poll;

      }

//      System.out.println("--------------------");
//      System.out.println("sec -> "+sec);
//      System.out.println("bridge -> "+ Arrays.toString(bridgeArr));
//      System.out.println("q -> " + q.toString());
//      System.out.println("--------------------+\n");

      if (q.isEmpty() && bridgeSum(bridgeArr) == 0) {
        break;
      }
    }

    return sec;
  }


  /**
   * 복잡도 터지면 튜닝 대상 로직
   */
  private static int bridgeSum(int[] bridgeArr) {
    int sum = 0;
    for (int i = 0; i < bridgeArr.length; i++) {
      sum += bridgeArr[i];
    }
    return sum;
  }

  private static void shiftBridge(int[] bridgeArr) {

    for (int i = 0; i < bridgeArr.length - 1; i++) {
      bridgeArr[i] = bridgeArr[i + 1];
    }
    bridgeArr[bridgeArr.length - 1] = 0;

  }


  public static void main(String[] args) {

    int bridgeWeight1 = 2;
    int weight1 = 10;
    int[] truckWeights1 = {7, 4, 5, 6};

    System.out.println(solution(bridgeWeight1, weight1, truckWeights1));

    int bridgeWeight2 = 100;
    int weight2 = 100;
    int[] truckWeights2 = {10};

    System.out.println(solution(bridgeWeight2, weight2, truckWeights2));

    int bridgeWeight3 = 100;
    int weight3 = 100;
    int[] truckWeights3 = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

    System.out.println(solution(bridgeWeight3, weight3, truckWeights3));
  }
}
