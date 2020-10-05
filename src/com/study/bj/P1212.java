package com.study.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * https://www.acmicpc.net/problem/1212
 * 8진수 2진수
 */
public class P1212 {

  static String[] arr = {"000", "001", "010", "011", "100", "101", "110", "111"};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String temp = br.readLine();
    char[] input = temp.toCharArray();
    int len = temp.length();

    if (input[0] == '0') {
      bw.write(0+"\n");
      bw.close();
      return;
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < len; i++) {
      if (i == 0) {
        if (input[i] == '1') {
          sb.append("1");
        } else if (input[i] == '2') {
          sb.append("10");
        } else if (input[i] == '3') {
          sb.append("11");
        } else {
          int t = input[i] - '0';
          sb.append(arr[t]);
        }
      } else {
        int t = input[i] - '0';
        sb.append(arr[t]);
      }
    }
    bw.write(sb.toString() + "\n");
    bw.close();
  }
}
