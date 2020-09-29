package com.study.bj;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 트리의 부모 찾기 https://www.acmicpc.net/problem/11725 배열+연결리스트 자료구조를 만든다. 1과 연결된 녀석은 어차피 1이 부모다. 1의 자식을 넣는다. 1의 자식  aaa 자식을 넣을때,이 aaa 자식의 부모가 1임을 마크하고 aaa를 넣고 dfs를 호출한다.
 */

public class P11725 {

  static boolean[] visit = new boolean[100020];
  static int[] parent = new int[100020];
  static ArrayList<Integer>[] arrList;
  static int N;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    N = scan.nextInt();
    arrList = new ArrayList[N + 1];
    for (int i = 0; i <= N; i++) {
      arrList[i] = new ArrayList<>();
    }
    for (int i = 0; i < 100020; i++) {
      visit[i] = false;
    }
    for (int i = 1; i < N; i++) {
      int a = scan.nextInt();
      int b = scan.nextInt();
//            System.out.println(a+" "+b);
      arrList[a].add(b);
      arrList[b].add(a);
    }
//        System.out.println("!!!");
    dfs(1);

    for (int i = 2; i <= N; i++) {
      System.out.println(parent[i]);
    }
  }

  public static void dfs(int pivot) {
//        System.out.println("!!!");
    for (int i = 0; i < arrList[pivot].size(); i++) {
      int temp = arrList[pivot].get(i);
      if (!visit[temp]) {
        visit[temp] = true;
        parent[temp] = pivot;
        dfs(temp);
      }
    }
  }
}
