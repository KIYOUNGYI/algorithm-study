package com.study.bj.b2021.step1.brute_force.n_and_m;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class P15656_N과_M_8 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  static Scanner scan = new Scanner(System.in);
  static int n, m;
  static int[] arr;
  static boolean[] visit;
  static int[] answer;

  public static void main(String[] args) throws IOException {

//    n = scan.nextInt();
//    m = scan.nextInt();
    String input1 = br.readLine();

    String[] temp1 = input1.split(" ");
    n = Integer.parseInt(temp1[0]);
    m = Integer.parseInt(temp1[1]);

    arr = new int[n + 1];
    visit = new boolean[n + 1];
    answer = new int[m + 1];

    String input2 = br.readLine();
    String[] temp2 = input2.split(" ");
    for (int i = 1; i <= n; i++) {
      arr[i] = Integer.parseInt(temp2[i - 1]);
    }

    Arrays.sort(arr);

    dfs(1);

    bw.flush();
    bw.close();

  }

  private static void dfs(int depth) throws IOException {

    if (depth == m + 1) {
      printArr2();
      return;
    }

    for (int i = 1; i <= n; i++) {

      if (depth == 1) {
        answer[depth] = arr[i];
        dfs(depth + 1);
      }

      if (depth >= 2 && answer[depth-1]<=arr[i]) {
        answer[depth] = arr[i];
        dfs(depth + 1);
      }

    }

  }

  private static void printArr() {
    for (int i = 1; i <= m; i++) {
      System.out.print(answer[i] + " ");
    }
    System.out.println();
  }

  private static void printArr2() throws IOException {
    for (int i = 1; i <= m; i++) {
      bw.write(answer[i] + " ");
    }
    bw.write("\n");

  }

}
