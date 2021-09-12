package com.study.bj.b2021.step1.queue_and_graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class P13549_숨바꼭질_3_v2_무식한_방법 {


  static final int MAX = 100_001;
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
    bfs(subin, 1);
    calculate();

    init();
    bfs(subin, 2);
    calculate();

    init();
    bfs(subin, 3);
    calculate();

    init();
    bfs(subin, 4);
    calculate();

    init();
    bfs(subin, 5);
    calculate();

    init();
    bfs(subin, 6);
    calculate();

    System.out.println(min);
  }

  private static void calculate() {

    List<Integer> arrList = new ArrayList<>();
    arrList.add(bro);

    int t = parent[bro];
    while (t != -1) {
      arrList.add(t);
      t = parent[t];
    }

    for (int i = arrList.size() - 1; i >= 0; i--) {
      System.out.print(arrList.get(i)+" ");
    }
    System.out.println();

    int cnt = 0;
    for (int i = arrList.size() - 1; i >= 1; i--) {
      int t1 = arrList.get(i);
      int t2 = arrList.get(i - 1);
      if (t1 * 2 != t2) {
        cnt += 1;
      }
    }
    if (cnt < min) {
      min = cnt;
    }

  }

  private static void bfs(int x, int type) {

    visit[x] = true;
    Queue<Integer> q = new LinkedList<>();
    q.add(x);
    parent[x] = -1;

    while (!q.isEmpty()) {

      int now = q.poll();
      if (now == bro) {
        return;
      }
      int t1 = now + 1;
      int t2 = now - 1;
      int t3 = now * 2;
      if (type == 1) {
        common(q, now, t1, t2, t3);
      }
      if (type == 2) {
        common(q, now, t1, t3, t2);
      }
      if (type == 3) {
        common(q, now, t2, t1, t3);
      }
      if (type == 4) {
        common(q, now, t2, t3, t1);
      }
      if (type == 5) {
        common(q, now, t3, t1, t2);
      }
      if (type == 6) {
        common(q, now, t3, t2, t1);
      }

    }

  }

  private static void common(Queue<Integer> q, int now, int t1, int t2, int t3) {

    if (t1 >= 0 && t1 < MAX && !visit[t1] && score[t1] == 0) {
      visit[t1] = true;
      score[t1] = score[now] + 1;
      parent[t1] = now;
      q.add(t1);
    }
    if (t2 >= 0 && t2 < MAX && !visit[t2] && score[t2] == 0) {
      visit[t2] = true;
      score[t2] = score[now] + 1;
      parent[t2] = now;
      q.add(t2);
    }
    if (t3 >= 0 && t3 < MAX && !visit[t3] && score[t3] == 0) {
      visit[t3] = true;
      score[t3] = score[now] + 1;
      parent[t3] = now;
      q.add(t3);
    }
  }

}
