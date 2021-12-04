package com.study.programmers.weekly.week11;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

  static final int SIZE = 52;
  static int[][] scoreMap = new int[SIZE][SIZE];
  static int[][] myMap = new int[SIZE][SIZE];

  static boolean[][] visit = new boolean[SIZE][SIZE];


  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};

  public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

    int len = rectangle.length;

    for (int i = 0; i < len; i++) {

      for (int a = rectangle[i][0]; a <= rectangle[i][2]; a++) {
        for (int b = rectangle[i][1]; b <= rectangle[i][3]; b++) {
          myMap[a][b] = myMap[a][b] + 1;
        }
      }
    }

    printArr();


    for (int i = 0; i < len; i++) {

      for (int a = rectangle[i][0]+1; a <= rectangle[i][2]-1; a++) {
        for (int b = rectangle[i][1]+1; b <= rectangle[i][3]-1; b++) {
          myMap[a][b] = 0;
        }
      }
    }

    System.out.println();
    printArr();
    myBfs(characterX,characterY);

    return scoreMap[itemX][itemY];
  }


  private static void myBfs(int characterX, int characterY) {

    Queue<Point> q = new LinkedList<>();
    q.add(new Point(characterX, characterY));
    visit[characterX][characterY] = true;
    scoreMap[characterX][characterY] = 1;

    while (!q.isEmpty()) {

      Point poll = q.poll();
      int x = poll.x;
      int y = poll.y;
      int curScore = scoreMap[x][y];

      for (int i = 0; i < 4; i++) {

        int tx = x + dx[i];
        int ty = y + dy[i];

        if (myMap[tx][ty] != 0 && !visit[tx][ty]) {
          visit[tx][ty] = true;
          scoreMap[tx][ty] = curScore + 1;
          q.add(new Point(tx, ty));
        }

      }

    }

  }


  public static void printArr() {
    for (int i = 0; i <= 9; i++) {
      for (int j = 0; j <= 9; j++) {
        System.out.print(myMap[i][j] + "  ");

      }
      System.out.println();
      System.out.println();
    }
  }

  public static void printScore() {
    for (int i = 0; i <= 10; i++) {
      for (int j = 0; j <= 10; j++) {
        System.out.print(scoreMap[i][j] + "    ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {

    int[][] rectangle1 = {{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}};
    int characterX1 = 1;
    int characterY1 = 3;
    int itemX1 = 7;
    int itemY1 = 8;

    System.out.println(solution(rectangle1, characterX1, characterY1, itemX1, itemY1));
  }

  private static class Point {

    private int x;
    private int y;


    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public String toString() {
      return "Point{" +
          "x=" + x +
          ", y=" + y +
          '}';
    }
  }
}
