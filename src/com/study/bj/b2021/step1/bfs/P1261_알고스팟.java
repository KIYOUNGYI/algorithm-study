package com.study.bj.b2021.step1.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 반례를 생각했어야 하는데...
 */
public class P1261_알고스팟 {

  static int sero, garo;
  static int[][] arr;
  static int[][] score;

  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    inputAndInit();

    solution();

//    printArr();

  }

  private static void solution() {

    for (int i = 2; i <= sero; i++) {
      if (arr[i][1] == 1) {
        score[i][1] = score[i - 1][1] + 1;
      } else {
        score[i][1] = score[i - 1][1];
      }
    }

    for (int i = 2; i <= garo; i++) {
      if (arr[1][i] == 1) {
        score[1][i] = score[1][i - 1] + 1;
      } else {
        score[1][i] = score[1][i - 1];
      }
    }

    for (int i = 2; i <= sero; i++) {
      for (int j = 2; j <= garo; j++) {

        if (arr[i][j] == 1) {
          score[i][j] = min(score[i - 1][j], score[i][j - 1]) + 1;
        } else if (arr[i][j] == 0) {
          score[i][j] = min(score[i - 1][j], score[i][j - 1]);
        }

      }
    }

    printScore();
    printAnswer();
  }

  private static void printAnswer() {
    System.out.println(score[sero][garo]);
  }

  private static void inputAndInit() throws IOException {

    String tempInput = br.readLine();
    String[] tempStr = tempInput.split(" ");

    garo = Integer.parseInt(tempStr[0]);
    sero = Integer.parseInt(tempStr[1]);

    arr = new int[sero + 2][garo + 2];
    score = new int[sero + 2][garo + 2];

    for (int i = 1; i <= sero; i++) {
      String input = br.readLine();
      for (int j = 0; j < input.length(); j++) {
        arr[i][j + 1] = Integer.parseInt(String.valueOf(input.charAt(j)));
      }
    }
  }

  public static void printArr() {

    for (int i = 1; i <= sero; i++) {
      for (int j = 1; j <= garo; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void printScore() {

    for (int i = 1; i <= sero; i++) {
      for (int j = 1; j <= garo; j++) {
        System.out.print(score[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static int min(int a, int b) {
    return a >= b ? b : a;
  }
}

//반례
//5 5
//00000
//11100
//00000
//01111
//00000