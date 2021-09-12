package com.study.bj.b2021.step1.simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class P16935_강좌들으면서 {


  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  static int n, m, commandCount;
  static int[][] arr;
  static int[][] temp;
  static List<Integer> commandList = new ArrayList<>();

  public static void main(String[] args) throws IOException {

    inputFM();

    for (int i = 0; i < commandCount; i++) {

      int type = commandList.get(i);
      int[] size = checkLen(arr);
      int s = size[0];
      int g = size[1];
//      System.out.println(Arrays.toString(size));
      if (type == 1) {
        type1();
      } else if (type == 2) {
        type2();
      } else if (type == 3) {
        type3(s, g);
      } else if (type == 4) {
        type4(s, g);
      } else if (type == 5) {
        type5();
      } else if (type == 6) {
        type6();
      }

      copy();

//      System.out.println("-----" + (i + 1));
    }
    int[] size = checkLen(arr);
    int s = size[0];
    int g = size[1];
    printArr(arr, s, g);
    bw.flush();
    bw.close();
  }

  private static void copy() {

    for (int i = 1; i < 110; i++) {
      for (int j = 1; j < 110; j++) {
        arr[i][j] = temp[i][j];
        temp[i][j] = 0;
      }
    }
  }

  private static void type1() {

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        temp[i][j] = arr[n - i + 1][j];
      }
    }
//    printArr(temp, n, m);
  }

  private static void type2() {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        temp[i][j] = arr[i][m - j + 1];
      }
    }
//    printArr(temp, n, m);
  }

  private static void type3(int sero, int garo) {

    for (int i = 1; i <= sero; i++) {
      for (int j = 1; j <= garo; j++) {
        temp[j][sero - i + 1] = arr[i][j];
      }
    }
//    printArr(temp, m, n);
  }

  private static int[] checkLen(int[][] t) {
//    System.out.println(arr[1][1]);
//    System.out.println(arr[2][1]);
    int sero = 0;
    for (int i = 1; i < 110; i++) {
      if (arr[i][1] != 0) {
        sero += 1;
      }
    }
//    System.out.println("s->"+sero);
    int garo = 0;
    for (int i = 1; i < 110; i++) {
      if (arr[1][i] != 0) {
        garo += 1;
      }
    }
//    System.out.println("g->"+garo);
    int[] ans = new int[2];
    ans[0] = sero;
    ans[1] = garo;
    return ans;
  }

  private static void type4(int sero, int garo) {

    for (int i = 1; i <= sero; i++) {
      for (int j = 1; j <= garo; j++) {
        temp[garo - j + 1][i] = arr[i][j];
      }
    }
//    printArr(temp, m, n);
  }

  private static void type5() {

    for (int i = 1; i <= n / 2; i++) {
      for (int j = 1; j <= m / 2; j++) {

        temp[i][j + m / 2] = arr[i][j];

        temp[i + n / 2][j + m / 2] = arr[i][j + m / 2];

        temp[i + n / 2][j] = arr[i + n / 2][j + m / 2];

        temp[i][j] = arr[i + n / 2][j];
      }
    }
//    printArr(temp, n, m);
  }


  private static void type6() {

    for (int i = 1; i <= n / 2; i++) {
      for (int j = 1; j <= m / 2; j++) {

        temp[i + n / 2][j] = arr[i][j];

        temp[i + n / 2][j + m / 2] = arr[i + n / 2][j];

        temp[i][j + m / 2] = arr[i + n / 2][j + m / 2];

        temp[i][j] = arr[i][j + m / 2];
      }
    }
//    printArr(temp, n, m);

  }


  private static void printArr(int[][] t, int x, int y) throws IOException {

    for (int i = 1; i <= x; i++) {
      for (int j = 1; j <= y; j++) {
        bw.write(t[i][j] + " ");
      }
      bw.write("\n");
    }
  }

  private static void inputFM() throws IOException {
    String input1 = br.readLine();
    String[] s = input1.split(" ");
    n = Integer.parseInt(s[0]);
    m = Integer.parseInt(s[1]);
    commandCount = Integer.parseInt(s[2]);

    arr = new int[110][110];
    temp = new int[110][110];
    for (int i = 1; i <= n; i++) {

      String input2 = br.readLine();
      String[] s2 = input2.split(" ");
      for (int j = 0; j < s2.length; j++) {
        arr[i][j + 1] = Integer.parseInt(s2[j]);
      }

    }
    String input3 = br.readLine();
    String[] s2 = input3.split(" ");
    for (int i = 0; i < s2.length; i++) {
      int command = Integer.parseInt(s2[i]);
      commandList.add(command);
    }
  }


}
