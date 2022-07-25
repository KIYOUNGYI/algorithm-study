package com.study.bj.b2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * N-QUEEN 문제
 * <p>
 * N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.
 * <p>
 * N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.
 * <p>
 * [입력] 첫째 줄에 N이 주어진다. (1 ≤ N < 15)
 * <p>
 * [출력] 첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.
 */
public class P9663Wrong {

  static int[][] table;
  //  static boolean[][] visit;
  static int n;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    String s = br.readLine();
    String[] s1 = s.split(" ");
    n = Integer.parseInt(s1[0]);

    table = new int[n][n];
    int t = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.println("진입점 " + "i:" + i + " j:" + j);
        t += count(i, j);
      }
      System.out.println("=---");
    }
    System.out.println(t / n);
  }

  public static int count(int i, int j) {
    int total = n * n;

    int cnt = 0;
    for (int a = j + 1; a < n; a++) {
      System.out.println("[" + i + " " + a + "]");
      cnt += 1;
    }

    for (int a = j - 1; a >= 0; a--) {
      System.out.println("[" + i + " " + a + "]");
      cnt += 1;
    }

    int i1 = i;
    int j1 = j;
    for (int a = j + 1; a < n; a++) {
      i1 += 1;
      j1 += 1;
      if (i1 < n && j1 < n) {
        System.out.println("[" + i1 + " " + j1 + "]");
        cnt += 1;
      } else {
        break;
      }
    }

    int i2 = i;
    int j2 = j;
    for (int a = j - 1; a >= n; a--) {
      i2 -= 1;
      j2 -= 1;
      if (i2 >= 0 && j2 >= 0) {
        System.out.println("[" + i2 + " " + j2 + "]");
        cnt += 1;
      } else {
        break;
      }
    }

    int i3 = i;
    int j3 = j;
    for (int x = 0; x < n; x++) {
      i3 -= 1;
      j3 += 1;
      if (i3 >= 0 && j3 >= 0 && i3 < n && j3 < n) {
        System.out.println("[" + i3 + " " + j3 + "]");
        cnt += 1;
      } else {
        break;
      }
    }

    int i4 = i;
    int j4 = j;
    for (int x = 0; x < n; x++) {

      i4 += 1;
      j4 -= 1;
      if (i4 >= 0 && j4 >= 0 && i4 < n && j4 < n) {
        System.out.println("[" + i4 + " " + j4 + "]");
        cnt += 1;
      } else {
        break;
      }
    }

    System.out.println("나랑 안겹치는 개수 : "+(total-cnt));

    return total - cnt;
  }
}
