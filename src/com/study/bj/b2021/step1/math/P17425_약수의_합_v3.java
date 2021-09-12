package com.study.bj.b2021.step1.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P17425_약수의_합_v3 {

  //  static int size = 10;
  static int size = 1_000_050;
  static long[] g;
  static long[] d;
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {

    d = new long[size + 1];
    g = new long[size + 1];
    for (int i = 1; i <= size; i++) {
      d[i] = 1;
    }
    g[1] = 1;
    for (int i = 2; i <= size; i++) {
      for (int j = 1; i * j <= size; j++) {
//        System.out.println(i + " " + j + " " + (i * j));
        d[i * j] += i;
      }
    }
//    System.out.println(Arrays.toString(d));
    long[] s = new long[size + 1];
    for (int i = 1; i <= size; i++) {
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
