package com.study.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 다신 풀지 말자
 */
public class P1100 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cnt = 0;
    for (int i = 0; i < 8; i++) {
      String temp = br.readLine();
      for (int j = 0; j < temp.length(); j++) {
        if (i % 2 == 0) {
          if (j == 0 || j == 2 || j == 4 || j == 6) {
            if (temp.charAt(j) == 'F') {
              cnt += 1;
            }
          }
        } else {
          if (j == 1 || j == 3 || j == 5 || j == 7) {
            if (temp.charAt(j) == 'F') {
              cnt += 1;
            }
          }
        }
      }
    }
    System.out.println(cnt);
  }
}
