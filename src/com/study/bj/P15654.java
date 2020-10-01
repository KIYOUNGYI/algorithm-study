package com.study.bj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * N과 M (5)
 * https://www.acmicpc.net/problem/15654
 */
public class P15654 {

  static boolean[] visit;
  static int[] arr;
  static int[] temp;
  static int n;
  static int r;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    r = scan.nextInt();
    arr = new int[n];
    temp = new int[r];
    visit = new boolean[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scan.nextInt();
    }
    Arrays.sort(arr);
    recursive(0);
    scan.close();
  }

  public static void recursive(int depth) {
    if (depth == r) {
      for (int i = 0; i < temp.length; i++) {
        System.out.print(temp[i] + " ");
      }
      System.out.println();
      return;
    }

    for (int i = 0; i < arr.length; i++) {
      if (!visit[i]) {
        visit[i] = true;
        temp[depth] = arr[i];
        recursive(depth + 1);
        visit[i] = false;
      }
    }
  }
}
