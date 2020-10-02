package com.study.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 우선순위 큐를 사용하라네...
 *
 */
public class P13549 {

  static final int limit = 100_001;
  static int n, k;
  static int[] score = new int[limit];
  static boolean[] visit = new boolean[limit];
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static Queue<Integer> q = new LinkedList<>();

  public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(System.in);
    String[] temp = br.readLine().split(" ");
    n = Integer.parseInt(temp[0]);
    k = Integer.parseInt(temp[1]);
    bfs(n);
    scan.close();
  }

  public static void bfs(int x) throws IOException {
    q.add(x);
    visit[x] = true;
    score[x] = 0;
    while (!q.isEmpty()) {
      int t = q.poll();
//      System.out.println(t);
      int s = score[t];
      if (t == k) {
        System.out.println(score[k]);
        return;
      }
      if (t * 2 <= 100_000 && visit[t * 2] == false) {
        visit[t * 2] = true;
        score[t * 2] = s;
        q.add(t * 2);
      }
      if (t - 1 >= 0 && visit[t - 1] == false) {
        visit[t - 1] = true;
        score[t - 1] = s + 1;
        q.add(t - 1);

      }
      if (t + 1 <= 100_000 && visit[t + 1] == false) {
        visit[t + 1] = true;
        score[t + 1] = s + 1;
        q.add(t + 1);

      }

    }
  }

}
