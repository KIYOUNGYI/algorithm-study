package com.study.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * [수 찾기]
 * https://www.acmicpc.net/problem/1920
 */
public class P1920 {

  static int[] arr, brr;
  static int n, q;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    arr = new int[n];
    String[] temp = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(temp[i]);
    }
    q = Integer.parseInt(br.readLine());
    brr = new int[q];
    temp = br.readLine().split(" ");
    for (int i = 0; i < q; i++) {
      brr[i] = Integer.parseInt(temp[i]);
    }
    Arrays.sort(arr);
    for (int i = 0; i < q; i++) {
      bSearch(brr[i]);
    }
  }

  private static void bSearch(int x) {
    //경계값 처리
    if (x < arr[0] || arr[arr.length - 1] < x) {
//      System.out.println("!!!");
      System.out.println("0");
      return;
    }
    if (x == arr[0] || x == arr[arr.length - 1]) {
      System.out.println("1");
      return;
    }
    int s = 0;
    int e = arr.length - 1;
    int m;
    while (s + 1 < e) {
      m = (s + e) / 2;
      if (arr[m] == x) {
        System.out.println("1");
        return;
      } else if (arr[m] < x) {
        s = m;
      } else {
        e = m;
      }
    }
    System.out.println("0");
  }

}
