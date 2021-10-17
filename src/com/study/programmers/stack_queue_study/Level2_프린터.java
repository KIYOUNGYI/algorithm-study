package com.study.programmers.stack_queue_study;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42587/solution_groups?language=java
 */
public class Level2_프린터 {

  // location 에 위치한 종이 몇 번 째 출력 했다.
  public static int solution(int[] priorities, int location) {

    int len = priorities.length;

    Queue<Node> q = new LinkedList<>();

    for (int i = 0; i < len; i++) {
      q.add(new Node(i, priorities[i]));
    }

    int idx = 0;

    while (!q.isEmpty()) {

      Node peek = q.peek();

      int pTemp = peek.getPriority();
      int pIdx = peek.getIdx();

      boolean flag = true;

      //우선순위 높은 것이 있으면 빼고 뒤에 넣는다.
      for (Node node : q) {
        if (node.getPriority() > pTemp) {
          flag = false;
          q.poll();
          q.add(peek);
          break;
        }
      }

      //정상 케이스면 poll 하고 센다.
      if (flag) {


        idx += 1;//몇 번째 출력
        q.poll();

        //location 종이 만약 출력되면 종료,
        if (pIdx == location) {
          break;
        }
      }

    }
    //그때 출력된 위치
    return idx;
  }

  public static void main(String[] args) {

//    int[] priorities1 = {2, 1, 3, 2};
//    int location1 = 2;
//
//    System.out.println(solution(priorities1, location1));

    int[] priorities2 = {1, 1, 9, 1, 1, 1};
    int location2 = 0;
    System.out.println(solution(priorities2, location2));
  }


  static class Node {

    private int idx;
    private int priority;

    public Node(int idx, int priority) {
      this.idx = idx;
      this.priority = priority;
    }

    public int getIdx() {
      return idx;
    }

    public int getPriority() {
      return priority;
    }

    @Override
    public String toString() {
      return "Node{" +
          "idx=" + idx +
          ", priority=" + priority +
          '}';
    }
  }
}
