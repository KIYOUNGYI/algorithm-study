package com.study.bj.b2021.step1.queue_and_graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P14426_이모티콘_v4_답_수정 {

  static final int SIZE = 2001;
  static int[][] score = new int[SIZE][SIZE];
  static int input;

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    input = sc.nextInt();

    for (int i = 0; i <= input; i++) {
      Arrays.fill(score[i], -1);
    }
    Queue<Point> q = new LinkedList();

    q.add(new Point(1, 0));
    score[1][0] = 0;
    while (!q.isEmpty()) {
      Point pt = q.poll();
      int s = pt.ps;
      int c = pt.pc;
      if (score[s][s] == -1) {
        score[s][s] = score[s][c] + 1;
        q.add(new Point(s, s));
      }
      if (s + c <= input && score[s + c][c] == -1) {
        score[s + c][c] = score[s][c] + 1;
        q.add(new Point(s + c, c));
      }
      if (s - 1 >= 0 && score[s - 1][c] == -1) {
        score[s - 1][c] = score[s][c] + 1;
        q.add(new Point(s - 1, c));
      }
    }
    int ans = -1;
    for (int i = 0; i <= input; i++) {
      if (score[input][i] != -1) {
        System.out.println("d[" + input + "][" + i + "]:" + score[input][i]);
        if (ans == -1 || ans > score[input][i]) {
          ans = score[input][i];
        }
      }
    }
    System.out.println(ans);
  }

  static class Point {

    int ps;
    int pc;

    public Point(int ps, int pc) {
      this.ps = ps;
      this.pc = pc;
    }

    @Override
    public String toString() {
      return "Point{" +
          "ps=" + ps +
          ", pc=" + pc +
          '}';
    }
  }

}
