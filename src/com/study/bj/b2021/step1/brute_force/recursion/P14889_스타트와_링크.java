package com.study.bj.b2021.step1.brute_force.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P14889_스타트와_링크 {

  static int MIN = Integer.MAX_VALUE;
  static int n;
  static Scanner scan = new Scanner(System.in);
  static int[][] arr;
  static boolean[] visit;
  static int teamLimit;

  public static void main(String[] args) {

    inputAndInit();
//    printArr();
//    System.out.println(teamLimit);

    tobin(1, 0);

    System.out.println(MIN);
  }

  private static void tobin(int depth, int cnt) {

//    System.out.println("depth = " + depth + ", cnt = " + cnt);
    //base case 1
    if (cnt == teamLimit) {

//      printVisit();

      johab();

      return;
    }
    //base case 2
    if (depth == n + 1) {
//      System.out.println("1");
//      printVisit();
      return;
    }

    visit[depth] = true;
    tobin(depth + 1, cnt + 1);
    visit[depth] = false;
    tobin(depth + 1, cnt);

  }

  private static void johab() {

    int sumA = 0;
    int sumB = 0;

    List<Integer> teamA = new ArrayList<>();
    List<Integer> teamB = new ArrayList<>();

    for (int i = 1; i <= n; i++) {
      if (visit[i]) {
        teamA.add(i);
      } else {
        teamB.add(i);
      }
    }
//    System.out.println("teamA:" + teamA.toString());

    for (int i = 0; i < teamA.size(); i++) {
      for (int j = 0; j < teamA.size(); j++) {
        if (i == j) {
          continue;
        }
//        System.out.println("[" + (i + 1) + "],[" + (j + 1) + "]");
        int x = teamA.get(i);
        int y = teamA.get(j);
        sumA += arr[x][y];
      }
    }
//    System.out.println("teamB:" + teamB.toString());
    for (int i = 0; i < teamB.size(); i++) {
      for (int j = 0; j < teamB.size(); j++) {
        if (i == j) {
          continue;
        }
//        System.out.println("[" + (i + 1) + "],[" + (j + 1) + "]");
        int x = teamB.get(i);
        int y = teamB.get(j);
        sumB += arr[x][y];
      }
    }
    int temp = abs(sumA - sumB);
//    System.out.println("temp : "+temp);
//    System.out.println("==========");
    if (temp < MIN) {
      MIN = temp;
    }

  }

  private static int abs(int t) {
    return t > 0 ? t : -t;
  }

  private static void inputAndInit() {

    n = scan.nextInt();
    arr = new int[n + 2][n + 2];
    visit = new boolean[n + 1];//  1=<방문지<=n

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        arr[i][j] = scan.nextInt();
      }
    }

    teamLimit = n / 2;
  }

  private static void printArr() {

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }

  }

  private static void printVisit() {

    for (int i = 1; i <= n; i++) {
      if (visit[i]) {
        System.out.print(1 + " ");
      } else {
        System.out.print(0 + " ");
      }
    }
    System.out.println();

  }
}
