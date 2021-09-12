package com.study.bj.b2021.step1.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P16926 {

  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};
  static int n, m, cnt;
  static int[][] arr;
  static boolean[][] v;
  static List<Integer>[] arrList, arrList2;
  static int groupSize;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();//sero
    m = scan.nextInt();//garo
    cnt = scan.nextInt();
    groupSize = Math.min(n, m) / 2;
    arrList = new ArrayList[groupSize + 1];
    arrList2 = new ArrayList[groupSize + 1];
    for (int i = 0; i <= groupSize; i++) {
      arrList[i] = new ArrayList<>();
      arrList2[i] = new ArrayList<>();
    }

    arr = new int[n + 2][m + 2];
    v = new boolean[n + 2][m + 2];
    for (int i = 0; i < m + 2; i++) {
      arr[0][i] = -1;
      arr[n + 1][i] = -1;
    }
    for (int j = 0; j < n + 2; j++) {
      arr[j][0] = -1;
      arr[j][m + 1] = -1;
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        arr[i][j] = scan.nextInt();
      }
    }
//    printArr();
    grouping();
    leftShift();
//    rightShift();
    placing();
//    printArr();
    printAnswer();

  }

  private static void placing() {
    int t = 0;
    int x = 1;
    int y = n;
    int z = m;

    for (int i = 1; i <= groupSize; i++) {
      List<Integer> arrTemp = arrList2[i];
      int idx = 0;

      for (int a = 1 + t; a <= m - (1 + t); a++) {
//        System.out.print( + " ");
        arr[x][a] = arrTemp.get(idx++);
      }
//      System.out.println();
      for (int a = 1 + t; a <= n - (1 + t); a++) {
//        System.out.print(arr[a][z] + " ");
//        arrList2[i].add(arr[a][z]);
        arr[a][z] = arrTemp.get(idx++);
      }
//      System.out.println();
      for (int a = m - t; a >= 2 + t; a--) {
//        System.out.print(arr[y][a] + " ");
//        arrList2[i].add(arr[y][a]);
        arr[y][a] = arrTemp.get(idx++);
      }
//      System.out.println();
      for (int a = n - t; a >= 2 + t; a--) {
//        System.out.print(arr[a][x] + " ");
//        arrList2[i].add(arr[a][x]);
        arr[a][x] = arrTemp.get(idx++);
      }
//      System.out.println();
      t += 1;
      x += 1;
      y -= 1;
      z -= 1;
    }
  }

  private static void leftShift() {

    for (int a = 1; a <= groupSize; a++) {

      List<Integer> original = arrList[a];
      List<Integer> temp = new ArrayList<>();

      for (int j = 0; j < original.size(); j++) {
        int t = original.get((j + cnt) % original.size());
        temp.add(t);
      }
      arrList2[a].addAll(temp);
    }

  }

  private static void rightShift() {
    for (int a = 1; a <= groupSize; a++) {

      List<Integer> original = arrList[a];
      List<Integer> temp = new ArrayList<>();
      int[] temp2 = new int[original.size()];
      for (int j = 0; j < original.size(); j++) {
        temp2[(j + cnt) % original.size()] = original.get(j);
      }
      for (int j = 0; j < temp2.length; j++) {
        temp.add(temp2[j]);
      }

      arrList2[a].addAll(temp);
    }
  }


  private static void grouping() {

    int t = 0;
    int x = 1;
    int y = n;
    int z = m;

    for (int i = 1; i <= groupSize; i++) {

      for (int a = 1 + t; a <= m - (1 + t); a++) {
//        System.out.print(arr[x][a] + " ");
        arrList[i].add(arr[x][a]);
      }
//      System.out.println();
      for (int a = 1 + t; a <= n - (1 + t); a++) {
//        System.out.print(arr[a][z] + " ");
        arrList[i].add(arr[a][z]);
      }
//      System.out.println();
      for (int a = m - t; a >= 2 + t; a--) {
//        System.out.print(arr[y][a] + " ");
        arrList[i].add(arr[y][a]);
      }
//      System.out.println();
      for (int a = n - t; a >= 2 + t; a--) {
//        System.out.print(arr[a][x] + " ");
        arrList[i].add(arr[a][x]);
      }
//      System.out.println();
      t += 1;
      x += 1;
      y -= 1;
      z -= 1;
    }


  }

  private static void printArr() {

    for (int i = 0; i < n + 2; i++) {
      for (int j = 0; j < m + 2; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static void printAnswer() {

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }
}
