package com.study.bj.b2021.step1.brute_force.n_and_m;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class P15652_N과M_4_v2 {

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
//      System.out.println(Arrays.toString(a));
      printArr();
      return;
    }

    if (depth == 1) {

      for (int i = 1; i <= n; i++) {
        a[depth] = i;
        recursion(depth + 1);
      }
    }
    if (depth >= 2) {

      for (int i = 1; i <= n; i++) {
        if (a[depth - 1] <= i) {
          a[depth] = i;
          recursion(depth + 1);
        }
      }

    }


  }

  private static void printArr() throws IOException {
    for (int i = 1; i <= m; i++) {
      bw.write(a[i] + " ");
    }
    bw.write("\n");
  }


}
