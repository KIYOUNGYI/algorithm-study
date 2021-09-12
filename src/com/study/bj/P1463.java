package com.study.bj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 1로 만들기
 * https://www.acmicpc.net/problem/1463
 * bfs
 */
public class P1463 {

  static final int limit = 1000020;
  static int[] score = new int[limit];
  static boolean[] visit = new boolean[limit];

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    bfs(N);
  }

  public static void bfs(int pivot) {
    visit[pivot] = true;
    score[pivot] = 0;
    Queue<Integer> q = new LinkedList<>();
    q.add(pivot);

    while (!q.isEmpty()) {
      int temp = q.poll();
      if (temp == 1) {
        System.out.println(score[temp]);
        return;
      }

      if (temp % 3 == 0 && !visit[temp / 3]) {
        q.add(temp / 3);
        visit[temp / 3] = true;
        score[temp / 3] = score[temp] + 1;
      }
      if (temp % 2 == 0 && !visit[temp / 2]) {
        q.add(temp / 2);
        visit[temp / 2] = true;
        score[temp / 2] = score[temp] + 1;
      }
      if (temp - 1 >= 0 && !visit[temp - 1]) {
        q.add(temp - 1);
        visit[temp - 1] = true;
        score[temp - 1] = score[temp] + 1;
      }
    }
  }
}
