package com.study.bj.b2021.step1.simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P16926_배열돌리기2_v2 {

  static int n, m, r;
  static int[][] arr;
  static int group;
  static List<Integer>[] arrList;
  static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {

    n = scan.nextInt();
    m = scan.nextInt();
    r = scan.nextInt();
    arr = new int[n][m];
    group = min(n, m) / 2;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        arr[i][j] = scan.nextInt();
      }
    }

    solution();

  }

  private static void solution() {

    arrList = new ArrayList[n];
    for (int i = 0; i < group; i++) {
      arrList[i] = new ArrayList<>();
    }

    for (int g = 0; g < group; g++) {

      for (int j = 0 + g; j < m - 1 - g; j++) {
//        System.out.println(g + " " + j + " = " + arr[g][j]);
        arrList[g].add(arr[g][j]);
      }

      for (int j = g; j < n - 1 - g; j++) {
//        System.out.println(j + " " + (m - 1 - g) + " = " + arr[j][m - 1 - g]);
        arrList[g].add(arr[j][m - 1 - g]);
      }

      for (int j = m - 1 - g; j >= g + 1; j--) {
//        System.out.println((n - 1 - g) + " " + j + " = " + arr[n - 1 - g][j]);
        arrList[g].add(arr[n - 1 - g][j]);
      }

      for (int j = n - 1 - g; j >= g + 1; j--) {
//        System.out.println(j + " " + g + " =  " + arr[j][g]);
        arrList[g].add(arr[j][g]);
      }
    }

//    for (int i = 0; i < group; i++) {
//      System.out.println(arrList[i].toString());
//    }
//    System.out.println("---");

    List<Integer>[] arrList2 = new ArrayList[n];
    for (int i = 0; i < group; i++) {
      arrList2[i] = new ArrayList<>();
    }

    for (int i = 0; i < group; i++) {
      int size = arrList[i].size();
      int[] arr = new int[size];
      for (int j = 0; j < size; j++) {
        arr[j] = arrList[i].get(j);
      }
      //shift
//      int[] temp = new int[size];
      List<Integer> arrList = new ArrayList<>();
      for (int j = 0; j < size; j++) {
//        temp[j] = arr[(j+size)%size];
        arrList.add(arr[(j + r) % size]);
      }
//      System.out.println(arrList.toString());
      arrList2[i] = arrList;
    }
//    System.out.println("====");
//    for (int i = 0; i < group; i++) {
//      System.out.println(arrList2[i].toString());
//    }

    printList(arrList2);


  }

  private static void printList(List<Integer>[] arrList2) {

    int[][] temp = new int[n][m];
    for (int g = 0; g < group; g++) {

      List<Integer> tempArrList = arrList2[g];
      int idx = 0;

      for (int j = 0 + g; j < m - 1 - g; j++) {
//        System.out.println(g + " " + j + " = " + arr[g][j]);
//        arrList[g].add(arr[g][j]);
        int t = tempArrList.get(idx++);
        temp[g][j] = t;
      }

      for (int j = g; j < n - 1 - g; j++) {
//        System.out.println(j + " " + (m - 1 - g) + " = " + arr[j][m - 1 - g]);
//        arrList[g].add(arr[j][m - 1 - g]);
        int t = tempArrList.get(idx++);
        temp[j][m - 1 - g] = t;
      }

      for (int j = m - 1 - g; j >= g + 1; j--) {
//        System.out.println((n - 1 - g) + " " + j + " = " + arr[n - 1 - g][j]);
//        arrList[g].add(arr[n - 1 - g][j]);
        int t = tempArrList.get(idx++);
        temp[n - 1 - g][j] = t;
      }

      for (int j = n - 1 - g; j >= g + 1; j--) {
//        System.out.println(j + " " + g + " =  " + arr[j][g]);
//        arrList[g].add(arr[j][g]);
        int t = tempArrList.get(idx++);
        temp[j][g] = t;
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(temp[i][j] + " ");
      }
      System.out.println();
    }

  }

  private static int min(int n, int m) {
    return n > m ? m : n;
  }


}
