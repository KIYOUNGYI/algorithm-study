package com.study.bj.b2021.step1.queue_and_graph;

import java.util.ArrayList;
import java.util.Scanner;

public class P11724_연결_요소의_개수_실패_분석_V1 {

  static final int MAX = 1_050;
  static int v, e;
  static boolean[] visit;
  static ArrayList<Integer>[] graph;
  static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {

    inputAndInit();
//    System.out.println(mySet.toString());
//    printGraph();

    solution();
  }


  private static void solution() {
    int cnt = 0;

    for (int i = 1; i <= v; i++) {
      if (!visit[i]) {
        dfs(i);
        cnt += 1;
      }
    }
    System.out.println(cnt);
  }

  private static void dfs(int t) {

    visit[t] = true;

    ArrayList<Integer> connected = graph[t];

    for (int i = 0; i < connected.size(); i++) {
      int x = connected.get(i);
      if (!visit[x]) {
        dfs(x);
      }
    }

  }

  private static void inputAndInit() {
    v = scan.nextInt();//정점
    e = scan.nextInt();//간선
    visit = new boolean[MAX];
    graph = new ArrayList[MAX];

    for (int i = 1; i < MAX; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 1; i <= e; i++) {
      int t1 = scan.nextInt();
      int t2 = scan.nextInt();
      graph[t1].add(t2);
      graph[t2].add(t1);
    }


  }

  public static void printGraph() {
    for (int i = 1; i <= v; i++) {
      System.out.println("v:" + i + " -> " + graph[i].toString());
    }
  }
}
