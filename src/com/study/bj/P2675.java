package com.study.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 문자열 반복
 * https://www.acmicpc.net/problem/2675
 */
public class P2675 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      StringBuilder sb = new StringBuilder();
      String[] temp = br.readLine().split(" ");
      int repeat = Integer.parseInt(temp[0]);
      String text = temp[1];
      for (int j = 0; j < text.length(); j++) {
        char t = text.charAt(j);
        for (int k = 0; k < repeat; k++) {
          sb.append(t);
        }
      }
      bw.write(sb.toString() + "\n");
    }
    bw.close();
  }
}
