package com.study.bj.b2021.step1.simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class P16926_배열돌리기1_v2 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  static int sero, garo, count;
  static int[][] arr;
  static ArrayList<Integer>[] groupArr;
  static ArrayList<Integer>[] tempArr;
  static int groupCount;
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};


  public static void main(String[] args) throws IOException {

    String input1 = br.readLine();
    String[] temp1 = input1.split(" ");
    sero = Integer.parseInt(temp1[0]);
    garo = Integer.parseInt(temp1[1]);
    count = Integer.parseInt(temp1[2]);
    arr = new int[sero + 2][garo + 2];

    for (int i = 1; i <= sero; i++) {
      String input2 = br.readLine();
      String[] temp2 = input2.split(" ");
      for (int j = 0; j < temp2.length; j++) {
        arr[i][j + 1] = Integer.parseInt(temp2[j]);
      }
    }
    groupCount = min(sero, garo) / 2;
    groupArr = new ArrayList[groupCount + 1];
    tempArr = new ArrayList[groupCount + 1];

    for (int i = 0; i <= groupCount; i++) {
      groupArr[i] = new ArrayList<>();
      tempArr[i] = new ArrayList<>();
    }

    solution();

  }

  private static void solution() {

    for (int g = 1; g <= groupCount; g++) {

      for (int k = g; k <= garo - g; k++) {
//        System.out.println(g + " " + k);
        groupArr[g].add(arr[g][k]);
      }

      for (int k = g; k <= sero - g; k++) {
//        System.out.println(k + " " + (garo - g + 1));
        groupArr[g].add(arr[k][garo - g + 1]);
      }

      for (int k = garo - g + 1; k >= g + 1; k--) {
//        System.out.println((sero - g + 1) + " " + k);
        groupArr[g].add(arr[sero - g + 1][k]);

      }

      for (int k = sero - g + 1; k >= g + 1; k--) {
//        System.out.println(k + " " + g);
        groupArr[g].add(arr[k][g]);
      }

    }
    shift();

    distribute();
  }

  private static void distribute() {

    for (int g = 1; g <= groupCount; g++) {
      int idx = 0;
      ArrayList<Integer> temp = tempArr[g];

      for (int k = g; k <= garo - g; k++) {

        int t = temp.get(idx);
        arr[g][k] = t;
        idx++;
      }

      for (int k = g; k <= sero - g; k++) {
//        System.out.println(k + " " + (garo - g + 1));
        int t = temp.get(idx);
        arr[k][garo - g + 1] = t;
        idx++;
      }

      for (int k = garo - g + 1; k >= g + 1; k--) {
//        System.out.println((sero - g + 1) + " " + k);
        int t = temp.get(idx);
        arr[sero - g + 1][k] = t;
        idx++;

      }

      for (int k = sero - g + 1; k >= g + 1; k--) {
//        System.out.println(k + " " + g);
        int t = temp.get(idx);
        arr[k][g] = t;
        idx++;
      }

    }

    for (int i = 1; i <= sero; i++) {
      for (int j = 1; j <= garo; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }

  }

  private static void shift() {

    for (int i = 1; i <= groupCount; i++) {

      ArrayList<Integer> temp = groupArr[i];
      int size = temp.size();
      int[] t1 = new int[size];
      int[] t2 = new int[size];
      for (int j = 0; j < size; j++) {
//        System.out.println(j);
        t1[j] = temp.get(j);
      }

      for (int k = 0; k < t1.length; k++) {
        t2[k] = t1[abs(k + count) % t1.length];
        tempArr[i].add(t1[(k + count) % t2.length]);
      }

    }
//    for (int k = 1; k <= groupCount; k++) {
//      System.out.println(tempArr[k].toString());
//    }
  }

  private static int abs(int a) {
    return a > 0 ? a : -a;
  }

  private static int min(int a, int b) {
    return a > b ? b : a;
  }

  private static void printArr() {

    for (int i = 1; i <= sero; i++) {
      for (int j = 1; j <= garo; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

  static class Point {

    int x;
    int y;
    int v;

    public Point(int x, int y, int v) {
      this.x = x;
      this.y = y;
    }

    @Override
    public String toString() {
      return "Point{" +
          "x=" + x +
          ", y=" + y +
          ", v=" + v +
          '}';
    }
  }
}

