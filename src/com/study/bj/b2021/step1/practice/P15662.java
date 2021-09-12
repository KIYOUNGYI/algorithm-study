package com.study.bj.b2021.step1.practice;

import java.util.Arrays;
import java.util.Scanner;

public class P15662 {

  static int n;
  static int[][] a;
  static int cal;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    n = scan.nextInt();
    a = new int[n][8];
    scan.nextLine();
    for (int i = 0; i < n; i++) {
      String s = scan.nextLine();
//      System.out.println(s);
      String[] temp = s.split("");
//      System.out.println(Arrays.toString(temp));
      for (int j = 0; j < temp.length; j++) {
        a[i][j] = Integer.parseInt(temp[j]);
      }
    }

    cal = scan.nextInt();

    for (int i = 0; i < cal; i++) {

      int x = scan.nextInt();
      int y = scan.nextInt();
//      System.out.println(x+" "+y);
      x = x - 1;//보정
      int[] s = new int[n];//시게,반시계,0 기록하는 배열
      Arrays.fill(s, -2);//초기값

      s[x] = y;
//      System.out.println("->"+Arrays.toString(s));
      for (int j = x; j < n - 1; j++) {
        int t1 = j;
        int t2 = j + 1;
        if (s[t1] == 0) {
          s[t2] = 0;
        } else {

          if (a[t1][2] != a[t2][6]) {
            s[t2] = -s[t1];
          } else {
            s[t2] = 0;
          }
        }
      }

      for (int j = x; j >= 1; j--) {
        int t1 = j;//2,1
        int t2 = j - 1;//1,0

        if (s[t1] == 0) {
          s[t2] = 0;
        } else {
          if (a[t1][6] != a[t2][2]) {
            s[t2] = -s[t1];
          } else {
            s[t2] = 0;
          }
        }
      }
//      System.out.println(Arrays.toString(s));
      solution(s);
    }
    calculate();

  }

  private static void solution(int[] s) {

    for (int i = 0; i < s.length; i++) {

      if (s[i] == 1) {
        rightShift(i);
      } else if (s[i] == -1) {
        leftShift(i);
      }
    }

  }

  private static void rightShift(int idx) {
    int[] temp = new int[8];
    for (int i = 0; i < 8; i++) {
      temp[(i + 1) % 8] = a[idx][i];
    }
    for (int i = 0; i < 8; i++) {
      a[idx][i] = temp[i];
    }
  }

  private static void leftShift(int idx) {
    int[] temp = new int[8];
    for (int i = 0; i < 8; i++) {
      temp[i] = a[idx][(i + 1) % 8];
    }
    for (int i = 0; i < 8; i++) {
      a[idx][i] = temp[i];
    }
  }


  private static void calculate() {
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      if (a[i][0] == 1) {
        cnt += 1;
      }
    }
    System.out.println(cnt);
  }

}
