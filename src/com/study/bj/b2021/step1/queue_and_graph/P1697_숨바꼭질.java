package com.study.bj.b2021.step1.queue_and_graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1697_숨바꼭질 {

  static final int size = 100_001;
  static int subin;
  static int bro;
  static int[] arr;
  static int[] score;
  static boolean[] visit;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    subin = scan.nextInt();
    bro = scan.nextInt();
    arr = new int[size];
    score = new int[size];
    visit = new boolean[size];

    bfs(subin);
//    for (int i = 0; i < 20; i++) {
//      System.out.println(i + " " + score[i]);
//    }
  }

  private static void bfs(int x) {

    visit[x] = true;
    Queue<Integer> q = new LinkedList<>();
    q.add(x);

    while (!q.isEmpty()) {

      int now = q.poll();
      if (now == bro) {
        System.out.println(score[bro]);
        return;
      }
      int t1 = now + 1;
      int t2 = now - 1;
      int t3 = now * 2;

      if (t1 < size && !visit[t1] && score[t1] == 0) {
        visit[t1] = true;
        score[t1] = score[now] + 1;
        q.add(t1);
      }
      if (t2 >= 0 && !visit[t2] && score[t2] == 0) {
        visit[t2] = true;
        score[t2] = score[now] + 1;
        q.add(t2);
      }
      if (t3 < size && !visit[t3] && score[t3] == 0) {
        visit[t3] = true;
        score[t3] = score[now] + 1;
        q.add(t3);
      }

    }

  }

}
