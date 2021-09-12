package com.study.bj.b2021.step1.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1697_숨바꼭질 {

  static final int MAX = 100_001;
  static int subin;
  static int littleBro;

  static int[] score = new int[MAX];
  static boolean[] visit = new boolean[MAX];

  static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {

    input();

    if (subin > littleBro) {
      System.out.println(subin - littleBro);
      scan.close();
    } else {
      bfs(subin);
      printAnswer();
    }

    scan.close();
  }

  private static void input() {
    subin = scan.nextInt();
    littleBro = scan.nextInt();
  }

  private static void printAnswer() {
    System.out.println(score[littleBro]);
  }

  private static void bfs(int point) {

    Queue<Integer> q = new LinkedList<>();
    visit[point] = true;

    q.add(point);

    while (!q.isEmpty()) {

      Integer poll = q.poll();
      int pollScore = score[poll];

      if (poll == littleBro) {
        return;
      }

      int a = poll - 1;
      int b = poll + 1;
      int c = poll * 2;

      if (a >= 0 && a < MAX && !visit[a]) {
        visit[a] = true;
        q.add(a);
        score[a] = pollScore + 1;
      }
      if (b >= 0 && b < MAX && !visit[b]) {
        visit[b] = true;
        q.add(b);
        score[b] = pollScore + 1;
      }
      if (c >= 0 && c < MAX && !visit[c]) {
        visit[c] = true;
        q.add(c);
        score[c] = pollScore + 1;
      }

    }


  }

}
