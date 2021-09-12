package com.study.bj.b2021.step1.simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P16935_배열_돌리기_3 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  static Scanner scan = new Scanner(System.in);
  static int n, m, calculationCount;
  static int type;
  static int[][] arr;
  static int[][] temp;
  static int[][] visit;
  static int[][] arr2;
  static int[][] temp2;

  public static void main(String[] args) throws IOException {

    input();
    calculate();

  }

  private static void calculate() {

    if (type == 1) {

      for (int i = 1; i <= calculationCount; i++) {
        topBottom();
        copyAndInit();
      }
      printArr();
    } else if (type == 2) {

      for (int i = 1; i <= calculationCount; i++) {
        leftRight();
        copyAndInit();
      }

      printArr();
    } else if (type == 3) {

      //n 세로, m 가로
      for (int i = 1; i <= calculationCount; i++) {
        int sero1 = m;
        int garo1 = n;

      }

      int[][] x = new int[m + 2][n + 2];

      for (int j = 1; j <= m; j++) {
        List<Integer> arrList = new ArrayList<>();
        for (int i = n; i >= 1; i--) {
          int v = arr[i][j];
          arrList.add(v);
        }

        for (int i = 1; i <= n; i++) {
          x[j][i] = arrList.get(i - 1);
        }
      }

      printArr2(x);

    }

  }

  private static void printArr2(int[][] p){

    for(int i=1;i<=m;i++){
      for(int j=1;j<=n;j++){
        System.out.print(p[i][j]+" ");
      }
      System.out.println();
    }
  }


  private static void topBottom() {

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        temp[n - i + 1][j] = arr[i][j];
      }
    }
  }

  private static void leftRight() {

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        temp[i][m - j + 1] = arr[i][j];
      }
    }
  }

  private static void ninetyRight() {
    //[1,1],[1,2],[1,3],[1,4],[1,5],[1,6] -> [6,1],[6,2],[6,3],[6,4],[6,5],[6,6]
    //[2,1],[2,2],[2,3],[2,4],[2,5],[2,6] -> [5,1],[5,2],[5,3],[5,4],[5,5],[5,6]
    //[3,1],[3,2],[3,3],[3,4],[3,5],[3,6] -> [4,1],[4,2],[4,3],[4,4],[4,5],[4,6]

    for (int i = 1; i <= m; i++) {
      int t = n;
      for (int j = 1; j <= n; j++) {
        arr2[i][j] = temp2[i][t--];
      }
    }


  }


  private static void input() throws IOException {
//    n = scan.nextInt();
//    m = scan.nextInt();
//    calculationCount = scan.nextInt();

    String input1 = br.readLine();
    String[] s = input1.split(" ");
    n = Integer.parseInt(s[0]);
    m = Integer.parseInt(s[1]);
    calculationCount = Integer.parseInt(s[2]);

    arr = new int[n + 2][m + 2];
    temp = new int[n + 2][m + 2];
    for (int i = 1; i <= n; i++) {

      String input2 = br.readLine();
      String[] s2 = input2.split(" ");
      for (int j = 0; j < s2.length; j++) {
        arr[i][j + 1] = Integer.parseInt(s2[j]);
      }

    }
    String input3 = br.readLine();
    type = Integer.parseInt(input3);
  }

  private static void printTemp() {

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        System.out.print(temp[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static void printArr() {

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static void copyAndInit() {

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        arr[i][j] = temp[i][j];
      }
    }
    temp = new int[n + 2][m + 2];
  }
}
