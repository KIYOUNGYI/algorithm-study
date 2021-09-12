package com.study.bj.b2021.step1.brute_force.permutation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class P10974_v2 {

  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int n;
  static boolean[] v;
  static int[] a;

  public static void main(String[] args) throws IOException {

    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    v = new boolean[n + 1];
    a = new int[n + 1];

    recursion(1);

    bw.flush();
    bw.close();
  }

  private static void recursion(int depth) throws IOException {

    //base case
    if (depth == n + 1) {
      printArr();
//      System.out.println(Arrays.toString(a));
      return;
    }

    for (int i = 1; i <= n; i++) {
      if (!v[i]) {
        v[i] = true;
        a[depth] = i;
        recursion(depth + 1);
        v[i] = false;
//        a[depth] = 0;
      }
    }
  }

  private static void printArr() throws IOException {
    for (int i = 1; i <= n; i++) {
      bw.write(a[i] + " ");
    }
    bw.write("\n");
  }

}
