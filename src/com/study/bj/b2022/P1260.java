package com.study.bj.b2022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P1260 {

  static int node, edge, start;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static List<Integer>[] adjList;
  static boolean[] visit;

  public static void main(String[] args) throws IOException {

    String s = br.readLine();
    String[] s1 = s.split(" ");
    node = Integer.parseInt(s1[0]);
    edge = Integer.parseInt(s1[1]);
    start = Integer.parseInt(s1[2]);

    adjList = new ArrayList[node + 1];
    visit = new boolean[node + 1];

    for (int i = 1; i <= node; i++) {
      adjList[i] = new ArrayList<>();
    }

    for (int i = 1; i <= edge; i++) {
      String s2 = br.readLine();
      String[] s3 = s2.split(" ");
      int a1 = Integer.parseInt(s3[0]);
      int a2 = Integer.parseInt(s3[1]);

      adjList[a1].add(a2);
      adjList[a2].add(a1);
    }

    for (int i = 1; i <= node; i++) {
      Collections.sort(adjList[i]);
    }

//    for (int i = 1; i <= node; i++) {
//      System.out.println("> " + i + " adjList = " + adjList[i].toString());
//    }

    visit[start] = true;
    System.out.print(start + " ");
    dfs(start);
    System.out.print("\n");

    visit = new boolean[node + 1];

    bfs(start);
  }

  private static void bfs(int node) {

    Queue<Integer> queue = new LinkedList<>();

    queue.add(node);

    visit[node] = true;

    while (!queue.isEmpty()) {

      Integer poll = queue.poll();
      System.out.print(poll + " ");

      List<Integer> list = adjList[poll];

      for (Integer atom : list) {

        if (!visit[atom]) {

          visit[atom] = true;
          queue.add(atom);
        }

      }

    }


  }

  private static void dfs(int node) {

    List<Integer> list = adjList[node];

    for (Integer t : list) {

      if (!visit[t]) {

        visit[t] = true;
        System.out.print(t + " ");
        dfs(t);
//        visit[t] = false;
      }

    }

  }


}
