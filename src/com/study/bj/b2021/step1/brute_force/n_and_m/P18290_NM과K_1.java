package com.study.bj.b2021.step1.brute_force.n_and_m;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//중복 안되게끔 하는 방법도 생각 (일단 나중 그건)
public class P18290_NM과K_1 {

  static int n, m, k;
  static int[][] arr;
  static boolean[][] visit;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  //  static int cnt = 0;
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};
  static int MAX = 0;

  public static void main(String[] args) throws IOException {

    inputAndInit();
    solution();
    System.out.println(MAX);
//    printArr();
  }

  private static void solution() {

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (!visit[i][j]) {
          visit[i][j] = true;
          dfs(1);
          visit[i][j] = false;
        }
      }
    }
  }

  private static void dfs(int cnt) {
//    System.out.println("x = " + x + ", y = " + y + ", cnt = " + cnt);
    if (cnt == k) {
      if (!validation()) {
        return;
      }
      printVisit();
      calculate();
      return;
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {

        if (!visit[i][j]) {
          visit[i][j] = true;
          dfs(cnt + 1);
          visit[i][j] = false;
        }

      }
    }

  }

  private static void calculate() {
    int sum = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (visit[i][j]) {
          sum += arr[i][j];
        }
      }
    }

    if (MAX < sum) {
      MAX = sum;
    }
  }

  private static boolean validation() {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {

        int x = i;
        int y = j;
        if (visit[x][y]) {
          for (int k = 0; k < 4; k++) {
            int tx = x + dx[k];
            int ty = y + dy[k];
            if (tx >= 1 && ty >= 1 && tx <= n && ty <= m && visit[tx][ty] == true) {
              return false;
            }
          }
        }

      }
    }
    return true;
  }

  private static void inputAndInit() throws IOException {
    String input1 = br.readLine();
    String[] temp1 = input1.split(" ");
    n = Integer.parseInt(temp1[0]);
    m = Integer.parseInt(temp1[1]);
    k = Integer.parseInt(temp1[2]);
    arr = new int[n + 2][m + 2];
    visit = new boolean[n + 2][m + 2];

    for (int i = 1; i <= n; i++) {
      String input2 = br.readLine();
      String[] temp2 = input2.split(" ");
      for (int j = 0; j < temp2.length; j++) {
        arr[i][j + 1] = Integer.parseInt(temp2[j]);
      }
    }
  }

  private static void printArr() {
    System.out.println("===================");
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println("===================");
  }

  private static void printVisit() {
    System.out.println("===================");
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (visit[i][j]) {
          System.out.print("o ");
        } else {
          System.out.print("x ");
        }
//        System.out.print(visit[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println("===================");
  }





}
