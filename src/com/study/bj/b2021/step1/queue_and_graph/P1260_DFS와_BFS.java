package com.study.bj.b2021.step1.queue_and_graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1260_DFS와_BFS {

  static final int MAX = 10_050;
  static int v, e, s;
  static boolean[] visit;
  static ArrayList<Integer>[] graph;
  static Scanner scan = new Scanner(System.in);
  static ArrayList<Integer> dfsResult = new ArrayList<>();
  static ArrayList<Integer> bfsResult = new ArrayList<>();

  public static void main(String[] args) {

    inputAndInit();
    visit[s] = true;
    dfs(s);
    print(dfsResult);
    initVisited();
    bfs(s);
//    printGraph();
//    System.out.println("bfsResult = " + bfsResult.toString());
    print(bfsResult);

  }

  private static void bfs(int t) {

    Queue<Integer> q = new LinkedList<>();
    q.add(t);
    visit[t] = true;

    while (!q.isEmpty()) {

      Integer node = q.peek();
      q.remove();
      bfsResult.add(node);
//      System.out.print("node -> " + node);

      ArrayList<Integer> connected = graph[node];
//      System.out.println("connected=" + connected.toString());
      for (int i = 0; i < connected.size(); i++) {

        int temp = connected.get(i);

        if (!visit[temp]) {
          visit[temp] = true;
          q.add(temp);



        }
      }

    }

  }

  private static void print(ArrayList<Integer> result) {
    int len = result.size();
    for (int i = 0; i < len - 1; i++) {
      System.out.print(result.get(i) + " ");
    }
    System.out.println(result.get(len - 1));
  }

  private static void initVisited() {
    visit = new boolean[MAX];
  }

  private static void dfs(int t) {
    dfsResult.add(t);

    visit[t] = true;
    ArrayList<Integer> connected = graph[t];

    for (int i = 0; i < connected.size(); i++) {
      int node = connected.get(i);
      if (!visit[node]) {
        visit[node] = true;
        dfs(node);
      }
    }


  }

  private static void inputAndInit() {
    v = scan.nextInt();
    e = scan.nextInt();
    s = scan.nextInt();
    visit = new boolean[MAX];
    graph = new ArrayList[v + 1];

    for (int i = 0; i <= v; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 1; i <= e; i++) {
      int t1 = scan.nextInt();
      int t2 = scan.nextInt();
      graph[t1].add(t2);
      graph[t2].add(t1);
    }

    for (int i = 1; i <= v; i++) {
      Collections.sort(graph[i]);
    }
  }

  public static void printGraph() {
    for (int i = 1; i <= v; i++) {
      System.out.println("v:" + i + " -> " + graph[i].toString());
    }
  }
}
