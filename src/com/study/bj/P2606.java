package com.study.bj;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 바이러스 https://www.acmicpc.net/problem/2606
 */
public class P2606 {

  static boolean[] visited;
  static ArrayList<Integer>[] arrList;
  static int node, edge;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    node = scan.nextInt();
    edge = scan.nextInt();
    arrList = new ArrayList[node + 1];
    visited = new boolean[node + 1];
    for (int i = 0; i <= node; i++) {
      arrList[i] = new ArrayList<>();
    }

    for (int i = 1; i <= edge; i++) {
      int x = scan.nextInt();
      int y = scan.nextInt();
      arrList[x].add(y);
      arrList[y].add(x);
    }

    dfs(1);
    count();

    scan.close();
  }

  private static void dfs(int x) {
    visited[x] = true;

    for (int i = 0; i < arrList[x].size(); i++) {
      int pivot = arrList[x].get(i);
      if (!visited[pivot]) {
        visited[pivot] = true;
        dfs(pivot);
      }
    }
  }

  private static void count() {
    int cnt = 0;
    for (int i = 2; i <= node; i++) {
      if (visited[i]) {
        cnt += 1;
      }
    }
    System.out.println(cnt);
  }
}
