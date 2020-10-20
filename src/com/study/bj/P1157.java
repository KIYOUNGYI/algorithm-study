package com.study.bj;

import java.util.Scanner;

/**
 * 단어 공부
 * https://www.acmicpc.net/problem/1157
 * 문자열
 */
public class P1157 {

  static int MAXINT = -1;
  static int MAXCNT = -1;
  static int[] arr = new int[100];

  public static void main(String[] args) {

//    System.out.println((int)'a');//97
//    System.out.println((int)'z');//122
//    System.out.println((int)'A');//65
//    System.out.println((int)'Z');//90

    Scanner scan = new Scanner(System.in);
    String input = scan.nextLine();
    for (int i = 0; i < input.length(); i++) {
      if ((int) input.charAt((i)) >= 97 && (int) input.charAt(i) <= 122) {
        arr[(int) input.charAt(i) - 32] += 1;
      } else {
        arr[(int) input.charAt(i)] += 1;
      }

    }

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > MAXCNT) {
        MAXCNT = arr[i];
        MAXINT = i;
      }
    }

    int t = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == MAXCNT) {
        t += 1;
      }
    }
    if (t >= 2) {
      System.out.println("?");
      return;
    }
    System.out.println((char) MAXINT);
    scan.close();
  }
}
