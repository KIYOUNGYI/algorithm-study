package com.study.bj.b2021.step1.brute_force.n_and_m;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class P15654_N과M_5_v2 {

  static int n;
  static int r;
  static int[] a;
  static int[] ans;
  static boolean[] v;
  static Scanner scan = new Scanner(System.in);
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {

    n = scan.nextInt();
    r = scan.nextInt();

    a = new int[n + 1];
    v = new boolean[n + 1];
    ans = new int[r + 1];

    for (int i = 1; i <= n; i++) {
      a[i] = scan.nextInt();
    }
    Arrays.sort(a);
    recursion(1);
    bw.flush();
    bw.close();
  }

  private static void recursion(int depth) throws IOException {
//    System.out.println("depth = " + depth);
    if (depth == r + 1) {
      printArr();
      return;
    }

    for (int i = 1; i <= n; i++) {

      if (!v[i]) {
        v[i] = true;
        ans[depth] = a[i];
        recursion(depth + 1);
        v[i] = false;
      }
    }

  }

  private static void printArr() throws IOException {

    for (int i = 1; i <= r; i++) {
      bw.write(ans[i] + " ");
    }
    bw.write("\n");
  }


}
