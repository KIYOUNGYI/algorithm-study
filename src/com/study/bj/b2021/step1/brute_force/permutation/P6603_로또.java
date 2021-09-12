package com.study.bj.b2021.step1.brute_force.permutation;

import java.util.Arrays;
import java.util.Scanner;

public class P6603_로또 {

  static int[] input;
  static int[] display;
  static boolean[] visit;
  static int n;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    for (; ; ) {

      n = scan.nextInt();

      if (n == 0) {
        return;
      }

      //init
      input = new int[n];
      display = new int[6];
      visit = new boolean[n];

      //input
      for (int j = 0; j < n; j++) {
        input[j] = scan.nextInt();
      }
      Arrays.sort(input);
      dfs(0);
      System.out.println();
    }

  }

  private static void dfs(int depth) {

    if (depth == 6 && display[5] > display[4]) {
      print();
      return;
    }

    if (depth >= 2 && display[depth - 2] > display[depth - 1]) {
      return;
    }

    for (int i = depth; i < n; i++) {

      if (!visit[i]) {
        visit[i] = true;
        display[depth] = input[i];
        dfs(depth + 1);
        display[depth] = 0;
        visit[i] = false;
      }

    }
  }

  private static void print() {

    for (int i = 0; i < 6; i++) {
      System.out.print(display[i] + " ");
    }
    System.out.println();
  }
}
