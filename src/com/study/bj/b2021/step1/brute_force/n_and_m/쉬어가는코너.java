package com.study.bj.b2021.step1.brute_force.n_and_m;

import java.util.ArrayList;

public class 쉬어가는코너 {

  public static ArrayList<Integer> arrList = new ArrayList();
  public static int n = 3;
  public static int cnt = 0;
  public static int total = 5;

  public static void main(String[] args) {

    dfs(0, 1);
  }

  private static void dfs(int depth, int v) {

    if (depth == n) {
      System.out.println(arrList.toString());
      cnt += 1;
      return;
    } else if (v == total + 1) {
      return;
    }

    arrList.add(v);
    dfs(depth + 1, v + 1);
    int len = arrList.size();
    arrList.remove(len - 1);
    dfs(depth, v + 1);
  }


}
