package com.study.bj.b2021.step1.dynamic_programming.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1149_RGB거리 {

  static int N;
  static int[][] arr;
  static int[][] sum;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    N = Integer.parseInt(br.readLine());
    arr = new int[N + 1][3];
    sum = new int[N + 1][3];
    for (int i = 1; i <= N; i++) {
      String temp = br.readLine();
      String[] input = temp.split(" ");
      arr[i][0] = Integer.parseInt(input[0]);
      arr[i][1] = Integer.parseInt(input[1]);
      arr[i][2] = Integer.parseInt(input[2]);

    }

    sum[1][0] = arr[1][0];
    sum[1][1] = arr[1][1];
    sum[1][2] = arr[1][2];

    for (int i = 2; i <= N; i++) {
      sum[i][0] = arr[i][0] + min(sum[i - 1][1], sum[i - 1][2]);
      sum[i][1] = arr[i][1] + min(sum[i - 1][0], sum[i - 1][2]);
      sum[i][2] = arr[i][2] + min(sum[i - 1][0], sum[i - 1][1]);
    }

    int t = min(min(sum[N][0], sum[N][1]), sum[N][2]);
    System.out.println(t);
  }


  private static int min(int a, int b) {
    return a > b ? b : a;
  }
}
