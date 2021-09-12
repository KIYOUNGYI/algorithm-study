package com.study.bj.b2021.step1.brute_force.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P15661_링크와_스타트 {

  static int min = Integer.MAX_VALUE;
  static int[] answer;
  static int[] a;
  static int n;
  static int r;
  static int limit;
  static int[][] board;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    n = scan.nextInt();

    a = new int[n + 1];
    board = new int[n + 1][n + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        board[i][j] = scan.nextInt();
      }
    }

    for (int i = 1; i <= n; i++) {
      limit = i;
      recursion(1, 0);
    }

    System.out.println(min);
  }


  private static void recursion(int depth, int sum) {

    if (sum == limit) {
//      System.out.println(Arrays.toString(a));
      calculate();
      return;
    }

    if (depth == n + 1) {
      return;
    }

    a[depth] = 1;
    recursion(depth + 1, sum + 1);
    a[depth] = 0;
    recursion(depth + 1, sum);

  }

  private static void calculate() {

    List<Integer> teamA = new ArrayList<>();
    List<Integer> teamB = new ArrayList<>();

    for (int i = 1; i <= n; i++) {
      if (a[i] == 1) {
        teamA.add(i);
      } else {
        teamB.add(i);
      }
    }

    if (teamA.size() == 0 || teamB.size() == 0) {
      return;
    }

//    System.out.println("teamA:" + teamA.toString());
//    System.out.println("teamB:" + teamB.toString());

    int sumA = 0;
    for (int i = 0; i < teamA.size(); i++) {
      int x = teamA.get(i);

      for (int j = 0; j < teamA.size(); j++) {
        int y = teamA.get(j);

        if (x == y) {
          continue;
        }
//        System.out.println("["+x+"]["+y+"]");
        sumA += board[x][y];

      }
    }

    int sumB = 0;
    for (int i = 0; i < teamB.size(); i++) {
      int x = teamB.get(i);

      for (int j = 0; j < teamB.size(); j++) {
        int y = teamB.get(j);

        if (x == y) {
          continue;
        }
//        System.out.println("["+x+"]["+y+"]");
        sumB += board[x][y];

      }
    }

    int result = abs(sumA - sumB);
    if(result<min){
      min = result;
    }

  }

  private static int abs(int x) {
    return x > 0 ? x : -x;
  }


  private static void printArr() {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }
}
