package com.study.bj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * DSLR https://www.acmicpc.net/problem/9019 bfs
 */
public class P9019 {

  /**
   * DSLR https://www.acmicpc.net/problem/9019 최소값을 구하는건 맞지만 과정도 기록해야 한다.
   * <p>
   * [1] v[i]=i 를 어떤 수에서 만들었는지 [2] w[i]=i 를 어떻게 만들었는지
   */
  private static final int LIMIT = 20040;
  private static String[] command = new String[LIMIT];
  private static int[] score = new int[LIMIT];
  private static boolean[] visit = new boolean[LIMIT];
  static String input1;
  static String input2;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    scan.nextLine();
    for (int i = 0; i < t; i++) {
      input1 = scan.next();
      input2 = scan.next();
      score[Integer.parseInt(input1)] = 0;
      bfs(input1);
      command = new String[LIMIT];
      visit = new boolean[LIMIT];
    }
  }

  private static void bfs(String input) {
    Queue<Integer> q = new LinkedList<>();
    q.add(Integer.parseInt(input));
    visit[Integer.parseInt(input)] = true;
    command[Integer.parseInt(input)] = "";
    while (!q.isEmpty()) {
      int t = q.poll();
      if (t == Integer.parseInt(input2)) {
        System.out.println(command[t]);
        return;
      }
      int c1 = t;
      c1 = (2 * c1) % 10000;
      if (!visit[c1]) {
        visit[c1] = true;
        command[c1] = command[t] + "D";
        q.add(c1);
      }
      int c2 = t;
      if (c2 == 0) {
        c2 = 9999;
      } else {
        c2 = c2 - 1;
      }
      if (!visit[c2]) {
        visit[c2] = true;
        command[c2] = command[t] + "S";
        q.add(c2);
      }

      int c3 = t;
      int d1, d2, d3, d4;
      d1 = t / 1000;//1
      d2 = (t % 1000) / 100;//2
      d3 = (t % 1000) % 100 / 10;//3
      d4 = (t % 1000) % 100 % 10;//4
      c3 = 1000 * d2 + 100 * d3 + 10 * d4 + 1 * d1;

      if (!visit[c3]) {
        visit[c3] = true;
        command[c3] = command[t] + "L";
        q.add(c3);
      }

      int c4 = t;
      c4 = 1000 * d4 + 100 * d1 + 10 * d2 + 1 * d3;

      if (!visit[c4]) {
        visit[c4] = true;
        command[c4] = command[t] + "R";
        q.add(c4);
      }
    }
  }


}
