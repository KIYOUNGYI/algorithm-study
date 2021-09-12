package com.study.bj.b2021.step1.dynamic_programming.part1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1463_1로_만들기 {

  static int n;
  static Scanner scan = new Scanner(System.in);
  static int[] score;
  static boolean[] visit;

  public static void main(String[] args) {

    n = scan.nextInt();
    score = new int[n + 1];
    visit = new boolean[n + 1];

    bfs(n);

  }

  private static void bfs(int node) {

    Queue<Integer> q = new LinkedList<>();
    visit[node] = true;
    score[node] = 0;
    q.add(node);

    while (!q.isEmpty()) {

      int t = q.poll();
//      System.out.println("t : "+t);
      if (t == 1) {
        System.out.println(score[1]);
        return;
      }

      int backupScore = score[t];

      if (t % 3 == 0) {
        if (!visit[t / 3]) {
          visit[t / 3] = true;
          score[t / 3] = backupScore + 1;
          q.add(t / 3);
        }
      }
      if (t % 2 == 0) {
        if (!visit[t / 2]) {
          visit[t / 2] = true;
          score[t / 2] = backupScore + 1;
          q.add(t / 2);
        }
      }
      int temp = t - 1;
      if (!visit[temp]) {
        visit[temp] = true;
        score[temp] = backupScore + 1;
        q.add(temp);
      }

    }

  }


}
