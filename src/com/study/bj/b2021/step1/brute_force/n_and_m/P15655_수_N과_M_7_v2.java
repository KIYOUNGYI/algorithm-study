package com.study.bj.b2021.step1.brute_force.n_and_m;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class P15655_수_N과_M_7_v2 {

  static int n;
  static int m;
  static int[] a;
  static int[] answer;
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {

    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    m = scan.nextInt();

    a = new int[n + 1];
    answer = new int[m + 1];

    for (int i = 1; i <= n; i++) {
      a[i] = scan.nextInt();
    }
    Arrays.sort(a);
//    System.out.println(Arrays.toString(a));
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
      answer[depth] = a[i];
      recursion(depth + 1);
    }
  }


  private static void printArr() throws IOException {

    for (int i = 1; i <= m; i++) {
      bw.write(answer[i] + " ");
    }
    bw.write("\n");

  }
}
