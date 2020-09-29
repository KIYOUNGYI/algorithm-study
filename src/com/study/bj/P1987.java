package com.study.bj;

import java.util.Scanner;

/**
 * 알파벳 https://acmicpc.net/problem/1987
 */
public class P1987 {

  static int[] dx = new int[]{0, 1, 0, -1};
  static int[] dy = new int[]{1, 0, -1, 0};
  static int sero, garo;
  static int[][] arr;
  static boolean[] visit = new boolean[100];
  static int cnt = 0;
  static int max = 0;

  public static void main(String[] args) {
//        System.out.println((int)'A');//65
//        System.out.println((int)'Z');//90
    Scanner scan = new Scanner(System.in);
    sero = scan.nextInt();
    garo = scan.nextInt();
    arr = new int[sero][garo];
    scan.nextLine();
    for (int i = 0; i < sero; i++) {
      String temp = scan.nextLine();
      for (int j = 0; j < garo; j++) {
        arr[i][j] = temp.charAt(j);
      }
    }
    visit[arr[0][0]] = true;
    cnt += 1;
    recursive(0, 0);
    System.out.println(max);
    scan.close();
  }

  private static void recursive(int x, int y) {
    if (max < cnt) {
      max = cnt;
    }

    for (int i = 0; i < 4; i++) {
      int tx = x + dx[i];
      int ty = y + dy[i];

      if (tx >= 0 && tx < sero && ty >= 0 && ty < garo && visit[arr[tx][ty]] == false) {
//                System.out.println(tx+" "+ty);
        visit[arr[tx][ty]] = true;
        cnt += 1;
        recursive(tx, ty);
        cnt -= 1;
        visit[arr[tx][ty]] = false;
      }
    }
  }

  public static void printArr() {
    for (int i = 0; i < sero; i++) {
      for (int j = 0; j < garo; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }
}
