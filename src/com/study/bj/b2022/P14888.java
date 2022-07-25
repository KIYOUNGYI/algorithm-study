package com.study.bj.b2022;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 수요일 2022-06-28 시작할 것 (기절함)
 * <p>
 * 06-30 시작
 */
public class P14888 {

  static int[] arr;
  static int n;
  static long max = Long.MIN_VALUE;
  static long min = Long.MAX_VALUE;
  static Scanner scan = new Scanner(System.in);
  static int plus;
  static int minus;
  static int mul;
  static int div;
  static boolean[] visit;
  static int[] giho;
  static int[] tempArr;

  public static void main(String[] args) {

    input();
//    System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
//    System.out.println("Arrays.toString(giho) = " + Arrays.toString(giho));
//    System.out.println("n:"+n);
    solution();

  }

  public static void solution() {

    dfs(0);

    System.out.println(max);
    System.out.println(min);
  }

  public static void calculate() {
    long total = arr[0];
    for (int i = 0; i < tempArr.length; i++) {
      if (tempArr[i] == 1) {
        total = total + arr[i + 1];
      } else if (tempArr[i] == 2) {
        total = total - arr[i + 1];
      } else if (tempArr[i] == 3) {
        total = total * arr[i + 1];
      } else if (tempArr[i] == 4) {
        total = total / arr[i + 1];
      }
    }
    if (max < total) {
      max = total;
    }
    if (min > total) {
      min = total;
    }

  }


  public static void dfs(int depth) {

    if (depth == n - 1) {
      calculate();
      return;
    }

    for (int i = 0; i < tempArr.length; i++) {

      if (!visit[i]) {
        visit[i] = true;
        tempArr[depth] = giho[i];
        dfs(depth + 1);
        visit[i] = false;
        tempArr[depth] = 0;
      }
    }


  }

  private static void input() {

    n = scan.nextInt();
    arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scan.nextInt();
    }

    plus = scan.nextInt();
    minus = scan.nextInt();
    mul = scan.nextInt();
    div = scan.nextInt();

    int t = plus + minus + mul + div;
    visit = new boolean[t];
    giho = new int[t];
    int temp = 0;
    for (int i = 0; i < plus; i++) {
      giho[temp++] = 1;
    }

    for (int i = 0; i < minus; i++) {
      giho[temp++] = 2;
    }

    for (int i = 0; i < mul; i++) {
      giho[temp++] = 3;
    }

    for (int i = 0; i < div; i++) {
      giho[temp++] = 4;
    }

    tempArr = new int[n - 1];
  }

}
