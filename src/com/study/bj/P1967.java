package com.study.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 트리의 지름 https://www.acmicpc.net/problem/1967
 * <p>
 * dfs 로 풀었으니 다음은 bfs 로 풀어본다!
 */
public class P1967 {

  static final int limit = 10020;
  static int[] scoreTable;
  static boolean[] visit;
  static ArrayList<Integer>[] adjacentList;
  static ArrayList<Integer>[] weight;
  static int edge;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    edge = Integer.parseInt(bf.readLine());
    adjacentList = new ArrayList[limit];
    scoreTable = new int[limit];
    weight = new ArrayList[limit];
    visit = new boolean[limit];

    for (int i = 0; i < limit; i++) {
      adjacentList[i] = new ArrayList<Integer>();
      weight[i] = new ArrayList<Integer>();
    }
    for (int i = 0; i < edge - 1; i++) {
      String[] x = bf.readLine().split(" ");
      int[] a = new int[3];
      a[0] = Integer.parseInt(x[0]);
      a[1] = Integer.parseInt(x[1]);
      a[2] = Integer.parseInt(x[2]);
      adjacentList[a[0]].add(a[1]);
      adjacentList[a[1]].add(a[0]);
      weight[a[0]].add(a[2]);
      weight[a[1]].add(a[2]);

    }
//        for(int i=1;i<limit;i++)
//        {
//            if(adjacentList[i].size()!=0)
//            {
//                System.out.println(i+" "+adjacentList[i].toString());
//            }
//        }
    problem();
//        getScoreArr();
  }

  public static void problem() {
    //get distance from root
    scoreTable[1] = 0;
    visit[1] = true;
    dfs(1);
    int[] result = findMax();
//        System.out.println("p:"+result[0]);
//        System.out.println("p-val:"+result[1]);

    for (int i = 0; i < limit; i++) {
      scoreTable[i] = 0;
    }
    for (int i = 0; i < limit; i++) {
      visit[i] = false;
    }

    visit[result[0]] = true;
    scoreTable[result[0]] = 0;
    dfs(result[0]);

    int[] result2 = findMax();
//        System.out.println("p:"+result2[0]);
//        System.out.println("p-val:"+result2[1]);
    System.out.println(result2[1]);

  }

  private static int[] findMax() {
    int max = -1;
    int idx = 0;
    for (int i = 0; i < limit; i++) {
      if (scoreTable[i] > max) {
        max = scoreTable[i];
        idx = i;
      }
    }
    int[] a = new int[2];
    a[0] = idx;
    a[1] = max;
    return a;
  }

  public static void dfs(int node) {
    for (int i = 0; i < adjacentList[node].size(); i++) {
      int pivot = adjacentList[node].get(i);
      if (!visit[pivot]) {
        visit[pivot] = true;
        int point = weight[node].get(i);
        scoreTable[pivot] = scoreTable[node] + point;
        dfs(pivot);
      }
    }
  }

  public static void getScoreArr() {
    for (int i = 1; i < 13; i++) {
      System.out.println(i + " " + scoreTable[i]);
    }
  }
}

