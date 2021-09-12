package com.study.bj.b2021.step1.queue_and_graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P13549_숨바꼭질_3_v3 {


  static final int MAX = 1000000;
  static int subin;
  static int bro;
  static int[] arr;
  static int[] score;
  static boolean[] visit;
  static int[] parent;
  static int min = Integer.MAX_VALUE;

  public static void init() {
    arr = new int[MAX];
    score = new int[MAX];
    parent = new int[MAX];
    visit = new boolean[MAX];
  }

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    subin = scan.nextInt();
    bro = scan.nextInt();
    init();
    bfs();

    System.out.println(score[bro]);
  }

  private static void bfs() {

    Queue<Integer> q = new LinkedList<>();
    Queue<Integer> nextQ = new LinkedList<>();

    q.add(subin);
    visit[subin] = true;
    score[subin] = 0;

    while (!q.isEmpty()) {

      int now = q.poll();

      int t1 = now + 1;
      int t2 = now - 1;
      int t3 = now * 2;

      if (t3 >= 0 && t3 < MAX && !visit[t3]) {
        visit[t3] = true;
        score[t3] = score[now];
        q.add(t3);
      } else {
        if (t1 >= 0 && t1 < MAX && !visit[t1]) {
          visit[t1] = true;
          score[t1] = score[now] + 1;
          nextQ.add(t1);
        }

        if (t2 >= 0 && t2 < MAX && !visit[t2]) {
          visit[t2] = true;
          score[t2] = score[now] + 1;
          nextQ.add(t2);
        }
      }

      if (q.isEmpty()) {
        q = nextQ;
        nextQ = new LinkedList<>();
      }
    }

  }

}
