package com.study.bj.b2021.step1.brute_force.n_and_m;

import java.util.Scanner;

public class P15650_N과M_2_v2 {

  public static int n, m;
  public static int[] arr;
  public static boolean[] visit;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    m = scan.nextInt();
    arr = new int[m + 1];
    visit = new boolean[n + 1];

    recursion(1);


  }

  private static void printArr() {
    for (int i = 1; i <= m; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  private static void recursion(int depth) {

    if (depth == m + 1) {
//      System.out.println(Arrays.toString(arr));
      printArr();
      return;
    }

    if (depth == 1) {
      for (int i = 1; i <= n; i++) {

        if (!visit[i]) {
          visit[i] = true;
          arr[depth] = i;
          recursion(depth + 1);
          visit[i] = false;
        }
      }
    }

    if (depth >= 2) {

      for (int i = 1; i <= n; i++) {

        if (!visit[i] && arr[depth - 1] < i) {
          visit[i] = true;
          arr[depth] = i;
          recursion(depth + 1);
          visit[i] = false;
        }
      }
    }

  }


}
