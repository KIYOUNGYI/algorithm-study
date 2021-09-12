package com.study.bj.b2021.step1.brute_force.n_and_m;

import java.util.Scanner;

public class P15650_N과M_2 {

  public static int N, M;
  public static int[] arr;
  public static boolean[] visit;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    inputAndInit(scan);

    dfs(1, 1);


  }

  private static void dfs(int depth, int start) {

    if (depth == M + 1) {
      printArr();
      return;
    }

    for (int i = start; i <= N; i++) {
      if (visit[i] == false) {

        if (i >= start) {

          visit[i] = true;
          arr[depth] = i;
          dfs(depth + 1, i);
          visit[i] = false;
        }
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
