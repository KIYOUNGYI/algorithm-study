package com.study.bj.b2021.step1.simulation;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayShift {

  /**
   * 10 1 2 3 4 5 6 7 8 9 10
   *
   * @param args
   */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scan.nextInt();
    }

    leftShift(arr, 1);
    rightShift(arr, 1);
  }

  private static void rightShift(int[] arr, int cnt) {
    int[] temp = new int[arr.length];

    for (int i = 0; i < arr.length; i++) {
      temp[(i + cnt) % arr.length] = arr[i];
    }

    System.out.println(Arrays.toString(temp));
  }

  private static void leftShift(int[] arr, int cnt) {

    int[] temp = new int[arr.length];

    for (int i = 0; i < arr.length; i++) {
      temp[i] = arr[(i + cnt) % arr.length];
    }
    System.out.println(Arrays.toString(temp));

  }
}
