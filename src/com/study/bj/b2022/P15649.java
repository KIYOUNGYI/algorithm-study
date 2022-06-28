package com.study.bj.b2022;

import java.io.IOException;
import java.util.Scanner;

/**
 * 난이도 2라는데?
 *
 * 중복 허용하지 않는 나열 문제
 */
public class P15649 {

  public static int n, m;
  public static int[] selected;
  public static boolean[] visited;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(System.in);

    n = scan.nextInt();//3
    m = scan.nextInt();//1
    selected = new int[m];
    visited = new boolean[n + 1];

    recursion(0);
    System.out.println(sb.toString());
  }

  public static void recursion(int depth) {

    if (depth == m) {

      for (int i = 0; i < m; i++) {
        sb.append(selected[i] + " ");
      }
      sb.append("\n");

      return;
    }

    for (int i = 1; i <= n; i++) {
      if (!visited[i]) {
        visited[i] = true;
        selected[depth] = i;
        recursion(depth + 1);
        visited[i] = false;
        selected[depth] = 0;
      }
    }
  }
}
