package com.study.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/2156
 * 자료집 참고함, 기억 희미해지면 다시 점화식 써보자
 */

public class P2156 {

  static int n;
  static long[] a, d;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    n = Integer.parseInt(br.readLine());
    a = new long[n + 1];
    d = new long[n + 1];
    for (int i = 1; i <= n; i++) {
      a[i] = Integer.parseInt(br.readLine());
    }
    d[1] = a[1];
    if (n == 1) {
      System.out.println(d[1]);
      return;
    }
    d[2] = a[1] + a[2];
    if (n == 2) {
      System.out.println(d[2]);
      return;
    }

    for (int i = 3; i <= n; i++) {
      d[i] = max(max(d[i - 1], d[i - 2] + a[i]), d[i - 3] + a[i - 1] + a[i]);
    }
    bw.write(d[n]+"\n");
    bw.close();
  }

  public static long max(long x, long y) {
    return x > y ? x : y;
  }
}
