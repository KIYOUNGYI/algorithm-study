package com.study.bj.b2021.step1.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class P13913_숨바꼭질4 {

  static Scanner scan = new Scanner(System.in);
  static final int MAX = 100_001;
  static int subin;
  static int littleBro;

  static int[] score = new int[MAX];
  static int[] parent = new int[MAX];

  public static void main(String[] args) {

    input();

    if (subin > littleBro) {
      extraOrdinaryCase();
      return;
    } else {
      bfs(subin);
      printAnswer();
    }

    scan.close();

  }

  private static void extraOrdinaryCase() {
    System.out.println(subin - littleBro);
    for (int i = subin; i >= littleBro; i--) {
      System.out.print(i + " ");
    }
    scan.close();
  }


  private static void input() {
    subin = scan.nextInt();
    littleBro = scan.nextInt();
  }

  private static void printAnswer() {
    System.out.println(score[littleBro]);
    printAncestor();
  }

  private static void printAncestor() {
    List arrList = new ArrayList<Integer>();

    arrList.add(littleBro);
    int s = littleBro;

    while (s != subin) {
      int t = parent[s];//parent[16] = 8; parent[8] = 4;

      arrList.add(t);
      s = t;//s = 8;
    }

    int size = arrList.size();
    for (int i = size - 1; i >= 0; i--) {
      System.out.print(arrList.get(i) + " ");
    }
    System.out.println();
//    System.out.println(arrList.toString());
  }

  private static void printParent() {
//    System.out.println(Arrays.asList(parent));

    for (int i = 0; i < 100; i++) {
      System.out.println(i + " " + parent[i] + " ");
    }
    System.out.println();
  }

  private static void bfs(int point) {

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
}