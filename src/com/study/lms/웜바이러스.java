package com.study.lms;

import java.util.ArrayList;
import java.util.Scanner;

public class 웜바이러스 {

  public static int n;
  public static int m;
  public static ArrayList<Integer>[] g;
  public static boolean[] v;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    input(scan);
    v[1] = true;
    dfs(1);
    result();
    scan.close();
  }

  public static void input(Scanner scan) {
    n = scan.nextInt();
    m = scan.nextInt();
    g = new ArrayList[n + 1];
    v = new boolean[n + 1];
    for (int i = 0; i <= n; i++) {
      g[i] = new ArrayList();
    }
    for (int i = 1; i <= m; i++) {
      int x = scan.nextInt();
      int y = scan.nextInt();
      g[x].add(y);
      g[y].add(x);
    }
  }

  public static void result() {
    int cnt = 0;
    for (int i = 2; i <= n; i++) {
      if (v[i] == true) {
        cnt += 1;
      }
    }
    System.out.println(cnt);
  }

  public static void dfs(int x) {
    for (int i = 0; i < g[x].size(); i++) {
      int t = g[x].get(i);
      if (!v[t]) {
        v[t] = true;
        dfs(t);
      }
    }
  }
}