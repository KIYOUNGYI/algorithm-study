package com.study.bj;

import java.util.Scanner;

/**
 * 연산자 끼워넣기 https://www.acmicpc.net/problem/14888
 */
public class P14888 {

  static int MAXVAL = Integer.MIN_VALUE;
  static int MINVAL = Integer.MAX_VALUE;
  static int N;
  static int[] arr;
  static int[] gihoInput;
  static boolean[] visit;
  static int[] gihoReal;
  static int gihoArrLen;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    N = scan.nextInt();
    arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = scan.nextInt();
    }

    int a = scan.nextInt();
    int b = scan.nextInt();
    int c = scan.nextInt();
    int d = scan.nextInt();
    gihoArrLen = a + b + c + d;
    gihoInput = new int[gihoArrLen];
    visit = new boolean[gihoArrLen];
    gihoReal = new int[gihoArrLen];
    int idx = 0;
    for (int i = 0; i < a; i++) {
      gihoInput[idx++] = 1;
    }//+
    for (int i = 0; i < b; i++) {
      gihoInput[idx++] = 2;
    }//-
    for (int i = 0; i < c; i++) {
      gihoInput[idx++] = 3;
    }//*
    for (int i = 0; i < d; i++) {
      gihoInput[idx++] = 4;
    }//(division)
//        System.out.println("[G] : "+Arrays.toString(gihoInput));
    recursive(0);
    System.out.println(MAXVAL);
    System.out.println(MINVAL);
    scan.close();
  }

  public static void recursive(int depth) {
    if (depth == gihoArrLen) {
//            System.out.println(Arrays.toString(gihoReal));
      calculate();
      return;
    }

    for (int i = 0; i < gihoArrLen; i++) {
      if (!visit[i]) {
        visit[i] = true;
        gihoReal[depth] = gihoInput[i];
        recursive(depth + 1);
        visit[i] = false;
      }
    }
  }

  public static void calculate() {
    int total = arr[0];
    for (int i = 0; i < gihoReal.length; i++) {
      int t = gihoReal[i];
      if (t == 1) {
        total = total + arr[i + 1];
      } else if (t == 2) {
        total = total - arr[i + 1];
      } else if (t == 3) {
        total = total * arr[i + 1];
      } else if (t == 4) {
        total = total / arr[i + 1];
      }
    }
    if (total > MAXVAL) {
      MAXVAL = total;
    }
    if (total < MINVAL) {
      MINVAL = total;
    }

  }

}
