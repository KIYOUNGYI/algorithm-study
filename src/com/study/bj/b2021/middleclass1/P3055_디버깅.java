package com.study.bj.b2021.middleclass1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P3055_디버깅 {

  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};
  static int r, c;
  static String[][] map;
  static int[][] score;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    r = scan.nextInt();
    c = scan.nextInt();
    map = new String[r][c];
    score = new int[r][c];
    scan.nextLine();
    for (int i = 0; i < r; i++) {
      String temp = scan.nextLine();
      for (int j = 0; j < temp.length(); j++) {
        map[i][j] = String.valueOf(temp.charAt(j));
      }
    }

    bfs();

  }

  private static void bfs() {

    Queue<Point> q = new LinkedList<>();

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (map[i][j].equals("*")) {
          q.add(new Point(i, j, "*"));
        }
      }
    }
    //나중에 넣어야지

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (map[i][j].equals("S")) {
          q.add(new Point(i, j, "S"));
        }
      }
    }

    int backupX = 0, backupY = 0;
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (map[i][j].equals("D")) {
          backupX = i;
          backupY = j;
        }
      }
    }

    while (!q.isEmpty()) {

      Point poll = q.poll();
      int tx = poll.x;
      int ty = poll.y;
      String tType = poll.type;
//      printMap();
      if (tType.equals("*")) {
        for (int i = 0; i < 4; i++) {

          int ax = tx + dx[i];
          int ay = ty + dy[i];

          if (ax >= 0 && ax < r && ay >= 0 && ay < c && (map[ax][ay].equals(".") || map[ax][ay].equals("S"))) {
            map[ax][ay] = "*";
            q.add(new Point(ax, ay, "*"));
          }

        }
      }
      if (tType.equals("S")) {

        int tempScore = score[tx][ty];

        for (int i = 0; i < 4; i++) {

          int ax = tx + dx[i];
          int ay = ty + dy[i];

          if (ax >= 0 && ax < r && ay >= 0 && ay < c && (map[ax][ay].equals(".") || map[ax][ay].equals("D"))) {

            score[ax][ay] = tempScore + 1;

            if (map[ax][ay].equals("D")) {
              break;
            }

            map[ax][ay] = "S";
            q.add(new Point(ax, ay, "S"));
          }

        }
      }

    }
//    System.out.println("answer");
    System.out.println(score[backupX][backupY] == 0 ? "KAKTUS" : score[backupX][backupY]);

  }

  private static void printMap() {

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        System.out.print(map[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println("-----");
  }

  static class Point {

    int x;
    int y;
    String type;

    public Point(int x, int y, String type) {
      this.x = x;
      this.y = y;
      this.type = type;
    }

    @Override
    public String toString() {
      return "Point{" +
          "x=" + x +
          ", y=" + y +
          ", type='" + type + '\'' +
          '}';
    }
  }
}
