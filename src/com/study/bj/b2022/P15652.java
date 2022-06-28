package com.study.bj.b2022;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * 난이도 2라는데?
 * 중복_허용 문제
 */
public class P15652 {

  public static int n, m;
  public static int[] selected;
  public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {

    Scanner scan = new Scanner(System.in);

    n = scan.nextInt();//3
    m = scan.nextInt();//1
    selected = new int[m];

    recursion(0);
    bw.flush();
    bw.close();
    ;
  }

  public static void recursion(int depth) throws IOException {

    if (depth == m) {
      printArr();
      return;
    }

    if (depth == 0) {
      for (int i = 1; i <= n; i++) {
        selected[depth] = i;
        recursion(depth + 1);
      }

    } else {
      for (int i = 1; i <= n; i++) {
        if (selected[depth - 1] <= i) {
          selected[depth] = i;
          recursion(depth + 1);
        }
      }

    }

  }

  private static void printArr() throws IOException {

    for (int i = 0; i < m; i++) {
      bw.write(selected[i] + " ");
    }
    bw.write("\n");
  }
}
