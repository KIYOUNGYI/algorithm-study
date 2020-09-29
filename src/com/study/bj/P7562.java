package com.study.bj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * bfs로 푸는게 정신건강에 좋아보임 나이트의 이동 https://www.acmicpc.net/problem/7562 쉬운 난이도
 */
public class P7562 {

  static int tc;
  static int len;
  static int stx, sty, edx, edy;
  static boolean[][] visit;
  static int[][] score;
  static int[] dx = {-2, -1, -2, -1, 1, 2, 1, 2};
  static int[] dy = {-1, -2, 1, 2, -2, -1, 2, 1};

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    tc = scan.nextInt();
    for (int z = 0; z < tc; z++) {
      len = scan.nextInt();
      score = new int[len][len];
      visit = new boolean[len][len];
      stx = scan.nextInt();
      sty = scan.nextInt();
      scan.nextLine();
      edx = scan.nextInt();
      edy = scan.nextInt();
      NPoint pt = new NPoint(stx, sty);
      bfs(pt);
      System.out.println(score[edx][edy]);
    }
  }

  public static void bfs(NPoint pt) {
    if (pt.x == edx && pt.y == edy) {
      return;
    }

    Queue<NPoint> q = new LinkedList<>();
    q.add(pt);
    visit[pt.x][pt.y] = true;
    score[pt.x][pt.y] = 0;

    while (!q.isEmpty()) {
      NPoint cur = q.poll();
      int ptx = cur.x;
      int pty = cur.y;
      int curScore = score[ptx][pty];
      for (int i = 0; i < 8; i++) {
        int cx = ptx + dx[i];
        int cy = pty + dy[i];
        if (cx >= 0 && cx < len && cy >= 0 && cy < len) {
          if (visit[cx][cy] == false && score[cx][cy] == 0) {
            score[cx][cy] = curScore + 1;
            visit[cx][cy] = true;
            q.add(new NPoint(cx, cy));
            if (cx == edx && cy == edy) {
              return;
            }
          }
        }
      }
    }
  }
}

class NPoint {

  int x;
  int y;

  public NPoint(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return "NPoint{" +
        "x=" + x +
        ", y=" + y +
        '}';
  }
}
