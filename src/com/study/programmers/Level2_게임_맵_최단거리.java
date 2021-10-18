package com.study.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Level2_게임_맵_최단거리 {

  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};
  static int[][] score;
  static int sero, garo;
  static boolean[][] visit;

  public static int solution(int[][] input) {

    sero = input.length;
    garo = input[0].length;
    score = new int[sero][garo];
    visit = new boolean[sero][garo];

    int x = bfs(0, 0, input);

    return x;
  }

  private static int bfs(int x, int y, int[][] input) {

    Queue<Node> q = new LinkedList<>();
    q.add(new Node(x, y));
    score[x][y] = 1;
    visit[x][y] = true;

    while (!q.isEmpty()) {

      Node poll = q.poll();
      int tx = poll.x;
      int ty = poll.y;
      int tempScore = score[tx][ty];

      for (int i = 0; i < 4; i++) {

        int ax = tx + dx[i];
        int ay = ty + dy[i];

        if (ax >= 0 && ax < sero && ay >= 0 && ay < garo && input[ax][ay] != 0 && score[ax][ay] == 0 && !visit[ax][ay]) {

          visit[ax][ay] = true;
          score[ax][ay] = tempScore + 1;
          q.add(new Node(ax, ay));

        }
      }
    }
    return score[sero - 1][garo - 1] == 0 ? -1 : score[sero - 1][garo - 1];

  }

  static class Node {

    int x;
    int y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public String toString() {
      return "Node{" +
          "x=" + x +
          ", y=" + y +
          '}';
    }
  }

  public static void main(String[] args) {

    int[][] input1 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
    int[][] input2 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
    System.out.println(solution(input1));
  }
}
