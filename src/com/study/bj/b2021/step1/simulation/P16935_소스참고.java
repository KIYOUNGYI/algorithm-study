package com.study.bj.b2021.step1.simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class P16935_소스참고 {


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

//      System.out.println(Arrays.toString(size));
      if (type == 1) {
        type1();
      } else if (type == 2) {
        type2();
      } else if (type == 3) {
        type3();
      } else if (type == 4) {
        type4();
      } else if (type == 5) {
        type5();
      } else if (type == 6) {
        type6();
      }

      copy();

//      System.out.println("-----" + (i + 1));
    }

    printArr(arr);
    bw.flush();
    bw.close();
  }

  private static void copy() {

    int sero = arr.length-1;
    int garo = arr[0].length-1;

    for (int i = 1; i <= sero; i++) {
      for (int j = 1; j <= garo; j++) {
        arr[i][j] = temp[i][j];
        temp[i][j] = 0;
      }
    }
  }

  private static void type1() {

    int sero = arr.length-1;
    int garo = arr[0].length-1;
//    System.out.println("sero" + sero);
//    System.out.println("garo" + garo);

    for (int i = 1; i <= sero; i++) {
      for (int j = 1; j <= garo; j++) {
        temp[i][j] = arr[sero - i + 1][j];
      }
    }
//    printArr(temp, n, m);
  }

  private static void type2() {

    int sero = arr.length-1;
    int garo = arr[0].length-1;

    for (int i = 1; i <= sero; i++) {
      for (int j = 1; j <= garo; j++) {
        temp[i][j] = arr[i][garo - j + 1];
      }
    }
//    printArr(temp, n, m);
  }

  private static void type3() {

    int sero = arr.length-1;
    int garo = arr[0].length-1;

    System.out.println("sero = " + sero);
    System.out.println("garo = " + garo);

    for (int i = 1; i <= sero; i++) {
      for (int j = 1; j <= garo; j++) {
        temp[j][sero - i + 1] = arr[i][j];
      }
    }
//    printArr(temp, m, n);
  }


  private static void type4() {
    int sero = arr.length-1;
    int garo = arr[0].length-1;

    for (int i = 1; i <= sero; i++) {
      for (int j = 1; j <= garo; j++) {
        temp[garo - j + 1][i] = arr[i][j];
      }
    }
//    printArr(temp, m, n);
  }

  private static void type5() {

    int sero = arr.length;
    int garo = arr[0].length;

    for (int i = 1; i <= sero / 2; i++) {
      for (int j = 1; j <= garo / 2; j++) {

        temp[i][j + garo / 2] = arr[i][j];

        temp[i + sero / 2][j + garo / 2] = arr[i][j + garo / 2];

        temp[i + sero / 2][j] = arr[i + sero / 2][j + garo / 2];

        temp[i][j] = arr[i + sero / 2][j];
      }
    }
//    printArr(temp, n, m);
  }


  private static void type6() {

    int sero = arr.length-1;
    int garo = arr[0].length-1;

    for (int i = 1; i <= sero / 2; i++) {
      for (int j = 1; j <= garo / 2; j++) {

        temp[i + sero / 2][j] = arr[i][j];

        temp[i + sero / 2][j + garo / 2] = arr[i + sero / 2][j];

        temp[i][j + garo / 2] = arr[i + sero / 2][j + garo / 2];

        temp[i][j] = arr[i][j + garo / 2];
      }
    }
//    printArr(temp, n, m);

  }


  private static void printArr(int[][] t) throws IOException {

    int sero = t.length-1;
    int garo = t[0].length-1;

    for (int i = 1; i <= sero; i++) {
      for (int j = 1; j <= garo; j++) {
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

    arr = new int[n + 1][m + 1];
    temp = new int[n + 1][m + 1];
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
