package com.study.bj;


import java.util.Scanner;

/**
 * GCD 합
 * https://www.acmicpc.net/problem/9613
 */
public class P9613 {

  static int loop;
  static int[] arr;
  static int size;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    loop = scan.nextInt();
    for (int i = 0; i < loop; i++) {
      size = scan.nextInt();
      arr = new int[size];
      for (int j = 0; j < size; j++) {
        arr[j] = scan.nextInt();
      }
      solution();
    }
  }

  public static void solution() {
    Long sum = 0l;
    for (int i = 0; i < size - 1; i++) {
      int pivot = arr[i];
      for (int j = i + 1; j < size; j++) {
        int std = arr[j];
        sum += gcd(pivot, std);
      }
    }
    System.out.println(sum);
  }

  private static int gcd(int x, int y) {
    int a = 0;
    int b = 0;
    int m = 0;
    int r = 0;
    if (x >= y) {
      a = x;
      b = y;
    } else {
      a = y;
      b = x;
    }
    while (true) {
      m = a / b;
      r = a % b;
        if (r == 0) {
            break;
        }
      a = b;
      b = r;
    }
    return b;
  }

}
