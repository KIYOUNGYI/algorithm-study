package com.study.bj.b2021.step1.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class P13549_숨바꼭질3 {


  static Scanner scan = new Scanner(System.in);
  static final int MAX = 100_001;
  static int subin;
  static int littleBro;

  static int[] score = new int[MAX];
  static int[] parent = new int[MAX];
  static int minPath = Integer.MAX_VALUE;

  public static void main(String[] args) {

    input();

    if (subin > littleBro) {
      extraOrdinaryCase();
      return;
    } else {
      bfs(subin, 1);
      calculateMinPath();

      initArr();
      bfs(subin, 2);
      calculateMinPath();

      initArr();
      bfs(subin, 3);
      calculateMinPath();

      initArr();
      bfs(subin, 4);
      calculateMinPath();

      initArr();
      bfs(subin, 5);
      calculateMinPath();

      initArr();
      bfs(subin, 6);
      calculateMinPath();

      System.out.println(minPath);
    }

    scan.close();

  }

  private static void initArr() {
    score = new int[MAX];
    parent = new int[MAX];
  }

  private static void extraOrdinaryCase() {
    System.out.println(subin - littleBro);
    scan.close();
  }


  private static void input() {
    subin = scan.nextInt();
    littleBro = scan.nextInt();
  }


  private static void calculateMinPath() {
    List<Integer> arrList = new ArrayList<Integer>();

    arrList.add(littleBro);
    int s = littleBro;

    while (s != subin) {
      int t = parent[s];//parent[16] = 8; parent[8] = 4;

      arrList.add(t);
      s = t;//s = 8;
    }
//    System.out.println(arrList.toString());

    int len = arrList.size() - 1;
    int cnt = 0;
    for (int i = len; i >= 1; i--) {

      int t1 = (arrList.get(i)) * 2;
      int t2 = arrList.get(i - 1);
      if (t1 == t2) {
        cnt += 1;
      }
    }
//System.out.println(score[littleBro]);
    int candidate = score[littleBro] - cnt;
//    System.out.println("candidagte:"+candidate);
    if (candidate < minPath) {
      minPath = candidate;
    }

  }


  private static void bfs(int point, int type) {

    Queue<Integer> q = new LinkedList<>();

    q.add(point);
    parent[point] = 0;

    while (!q.isEmpty()) {

      Integer poll = q.poll();

      if (poll == littleBro) {
        return;
      }

      int pollScore = score[poll];

      int a = poll - 1;
      int b = poll + 1;
      int c = poll * 2;
      if (type == 1) {
        commonMethod(q, poll, pollScore, a, b, c);
      } else if (type == 2) {
        commonMethod(q, poll, pollScore, a, c, b);
      } else if (type == 3) {
        commonMethod(q, poll, pollScore, b, a, c);
      } else if (type == 4) {
        commonMethod(q, poll, pollScore, b, c, a);
      } else if (type == 5) {
        commonMethod(q, poll, pollScore, c, a, b);
      } else if (type == 6) {
        commonMethod(q, poll, pollScore, c, b, a);
      }
    }
  }

  private static void commonMethod(Queue<Integer> q, Integer poll, int pollScore, int a, int b, int c) {
    if (a >= 0 && a < MAX && score[a] == 0) {
      q.add(a);
      score[a] = pollScore + 1;
      parent[a] = poll;
    }
    if (b >= 0 && b < MAX && score[b] == 0) {
      q.add(b);
      score[b] = pollScore + 1;
      parent[b] = poll;
    }
    if (c >= 0 && c < MAX && score[c] == 0) {
      q.add(c);
      score[c] = pollScore + 1;
      parent[c] = poll;
    }
  }


}
