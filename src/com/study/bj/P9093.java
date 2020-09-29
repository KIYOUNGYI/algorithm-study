package com.study.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 단어 뒤집기 https://www.acmicpc.net/problem/9093
 */
public class P9093 {

  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      String input = br.readLine();
      String[] temp = input.split(" ");
      for (int j = 0; j < temp.length; j++) {
        for (int k = temp[j].length() - 1; k >= 0; k--) {
          bw.write(temp[j].charAt(k));
//          System.out.print(temp[j].charAt(k));
        }
        bw.write(" ");
//        System.out.print(" ");
      }
      bw.write("\n");
    }
    bw.close();
  }
}
