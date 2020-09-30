package com.study.bj;

import java.util.Scanner;

/**
 * 스타트와 링크 https://www.acmicpc.net/problem/14889
 */
public class P14889 {

  static int teamMemberLimit;
  static int N;
  static int[] team;
  static int[][] arr;
  static int difference = Integer.MAX_VALUE;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    N = scan.nextInt();
    team = new int[N];
    arr = new int[N][N];
    teamMemberLimit = N / 2;
    scan.nextLine();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        arr[i][j] = scan.nextInt();
      }
    }
    problem();
//    System.out.println("-------");
    System.out.println(difference);
    scan.close();
  }

  public static void problem() {
    splitTeam(0, 0);
  }

  public static void splitTeam(int depth, int oneCnt) {
    if (oneCnt == teamMemberLimit) {
//      System.out.println(Arrays.toString(team));

      int[] teamA = new int[teamMemberLimit];
      int[] teamB = new int[teamMemberLimit];
      int idx1 = 0;
      int idx2 = 0;
      for (int i = 0; i < team.length; i++) {
        if (team[i] == 1) {
          teamA[idx1++] = i;
        } else if (team[i] == 0) {
          teamB[idx2++] = i;
        }
      }
//      System.out.println("teamA:"+Arrays.toString(teamA));
//      System.out.println("teamB:"+Arrays.toString(teamB));

      int sumA = 0;
      for (int i = 0; i < teamA.length; i++) {
        for (int j = 0; j < teamA.length; j++) {
          if (i == j) {
            continue;
          } else {
//            System.out.println(teamA[i] + " " + teamA[j] + " " + arr[i][j]);
            sumA += arr[teamA[i]][teamA[j]];
          }
        }
      }
//      System.out.println("sumA:"+sumA);
//      System.out.println("---------------------------");
      int sumB = 0;
      for (int i = 0; i < teamB.length; i++) {
        for (int j = 0; j < teamB.length; j++) {
          if (i == j) {
            continue;
          } else {
//            System.out.println(teamB[i]+" "+teamB[j]);
            sumB += arr[teamB[i]][teamB[j]];
          }
        }
      }
//      System.out.println("sumB:"+sumB);
      int t = abs(sumA - sumB);
      if (t < difference) {
        difference = t;
      }
      return;
    }

    if (depth == N) {
      return;
    }

    team[depth] = 1;
    splitTeam(depth + 1, oneCnt + 1);
    team[depth] = 0;
    splitTeam(depth + 1, oneCnt);
  }

  public static int abs(int x) {
    if (x > 0) {
      return x;
    } else {
      return -x;
    }
  }
}
