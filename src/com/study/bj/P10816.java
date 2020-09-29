package com.study.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 숫자 카드 2 https://www.acmicpc.net/problem/10816
 */
public class P10816 {

  static long[] plusArr = new long[10000020];
  static long[] minusArr = new long[10000020];

  public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    // StringTokenizer 객체 선언
    StringTokenizer st = null;
    int N = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int a = Integer.parseInt(st.nextToken());
      if (a >= 0) {
        plusArr[a] += 1;
      } else {
        minusArr[abs(a)] += 1;
      }
    }
    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < M; i++) {
      int a = Integer.parseInt(st.nextToken());
      if (a >= 0) {
        if (i == M - 1) {
          sb.append(plusArr[a]);
        } else {
          sb.append(plusArr[a] + " ");
        }
      } else {
        if (i == M - 1) {
          sb.append(minusArr[abs(a)]);
        } else {
          sb.append(minusArr[abs(a)] + " ");
        }
      }
    }
    System.out.println(sb.toString());
  }

  public static int abs(int x) {
    if (x > 0) {
      return x;
    } else {
      return -x;
    }
  }
}
