package com.study.bj.b2021.step1.queue_and_graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P14426_이모티콘_v2 {

  static final int SIZE = 2001;
  static int[][] score = new int[SIZE][SIZE];
  static boolean[][] v = new boolean[SIZE][SIZE];
  static int input;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    input = scan.nextInt();

    bfs(1, 0);

  }

  public static void bfs(int tempS, int tempC) {

    Queue<Point> q = new LinkedList<>();
    q.add(new Point(tempS, tempC));
    score[tempS][tempC] = 0;//이미 입력했다.

    while (!q.isEmpty()) {
      Point poll = q.poll();
      int ps = poll.s;
      int pc = poll.c;

      if (v[ps][ps] == false) {
        score[ps][ps] = score[ps][pc] + 1;
        v[ps][ps] = true;
        q.add(new Point(ps, ps));
      }
      if ((ps + pc < SIZE) && v[ps + pc][pc] == false) {
        score[ps + pc][pc] = score[ps][pc] + 1;
        v[ps + pc][pc] = true;
        q.add(new Point(ps + pc, pc));
      }
      if (ps - 1 >= 0 && v[ps - 1][pc] == false) {
        score[ps - 1][pc] = score[ps][pc] + 1;
        v[ps - 1][pc] = true;
        q.add(new Point(ps - 1, pc));
      }
    }

    int ans = Integer.MAX_VALUE;
    for (int i = 0; i <= input; i++) {
      if (score[input][i] != 0) {
        ans = Math.min(ans, score[input][i]);
      }
    }
    System.out.println(ans);
  }


  static class Point {

    int s;
    int c;

    public Point(int s, int c) {
      this.s = s;
      this.c = c;
    }

    @Override
    public String toString() {
      return "Point{" +
          "s=" + s +
          ", c=" + c +
          '}';
    }
  }
}
