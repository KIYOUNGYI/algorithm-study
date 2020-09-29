package com.study.bj;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * DFS와 BFS https://www.acmicpc.net/problem/1260 처음 -> bfs 에서 peek 한거 가지고 삽질함.
 */
public class P1260 {

  static boolean[] visited;
  static ArrayList<Integer>[] arrayList;
  static int node, edge, start;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    input(scan);
    dfs(start);
    System.out.println();
    initVisited();
    bfs(start);

  }

  private static void bfs(int node) {
    Queue<Integer> q = new LinkedList<>();

    q.add(node);
    visited[node] = true;

    while (!q.isEmpty()) {
      int peek = q.peek();
      q.remove();
      System.out.print(peek + " ");

      for (int i = 0; i < arrayList[peek].size(); i++) {
        int pivot = arrayList[peek].get(i);
        if (!visited[pivot]) {
          visited[pivot] = true;
          q.add(pivot);
        }
      }
    }
  }

  private static void dfs(int node) {
    visited[node] = true;
    System.out.print(node + " ");
    for (int i = 0; i < arrayList[node].size(); i++) {
      int pivot = arrayList[node].get(i);
      if (!visited[pivot]) {
        visited[pivot] = true;
        dfs(pivot);
      }
    }
  }

  private static void input(Scanner scan) {
    node = scan.nextInt();
    edge = scan.nextInt();
    start = scan.nextInt();
    arrayList = new ArrayList[node + 1];
    visited = new boolean[node + 1];

    for (int i = 1; i <= node; i++) {
      arrayList[i] = new ArrayList<>();
    }

    for (int i = 1; i <= edge; i++) {
      int x = scan.nextInt();
      int y = scan.nextInt();
      arrayList[x].add(y);
      arrayList[y].add(x);
    }
    for (int i = 1; i <= node; i++) {
      Collections.sort(arrayList[i]);
    }
  }

  public static void initVisited() {
    for (int i = 0; i <= node; i++) {
      visited[i] = false;
    }
  }
}
