package com.study.bj.b2021.step1.simulation;

import java.util.Scanner;

public class P16917_배열_복원하기 {

  static int h, w, x, y;
  static int[][] input, a, b;
  static int[][] bitMap;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    h = scan.nextInt();
    w = scan.nextInt();
    x = scan.nextInt();
    y = scan.nextInt();
    input = new int[h + x][w + y];
    bitMap = new int[h + x][w + y];
    a = new int[h][w];
    b = new int[h][w];

    //입력
    for (int i = 0; i < h + x; i++) {
      for (int j = 0; j < w + y; j++) {
        input[i][j] = scan.nextInt();
      }
    }

    //마킹
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        bitMap[i][j] += 1;
      }
    }
    for (int i = x; i < h + x; i++) {
      for (int j = y; j < w + y; j++) {
        bitMap[i][j] += 1;
      }
    }
//    System.out.println();
//    printBitMap();

    //a 탐색
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        if (bitMap[i][j] == 1) {
          a[i][j] = input[i][j];
        }
      }
    }

    //2인것 도출
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        if (bitMap[i][j] == 2) {
//          System.out.println("i-x:"+(i-x)+"i-y:"+(i-y));
          a[i][j] = input[i][j] - a[i - x][j - y];
        }
      }
    }

    printA();

  }

  private static void printBitMap() {
    for (int i = 0; i < h + x; i++) {
      for (int j = 0; j < w + y; j++) {
        System.out.print(bitMap[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static void printA() {
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        System.out.print(a[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static void printB() {
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        System.out.print(b[i][j] + " ");
      }
      System.out.println();
    }
  }

}
