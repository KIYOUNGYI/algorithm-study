package com.study.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 수 정렬하기 2 https://www.acmicpc.net/problem/2751 https://www.acmicpc.net/board/view/31887 scanner 로 입력받으면 폭발한다. 알고리즘 자체는 맞는데 배열 크기 할당이라든가 입력방식이라든가 신경써야 한다.
 */
public class P2751 {

  static int n;
  static int[] arr = new int[1000020], temp = new int[1000020];

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(bf.readLine()); //Int
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(bf.readLine());
    }
    mergeSort(0, n - 1);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      sb.append(arr[i] + "\n");
    }
    System.out.println(sb.toString());
  }

  public static void mergeSort(int s, int e) {
    if (s >= e) {
      return;
    }
    int m = (s + e) / 2;
    mergeSort(s, m);
    mergeSort(m + 1, e);
    merging(s, m, m + 1, e);

  }

  public static void merging(int s1, int e1, int s2, int e2) {
    int p = s1;
    int q = s2;
    int tempIdx = 0;
    while (p <= e1 && q <= e2) {
      if (arr[p] <= arr[q]) {
        temp[tempIdx++] = arr[p++];
      } else {
        temp[tempIdx++] = arr[q++];
      }
    }
    if (p > e1) {
      for (int i = q; i <= e2; i++) {
        temp[tempIdx++] = arr[i];
      }
    }
    if (q > e2) {
      for (int i = p; i <= e1; i++) {
        temp[tempIdx++] = arr[i];
      }
    }
    for (int i = s1; i <= e2; i++) {
      arr[i] = temp[i - s1];//temp[0]부터 fill 했자나 ~~~
    }

  }

}
