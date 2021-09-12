package com.study.bj.b2021.step1.queue_and_graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class P1260_DFS와_BFS_v2 {

  static List<Integer>[] arrList;
  static int[] arr;
  static boolean[] v;
  static int node, edge, start;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    node = scan.nextInt();
    edge = scan.nextInt();
    start = scan.nextInt();

    arr = new int[node + 1];
    v = new boolean[node + 1];
    arrList = new ArrayList[node + 1];

    for (int i = 0; i < node + 1; i++) {
      arrList[i] = new ArrayList<>();
    }

    for (int i = 1; i <= edge; i++) {

      int x = scan.nextInt();
      int y = scan.nextInt();

      arrList[x].add(y);
      arrList[y].add(x);

    }

    for (int i = 1; i <= node; i++) {
      Collections.sort(arrList[i]);
    }

    v[start] = true;
    dfs(start);
    System.out.println();
    v = new boolean[node + 1];
    bfs(start);

  }

  private static void bfs(int currentNode) {

    Queue<Integer> q = new LinkedList<>();
    q.add(currentNode);
    v[currentNode] = true;

    while (!q.isEmpty()) {

      Integer poll = q.poll();
      System.out.print(poll + " ");

      List<Integer> adList = arrList[poll];

      for (int i = 0; i < adList.size(); i++) {

        Integer candidateNode = adList.get(i);

        if (!v[candidateNode]) {
          v[candidateNode] = true;
          q.add(candidateNode);
        }
      }

    }
  }

  private static void dfs(int currentNode) {

    System.out.print(currentNode + " ");

    List<Integer> adList = arrList[currentNode];

    for (int i = 0; i < adList.size(); i++) {

      int candidateNode = adList.get(i);

      if (!v[candidateNode]) {
        v[candidateNode] = true;
        dfs(candidateNode);
      }
    }

  }


}
