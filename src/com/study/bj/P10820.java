package com.study.bj;

import java.util.Scanner;

/**
 * 문자열 분석 https://www.acmicpc.net/problem/10820
 */
public class P10820 {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    while (scan.hasNextLine()) {
      String x = scan.nextLine();
      analyze(x);
    }
    scan.close();
  }

  //소문자, 대문자, 숫자, 공백의
  public static void analyze(String input) {
    int a = 0, b = 0, c = 0, d = 0;
    for (int i = 0; i < input.length(); i++) {
      int pivot = input.charAt(i);
      if (pivot >= 97 && pivot <= 122) {
        a += 1;
      }//소문자
      else if (pivot >= 65 && pivot <= 90) {
        b += 1;
      }//대문자
      else if (pivot >= 48 && pivot <= 57) {
        c += 1;
      }//숫자
      else if (pivot == 32) {
        d += 1;
      }
    }
    System.out.println(a + " " + b + " " + c + " " + d);
  }

}
