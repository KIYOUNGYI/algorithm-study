package com.study.bj.b2021.step1.brute_force.permutation;

import java.util.Scanner;

public class P1248_맞춰봐_v2 {

  static boolean flag = false;
  static String input;
  static char[] inputArr;
  static int[] ans;
  static int n;
  static String[][] s;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    ans = new int[n + 1];
    s = new String[n + 1][n + 1];
    input = scan.next();

    inputArr = (" " + input).toCharArray();
    int idx = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = i; j <= n; j++) {
        s[i][j] = String.valueOf(input.charAt(idx++));
      }
    }
//    printSrr();
    recursion(1);
  }

  private static void recursion(int depth) {

    if (flag) {
      return;
    }

    //depth 2 부턴 체크
    if (depth >= 2) {
      if (!check(depth)) {
        return;
      }
    }
    if (depth == n + 1) {

      printAns();
      flag = true;

      return;
    }

    if (depth == 1) {
      if (inputArr[1] == '+') {

        for (int i = 10; i >= 1; i--) {

          ans[depth] = i;
          recursion(depth + 1);
        }
      }
      if (inputArr[1] == '-') {
        for (int i = 10; i >= 1; i--) {
          ans[depth] = -i;
          recursion(depth + 1);
        }
      }
      if (inputArr[1] == '0') {
        ans[depth] = 0;
        recursion(depth + 1);
      }
    }
    if (depth >= 2) {

      for (int i = 10; i >= 0; i--) {
        ans[depth] = i;
        recursion(depth + 1);
      }
      for (int i = 10; i >= 1; i--) {
        ans[depth] = -i;
        recursion(depth + 1);
      }
    }

  }

  private static boolean check(int depth) {

    for (int k = 1; k <= depth - 1; k++) {

      int start = k;
      int end = depth - 1;
      int tempSum = 0;
      for (int l = start; l <= end; l++) {
        tempSum += ans[l];
      }
//      System.out.println("s[" + k + "][" + (depth - 1) + "] : " + s[k][depth - 1] + "   " + tempSum);
      if (s[k][depth - 1].equals("+") && !(tempSum > 0)) {
        return false;
      } else if (s[k][depth - 1].equals("-") && !(tempSum < 0)) {
        return false;
      } else if (s[k][depth - 1].equals("0") && (tempSum != 0)) {
        return false;
      }
    }
    return true;
  }

  private static boolean check2() {

    for (int i = 1; i <= n; i++) {
      for (int j = i; j <= n; j++) {

        int start = i;
        int end = j;
        int tempSum = 0;
        for (int k = start; k <= end; k++) {
          tempSum += ans[k];
        }
        if (s[start][end].equals("+") && !(tempSum > 0)) {
          return false;
        } else if (s[start][end].equals("-") && !(tempSum < 0)) {
          return false;
        } else if (s[start][end].equals("0") && (tempSum != 0)) {
          return false;
        }
      }
    }

    return true;
  }


  private static void printSrr() {

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (s[i][j] != null) {
          System.out.print(s[i][j] + " ");
        } else {
          System.out.print("n ");
        }
      }
      System.out.println();
    }
  }

  private static void printAns() {
    for (int i = 1; i <= n; i++) {
      System.out.print(ans[i] + " ");
    }
    System.out.println();
  }

}
//[0, -2, 5, -3, 1]