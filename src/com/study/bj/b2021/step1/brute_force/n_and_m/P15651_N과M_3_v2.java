package com.study.bj.b2021.step1.brute_force.n_and_m;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class P15651_N과M_3_v2 {

  //N -> N 개의 수 4 (1,2,3,4)
  //M -> M 자리 수 2 (1,1)(1,2)(1,3)(1,4)(2,1)(2,2)(2,3)(2,4)
  public static int n, m;
  public static int[] a;
  public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {

    Scanner scan = new Scanner(System.in);

    n = scan.nextInt();
    m = scan.nextInt();
    a = new int[m + 1];

    recursion(1);

    bw.flush();
    bw.close();
  }

  private static void recursion(int depth) throws IOException {

    if (depth == m + 1) {
      printArr();
      return;
    }

    for (int i = 1; i <= n; i++) {
      a[depth] = i;
      recursion(depth + 1);
    }


  }

  private static void printArr() throws IOException {

    for (int i = 1; i <= m; i++) {
      bw.write(a[i] + " ");
    }
    bw.write("\n");
  }
}
