package com.study.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Level2_배달 {

  static List<Integer>[] destMap;
  static List<Integer>[] weightMap;
  static int[] scoreList;
  static int villageCnt;

  public static int solution(int N, int[][] road, int K) {

    villageCnt = N;
    destMap = new ArrayList[villageCnt + 1];
    weightMap = new ArrayList[villageCnt + 1];
    scoreList = new int[villageCnt + 1];

    for (int i = 0; i <= villageCnt; i++) {
      destMap[i] = new ArrayList();
      weightMap[i] = new ArrayList();
    }

    for (int i = 0; i < road.length; i++) {
      int s = road[i][0];
      int e = road[i][1];
      int w = road[i][2];

      destMap[s].add(e);
      destMap[e].add(s);

      weightMap[s].add(w);
      weightMap[e].add(w);

    }

//    printDestMap();
//    System.out.println("----");
//    printWeightMap();

    bfs();
//    System.out.println("----");
//    printScore();
    return getAnswer(K);
  }


  private static void bfs() {

    Queue<Integer> q = new LinkedList<>();
    q.add(1);

    while (!q.isEmpty()) {

      int poll = q.poll();
      int nowVal = scoreList[poll];

      List<Integer> destinations = destMap[poll];
      List<Integer> weights = weightMap[poll];

      for (int i = 0; i < destinations.size(); i++) {

        int next = destinations.get(i);
        int nextVal = weights.get(i);
        int t1 = nowVal + nextVal;

        if (scoreList[next] == 0) {
          scoreList[next] = t1;
          q.add(next);
        } else {
          if (t1 < scoreList[next]) {
            scoreList[next] = t1;
            q.add(next);
          }
        }


      }


    }


  }

  private static int getAnswer(int k) {
    int cnt = 0;
    for (int i = 2; i <= villageCnt; i++) {
//      System.out.println("i = " + i + " " + scoreList[i]);
      if (scoreList[i] <= k) {
        cnt += 1;
      }
    }
    return cnt + 1;
  }

  private static void printScore() {
    for (int i = 2; i <= villageCnt; i++) {
      System.out.println("i = " + i + " " + scoreList[i]);
    }
  }

  private static void printDestMap() {

    for (int i = 1; i <= villageCnt; i++) {
      System.out.println("i = " + i + " " + destMap[i].toString());
    }
  }

  private static void printWeightMap() {
    for (int i = 1; i <= villageCnt; i++) {
      System.out.println("i = " + i + " " + weightMap[i].toString());
    }
  }

  public static void main(String[] args) {

    int N1 = 5;
    int[][] road1 = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
    int K1 = 3;
    System.out.println(solution(N1, road1, K1));
//
//    int N2 = 6;
//    int[][] road2 = {{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}};
//    int K2 = 4;
//    System.out.println(solution(N2, road2, K2));
  }
}
