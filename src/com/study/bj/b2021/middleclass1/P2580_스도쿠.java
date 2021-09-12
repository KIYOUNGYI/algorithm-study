package com.study.bj.b2021.middleclass1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P2580_스도쿠 {

  static int[][] arr = new int[10][10];
  static Scanner scan = new Scanner(System.in);

  static ArrayList<Integer>[] arrList = new ArrayList[10];

  static boolean[][] boolList = new boolean[10][];
  static int[][] ansList = new int[10][];

  static ArrayList<Point>[] pointArrList = new ArrayList[10];

  static boolean[][] vt = new boolean[10][10];

  public static void main(String[] args) {

    for (int i = 0; i < 10; i++) {
      arrList[i] = new ArrayList<>();
      pointArrList[i] = new ArrayList<>();
//      boolList[i] = new ArrayList<>();
    }

    input();
    printVt();
    candiate();
    printCandidate();
    bojung();
    printVt();
    printCandidate();
    printArr();

    solution(1, 0);

  }

  private static void solution(int depth, int smallDepth) {

    if (depth == 10) {
      return;
    }

    //arrList 나열
    recursion(depth, smallDepth);

  }

  private static void recursion(int depth, int smallDepth) {
//
//    if(smallDepth==xx){
//      return;
//    }
//
//
//    for(;;){
//      vt[]
//    }

  }

  private static void smallRectangle(int rectangle, int smallDepth) {

    if (smallDepth == arrList[rectangle].size()) {
      return;
    }

    smallRectangle(rectangle, smallDepth + 1);


  }

  private static void printArr() {
    for (int i = 1; i <= 9; i++) {
      for (int j = 1; j <= 9; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static void input() {

    for (int i = 1; i <= 9; i++) {
      for (int j = 1; j <= 9; j++) {
        arr[i][j] = scan.nextInt();
      }
    }

    for (int i = 1; i <= 3; i++) {
      for (int j = 1; j <= 3; j++) {
        vt[1][arr[i][j]] = true;
        if (arr[i][j] == 0) {
          pointArrList[1].add(new Point(i, j));
        }
      }
      for (int j = 4; j <= 6; j++) {
        vt[2][arr[i][j]] = true;
        if (arr[i][j] == 0) {
          pointArrList[2].add(new Point(i, j));
        }
      }
      for (int j = 7; j <= 9; j++) {
        vt[3][arr[i][j]] = true;
        if (arr[i][j] == 0) {
          pointArrList[3].add(new Point(i, j));
        }
      }
    }

    for (int i = 4; i <= 6; i++) {

      for (int j = 1; j <= 3; j++) {
        vt[4][arr[i][j]] = true;
        if (arr[i][j] == 0) {
          pointArrList[4].add(new Point(i, j));
        }
      }
      for (int j = 4; j <= 6; j++) {
        vt[5][arr[i][j]] = true;
        if (arr[i][j] == 0) {
          pointArrList[5].add(new Point(i, j));
        }
      }
      for (int j = 7; j <= 9; j++) {
        vt[6][arr[i][j]] = true;
        if (arr[i][j] == 0) {
          pointArrList[6].add(new Point(i, j));
        }
      }
    }

    for (int i = 7; i <= 9; i++) {

      for (int j = 1; j <= 3; j++) {
        vt[7][arr[i][j]] = true;
        if (arr[i][j] == 0) {
          pointArrList[7].add(new Point(i, j));
        }
      }
      for (int j = 4; j <= 6; j++) {
        vt[8][arr[i][j]] = true;
        if (arr[i][j] == 0) {
          pointArrList[8].add(new Point(i, j));
        }
      }
      for (int j = 7; j <= 9; j++) {
        vt[9][arr[i][j]] = true;
        if (arr[i][j] == 0) {
          pointArrList[9].add(new Point(i, j));
        }
      }
    }


  }

  private static void printVt() {

    for (int i = 1; i <= 9; i++) {
      System.out.print("사각형 " + i + "\n");
      for (int j = 1; j <= 9; j++) {

        if (vt[i][j] == true) {
          System.out.print(1 + " ");
        } else {
          System.out.print(0 + " ");
        }
      }
      System.out.println();
    }

  }


  private static void candiate() {

    for (int i = 1; i <= 9; i++) {

      for (int j = 1; j <= 9; j++) {
        if (vt[i][j] == true) {

        } else {
          arrList[i].add(j);

        }
      }

      int x = arrList[i].size();
      boolean[] temp = new boolean[x];
      boolList[i] = new boolean[x];
    }
  }

  private static void printCandidate() {
    for (int i = 1; i <= 9; i++) {
      System.out.println(i + " 사각형 : " + arrList[i].toString());
      System.out.println(i + " 좌표 : " + pointArrList[i].toString());
//      System.out.println(i + " 체크배열 : " + Arrays.toString(boolList[i].get(0)));
      System.out.println(i + " 체크배열 : " + Arrays.toString(boolList[i]));
    }
  }

  private static void bojung() {

    for (int i = 1; i <= 9; i++) {

      if (arrList[i].size() == 1) {

        Point point = pointArrList[i].get(0);

        arr[point.x][point.y] = arrList[i].get(0);
        vt[i][arrList[i].get(0)] = true;

        arrList[i].remove(0);
        pointArrList[i].remove(0);

      }
    }
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

}
