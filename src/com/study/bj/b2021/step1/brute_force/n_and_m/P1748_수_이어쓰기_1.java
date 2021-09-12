package com.study.bj.b2021.step1.brute_force.n_and_m;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1748_수_이어쓰기_1 {

  //메모리 초과 풀이
  //100000000
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    String input = bufferedReader.readLine();

    int len = Integer.parseInt(input);
    long size = 0;
    long t = 0;
    for (int i = 1; i <= len; i++) {
      t = String.valueOf(i).length();
      size += t;
    }
    bufferedWriter.write(String.valueOf(size));
    bufferedWriter.flush();
    bufferedWriter.close();
  }
}
