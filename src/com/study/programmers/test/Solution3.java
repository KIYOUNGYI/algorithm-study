package com.study.programmers.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution3 {


  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};
  static int[][] map = new int[7][7];

  public static String[] solution(int[][] macaron) {

    for (int i = 0; i < macaron.length; i++) {

      int std = macaron[i][0];//세로 기준
      int val = macaron[i][1];//해당 값

      updateMap(std, val);
      blowup();

    }
//    printMap();

    for (int i = 0; i < 30; i++) {
      blowup();
    }
//    printMap();

    String[] answer = new String[6];

    for (int i = 1; i <= 6; i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = 1; j <= 6; j++) {
        sb.append(map[i][j]);
      }
      String temp = sb.toString();
      answer[i - 1] = temp;
    }

    return answer;
  }

  private static void reorganizeMap() {

//    printMap();

    for (int i = 1; i <= 6; i++) {

      List<Integer> arrList = new ArrayList<>();

      for (int j = 6; j >= 1; j--) {

        if (map[j][i] != 0) {
          arrList.add(map[j][i]);
        }
        map[j][i] = 0;
      }
//      System.out.println("arrList = " + arrList.toString());
      int idx = 0;
      for (int k = 6; k >= 6 - arrList.size() + 1; k--) {
        map[k][i] = arrList.get(idx++);
      }

    }

  }

  private static void blowup() {

    for (int i = 1; i <= 6; i++) {

      for (int j = 1; j <= 6; j++) {

        int tx = i;
        int ty = j;
        int val = map[tx][ty];
        int cnt = 0;
        for (int k = 0; k < 4; k++) {
          tx = tx + dx[k];
          ty = ty + dy[k];

          if (tx >= 1 && tx <= 6 && ty >= 1 && ty <= 6 && map[tx][ty] == val && map[tx][ty] != 0) {
            cnt += 1;
          }
        }

        if (cnt >= 3) {
          bfs(i, j);
          reorganizeMap();
        }

        int ax1 = i - 1;
        int ax2 = i + 1;
        if (ax1 >= 1 && ax2 >= 1 && ax1 <= 6 && ax2 <= 6 && map[ax1][j] == map[i][j] && map[ax2][j] == map[i][j] && map[i][j] != 0) {
          bfs(i, j);
          reorganizeMap();
        }
//
        int ay1 = j - 1;
        int ay2 = j + 1;
        if (ay1 >= 1 && ay2 >= 1 && ay2 <= 6 && ay1 <= 6 && map[i][ay1] == map[i][j] && map[i][j] == map[i][ay2] && map[i][j] != 0) {
          bfs(i, j);
          reorganizeMap();
        }


      }
    }
  }

  private static void bfs(int tx, int ty) {

    Queue<Node> q = new LinkedList<>();
    q.add(new Node(tx, ty));
    int val = map[tx][ty];
    map[tx][ty] = 0;

    while (!q.isEmpty()) {

      Node poll = q.poll();
      int x = poll.x;
      int y = poll.y;

      for (int i = 0; i < 4; i++) {

        int ax = x + dx[i];
        int ay = y + dy[i];

        if (ax >= 1 && ax <= 6 && ay >= 1 && ay <= 6 && map[ax][ay] == val) {
          map[ax][ay] = 0;
          q.add(new Node(ax, ay));
        }

      }


    }


  }

  private static void updateMap(int std, int val) {

    for (int i = 6; i >= 1; i--) {
      if (map[i][std] == 0) {
        map[i][std] = val;
        break;
      }
    }
//    printMap();
//    System.out.println("----");
  }

  private static void printMap() {
    for (int i = 1; i <= 6; i++) {
      for (int j = 1; j <= 6; j++) {
        System.out.print(map[i][j] + " ");
      }
      System.out.println();
    }
  }


  public static void main(String[] args) {

    int[][] marcaron1 = {{1, 1}, {2, 1}, {1, 2}, {3, 3}, {6, 4}, {3, 1}, {3, 3}, {3, 3}, {3, 4}, {2, 1}};
    System.out.println(Arrays.toString(solution(marcaron1)));
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
}
