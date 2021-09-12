package com.study.bj.b2021.step1.brute_force.permutation;

import java.util.Scanner;

public class P10971_외판원_순회_2 {

  static int ANSWER = Integer.MAX_VALUE;
  static Scanner scan = new Scanner(System.in);
  static int n;
  static int[][] arr;
  static int[] mark;
  static boolean[] visit;

  public static void main(String[] args) {

    inputAndInit();

    dfs(1);
    System.out.println(ANSWER);
  }

  private static void dfs(int depth) {
    //base case
    if (depth == n + 1) {
//      System.out.println(Arrays.toString(mark));
      sum();
      return;
    }

    for (int i = 1; i <= n; i++) {
      if (!visit[i]) {
        visit[i] = true;
        mark[depth] = i;
        dfs(depth + 1);
        visit[i] = false;
      }
    }
  }

  private static void sum() {
    int sum = 0;
    for (int i = 1; i <= n - 1; i++) {
      int t1 = mark[i];
      int t2 = mark[i + 1];
//      System.out.print(arr[t1][t2]+" ");
      if(arr[t1][t2]==0){
        return;
      }

      sum += arr[t1][t2];


    }
//    System.out.println();

    int t = arr[mark[n]][mark[1]];
    if (t != 0) {
      sum += t;
    }
    else {
      return;
    }
//    System.out.println("sum="+sum);
    if (sum < ANSWER) {
      ANSWER = sum;
    }
  }

  private static void inputAndInit() {
    n = scan.nextInt();
    arr = new int[n + 1][n + 1];
    visit = new boolean[n + 1];
    mark = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        arr[i][j] = scan.nextInt();
      }
    }
  }
}


