package com.study.programmers.interpark;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution1 {

  /**
   * [자료구조]
   * <p>
   * 1] 우선순위 큐 - 학생의 인덱스와 점수를 저장한 자료구조를 저장 (제거 순은 점수가 높은 순) 2] 맵 -  점수별로 동점자수가 몇 명인지 저장
   * <p>
   * [로직] (자료구조 구성) 1] input 을 바탕으로 scoreQueue 와 scoreCountMap 을 구성
   * <p>
   * (result 배열 구성) 2] queue 가 empty 될때까지 poll 수행 2-1] peek 한 것의 score 를 참조해서 map 에서 동점자 수를 가지고 온다. 2-2] 가지오 온 동점자 수 만큼 poll 하고 등수를 반영한다.
   */
  public static int[] solution(int[] grade) {

    // data set
    int[] result = new int[grade.length];

    PriorityQueue<Node> scoreQueue = new PriorityQueue<>(new ScoreCompare());
    Map<Integer, Integer> scoreCountMap = new HashMap<>();

    for (int i = 0; i < grade.length; i++) {

      scoreQueue.add(new Node(i, grade[i]));

      if (scoreCountMap.containsKey(grade[i])) {

        int t = scoreCountMap.get(grade[i]);
        scoreCountMap.put(grade[i], t + 1);

      } else {
        scoreCountMap.put(grade[i], 1);
      }
    }

    //score set

    int before = 0;
    while (!scoreQueue.isEmpty()) {

      Node peek = scoreQueue.peek();
      int score = peek.getScore();

      int cnt = scoreCountMap.get(score);

      for (int i = 0; i < cnt; i++) {
        Node temp = scoreQueue.poll();
        int idx = temp.getIdx();
        result[idx] = before + 1;
      }
      before = before + cnt;
    }

//    System.out.println(Arrays.toString(result));

    return result;
  }

  public static void main(String[] args) {

    int[] t1 = {2, 2, 1};
    System.out.println(Arrays.toString(solution(t1)));

    int[] t2 = {3, 2, 1, 2};
    System.out.println(Arrays.toString(solution(t2)));

//    PriorityQueue<Node> q = new PriorityQueue<>(new ScoreCompare());
//    q.add(new Node(0, 3));
//    q.add(new Node(1, 2));
//    q.add(new Node(2, 1));
//    q.add(new Node(3, 2));
//
//    Node peek = q.poll();
//    System.out.println("poll 1 " + peek);
//
//    Node poll = q.poll();
//    System.out.println("poll 2 = " + poll);
//
//    Node poll1 = q.poll();
//    System.out.println("poll 3 = " + poll1);
//
//    System.out.println(q.toString());
  }

  static class Node {

    int idx;
    int score;

    public int getIdx() {
      return idx;
    }

    public int getScore() {
      return score;
    }

    public Node(int idx, int score) {
      this.idx = idx;
      this.score = score;
    }

    @Override
    public String toString() {
      return "Node{" +
          "idx=" + idx +
          ", score=" + score +
          '}';
    }
  }

  static class ScoreCompare implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {

      if (o1.getScore() > o2.getScore()) {
        return -1;
      } else {
        return +1;
      }
    }
  }
}
