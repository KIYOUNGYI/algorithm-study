package com.study.programmers.heap_study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class 디스크_컨트롤러 {

  static final int MAX = 1_001 * 1_001;
//  static final int MAX = 11 * 11;

  public static int solution(int[][] jobs) {


    List<Node> nodes = arrayToNodeList(jobs);
    Node[] nodesArr = new Node[MAX];

    for (int i = 0; i < nodes.size(); i++) {
      Node node = nodes.get(i);
      nodesArr[node.getTime()] = node;
    }

    PriorityQueue<Node> waitingQueue = new PriorityQueue<>(new WorkCompare());
    Queue<Node> workingQueue = new LinkedList<>();

    int sum = 0;

    for (int second = 0; second < MAX; second++) {

      if (!workingQueue.isEmpty()) {

        Node t = workingQueue.poll();
        t.decrease();

        if (!t.check()) {
          workingQueue.add(t);
        } else {

          t.setE(second);
          int v = t.calculate();
          sum += v;
        }
      }

      if (nodesArr[second] != null) {

        nodesArr[second].setS(second);

        waitingQueue.add(nodesArr[second]);
//        s1 = second;
//        System.out.println(" t 는 " + s1 + "초일때 요청이 들어왔다.");
      }

      if (workingQueue.isEmpty() && !waitingQueue.isEmpty()) {

        Node poll = waitingQueue.poll();

        workingQueue.add(poll);
      }
//
//      System.out.println("second : " + second);
//      System.out.println("watingQueue->" + waitingQueue.toString());
//      System.out.println("workingQueue->" + workingQueue.toString());
//      System.out.println("===============+\n");
//      if(workingQueue.isEmpty() && waitingQueue.is)

    }

    return sum / nodes.size();
  }

  public static List<Node> arrayToNodeList(int[][] jobs) {

    List<Node> list = new ArrayList<>();

    for (int[] job : jobs) {
      int time = job[0];
      int work = job[1];
      Node node = new Node(time, work);
      list.add(node);
    }

    Collections.sort(list, new TimeCompare());
//    System.out.println("->" + list.toString());
    return list;
  }


  public static void main(String[] args) {

    int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
    System.out.println(solution(jobs));
//    System.out.println(arrayToNodeList(jobs).toString());
  }


  static class Node {

    private int s;
    private int e;

    private int time;
    private int work;

    public void setS(int s) {
      this.s = s;
    }

    public void setE(int e) {
      this.e = e;
    }

    public int calculate() {
      return (this.e - this.s);
    }

    public Node(int time, int work) {
      this.time = time;
      this.work = work;
    }

    public int getTime() {
      return time;
    }

    public int getWork() {
      return work;
    }


    public void decrease() {
      this.work = this.work - 1;
    }

    public boolean check() {
      return this.work == 0;
    }

    @Override
    public String toString() {
      return "Node{" +
          "time=" + time +
          ", work=" + work +
          '}';
    }
  }

  static class TimeCompare implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
      if (o1.getTime() < o2.getTime()) {
        return -1;
      } else {
        return 1;
      }
    }
  }

  static class WorkCompare implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {

      if (o1.getWork() < o2.getWork()) {
        return -1;
      } else {
        return 1;
      }
    }
  }
}
