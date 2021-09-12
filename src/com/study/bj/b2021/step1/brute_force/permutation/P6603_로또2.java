package com.study.bj.b2021.step1.brute_force.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P6603_로또2 {


  static int n;
  static int r;
  static int[] bit;
  static int[] a;
  static int[] answer;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    for (; ; ) {
      String s = br.readLine();
      String[] temp = s.split(" ");

      n = Integer.parseInt(temp[0]);
      if (n == 0) {
        return;
      }
      bit = new int[n + 1];
      r = 6;
      a = new int[n + 1];
      for (int i = 1; i < temp.length; i++) {
        a[i] = Integer.parseInt(temp[i]);
      }
      Arrays.sort(a);
      answer = new int[7];

      recursion(1, 0);
      System.out.println();
    }


  }

  private static void recursion(int depth, int v) {

    if (v == r) {
      for (int i = 1; i <= n; i++) {
        if (bit[i] == 1) {
          System.out.print(a[i] + " ");
        }
      }
      System.out.println();
      return;
    }

    if (depth == n + 1) {
      return;
    }

    bit[depth] = 1;
    recursion(depth + 1, v + 1);
    bit[depth] = 0;
    recursion(depth + 1, v);
  }


}
