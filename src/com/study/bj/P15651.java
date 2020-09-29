package com.study.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * N과 M (3) https://www.acmicpc.net/problem/15651
 */
public class P15651 {

  static int N, M;//4 2
  static int[] arr;
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = scan.nextInt();
    M = scan.nextInt();

    arr = new int[M];
    recursive(0);
    bw.close();
    scan.close();
  }

  public static void recursive(int depth) throws IOException {
    StringBuilder sb = new StringBuilder();
    if (depth == M) {
      for (int i = 0; i < M; i++) {
        bw.write(arr[i] + " ");
      }
      bw.write("\n");
      return;
    }

    for (int i = 1; i <= N; i++) {
      arr[depth] = i;
      recursive(depth + 1);
    }
  }
}
