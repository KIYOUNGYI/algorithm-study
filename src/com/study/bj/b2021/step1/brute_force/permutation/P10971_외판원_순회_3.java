package com.study.bj.b2021.step1.brute_force.permutation;

import java.util.Scanner;

public class P10971_외판원_순회_3 {

  static int n;
  static int[][] a;
  static boolean[] v;
  static int[] ans;
  static int min = Integer.MAX_VALUE;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    a = new int[n + 1][n + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        a[i][j] = scan.nextInt();
      }
    }
    ans = new int[n + 1];
    v = new boolean[n + 1];
    recursion(1);
    System.out.println(min);
  }

  private static void recursion(int depth) {

    if (depth == n + 1) {
//      System.out.println(Arrays.toString(ans)+" min:"+min);
      check();

      return;
    }

    for (int i = 1; i <= n; i++) {
      if (!v[i]) {
        v[i] = true;
        ans[depth] = i;
        recursion(depth + 1);
        v[i] = false;
      }
    }
  }

  private static void check() {

    int s = ans[1];
    int e = ans[n];
    if (a[e][s] == 0) {
      return;
    }
    int sum = 0;
    for (int i = 1; i < n; i++) {
      int x = ans[i];
      int y = ans[i + 1];
//      System.out.println("["+x+"]["+y+"]");
      if (a[x][y] == 0) {
        return;
      }
      sum += a[x][y];

    }
    sum += a[e][s];
    if (sum < min) {
      min = sum;
    }
  }
}
