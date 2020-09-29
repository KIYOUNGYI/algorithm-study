package com.study.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 오르막길
 * https://www.acmicpc.net/problem/2846
 */
public class P2846 {

  static int MAX = 0;
  static int[] arr;
  static int[] sum;
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    arr = new int[N];
    sum = new int[N];
    String[] temp = br.readLine().split(" ");
      for (int i = 0; i < N; i++) {
          arr[i] = Integer.parseInt(temp[i]);
      }
//        System.out.println(Arrays.toString(arr));

    sum[0] = 0;
    for (int i = 1; i < N; i++) {
      if (arr[i - 1] < arr[i]) {
        sum[i] = sum[i - 1] + (arr[i] - arr[i - 1]);
          if (MAX < sum[i]) {
              MAX = sum[i];
          }
      } else {
        sum[i] = 0;
      }
    }
    System.out.println(MAX);
  }
}
