package com.study.bj.b2021.step1.queue_and_graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//모든 시작점에서 검사를 해야한다.
//이분 그래프의 정의에는 모두 다 연결되어야 하는 것은 없습니다.
//그냥 두개로 나눌 수 있고, 두개 사이에 간선이 있고, 그리고 그 안에는 간선이 있으면 안된다라는 조건만 만족하면 되는거여서...
public class P1707_이분그래프 {

  static boolean flag = true;
  static int[] color;
  static int t;
  static int node, edge;
  static ArrayList<Integer>[] arrList;
  static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {

    t = scan.nextInt();
    for (int i = 1; i <= t; i++) {

      flag = true;
      node = scan.nextInt();
      edge = scan.nextInt();
      arrList = new ArrayList[node + 1];
      color = new int[node + 1];
      for (int a = 0; a < node + 1; a++) {
        arrList[a] = new ArrayList<>();
      }
      for (int j = 1; j <= edge; j++) {
        int x = scan.nextInt();
        int y = scan.nextInt();
        arrList[x].add(y);
        arrList[y].add(x);
      }
      for (int a = 0; a < node + 1; a++) {
        Collections.sort(arrList[a]);
      }

      for (int x = 1; x <= node; x++) {
        if (color[x] == 0) {
          dfs(x);
        }
      }

      if (flag) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }

  }

  private static void dfs(int node) {

    int nodeColor = color[node];
    ArrayList<Integer> tempList = arrList[node];

    for (int i = 0; i < tempList.size(); i++) {

      int candidateNode = tempList.get(i);

      if (color[candidateNode] == 0) {
        color[candidateNode] = nodeColor == 1 ? 2 : 1;
        dfs(candidateNode);

      } else {
        if (nodeColor == color[candidateNode]) {
          flag = false;
          return;
        }
      }
    }

  }

  private static void printArr() {

    for (int i = 1; i <= node; i++) {
      System.out.println("node:" + i + " : " + arrList[i].toString());
    }
  }


}
