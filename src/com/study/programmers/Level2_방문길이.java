package com.study.programmers;

import java.util.ArrayList;
import java.util.Objects;

public class Level2_방문길이 {

  static ArrayList<Node>[][] nodeMap = new ArrayList[40][40];//previous 좌표 저장
  static int[] dx = {1, 0, 0, -1};
  static int[] dy = {0, -1, 1, 0};

  public static int solution(String dirs) {

    for (int i = 15; i <= 25; i++) {
      for (int j = 15; j <= 25; j++) {
        nodeMap[i][j] = new ArrayList<>();
      }
    }

    int sx = 20;
    int sy = 20;

    for (int i = 0; i < dirs.length(); i++) {

      //backup
      int tx = sx;
      int ty = sy;

      if (dirs.charAt(i) == 'U') {

        sx = sx + dx[0];
        sy = sy + dy[0];

      } else if (dirs.charAt(i) == 'L') {

        sx = sx + dx[1];
        sy = sy + dy[1];

      } else if (dirs.charAt(i) == 'R') {

        sx = sx + dx[2];
        sy = sy + dy[2];

      } else if (dirs.charAt(i) == 'D') {

        sx = sx + dx[3];
        sy = sy + dy[3];

      }

      if (sx > 25 || sx < 15 || sy > 25 || sy < 15) {
        sx = tx;
        sy = ty;
      } else {
//        System.out.println("sx:" + sx + " sy:" + sy);

        {
          boolean flag = true;

          if (nodeMap[sx][sy].contains(new Node(tx, ty))) {
            flag = false;
          }

          if (flag) {
            nodeMap[sx][sy].add(new Node(tx, ty));
          }
        }

      }


    }

//    printMap();

//    int answer = 0;
    return getAnswer();
  }


  private static void printMap() {

    for (int i = 15; i < 25; i++) {
      for (int j = 15; j < 25; j++) {
        System.out.print(nodeMap[i][j].toString() + " ");
      }
      System.out.println();
    }

  }

  private static int getAnswer() {
    int t = 0;
    for (int i = 15; i < 25; i++) {
      for (int j = 15; j < 25; j++) {
        t += nodeMap[i][j].size();
      }
    }
    return t;

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

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Node node = (Node) o;
      return x == node.x &&
          y == node.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }

  public static void main(String[] args) {
    System.out.println(solution("ULURRDLLU"));
    System.out.println(solution("LULLLLLLU"));
  }

}
