package com.study.bj;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1676 팩토리얼 0의 개수
 */
public class P1676 {

  static int[] arr = new int[550];

  public static void main(String[] args) {
    init();
//        printArr();
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    int result = 0;
    for (int i = 0; i <= N; i++) {
      result += arr[i];
    }
    System.out.println(result);
  }

  public static void init() {
    for (int i = 1; i <= 500; i++) {
      fiveCnt(i);
    }
  }

  public static void fiveCnt(int x) {
    int temp = x;

    if (x % 5 != 0) {
      arr[x] = 0;
      return;
    }
    int cnt = 0;
    int remain = 0;
    while (true) {
      if (remain == 0) {
        x = x / 5;
        remain = x % 5;
        cnt += 1;
      }
      if (remain != 0) {
        arr[temp] = cnt;
        break;
      }
    }
  }

  public static void printArr() {
    for (int i = 0; i <= 500; i++) {
      System.out.println(i + " " + arr[i]);
    }
  }

}
