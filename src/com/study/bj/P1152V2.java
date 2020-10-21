package com.study.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 단어의 개수
 * https://www.acmicpc.net/problem/1152
 */
public class P1152V2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String temp = br.readLine();
    if (temp.length() == 1 && temp.charAt(0) == ' ') {
      System.out.println(0);
      return;
    }
    temp = temp.trim();
    int len = temp.length();
    int cnt = 1;
    for (int i = 0; i < len; i++) {
      if (temp.charAt(i) == 32) {
        cnt += 1;
      }
    }
    System.out.println(cnt);
  }
}
