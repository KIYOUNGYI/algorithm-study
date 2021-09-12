package com.study.bj.b2021.step1.simulation;

import java.util.ArrayList;
import java.util.Scanner;

public class P16926_배열돌리기1_v4_풀이답습 {

  static Scanner sc = new Scanner(System.in);
  static int n, m, r;
  static int[][] a;

  public static void main(String[] args) {

    n = sc.nextInt();
    m = sc.nextInt();
    r = sc.nextInt();
    a = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        a[i][j] = sc.nextInt();
      }
    }

    ArrayList<ArrayList<Integer>> groups = new ArrayList<>();
    int groupNum = Math.min(n, m) / 2;

    for (int k = 0; k < groupNum; k++) {
      ArrayList<Integer> group = new ArrayList<>();

      for (int j = k; j < m - k; j++) {
//        System.out.println(k + " " + j);
        group.add(a[k][j]);
      }
//      System.out.println("----");
      for (int i = k + 1; i < n - k - 1; i++) {
//        System.out.println((i) + " " + (m - k - 1));
        group.add(a[i][m - k - 1]);
      }
//      System.out.println("----");
      for (int j = m - k - 1; j > k; j--) {
//        System.out.println((n - k - 1) + " " + j);
        group.add(a[n - k - 1][j]);
      }
//      System.out.println("----");
      for (int i = n - k - 1; i > k; i--) {
//        System.out.println((i) + " " + k);
        group.add(a[i][k]);
      }
//      System.out.println("----");
      groups.add(group);
    }

    for (int k = 0; k < groupNum; k++) {

      ArrayList<Integer> group = groups.get(k);
      int len = group.size();
      int idx = 0;
      for (int j = k; j < m - k; j++) {
        a[k][j] = group.get((idx + r) % len);
        idx += 1;
      }

      for (int i = k + 1; i < n - k - 1; i++) {
        a[i][m - k - 1] = group.get((idx + r) % len);
        idx += 1;
      }
      for (int j = m - k - 1; j > k; j--) {
        a[n - k - 1][j] = group.get((idx + r) % len);
        idx += 1;
      }
      for (int i = n - k - 1; i > k; i--) {
        a[i][k] = group.get((idx + r) % len);
        idx += 1;
      }

    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(a[i][j] + " ");
      }
      System.out.println();
    }

  }

}
