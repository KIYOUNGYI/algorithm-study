package com.study.bj.b2021.step1.brute_force.recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2529_부등호 {

  static boolean smallFlag = false;
  static boolean bigFlag = false;

  static String[] arr;
  static int[] numberArr;
  static boolean[] visit = new boolean[10];

  static int n;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {

    String numberStr = br.readLine();
    n = Integer.parseInt(numberStr);

    String arrowStrInput = br.readLine();
    arr = arrowStrInput.split(" ");
    numberArr = new int[n + 1];

    big(0);
    visit = new boolean[10];
    numberArr = new int[n + 1];
    small(0);

  }

  private static void small(int depth) {

    if (smallFlag) {
      return;
    }

    if (depth == n + 1) {
      printArr();
      smallFlag = true;
      return;
    }

    for (int i = 0; i < 10; i++) {

      if (depth == 0) {
        if (!visit[i]) {
          visit[i] = true;
          numberArr[depth] = i;

          small(depth + 1);
          visit[i] = false;
        }
      }
      if (depth >= 1) {

        if (arr[depth - 1].equals(">")) {
          if (numberArr[depth - 1] > i && !visit[i]) {
            numberArr[depth] = i;
            visit[i] = true;
            small(depth + 1);
            visit[i] = false;
          }
        }

        if (arr[depth - 1].equals("<")) {//<
          if (numberArr[depth - 1] < i && !visit[i]) {
            numberArr[depth] = i;
            visit[i] = true;
            small(depth + 1);
            visit[i] = false;
          }
        }
      }
    }
  }


  private static void big(int depth) {

    if (bigFlag) {
      return;
    }

    if (depth == n + 1) {
      printArr();
      bigFlag = true;
      return;
    }

    for (int i = 9; i >= 0; i--) {

      if (depth == 0) {
        if (!visit[i]) {
          visit[i] = true;
          numberArr[depth] = i;

          big(depth + 1);
          visit[i] = false;
        }
      }
      if (depth >= 1) {

        if (arr[depth - 1].equals(">")) {
          if (numberArr[depth - 1] > i && !visit[i]) {
            numberArr[depth] = i;
            visit[i] = true;
            big(depth + 1);
            visit[i] = false;
          }
        }

        if (arr[depth - 1].equals("<")) {//<
          if (numberArr[depth - 1] < i && !visit[i]) {
            numberArr[depth] = i;
            visit[i] = true;
            big(depth + 1);
            visit[i] = false;
          }
        }
      }
    }
  }

  private static void printArr() {
    for (int i = 0; i < numberArr.length; i++) {
      System.out.print(numberArr[i]);
    }
    System.out.println();
  }

}
