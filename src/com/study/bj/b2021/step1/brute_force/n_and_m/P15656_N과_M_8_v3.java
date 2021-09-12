package com.study.bj.b2021.step1.brute_force.n_and_m;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class P15656_N과_M_8_v3 {

  static int n;
  static int r;
  static int[] arr;
  static int[] answer;
  static Scanner scan = new Scanner(System.in);
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {

    n = scan.nextInt();
    r = scan.nextInt();
    arr = new int[n + 1];
    answer = new int[r + 1];

    for (int i = 1; i <= n; i++) {
      arr[i] = scan.nextInt();
    }
    Arrays.sort(arr);

    recursion(1);

    bw.flush();
    bw.close();
  }

  private static void recursion(int depth) throws IOException {

    if (depth == r + 1) {
      printArr();
      return;
    }

    if (depth == 1) {
      for (int i = 1; i <= n; i++) {
        answer[depth] = arr[i];
        recursion(depth + 1);
      }
    }

    if (depth >= 2) {
      for (int i = 1; i <= n; i++) {
        if (answer[depth - 1] <= arr[i]) {
          answer[depth] = arr[i];
          recursion(depth + 1);
        }
      }
    }

  }

  private static void printArr() throws IOException {

    for (int i = 1; i <= r; i++) {
      bw.write(answer[i] + " ");
    }
    bw.write("\n");

  }


}
