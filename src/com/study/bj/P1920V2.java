package com.study.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 */
public class P1920V2 {

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
    int s = 0, e = arr.length - 1;

    while (s <= e) {
      int m = (s + e) / 2;
      if (arr[m] == x) {
        System.out.println(1);
        return;
      } else if (arr[m] < x) {
        s = m + 1;
      } else if (arr[m] > x) {
        e = m - 1;
      }
    }
    System.out.println(0);
  }
}
