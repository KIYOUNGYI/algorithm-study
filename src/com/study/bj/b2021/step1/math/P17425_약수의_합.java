package com.study.bj.b2021.step1.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P17425_약수의_합 {

  static final int MAX = 1_000_050;

//  static final int MAX = 33;

  public static void main(String[] args) throws IOException {

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    long[] d = new long[MAX + 1];
    for (int i = 1; i <= MAX; i++) {
      d[i] = 1;
    }

    for (int i = 2; i <= MAX; i++) {

      for (int j = 1; i * j <= MAX; j++) {
//        System.out.println("[" + i + "," + j + "] = " + i * j);
        d[i * j] += i;
      }
//      System.out.println("---------");
    }

    long[] s = new long[MAX + 1];
    for (int i = 1; i <= MAX; i++) {
      s[i] = s[i - 1] + d[i];
    }
    int t = Integer.parseInt(bf.readLine());
    while (t-- > 0) {
      int n = Integer.parseInt(bf.readLine());
      bw.write(s[n] + "\n");
    }
    bw.flush();
    bw.close();
  }
}
