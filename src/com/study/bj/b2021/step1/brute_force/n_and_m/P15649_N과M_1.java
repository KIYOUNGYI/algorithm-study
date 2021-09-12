package com.study.bj.b2021.step1.brute_force.n_and_m;

import java.util.Scanner;

public class P15649_N과M_1 {

  //N -> N 개의 수 4 (1,2,3,4)
  //M -> M 자리 수 2 (1,2)(1,3),(1,4)(2,1)(2,3)(2,4)
  public static int N, M;
  public static int[] arr;
  public static boolean[] visit;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    inputAndInit(scan);

    dfs(1);

    scan.close();
  }

  private static void dfs(int depth) {

    if (depth == M + 1) {
      printArr();
      return;
    }

    for (int i = 1; i <= N; i++) {
      if (visit[i] == false) {
        visit[i] = true;
        arr[depth] = i;
        dfs(depth + 1);
        visit[i] = false;
      }
    }

  }

  private static void inputAndInit(Scanner scan) {
    N = scan.nextInt();
    M = scan.nextInt();
    visit = new boolean[N + 1];
    arr = new int[M + 1];
  }


  private static void printArr() {
    int size = arr.length;

    for (int i = 1; i < size; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
}
