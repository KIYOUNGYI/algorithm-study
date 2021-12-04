package com.study.programmers.weekly.week10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

  static int minX = Integer.MAX_VALUE;
  static int maxX = Integer.MIN_VALUE;
  static int minY = Integer.MAX_VALUE;
  static int maxY = Integer.MIN_VALUE;


  public static String[] solution(int[][] line) {

    List<Point> myList = new ArrayList<>();

    for (int x = 0; x < line.length; x++) {
      for (int y = x + 1; y < line.length; y++) {

        if (x == y) {
          continue;
        }
//        System.out.println("x = " + x + " y = " + y);

        int a = line[x][0];
        int b = line[x][1];
        int e = line[x][2];

        int c = line[y][0];
        int d = line[y][1];
        int f = line[y][2];

        if (a * d - b * c == 0) {
          continue;
        }
        if ((b * f - e * d) % (a * d - b * c) == 0 && (e * c - a * f) % (a * d - b * c) == 0) {
          int tx = (b * f - e * d) / (a * d - b * c);
          int ty = (e * c - a * f) / (a * d - b * c);
//          System.out.println("tx = " + tx + " ty = " + ty);
          myList.add(new Point(tx, ty));

          if (tx <= minX) {
            minX = tx;
          }
          if (tx >= maxX) {
            maxX = tx;
          }
          if (ty <= minY) {
            minY = ty;
          }
          if (ty >= maxY) {
            maxY = ty;
          }
        }
      }
    }

    Collections.sort(myList, new MyComparator());
//    System.out.println("myList = " + myList.toString());
//    System.out.println("minX = " + minX);
//    System.out.println("minY = " + minY);
//    System.out.println("maxX = " + maxX);
//    System.out.println("maxY = " + maxY);
    int idx = 0;

    int tIdx = 0;
    String[] answer = new String[maxY - minY + 1];

    for (int j = maxY; j >= minY; j--) {

      StringBuilder sb = new StringBuilder();

      for (int i = minX; i <= maxX; i++) {

        if (myList.get(idx).x == i && myList.get(idx).y == j) {
//          System.out.print("*");
          sb.append("*");
          idx += 1;
        } else {
//          System.out.print(".");
          sb.append(".");
        }
      }
      answer[tIdx++] = sb.toString();
//      System.out.println();
    }

    return answer;
  }

  public static void main(String[] args) {

    int[][] a = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
    System.out.println(Arrays.deepToString(solution(a)));
  }

  static class Point {

    int x;
    int y;

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

  static class MyComparator implements Comparator<Point> {

    @Override
    public int compare(Point pt1, Point pt2) {
      if (pt1.y < pt2.y) {
        return 1;
      } else if (pt1.y == pt2.y) {

        if (pt1.x < pt2.x) {
          return -1;
        } else {
          return 1;
        }
      } else {
        return -1;
      }
    }
  }
}
