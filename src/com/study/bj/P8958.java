package com.study.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * OX퀴즈
 * https://www.acmicpc.net/problem/8958
 */
public class P8958 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      String input = br.readLine();
      int len = input.length();
      int cnt = 0;
      int sum = 0;
      for (int j = 0; j < len; j++) {
        if (input.charAt(j) == 'O') {
          cnt += 1;
          sum = sum + cnt;
        } else {
          cnt = 0;
        }
      }
      bw.write(sum + "\n");
    }
    bw.flush();
    bw.close();

  }
}
