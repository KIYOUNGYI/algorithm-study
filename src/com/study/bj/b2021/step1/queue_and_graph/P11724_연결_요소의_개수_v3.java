package com.study.bj.b2021.step1.queue_and_graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P11724_연결_요소의_개수_v3 {

  static boolean[] v;
  static int node, edge;
  static List<Integer>[] arrList;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    node = scan.nextInt();
    edge = scan.nextInt();

    v = new boolean[node + 1];
    arrList = new ArrayList[node + 1];

    for (int i = 0; i < node + 1; i++) {
      arrList[i] = new ArrayList<Integer>();
    }

    for (int i = 1; i <= edge; i++) {

      int x = scan.nextInt();
      int y = scan.nextInt();

      arrList[x].add(y);
      arrList[y].add(x);

    }

    int cnt = 0;
    for (int i = 1; i <= node; i++) {
      if (!v[i]) {
        dfs(i);
        cnt += 1;
      }
    }
    System.out.println(cnt);
  }

  private static void dfs(int currentNode) {

    List<Integer> integers = arrList[currentNode];
    for (Integer candidate : integers) {
      if (!v[candidate]) {
        v[candidate] = true;
        dfs(candidate);
      }
    }

  }
}
