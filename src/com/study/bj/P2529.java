package com.study.bj;

import java.util.Scanner;

/**
 * 부등호
 * https://www.acmicpc.net/problem/2529
 */
public class P2529 {

  static boolean flag = false;
  static int N;
  static int[] arr;
  static char[] giho;
  static boolean[] visit = new boolean[10];

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    N = scan.nextInt();
    giho = new char[N];
    arr = new int[N + 1];
    scan.nextLine();
    String[] inputTemp = scan.nextLine().split(" ");
    for (int i = 0; i < inputTemp.length; i++) {
      giho[i] = inputTemp[i].charAt(0);
    }
    recursive1(0);
    for (int i = 0; i < 10; i++) {
      visit[i] = false;
    }
    flag = false;
    recursive2(0);
  }

  public static void recursive1(int depth) {
    if (flag) {
      return;
    }

    if (depth == N + 1) {
      printArr();
      flag = true;
      return;
    }

    for (int i = 9; i >= 0; i--) {
      if (visit[i] == false) {
        if (depth == 0) {
          visit[i] = true;
          arr[depth] = i;
          recursive1(depth + 1);
          visit[i] = false;
        }
        if (depth >= 1 && giho[depth - 1] == '>' && arr[depth - 1] > i) {
          visit[i] = true;
          arr[depth] = i;
          recursive1(depth + 1);
          visit[i] = false;
        }
        if (depth >= 1 && giho[depth - 1] == '<' && arr[depth - 1] < i) {
          visit[i] = true;
          arr[depth] = i;
          recursive1(depth + 1);
          visit[i] = false;
        }
      }
    }
  }

  public static void recursive2(int depth) {
    if (flag) {
      return;
    }

    if (depth == N + 1) {
      printArr();
      flag = true;
      return;
    }

    for (int i = 0; i <= 9; i++) {
      if (visit[i] == false) {
        if (depth == 0) {
          visit[i] = true;
          arr[depth] = i;
          recursive2(depth + 1);
          visit[i] = false;
        }
        if (depth >= 1 && giho[depth - 1] == '>' && arr[depth - 1] > i) {
          visit[i] = true;
          arr[depth] = i;
          recursive2(depth + 1);
          visit[i] = false;
        }
        if (depth >= 1 && giho[depth - 1] == '<' && arr[depth - 1] < i) {
          visit[i] = true;
          arr[depth] = i;
          recursive2(depth + 1);
          visit[i] = false;
        }
      }
    }
  }

  public static void printArr() {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]);
    }
    System.out.println();
  }
}
