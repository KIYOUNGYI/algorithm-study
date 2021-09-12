package com.study.bj.b2021.step1.queue_and_graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class P13913_숨바꼭질_4 {

  static final int size = 100_001;
  static int subin;
  static int bro;
  static int[] arr;
  static int[] score;
  static boolean[] visit;
  static int[] parent;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    subin = scan.nextInt();
    bro = scan.nextInt();
    arr = new int[size];
    score = new int[size];
    parent = new int[size];
    visit = new boolean[size];

    bfs(subin);

    printRoute();


  }

  private static void printRoute() {


    List<Integer> arrList = new ArrayList<>();
    arrList.add(bro);

    int t = parent[bro];
    while (t != -1) {
      arrList.add(t);
      t = parent[t];
    }

    for (int i = arrList.size() - 1; i >= 0; i--) {
      System.out.print(arrList.get(i) + " ");
    }

  }

  private static void bfs(int x) {

    visit[x] = true;
    Queue<Integer> q = new LinkedList<>();
    q.add(x);
    parent[x] = -1;

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
        parent[t1] = now;
        q.add(t1);
      }
      if (t2 >= 0 && !visit[t2] && score[t2] == 0) {
        visit[t2] = true;
        score[t2] = score[now] + 1;
        parent[t2] = now;
        q.add(t2);
      }
      if (t3 < size && !visit[t3] && score[t3] == 0) {
        visit[t3] = true;
        score[t3] = score[now] + 1;
        parent[t3] = now;
        q.add(t3);
      }

    }

  }
}
