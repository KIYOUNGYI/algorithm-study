package com.study.lms;

import java.util.ArrayList;
import java.util.Scanner;

public class 이분그래프판별 {

  public static int n;
  public static int m;
  public static boolean flag = true;
  public static ArrayList<Integer>[] graph;
  public static int[] v;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    input(scan);
    v[1] = 1;
    dfs(1);
    if (flag) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
    scan.close();
  }

  public static void dfs(int x) {
    int curColor = v[x];

    for (int i = 0; i < graph[x].size(); i++) {
      int t = graph[x].get(i);//인접노드
      if (v[t] == 0) {
        if (curColor == 1) {
          v[t] = 2;
          dfs(t);
        } else if (curColor == 2) {
          v[t] = 1;
          dfs(t);
        }
      } else {
        if (curColor == v[t]) {
          flag = false;
          return;
        }
      }
    }
  }

  public static void input(Scanner scan) {
    n = scan.nextInt();
    m = scan.nextInt();
    graph = new ArrayList[n + 1];
    v = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      graph[i] = new ArrayList();
    }
    for (int i = 0; i < m; i++) {
      int x = scan.nextInt();
      int y = scan.nextInt();
      graph[x].add(y);
      graph[y].add(x);
    }
  }
}