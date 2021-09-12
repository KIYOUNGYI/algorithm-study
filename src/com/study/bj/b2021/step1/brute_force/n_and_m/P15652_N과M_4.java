package com.study.bj.b2021.step1.brute_force.n_and_m;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class P15652_N과M_4 {

  public static int N, M;
  public static int[] arr;
  public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


  public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(System.in);
    inputAndInit(scan);

    dfs(1, 1);

    bw.flush();
    bw.close();
  }

  private static void dfs(int depth, int value) throws IOException {

    if (depth == M + 1) {
      printArr();
      return;
    }

    for (int i = value; i <= N; i++) {
      arr[depth] = i;
      dfs(depth + 1, i);
    }

  }

  private static void inputAndInit(Scanner scan) {
    N = scan.nextInt();
    M = scan.nextInt();
    arr = new int[M + 1];
  }


  private static void printArr() throws IOException {
    int size = arr.length;
    StringBuilder sb = new StringBuilder();

    for (int i = 1; i < size; i++) {
//      System.out.print(arr[i] + " ");
      sb.append(arr[i] + " ");
    }
    bw.write(sb.toString() + "\n");
  }

}
