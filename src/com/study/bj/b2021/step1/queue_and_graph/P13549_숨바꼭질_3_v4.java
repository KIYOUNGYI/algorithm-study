package com.study.bj.b2021.step1.queue_and_graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P13549_숨바꼭질_3_v4 {

  public static final int MAX = 1_000_000;
  static int subin;
  static int bro;
  static boolean[] visit = new boolean[MAX];
  static int[] score = new int[MAX];
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    subin = sc.nextInt();
    bro = sc.nextInt();
    score = new int[MAX];

    bfs();

    System.out.println(score[bro]);
  }

  private static void bfs() {


    Queue<Integer> q = new LinkedList<Integer>();
    Queue<Integer> nextQueue = new LinkedList<Integer>();

    visit[subin] = true;
    score[subin] = 0;
    q.add(subin);

    while (!q.isEmpty()) {

      int now = q.poll();

      for (int next : new int[]{now * 2, now - 1, now + 1}) {

        if (next >= 0 && next < MAX) {
          if (visit[next] == false) {
            visit[next] = true;
            if (now * 2 == next) {
              q.add(next);
              score[next] = score[now];
            } else {
              nextQueue.add(next);
              score[next] = score[now] + 1;
            }
          }
        }
      }
      if (q.isEmpty()) {
        q = nextQueue;
        nextQueue = new LinkedList<Integer>();
      }
    }
  }
}
